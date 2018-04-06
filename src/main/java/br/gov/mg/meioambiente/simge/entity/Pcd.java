package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pcd")
@AttributeOverride(name = "id", column = @Column(name = "pcd_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Pcd extends BaseEntityAudit<Long> {
	
	private static final long serialVersionUID = -1390992359712683300L;

	@Column(name="codigo", nullable=false)
	private String codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="instituicao", nullable=false)
	private String instituicao;
	
	@Column(name="latitude", nullable=false)
	private String latitude;
	
	@Column(name="longitude", nullable=false)
	private String longitude;
	
	@Column(name="altitude", nullable=false)
	private String altitude;
	
	@Column(name="municipio", nullable=false)
	private String municipio;
	
	@Column(name="tipo", nullable=false)
	private String tipo;
	
	@Column(name="status", nullable=false)
	private String status;
	
	@Column(name="automatica", nullable=false)
	private Boolean automatica;

	
	//-------------- Get's & Set's -------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getAutomatica() {
		return automatica;
	}

	public void setAutomatica(Boolean automatica) {
		this.automatica = automatica;
	}
	
	
	//-------------- Construtores -------------------
	
	public Pcd() {}
	
	public Pcd(String codigo, String nome, String instituicao, String latitude, String longitude, String altitude,
			String municipio, String tipo, String status, Boolean automatica) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.instituicao = instituicao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.municipio = municipio;
		this.tipo = tipo;
		this.status = status;
		this.automatica = automatica;
	}
	
	//-------------- Soberscrituras -------------------
	
	@Override
	public String toString() {
		return "Pcd [codigo=" + codigo + ", nome=" + nome + ", instituicao=" + instituicao + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", altitude=" + altitude + ", municipio=" + municipio + ", tipo=" + tipo
				+ ", status=" + status + ", automatica=" + automatica + "]";
	}
	


}
