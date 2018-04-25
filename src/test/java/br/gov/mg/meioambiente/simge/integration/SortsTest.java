package br.gov.mg.meioambiente.simge.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.mg.meioambiente.simge.builder.PersonBuilder;
import br.gov.mg.meioambiente.simge.controller.Sorts;
import br.gov.mg.meioambiente.simge.controller.Specifications;
import br.gov.mg.meioambiente.simge.entity.Person;
import br.gov.mg.meioambiente.simge.repository.PersonRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SortsTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void should_be_able_to_sort_by_desc() {
        // given
        Person jack = new PersonBuilder()
            .name("Jack")
            .age(18)
            .build();
        Person eric = new PersonBuilder()
            .name("Eric")
            .age(20)
            .build();
        Person aaron = new PersonBuilder()
            .name("Aaron")
            .age(18)
            .build();
        personRepository.save(jack);
        personRepository.save(eric);
        personRepository.save(aaron);

        // when
        Specification<Person> specification = Specifications.<Person>and()
            .ne("name", (Object) null)
            .build();

        Sort sort = Sorts.builder()
            .desc(jack.getAge() != null, "age")
            .desc("name")
            .desc(jack.getCompany() != null, "company")
            .build();

        List<Person> persons = personRepository.findAll(specification, sort);

        // then
        assertThat(persons.get(0)).isEqualToComparingFieldByField(eric);
        assertThat(persons.get(1)).isEqualToComparingFieldByField(jack);
    }

    @Test
    public void should_be_able_to_sort_by_asc() {
        // given
        Person jack = new PersonBuilder()
            .name("Jack")
            .age(18)
            .build();
        Person eric = new PersonBuilder()
            .name("Eric")
            .age(20)
            .build();
        Person aaron = new PersonBuilder()
            .name("Aaron")
            .age(18)
            .build();
        personRepository.save(jack);
        personRepository.save(eric);
        personRepository.save(aaron);

        // when
        Specification<Person> specification = Specifications.<Person>and()
            .ne("name", (Object) null)
            .build();

        Sort sort = Sorts.builder()
            .asc(jack.getAge() != null, "age")
            .asc("name")
            .asc(jack.getCompany() != null, "company")
            .build();

        List<Person> persons = personRepository.findAll(specification, sort);

        // then
        assertThat(persons.get(0)).isEqualToComparingFieldByField(aaron);
        assertThat(persons.get(2)).isEqualToComparingFieldByField(eric);
    }
}
