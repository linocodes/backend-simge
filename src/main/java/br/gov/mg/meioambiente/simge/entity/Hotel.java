package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
@AttributeOverride(name = "id", column = @Column(name = "hotel_id", nullable = false, columnDefinition = "BIGINT UNSIGNED"))  
public class Hotel extends BaseEntityAudit<Long> {

	private static final long serialVersionUID = 8199708971498707980L;

	@Column(nullable = false)
	private String name;

	@Column()
	private String description;

	@Column()
	String city;

	@Column()
	private int rating;

	public Hotel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
