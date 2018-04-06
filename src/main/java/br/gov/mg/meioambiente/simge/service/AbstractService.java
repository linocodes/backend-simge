package br.gov.mg.meioambiente.simge.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.repository.BaseRepository;
import br.gov.mg.meioambiente.simge.repository.AbstractRepository;

public abstract class AbstractService<T, PK extends Serializable> implements BaseCrudService<T, PK> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRepository.class);

	protected BaseRepository<T, PK> repository;

	public AbstractService(BaseRepository<T, PK> repository) {
		this.repository = repository;
	}

	/**
	 * Valida os dados antes de enviar para o banco de dados.
	 * 
	 * @param entity
	 * @return
	 */
	abstract boolean isValidacao(T entity);

	/**
	 * Antes de Salvar
	 */
	abstract void beforeCreate();

	/**
	 * Depois de Salvar
	 */
	abstract void afterCreate();

	/**
	 * Persiste os dados
	 */
	@Override
	public T createEntity(T entity) {

		LOGGER.info("Criando um novo registro entidade: {}", entity.getClass().getSimpleName());

		if (isValidacao(entity)) {
			beforeCreate();
		} else {

		}

		try {

			repository.saveAndFlush(entity);
			LOGGER.info("Registro criado com sucesso.");
			afterCreate();

		} catch (Exception e) {
			LOGGER.error("Erro ao inserir {} erro {}", entity.getClass().getSimpleName(), e);
			// throw new SQLExceptionSade(new MensagensErro("erroSQLInsert",
			// NOME_ENTIDADE_PARA_EXIBICAO));
		}

		return entity;
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
		// return null;
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
	 * @Override public T save(T entity) {
	 * this.logger.debug("Create a new {} with information: {}", entity.getClass(),
	 * entity.toString()); return this.dao.save(entity); }
	 */

}