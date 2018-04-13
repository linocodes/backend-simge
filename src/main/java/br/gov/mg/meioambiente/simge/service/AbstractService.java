package br.gov.mg.meioambiente.simge.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.repository.BaseRepository;
import br.gov.mg.meioambiente.simge.validator.EntityOptionalValidator;
import br.gov.mg.meioambiente.simge.entity.BaseEntity;
import br.gov.mg.meioambiente.simge.entity.Usuario;
import br.gov.mg.meioambiente.simge.exception.AppException;
import br.gov.mg.meioambiente.simge.exception.NotFoundException;
import br.gov.mg.meioambiente.simge.logger.LogMessagem;
import br.gov.mg.meioambiente.simge.repository.AbstractRepository;

public abstract class AbstractService<T, PK extends Serializable> implements BaseCrudService<T, PK> {

	final static String log_listando = "Listando os registros na entidade: {}";
	final static String log_pesquisando = "Pesquisando o registro na entidade: {} identificado {}";
	final static String log_editando = "Editando um novo registro na entidade: {}";
	final static String log_excluindo = "Deleta um novo registro na entidade: {}";
	final static String log_inserindo = "Criando um novo registro na entidade: {}";
	final static String log_sucesso = "Operação realizada com sucesso.";

	protected BaseRepository<T, PK> repository;

	private EntityOptionalValidator<T> validarEntidade;

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

		new LogMessagem().printInfoLogWithId(log_inserindo, entity.getClass().getSimpleName());

		if (isValidacao(entity)) {
			beforeCreate(entity);
		}

		try {

			repository.saveAndFlush(entity);
			afterCreate(entity);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_inserindo, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entity;
	}

	@Override
	public void delete(T entity) {

		new LogMessagem().printInfoLogWithId(log_excluindo, entity.getClass().getSimpleName());

		beforeDelete(entity);

		try {
			repository.delete(entity);
			afterDelete(entity);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_excluindo, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);

	}

	@Override
	public void deleteById(PK id) {

		new LogMessagem().printInfoLogWithId(log_excluindo, id);

		T entity = this.getById(id);

		beforeDelete(entity);

		try {
			repository.delete(entity);
			afterDelete(entity);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_excluindo, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);

	}

	@Override
	public T update(T entity) {

		new LogMessagem().printInfoLogWithId(log_editando, entity.getClass().getSimpleName());

		if (isValidacao(entity)) {
			beforeUpdate(entity);
		}

		try {

			repository.saveAndFlush(entity);
			afterUpdate(entity);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_editando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entity;

	}

	@Override
	public T getById(PK id) {

		new LogMessagem().printInfoLogWithId(log_pesquisando, id);

		try {
			T entity = this.getById(id);
			validarEntidade.validadatorOptional(entity);
			new LogMessagem().printInfoLog(log_sucesso);
			return entity;
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_pesquisando, e);
		}

	}

	@Override
	public T getById(T entity, PK id) {

		new LogMessagem().printInfoLogWithId(log_pesquisando, entity.getClass().getSimpleName(), id);

		try {
			entity = repository.findOne(id);
			validarEntidade.validadatorOptional(entity);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_pesquisando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return entity;

	}

	@Override
	public List<T> getAll() {

		new LogMessagem().printInfoLog(log_listando);

		List<T> list = null;

		try {

			list = repository.findAll();
			validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;

	}

	@Override
	public Page<T> getPageAll(Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<T> list = null;

		try {

			list = repository.findAll(pageable);
			//validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;
	}

	@Override
	public Page<T> getByFilter(Specification<T> spec) {
		new LogMessagem().printInfoLog(log_listando);

		Page<T> list = null;

		try {
			list = (Page<T>) repository.findAll(spec);
			validarEntidade.validadatorOptional(list);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;
	}

	@Override
	public Page<T> getByFilter(Specification<T> spec, Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<T> list = null;

		try {
			list = repository.findAll(spec, pageable);
			validarEntidade.validadatorOptional(list);
		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);
		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;

	}

}