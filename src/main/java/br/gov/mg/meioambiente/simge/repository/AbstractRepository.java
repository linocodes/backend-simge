package br.gov.mg.meioambiente.simge.repository;

import java.io.Serializable;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import br.gov.mg.meioambiente.simge.entity.Phone;

public class AbstractRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRepository.class);
	
	private EntityManager entityManager;

	public AbstractRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}
	
	/*
	@Transactional
	@Override
	public Optional<T> deleteById(ID id) {
		LOGGER.info("Deleting an entity by using id: {}", id);

		T deleted = entityManager.find(this.getDomainClass(), id);
		LOGGER.debug("Deleted entity is: {}", deleted);

		Optional<T> returned = Optional.empty();

		if (deleted != null) {
			entityManager.remove(deleted);
			returned = Optional.of(deleted);
		}

		LOGGER.info("Returning deleted entity: {}", returned);

		return returned;
	}
	*/

}