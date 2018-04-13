package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

	@Column(name = "senha", nullable = false)
	private String senha;

	public Usuario(Boolean isTestUser) {

		if (isTestUser) {
			this.id = 1L;
			this.cpf = "061523456";
			this.nome = "UserTeste";
		}

	}

	public Usuario(Usuario usuario) {

		this.id = usuario.id;
		this.cpf = usuario.cpf;
		this.nome = usuario.nome;
		this.senha = usuario.senha;

	}

	// ----------------- Get's & Set's -----------------------------

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

}
