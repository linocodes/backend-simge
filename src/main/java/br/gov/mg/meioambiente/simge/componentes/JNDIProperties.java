package br.gov.mg.meioambiente.simge.componentes;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class JNDIProperties {

	@NotEmpty
	private String jndiMysql;

	public String getJndiMysql() {
		return jndiMysql;
	}

	public void setJndiMysql(String jndiMysql) {
		this.jndiMysql = jndiMysql;
	}

}
