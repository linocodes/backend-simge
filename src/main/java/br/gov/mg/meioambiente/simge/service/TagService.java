package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.mg.meioambiente.simge.entity.Tag;
import br.gov.mg.meioambiente.simge.repository.TagRepository;

@Service
public class TagService extends AbstractService<Tag, Long> {

	@Autowired
	public TagService(TagRepository tagRepository) {
		super(tagRepository);
	}

	@Override
	boolean isValidacao(Tag entity) {
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