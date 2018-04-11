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
		return false;
	}

	@Override
	void beforeCreate(Tag entity) {
	}

	@Override
	void afterCreate(Tag entity) {
	}

	@Override
	void beforeUpdate(Tag entity) {
	}

	@Override
	void afterUpdate(Tag entity) {
	}

	@Override
	void beforeDelete(Tag entity) {
	}

	@Override
	void afterDelete(Tag entity) {
	}

}