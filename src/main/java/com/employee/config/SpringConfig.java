package com.employee.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.employee")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer
{
	//Configuring CSS and JS File Locations
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/CSS/**").addResourceLocations("/CSS/");
		registry.addResourceHandler("/JS/**").addResourceLocations("/JS/");
	}
	//Configuring InternalResourceViewResolver class
	
	@Bean
	InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	// configuring LocalSessionFactoryBean class
	@Bean
	LocalSessionFactoryBean getSessionFactoryBean()
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		
		//Set Connection string as object of DataSource
		factoryBean.setDataSource(getDataSource());
		
		//Set hibernate properties as object of Properties class
		factoryBean.setHibernateProperties(getProperties());
		
		//Set packagesToScan as String
		factoryBean.setPackagesToScan("com.employee.entity");	
		return factoryBean;
		
	}
	private Properties getProperties() {
		Properties properties = new Properties();
		 properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	        properties.setProperty("hibernate.show_sql", "true");
	        properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	private DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mvc4?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql");
        return dataSource;
	}
	
	


}
