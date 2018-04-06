package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "instituicao_id", nullable = false, columnDefinition = "BIGINT UNSIGNED")) 
@Table(name = "instituicao")
public class Instituicao extends BaseEntityAudit<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name="sigla", nullable=false)
	private String sigla;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="contato", nullable=false)
	private String contato;
	
	@Column(name="contato_telefone", nullable=false)
	private String contato_telefone;
	
	@Column(name="contato_email", nullable=false)
	private String contato_email;
	
	@Column(name="observacao")
	private String observacao;
	
	
	//----------- Construtores ---------------
	
	public Instituicao() {
		
	}

	public Instituicao(String sigla, String nome, String contato, String contato_telefone, String contato_email, String observacao) {
		
		this.sigla = sigla;
		this.nome = nome;
		this.contato = contato;
		this.contato_telefone = contato_telefone;
		this.contato_email = contato_email;
		this.observacao = observacao;
		
	}
	
	
	//---------- Get's & Set's ----------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato_nome(String contato) {
		this.contato = contato;
	}

	public String getContato_telefone() {
		return contato_telefone;
	}

	public void setContato_telefone(String contato_telefone) {
		this.contato_telefone = contato_telefone;
	}

	public String getContato_email() {
		return contato_email;
	}

	public void setContato_email(String contato_email) {
		this.contato_email = contato_email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
	//------------ Sobreposição ----------------------------
	
	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		s.append("Instituição [");
			s.append("id:").append(this.id).append(", ");
			s.append("sigla:").append(this.sigla).append(", ");
			s.append("nome:").append(this.nome).append(", ");
			s.append("contato:").append(this.contato).append(", ");
			s.append("contato_telefone:").append(this.contato_telefone).append(", ");
			s.append("contato_email:").append(this.contato_email).append(", ");
			s.append("observacao:").append(this.observacao).append(", ");
		s.append("]");
		
		return s.toString();
		
	}
	
}
