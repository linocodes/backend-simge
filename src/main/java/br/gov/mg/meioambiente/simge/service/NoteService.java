package br.gov.mg.meioambiente.simge.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Note;
import br.gov.mg.meioambiente.simge.repository.NoteRepository;

import org.springframework.data.jpa.domain.Specification;


@Service
public class NoteService extends AbstractService<Note, Long> {

	private static final Logger log = LoggerFactory.getLogger(NoteService.class);

	@Autowired
	public NoteService(NoteRepository noteRepository) {
		super(noteRepository);
	}
/*
	@Override
	public Page<Note> getByFilter(Specification<Note> spec, Pageable pageable) {
		// Sort sort = new Sort(Direction.ASC, "sequence");
		 return this.getPageAll();
		//return null;
	}
	*/

}