package br.gov.mg.meioambiente.simge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class BaseEntityAudit<PK> extends BaseEntity<PK> {

	private static final long serialVersionUID = -2365589203273765901L;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Size(max = 20)
	@Column(name = "created_by", length = 20)
	private String createdBy;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Size(max = 20)
	@Column(name = "updated_by", length = 20)
	private String updatedBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@PrePersist
	public void setCreationDate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	public void setChangeDate() {
		this.updatedAt = new Date();
	}

}