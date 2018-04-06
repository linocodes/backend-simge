package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Instituicao;
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
	void beforeCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void afterCreate() {
		// TODO Auto-generated method stub
		
	}

}