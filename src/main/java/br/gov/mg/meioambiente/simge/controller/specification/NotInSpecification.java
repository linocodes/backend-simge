package br.gov.mg.meioambiente.simge.controller.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class NotInSpecification<T> extends AbstractSpecification<T> {
    private String property;
    private Object[] values;

    public NotInSpecification(String property, Object[] values) {
        this.property = property;
        this.values = values;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        From from = getRoot(property, root);
        String field = getProperty(property);
        return from.get(field).in(values).not();
    }
}
