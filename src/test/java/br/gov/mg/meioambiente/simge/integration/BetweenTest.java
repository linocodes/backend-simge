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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BetweenTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void should_be_able_to_find_by_using_between() throws ParseException {
        // given
        Person jack = new PersonBuilder()
                .name("Jack")
                .birthday(getDate("1987-11-14"))
                .build();
        Person eric = new PersonBuilder()
                .name("Eric")
                .birthday(getDate("1990-10-12"))
                .build();
        personRepository.save(jack);
        personRepository.save(eric);

        // when
        Specification<Person> specification = Specifications.<Person>and()
                .between(nonNull(jack.getBirthday()), "birthday", getDate("1980-01-01"), getDate("1989-12-31"))
                .build();

        List<Person> persons = personRepository.findAll(specification);

        // then
        assertThat(persons.size()).isEqualTo(1);
    }

    private Date getDate(String source) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(source);
    }
}
