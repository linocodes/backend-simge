package br.gov.mg.meioambiente.simge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import br.gov.mg.meioambiente.simge.entity.Tag;

@Repository
public interface TagRepository extends BaseRepository<Tag, Long> {
	
    Page<Tag> findByNameStartingWithIgnoreCase(String search, Pageable pageable);

}
