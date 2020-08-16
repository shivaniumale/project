package com.example.demo1.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

public class CreateJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/ loginuser";

    private static final String dbUsername = "root";
    private static final String dbPassword = "1234";
    private static DataSource dataSource;
    public  JdbcTemplate CreateTemplate() throws Exception{
        dataSource=getDataSource();
        JdbcTemplate template=new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;

    }

      private DriverManagerDataSource getDataSource(){
             DriverManagerDataSource dmds=new DriverManagerDataSource();
             dmds.setDriverClassName("com.mysql.jdbc.Driver");
             dmds.setUrl(url);
             dmds.setUsername(dbUsername);
             dmds.setPassword(dbPassword);
             return dmds;
      }
    public static String getUrl() {
        return url;
    }

    public static String getDbUsername() {
        return dbUsername;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

}
