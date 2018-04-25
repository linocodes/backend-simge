package br.gov.mg.meioambiente.simge.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "id_card")
public class IdCard extends BaseEntity<Long> {


	private static final long serialVersionUID = 1L;
	private String number;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
