package br.gov.mg.meioambiente.simge.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;


//@Configuration
//@EnableConfigurationProperties
public class AppConfig {
	
	/*
    @Value("${spring.datasource.primary.jndi-name}")
    private String primaryJndiName;

    @Value("${spring.datasource.secondary.jndi-name}")
    private String secondaryJndiName;
    
    private JndiDataSourceLookup lookup = new JndiDataSourceLookup();    

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public JndiPropertyHolder primary() {
		return new JndiPropertyHolder();
	}
	
    @Primary
    @Bean(destroyMethod = "") 
    public DataSource primaryDs() {
        return lookup.getDataSource(primaryJndiName);
    }

    @Bean(destroyMethod = "") 
    public DataSource secondaryDs() {
        return lookup.getDataSource(secondaryJndiName);
    }
    
    /*
	@Bean
	@Primary
	public DataSource primaryDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(primary().getJndiName());
		return dataSource;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public JndiPropertyHolder secondary() {
		return new JndiPropertyHolder();
	}

	@Bean
	public DataSource secondaryDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(secondary().getJndiName());
		return dataSource;
	}
	*/

}