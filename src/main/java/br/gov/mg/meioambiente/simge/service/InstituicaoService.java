package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Instituicao;
import br.gov.mg.meioambiente.simge.filter.Filter;
import br.gov.mg.meioambiente.simge.repository.InstituicaoRepository;

@Service
public class InstituicaoService extends AbstractService<Instituicao, Long> {

	@Autowired
	public InstituicaoService(InstituicaoRepository instituicaoRepository) {
		super(instituicaoRepository);
	}

	@Override
	boolean isValidacao(Instituicao entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void beforeCreate(Instituicao entity) {
	}

	@Override
	void afterCreate(Instituicao entity) {
	}

	@Override
	void beforeUpdate(Instituicao entity) {
	}

	@Override
	void afterUpdate(Instituicao entity) {
	}

	@Override
	void beforeDelete(Instituicao entity) {
	}

	@Override
	void afterDelete(Instituicao entity) {
	}

	@Override
	Filter search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void entityUpdate(Instituicao origem, Instituicao destino) {
		// TODO Auto-generated method stub
		
	}


}