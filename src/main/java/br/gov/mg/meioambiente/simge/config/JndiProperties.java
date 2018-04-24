package br.gov.mg.meioambiente.simge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:jndi.properties")
public class JndiProperties {

	@Value("${jndiMysql}")
	private String jndiMysql;

	public String getJndiMysql() {
		return jndiMysql;
	}

	public void setJndiMysql(String jndiMysql) {
		this.jndiMysql = jndiMysql;
	}

}
