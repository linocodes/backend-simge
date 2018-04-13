package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.group.GroupSequenceProvider;

@Entity(name = "Tag")
@Table(name = "tag")
@AttributeOverride(name = "id", column = @Column(name = "tag_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Tag extends BaseEntity<Long> {

	private static final long serialVersionUID = -7655961997031546542L;

	@NaturalId
	@Column(nullable=false)	
	private String name;

	@NaturalId
	@Column(nullable=false)	
	private String sobrenome;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}