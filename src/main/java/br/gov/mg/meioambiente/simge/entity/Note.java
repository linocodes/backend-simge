package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "notes")
@AttributeOverride(name = "id", column = @Column(name = "notes_id", nullable = false, columnDefinition = "BIGINT"))
public class Note extends BaseEntityAudit<Long> {

	private static final long serialVersionUID = 6935320812899580088L;

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
