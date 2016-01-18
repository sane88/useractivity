package com.vr.useractivity.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("WEB-INF/database.properties")
@EnableTransactionManagement
public class HibernateConfig {

    private String driver;

    private String url;

    private String username;

    private String password;

    private String dialect;




    public DataSource getDataSource() throws PropertyVetoException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
