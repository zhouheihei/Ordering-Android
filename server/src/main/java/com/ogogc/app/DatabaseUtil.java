package com.ogogc.app;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseUtil {
	private static JdbcTemplate jdbc= null;
	
	public static JdbcTemplate getjdbc(){
		if(jdbc==null){
			jdbc=new JdbcTemplate(getDataSource());
		}
		return jdbc;
	}
	
	
	private static DataSource getDataSource(){
		DataSource datasource = new DataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");  
        datasource.setUrl("jdbc:mysql://127.0.0.1:3306/ordering?useUnicode=true&characterEncoding=utf-8&useSSL=false");  
        datasource.setUsername("root"); 
        datasource.setPassword("xpadmin.");
//        datasource.set
        datasource.setValidationQuery("select 1");
        datasource.setTestWhileIdle(true);
        datasource.setValidationInterval(18000);
//        datasource.setTestOnConnect(true);
        return datasource;
	}

}
