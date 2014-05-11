package com.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.entitys.Resource;

public class ResourceMapping extends MappingSqlQuery {

	public ResourceMapping(DataSource dataSource,String resourceQuery){
		super(dataSource,resourceQuery);
		compile();
	}
	
	@Override
	protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		String url=rs.getString(1);
		String role=rs.getString(2);
		Resource resource=new Resource(url,role);
		return resource;
	}

}
