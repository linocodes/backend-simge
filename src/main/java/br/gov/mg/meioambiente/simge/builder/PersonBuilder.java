package br.gov.mg.meioambiente.simge.builder;



import java.util.Date;

import br.gov.mg.meioambiente.simge.entity.Address;
import br.gov.mg.meioambiente.simge.entity.IdCard;
import br.gov.mg.meioambiente.simge.entity.Person;
import br.gov.mg.meioambiente.simge.entity.Phone;

public class PersonBuilder {
    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public PersonBuilder name(String name) {
        this.person.setName(name);
        return this;
    }

    public PersonBuilder age(Integer age) {
        this.person.setAge(age);
        return this;
    }

    public PersonBuilder nickName(String nickName) {
        this.person.setNickName(nickName);
        return this;
    }

    public PersonBuilder company(String company) {
        this.person.setCompany(company);
        return this;
    }

    public PersonBuilder birthday(Date birthday) {
        this.person.setBirthday(birthday);
        return this;
    }

    public PersonBuilder phone(String brand, String number) {
        Phone phone = new Phone();
        phone.setBrand(brand);
        phone.setNumber(number);
        this.person.getPhones().add(phone);
        return this;
    }

    public PersonBuilder address(String street, Integer number) {
        Address address = new Address();
        address.setStreet(street);
        address.setNumber(number);
        this.person.getAddresses().add(address);
        return this;
    }

    public PersonBuilder idCard(String number) {
		IdCard idCard = new IdCard();
        idCard.setNumber(number);
        this.person.setIdCard(idCard);
        return this;
    }

    public Person build() {
        return this.person;
    }
}
