package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Tag;
import br.gov.mg.meioambiente.simge.exception.AppException;
import br.gov.mg.meioambiente.simge.filter.Comparison;
import br.gov.mg.meioambiente.simge.filter.Condition;
import br.gov.mg.meioambiente.simge.filter.Filter;
import br.gov.mg.meioambiente.simge.logger.LogMessagem;
import br.gov.mg.meioambiente.simge.repository.TagRepository;

@Service
public class TagService extends AbstractService<Tag, Long> {

	private final TagRepository tagRepository;

	@Autowired
	public TagService(TagRepository tagRepository) {
		super(tagRepository);
		this.tagRepository = tagRepository;
	}

	@Override
	boolean isValidacao(Tag entity) {
		return true;
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

	@Override
	void entityUpdate(Tag origem, Tag destino) {
		if (!destino.getName().isEmpty()) {
			origem.setName(destino.getName());
		}
	}

	@Override
	Filter<Tag> search(String search) {
		Filter<Tag> filter = new Filter<Tag>();
		filter.addCondition(
				new Condition.Builder().setComparison(Comparison.eq).setField("name").setValue(search).build());
		return filter;
	}

	@Override
	public Page<Tag> getByFilter(String search, Pageable pageable) {
		new LogMessagem().printInfoLog(log_listando);

		Page<Tag> list = null;

		try {
			list = tagRepository.findByNameStartingWithIgnoreCase(search, pageable);
			// validarEntidade.validadatorOptional(list);

		} catch (Exception e) {
			new LogMessagem().printErrorLog(e);
			throw new AppException(log_listando, e);

		}

		new LogMessagem().printInfoLog(log_sucesso);
		return list;
	}

}