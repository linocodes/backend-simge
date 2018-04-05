package br.gov.mg.meioambiente.simge.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BaseCrudService<T, PK extends Serializable> {

	T save(T entity);

	void delete(T entity);

	void deleteById(PK id);

	T update(T entity);

	T getById(PK id);

	List<T> getAll();
	
	Page<T> getPageAll(Pageable pageable);

	List<T> getByFilter(Specification<T> spec);

	Page<T> getByFilter(Specification<T> spec, Pageable pageable);

}