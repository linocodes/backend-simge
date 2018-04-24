package br.gov.mg.meioambiente.simge.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class User extends BaseEntity<Long> {

	private static final long serialVersionUID = -2327644839442179828L;

	@Column
    public String email;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @OneToMany(mappedBy = "user")
    public List<Address> addresses;

}