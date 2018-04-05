package br.gov.mg.meioambiente.simge.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedRepository<T, PK extends Serializable> extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
	
	/**
     * Deletes a managed entity.
     * @param id    The id of the deleted entity.
     * @return      an {@code Optional} that contains the deleted entity. If there
     *              is no entity that has the given id, this method returns an empty {@code Optional}.
     */
    Optional<T> deleteById(PK id);
}