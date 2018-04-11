package br.gov.mg.meioambiente.simge.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.repository.BaseRepository;
import br.gov.mg.meioambiente.simge.exception.ResourceNotFoundException;
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
	abstract void beforeCreate(T entity);

	/**
	 * Depois de Salvar
	 */
	abstract void afterCreate(T entity);

	/**
	 * Antes de atualizar o registro
	 */
	abstract void beforeUpdate(T entity);

	/**
	 * Depois de atualizar o registro
	 */
	abstract void afterUpdate(T entity);

	/**
	 * Antes de deletar o registro
	 */
	abstract void beforeDelete(T entity);

	/**
	 * Depois de deletar o registro
	 */
	abstract void afterDelete(T entity);

	
	/**
	 * Persiste os dados
	 */
	@Override
	public T createEntity(T entity) {

		LOGGER.info("Criando um novo registro entidade: {}", entity.getClass().getSimpleName());

		if (isValidacao(entity)) {
			beforeCreate(entity);
		} else {

		}

		try {

			repository.saveAndFlush(entity);
			LOGGER.info("Registro criado com sucesso.");
			afterCreate(entity);

		} catch (Exception e) {
			LOGGER.error("Erro ao inserir {} erro {}", entity.getClass().getSimpleName(), e);
			// throw new SQLExceptionSade(new MensagensErro("erroSQLInsert",
			// NOME_ENTIDADE_PARA_EXIBICAO));
		}

		return entity;
	}

	@Override
	public void delete(T entity) {
		
		LOGGER.info("Deleta um novo registro entidade: {}", entity.getClass().getSimpleName());
		
		beforeDelete(entity);
		
		try {
			repository.delete(entity);
			LOGGER.info("Registro deletado com sucesso.");
			afterDelete(entity);
		} catch (Exception e) {
			//logger.error(new LogBuilder().adicionaMensagem("Erro ao deletar estilo")
			//		.adicionaParametro("Estilo", estilo.toString()).getMensagem(), e);
			//throw new SQLExceptionSade(new MensagensErro("erroSQLDelete", NOME_ENTIDADE_PARA_EXIBICAO));
		}

	}

	@Override
	public void deleteById(PK id) {
		
		LOGGER.info("Deleta um novo registro : {}", id);

		T entity = this.getById(id);
		
		if (entity == null) {
			  throw new ResourceNotFoundException("resource not found");
		}
		
		beforeDelete(entity);
		
		try {
			repository.delete(entity);
			LOGGER.info("Registro deletado com sucesso.");
			afterDelete(entity);
		} catch (Exception e) {
			//logger.error(new LogBuilder().adicionaMensagem("Erro ao deletar estilo")
			//		.adicionaParametro("Estilo", estilo.toString()).getMensagem(), e);
			//throw new SQLExceptionSade(new MensagensErro("erroSQLDelete", NOME_ENTIDADE_PARA_EXIBICAO));
		}

	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getById(PK id) {
		
		LOGGER.info("Pesquisando o registro: {}", id);		

		try {
			return repository.findOne(id);

		} catch (Exception e) {
			// LOGGER.error("Erro ao inserir {} erro {}", entity.getClass().getSimpleName(),
			// e);
			// throw new SQLExceptionSade(new MensagensErro("erroSQLInsert",
			// NOME_ENTIDADE_PARA_EXIBICAO));
		}
		
		return null;

	}

	@Override
	public List<T> getAll() {
		LOGGER.info("Pesquisando getAll");
		return this.repository.findAll();
	}

	@Override
	public Page<T> getPageAll(Pageable pageable) {
		return repository.findAll(pageable);
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