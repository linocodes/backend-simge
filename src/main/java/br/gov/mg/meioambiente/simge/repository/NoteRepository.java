package br.gov.mg.meioambiente.simge.repository;

import org.springframework.stereotype.Repository;
import br.gov.mg.meioambiente.simge.entity.Note;

@Repository
public interface NoteRepository extends BaseRepository<Note, Long> {

	/*
	 * Page<UserHistory>
	 * findByUserHistoryPK_FromDateLessThanEqualAndUserHistoryPK_ToDateGreaterThanEqual(
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("from") Date from,
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") @Param("to") Date to, Pageable
	 * pageable);
	 */

}
