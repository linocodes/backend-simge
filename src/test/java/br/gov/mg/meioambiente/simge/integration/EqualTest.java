package br.gov.mg.meioambiente.simge.integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.mg.meioambiente.simge.builder.PersonBuilder;
import br.gov.mg.meioambiente.simge.controller.Specifications;
import br.gov.mg.meioambiente.simge.entity.Person;
import br.gov.mg.meioambiente.simge.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EqualTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void should_be_able_to_find_by_using_equal() {
        // given
        Person person = new PersonBuilder()
                .name("Jack")
                .age(18)
                .build();
        personRepository.save(person);

        // when
        Specification<Person> specification = Specifications.<Person>and()
                .eq(isNotBlank(person.getName()), "name", person.getName())
                .build();

        Optional<Person> result = personRepository.findOne(specification);

        // then
        assertThat(result.get().getName()).isEqualTo(person.getName());
    }

    @Test
    public void should_be_able_to_find_by_using_equal_for_single_null_value() {
        // given
        Person jack = new PersonBuilder()
                .name("Jack")
                .age(18)
                .company("Abc")
                .build();
        Person eric = new PersonBuilder()
                .name("Eric")
                .age(20)
                .build();

        personRepository.save(jack);
        personRepository.save(eric);

        // when
        Specification<Person> specification = Specifications.<Person>and()
                .eq("company", (Object) null)
                .eq("nickName", null)
                .build();

        List<Person> persons = personRepository.findAll(specification);

        // then
        assertThat(persons.size()).isEqualTo(1);
    }

    @Test
    public void should_be_able_to_find_by_using_equal_with_multiple_values() {
        // given
        Person jack = new PersonBuilder()
                .name("Jack")
                .age(18)
                .build();
        Person eric = new PersonBuilder()
                .name("Eric")
                .age(20)
                .build();
        Person jackson = new PersonBuilder()
                .age(30)
                .nickName("Jackson")
                .build();
        personRepository.save(jack);
        personRepository.save(eric);
        personRepository.save(jackson);

        // when
        Specification<Person> specification = Specifications.<Person>and()
                .eq(isNotBlank(jack.getName()), "name", jack.getName(), eric.getName(), null)
                .build();

        List<Person> persons = personRepository.findAll(specification);

        // then
        assertThat(persons.size()).isEqualTo(3);
    }

    @Test
    public void should_be_able_to_find_all_if_all_predicate_are_null() {
        // given
        Person jack = new PersonBuilder()
                .name("Jack")
                .age(18)
                .build();
        Person eric = new PersonBuilder()
                .name("Eric")
                .age(20)
                .build();
        personRepository.save(jack);
        personRepository.save(eric);

        // when
        Specification<Person> specification = Specifications.<Person>and()
                .eq(isNotBlank(EMPTY), "name", jack.getName())
                .like(isNotBlank(EMPTY), "name", "%" + jack.getName() + "%")
                .build();

        List<Person> persons = personRepository.findAll(specification);

        // then
        assertThat(persons.size()).isEqualTo(2);
    }
}
