package br.gov.mg.meioambiente.simge.controller.specification;



import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.entity.Person;

public class PersonSpec implements Specification<Person> {

  private final Person example;

  public PersonSpec(Person example) {
    this.example = example;
  }
/*
  @Override
  public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    List<Predicate> predicates = new ArrayList<>();

    if (StringUtils.isNotBlank(example.getLastName())) {
      predicates.add(cb.like(cb.lower(root.get(Person_.lastName)), example.getLastName().toLowerCase() + "%"));
    }

    if (StringUtils.isNotBlank(example.getFirstName())) {
      predicates.add(cb.like(cb.lower(root.get(Person_.firstName)), example.getFirstName().toLowerCase() + "%"));
    }

    if (example.getEmployed() != null) {
      predicates.add(cb.equal(root.get(Person_.employed), example.getEmployed()));
    }

    if (example.getDob() != null) {
      predicates.add(cb.equal(root.get(Person_.dob), example.getDob()));
    }

    return andTogether(predicates, cb);
  }

  private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
    return cb.and(predicates.toArray(new Predicate[0]));
  }
  */

@Override
public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	// TODO Auto-generated method stub
	return null;
}
}