package br.gov.mg.meioambiente.simge.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BaseCrudService<T, PK extends Serializable> {

	T createEntity(T entity);

	void delete(T entity);

	void deleteById(PK id);

	T update(T entity);
	
	T update(T entity, PK id);	
	
	T getById(PK id);
	
	T getById(T entity, PK id);	

	List<T> getAll();
	
	Page<T> getAll(Pageable pageable);

	Page<T> getByFilter(String search, Pageable pageable);

	Page<T> getByFilter(Specification<T> spec, Pageable pageable);

}