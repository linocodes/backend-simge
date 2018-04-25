package br.gov.mg.meioambiente.simge.integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TestTransaction;

import br.gov.mg.meioambiente.simge.builder.PersonBuilder;
import br.gov.mg.meioambiente.simge.controller.Specifications;
import br.gov.mg.meioambiente.simge.entity.Person;
import br.gov.mg.meioambiente.simge.entity.PersonIdCard;
import br.gov.mg.meioambiente.simge.repository.PersonIdCardRepository;
import br.gov.mg.meioambiente.simge.repository.PersonRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VirtualViewTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonIdCardRepository personIdCardRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_be_able_to_query_from_virtual_view() {
        // given
        Person jack = new PersonBuilder()
            .name("Jack")
            .age(18)
            .idCard("100000000000000000")
            .build();
        Person eric = new PersonBuilder()
            .name("Eric")
            .age(20)
            .idCard("200000000000000000")
            .build();
        Person jackson = new PersonBuilder()
            .age(30)
            .nickName("Jackson")
            .idCard("300000000000000000")
            .build();
        personRepository.save(jack);
        personRepository.save(eric);
        personRepository.save(jackson);
        entityManager.flush();

        // when
        Specification<PersonIdCard> specification = Specifications.<PersonIdCard>and()
            .gt("age", 18)
            .build();
        List<PersonIdCard> personIdCards = personIdCardRepository.findAll(specification);

        // then
        assertThat(personIdCards.size()).isEqualTo(2);
    }
}
