package br.gov.mg.meioambiente.simge.config;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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

//@Profile("!test")          // 1
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "au.com.myblog.dao", entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")        // 2
public class PrimaryMysqlDBConfiguration {
	/*
	@Bean(name = "dataSource")      // 3
     @Primary
     @ConfigurationProperties(prefix = "primary.datasource.mysql")
     public DataSource mysqlDataSource() {
          return DataSourceBuilder.create().build();
     }
    @PersistenceContext(unitName = "primary")   // 4
     @Primary
     @Bean(name = "entityManager")
     public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
          return builder.dataSource(mysqlDataSource()).persistenceUnit("primary").properties(jpaProperties())
                    .packages("au.com.myblog.domain").build     }
     private Map<String, Object> jpaProperties() {
          Map<String, Object> props = new HashMap<>();
          props.put("hibernate.ejb.naming_strategyw SpringNamingStrategy());
          return props;
      }
      
      */
}