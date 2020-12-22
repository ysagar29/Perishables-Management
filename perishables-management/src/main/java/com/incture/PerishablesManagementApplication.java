package com.incture;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan("com.incture")
public class PerishablesManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PerishablesManagementApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PerishablesManagementApplication.class);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

/*	@Bean
	@Primary
	public DataSource dataSource(@Value("${vcap.services.Perishable_Management.credentials.url}") final String url,
			@Value("${vcap.services.Perishable_Management.credentials.user}") final String user,
			@Value("${vcap.services.Perishable_Management.credentials.password}") final String password) {
		DataSource dataSource = DataSourceBuilder.create().type(DriverManagerDataSource.class)
				.driverClassName(com.sap.db.jdbc.Driver.class.getName()).url(url).username(user).password(password)
				.build();
		return dataSource;
	}
*/
	


@Bean
@Primary
public DataSource dataSource() 
{
    return DataSourceBuilder
        .create()
        .username("PERISHABLE_MANAGEMENT")
        .password("Sq3A09Zw5NOlWz8dzryY1J2_mvmXwJJKh0REBknMUSdq5-N8hE23DjFurH6JwKkeoQtnBxGuM.f2APteyFtU39ZDegixxZ9Z4JKp-f25NhRlt5JfuVA88iod8Zyj.61n")
        .url("jdbc:sap://zeus.hana.prod.eu-central-1.whitney.dbaas.ondemand.com:24458?encrypt=true&validateCertificate=true&currentschema=PERISHABLE_MANAGEMENT")
        .driverClassName("com.sap.db.jdbc.Driver")
        .build();
}







}





















