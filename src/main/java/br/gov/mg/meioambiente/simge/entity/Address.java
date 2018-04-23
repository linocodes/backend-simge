package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.*;

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

}