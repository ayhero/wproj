package com.filters;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.ConfigAttributeEditor;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.RequestKey;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.dao.imp.RescDaoImp;
import com.entitys.Resc;
//import com.entitys.Resource;

import com.entitys.Role;
import com.mapping.ResourceMapping;

@Service("filterInvocationSecurityMetadataSource")
public class JdbcFilterInvocationDefinitionSourceFactoryBean
	extends JdbcDaoSupport implements FactoryBean {
	private String resourceQuery;
    public void setResourceQuery(String resourceQuery) {
		this.resourceQuery = resourceQuery;
	}

	@Resource
    private RescDaoImp rdi;

    public boolean isSingleton() {
        return true;
    }

    public Class getObjectType() {
        return FilterInvocationSecurityMetadataSource.class;
    }

    public Object getObject() {
        return new DefaultFilterInvocationSecurityMetadataSource(this.buildRequestMap());
    }

    protected Map<String, String> findResources() {
    	 
    	/*ResourceMapping resourceMapping = new ResourceMapping(getDataSource(),
                 resourceQuery);

         Map<String, String> resourceMap = new LinkedHashMap<String, String>();

         for (Resource resource : (List<Resource>) resourceMapping.execute()) {
             String url = resource.getUrl();
             String role = resource.getRole();

             if (resourceMap.containsKey(url)) {
                 String value = resourceMap.get(url);
                 resourceMap.put(url, value + "," + role);
             } else {
                 resourceMap.put(url, role);
             }
             System.out.println(url+"-"+resourceMap.get(url));
         }

         return resourceMap;*/
    	
    	List<Resc> list=this.rdi.getRescs();
        Map<String, String> resourceMap = new LinkedHashMap<String, String>();
        for(Resc resc : list){
        	Iterator<Role> it=resc.getRoles().iterator();
        	while(it.hasNext()){
        		Role role=it.next();
        		if(resourceMap.containsKey(resc.getRes_string())){
        			String oldValue=resourceMap.get(resc.getRes_string());
        			resourceMap.put(resc.getRes_string(), oldValue+","+role.getName());
        		}else{
        			resourceMap.put(resc.getRes_string(), role.getName());
        		}
        		System.out.println(resc.getRes_string()+"-"+resourceMap.get(resc.getRes_string()));
        	}
        }
        System.out.println("It works!~");
        
        return resourceMap;
        
    }

    protected LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

        ConfigAttributeEditor editor = new ConfigAttributeEditor();
        

        Map<String, String> resourceMap = this.findResources();

        for (Map.Entry<String, String> entry : resourceMap.entrySet()) {
            String key = entry.getKey();
            editor.setAsText(entry.getValue());
            requestMap.put(new AntPathRequestMatcher(key),
                (Collection<ConfigAttribute>) editor.getValue());
        }

        return requestMap;
    }

}