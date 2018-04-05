package br.gov.mg.meioambiente.simge.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.repository.ExtendedRepository;
import br.gov.mg.meioambiente.simge.repository.ExtendedRepositoryImpl;

public class AbstractService<T, PK extends Serializable> implements BaseCrudService<T, PK> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExtendedRepositoryImpl.class);    

	protected ExtendedRepository<T, PK> repository;

    public AbstractService(ExtendedRepository<T, PK> repository) {
        this.repository = repository;
    }

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(PK id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> getPageAll(Pageable pageable) {
		return repository.findAll(pageable);
		// TODO Auto-generated method stub
		//return null;
	}
	
	@Override
	public List<T> getByFilter(Specification<T> spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> getByFilter(Specification<T> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



    /*
    @Override
    public T save(T entity) {
        this.logger.debug("Create a new {} with information: {}", entity.getClass(),
                entity.toString());
        return this.dao.save(entity);
    }
    */
  
}