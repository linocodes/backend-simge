package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Pcd;
import br.gov.mg.meioambiente.simge.repository.PcdRepository;

@Service
public class PcdService extends AbstractService<Pcd, Long> {

	@Autowired
	public PcdService(PcdRepository pcdRepository) {
		super(pcdRepository);
	}

	@Override
	boolean isValidacao(Pcd entity) {
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