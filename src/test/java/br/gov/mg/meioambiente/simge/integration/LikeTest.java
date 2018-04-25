package br.gov.mg.meioambiente.simge.integration;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.assertj.core.api.Assertions.assertThat;

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

@RunWith(SpringRunner.class)
@DataJpaTest
public class LikeTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void should_be_able_to_find_by_using_like_with_multiple_values() {
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
            .like(isNotBlank(jack.getName()), "name", "%ac%", "%ri%")
            .build();

        List<Person> persons = personRepository.findAll(specification);

        // then
        assertThat(persons.size()).isEqualTo(2);
    }

}
