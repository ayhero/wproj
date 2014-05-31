package com.test;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GenEntityMysql {
	
	private String packageOutPath = "com.entitys.face";//指定实体生成所在包的路径
	private String authorName = "memego";//作者名字
	private String[] colnames; // 列名数组
	private String[] colTypes; //列名类型数组
	private int[] colSizes; //列名大小数组
	private boolean f_util = false; // 是否需要导入包java.util.*
	private boolean f_sql = false; // 是否需要导入包java.sql.*
    private String dbName;//数据库名字
    
    
    //数据库连接
	private String URL ="jdbc:mysql://localhost:3306/";
	private String NAME = "root";
	private String PASS = "";
	private String DRIVER ="com.mysql.jdbc.Driver";

	/*
	 * 构造函数
	 */
	public GenEntityMysql(){
		
	}
	public GenEntityMysql(String dbName){
		this.dbName=dbName;
		this.URL =this.URL+this.dbName;
	}
	
	
	public List<String> getTables(){
		//创建连接
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//查要生成实体类的表
    	String sql = "select t.table_name from information_schema.TABLES t where t.table_schema=?";
    	PreparedStatement pStemt = null;
    	try {
        	Connection con = DriverManager.getConnection(URL,NAME,PASS);
			pStemt = con.prepareStatement(sql);
			pStemt.setString(1, this.dbName);
			ResultSet rs=pStemt.executeQuery();
			List<String> tables=new ArrayList<String>();
			while(rs.next()){
				tables.add(rs.getString(1));
			}
			rs.close();
			con.close();
			return tables;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public void generate(String tableName){
			//创建连接
	    	Connection con;
			//查要生成实体类的表
	    	String sql = "select * from " + tableName;
	    	PreparedStatement pStemt = null;
	    	try {
	    		try {
					Class.forName(DRIVER);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		con = DriverManager.getConnection(URL,NAME,PASS);
				pStemt = con.prepareStatement(sql);
				ResultSetMetaData rsmd = pStemt.getMetaData();
				int size = rsmd.getColumnCount();	//统计列
				colnames = new String[size];
				colTypes = new String[size];
				colSizes = new int[size];
				for (int i = 0; i < size; i++) {
					colnames[i] = rsmd.getColumnName(i + 1);
					colTypes[i] = rsmd.getColumnTypeName(i + 1);
					
					if(colTypes[i].toLowerCase().startsWith("datetime") || colTypes[i].toLowerCase().startsWith("time")){
						f_util = true;
					}
					if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){
						f_sql = true;
					}
					colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
				}
				
				String content = parse(tableName,colnames,colTypes,colSizes);
				
				try {
					File directory = new File("");
					//System.out.println("绝对路径："+directory.getAbsolutePath());
					//System.out.println("相对路径："+directory.getCanonicalPath());
					String path=this.getClass().getResource("").getPath();
					
					System.out.println(path);
					System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );
//					String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";
					String outputPath = directory.getAbsolutePath()+ "/src/main/java/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tableName) + ".java";
					FileWriter fw = new FileWriter(outputPath);
					PrintWriter pw = new PrintWriter(fw);
					pw.println(content);
					pw.flush();
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
    	
    }

	/**
	 * 功能：生成实体类主体代码
	 * @param colnames
	 * @param colTypes
	 * @param colSizes
	 * @return
	 */
	private String parse(String tableName,String[] colnames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();

		sb.append("package " + this.packageOutPath + ";\r\n");
		//判断是否导入工具包
		if(f_util){
			sb.append("import java.util.Date;\r\n");
		}
		if(f_sql){
			sb.append("import java.sql.*;\r\n");
		}
		sb.append("\r\n");
		//注释部分
		sb.append("   /**\r\n");
		sb.append("    * "+tableName+" 实体类\r\n");
		sb.append("    * "+new Date()+" "+this.authorName+"\r\n");
		sb.append("    */ \r\n");
		//实体部分
		sb.append("\r\n\r\npublic class " + initcap(tableName) + "{\r\n");
		processAllAttrs(sb);//属性
		processAllMethod(sb);//get set方法
		sb.append("}\r\n");
		
    	//System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 功能：生成所有属性
	 * @param sb
	 */
	private void processAllAttrs(StringBuffer sb) {
		
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";\r\n");
		}
		
	}

	/**
	 * 功能：生成所有方法
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " + 
					colnames[i] + "){\r\n");
			sb.append("\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
			sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
		
	}
	
	/**
	 * 功能：将输入字符串的首字母改成大写
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		
		char[] ch = str.toCharArray();
		if(ch[0] >= 'a' && ch[0] <= 'z'){
			ch[0] = (char)(ch[0] - 32);
		}
		
		return new String(ch);
	}

	/**
	 * 功能：获得列的数据类型
	 * @param sqlType
	 * @return
	 */
	private String sqlType2JavaType(String sqlType) {
		
		if(sqlType.toLowerCase().startsWith("bit")){
			return "boolean";
		}else if(sqlType.toLowerCase().startsWith("tinyint")){
			return "byte";
		}else if(sqlType.toLowerCase().startsWith("smallint")){
			return "short";
		}else if(sqlType.toLowerCase().startsWith("int")){
			return "int";
		}else if(sqlType.toLowerCase().startsWith("bigint")){
			return "long";
		}else if(sqlType.toLowerCase().startsWith("float")){
			return "float";
		}else if(sqlType.toLowerCase().startsWith("decimal") || sqlType.toLowerCase().startsWith("numeric") 
				|| sqlType.toLowerCase().startsWith("real") || sqlType.toLowerCase().startsWith("money") 
				|| sqlType.toLowerCase().startsWith("smallmoney") || sqlType.toLowerCase().startsWith("double")){
			return "double";
		}else if(sqlType.toLowerCase().startsWith("varchar") || sqlType.toLowerCase().startsWith("char") 
				|| sqlType.toLowerCase().startsWith("nvarchar") || sqlType.toLowerCase().startsWith("nchar") 
				|| sqlType.toLowerCase().startsWith("text")){
			return "String";
		}else if(sqlType.toLowerCase().startsWith("datetime") || sqlType.toLowerCase().startsWith("time")){
			return "Date";
		}else if(sqlType.toLowerCase().startsWith("image")){
			return "Blod";
		}
		
		return null;
	}
	
	/**
	 * 出口
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		
		GenEntityMysql gem=new GenEntityMysql("face");
		gem.generate("service_orderlist");
		/**
		List<String> dbs=gem.getTables();
		for(String tableName : dbs){
			GenEntityMysql gems=new GenEntityMysql("face");
			gems.generate(tableName);
		}
		*/
	}

}