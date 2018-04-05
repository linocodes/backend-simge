package br.gov.mg.meioambiente.simge.repository;

import org.springframework.stereotype.Repository;
import br.gov.mg.meioambiente.simge.entity.Tag;

@Repository
public interface TagRepository extends ExtendedRepository<Tag, Long> {

}
