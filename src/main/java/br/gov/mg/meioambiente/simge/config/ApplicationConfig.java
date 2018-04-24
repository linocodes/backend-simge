package br.gov.mg.meioambiente.simge.config;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
//@EnableConfigurationProperties(JndiProperties.class)
//@PropertySource("classpath:jndi.properties")
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "br.gov.mg.meioambiente.simge")
//@EnableJpaRepositories(
//		basePackages = "br.gov.mg.meioambiente.simge.repository", 
//		entityManagerFactoryRef = "entityManagerFactory", 
//		transactionManagerRef = "transactionManager")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private JndiProperties jndi;

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

	private JndiDataSourceLookup lookup = new JndiDataSourceLookup();


	public ApplicationConfig(JndiProperties jndi) {
		this.jndi = jndi;
	}	

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(additionalProperties());
		factoryBean.setPackagesToScan("br.gov.mg.meioambiente.simge.entity");

		return factoryBean;
	}

	@Primary
	@Bean
	public DataSource dataSource() throws NamingException {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(this.jndi.getJndiMysql());
		return dataSource;

		//InitialContext ctx = new InitialContext();
		//DataSource ds = (DataSource) ctx.lookup("java:/POST-SIMGE");
		//return ds;
	}

	@Primary
	@Bean
	public PlatformTransactionManager transactionManager() throws NamingException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		final ResourceBundle bundle = ResourceBundle.getBundle("persistence-properties");
		Enumeration<String> enumeration = bundle.getKeys();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			hibernateProperties.setProperty(key, bundle.getString(key));
		}
		return hibernateProperties;
	}

	/*
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(-1);
		return resolver;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				try {
					registry.addMapping("/**")
							.allowedOrigins((String) new InitialContext()
									.lookup(ResourceBundle.getBundle("jndi-names").getString("urlCliente")))
							.allowedHeaders("*").allowedMethods("*");
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
		};
	}
	*/

}
