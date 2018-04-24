package br.gov.mg.meioambiente.simge.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Address extends BaseEntity<Long> {

	private static final long serialVersionUID = -7110655710892980517L;

	@ManyToOne
	public User user;

	@Column
	public Integer zip;

	@Column
	public String street;

	@Column
	public String city;

	@Column
	public Integer number;

	@ManyToMany(mappedBy = "addresses")
	private Set<Person> owners = new HashSet<Person>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set<Person> getOwners() {
		return owners;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}

}