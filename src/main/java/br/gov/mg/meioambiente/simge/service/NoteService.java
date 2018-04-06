package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.mg.meioambiente.simge.entity.Note;
import br.gov.mg.meioambiente.simge.repository.NoteRepository;


@Service
public class NoteService extends AbstractService<Note, Long> {

	@Autowired
	public NoteService(NoteRepository noteRepository) {
		super(noteRepository);
	}

	@Override
	boolean isValidacao(Note entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void beforeCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void afterCreate() {
		// TODO Auto-generated method stub
		
	}
	
}