package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("SELECT p.id id, p.name name, p.age age, ic.number number " +
           "FROM person p " +
           "LEFT JOIN id_card ic " +
           "ON p.id_card_id=ic.id")
public class PersonIdCard extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
    private String name;
    private Integer age;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
