package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.mg.meioambiente.simge.entity.Note;
import br.gov.mg.meioambiente.simge.filter.Filter;
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
	void beforeCreate(Note entity) {
	}

	@Override
	void afterCreate(Note entity) {
	}

	@Override
	void beforeUpdate(Note entity) {
	}

	@Override
	void afterUpdate(Note entity) {
	}

	@Override
	void beforeDelete(Note entity) {
	}

	@Override
	void afterDelete(Note entity) {
	}

	@Override
	Filter search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void entityUpdate(Note origem, Note destino) {
		// TODO Auto-generated method stub
		
	}
	
}