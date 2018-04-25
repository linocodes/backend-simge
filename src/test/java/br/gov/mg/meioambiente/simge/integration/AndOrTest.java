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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AndOrTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void should_be_able_to_find_by_using_and_or() {
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
                .name("Jackson")
                .build();
        personRepository.save(jack);
        personRepository.save(eric);
        personRepository.save(jackson);

        // when
        Specification<Person> specification = Specifications.<Person>and()
                .like("name", "%ac%")
                .predicate(Specifications.or()
                        .lt("age", 19)
                        .gt("age", 25)
                        .build())
                .build();

        List<Person> persons = personRepository.findAll(specification);

        // then
        assertThat(persons.size()).isEqualTo(2);
    }
}
