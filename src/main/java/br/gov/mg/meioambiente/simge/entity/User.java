package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.*;
import java.util.List;

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