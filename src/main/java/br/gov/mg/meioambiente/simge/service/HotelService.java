package br.gov.mg.meioambiente.simge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.entity.Hotel;
import br.gov.mg.meioambiente.simge.filter.Filter;
import br.gov.mg.meioambiente.simge.repository.HotelRepository;

@Service
public class HotelService extends AbstractService<Hotel, Long> {

	@Autowired
	public HotelService(HotelRepository hotelRepository) {
		super(hotelRepository);
	}

	@Override
	public Page<Hotel> getByFilter(Specification<Hotel> spec, Pageable pageable) {
		// Sort sort = new Sort(Direction.ASC, "sequence");
		// return this.getByFilter(spec, sort, pageable);
		return null;
	}

	@Override
	boolean isValidacao(Hotel entity) {
		return true;
	}

	@Override
	void beforeCreate(Hotel entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void afterCreate(Hotel entity) {
	}

	@Override
	void beforeUpdate(Hotel entity) {
	}

	@Override
	void afterUpdate(Hotel entity) {
	}

	@Override
	void beforeDelete(Hotel entity) {
	}

	@Override
	void afterDelete(Hotel entity) {
	}

	@Override
	Filter search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void entityUpdate(Hotel origem, Hotel destino) {
		// TODO Auto-generated method stub
		
	}

}