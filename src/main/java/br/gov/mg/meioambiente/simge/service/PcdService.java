package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Pcd;
import br.gov.mg.meioambiente.simge.filter.Filter;
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
	void beforeCreate(Pcd entity) {
	}

	@Override
	void afterCreate(Pcd entity) {
	}

	@Override
	void beforeUpdate(Pcd entity) {
	}

	@Override
	void afterUpdate(Pcd entity) {
	}

	@Override
	void beforeDelete(Pcd entity) {
	}

	@Override
	void afterDelete(Pcd entity) {
	}

	@Override
	Filter search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}