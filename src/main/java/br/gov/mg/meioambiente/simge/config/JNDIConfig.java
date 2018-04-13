package br.gov.mg.meioambiente.simge.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

public class JNDIConfig {
	/*
	@Value("${spring.mysql.datasource.jndi-name}")
	private String mySQLJNDIName;

	@Bean(destroyMethod = "")
	public DataSource mySQLDataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource(mySQLJNDIName);
	}	
	*/

}
