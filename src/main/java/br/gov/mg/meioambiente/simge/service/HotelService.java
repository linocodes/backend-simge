package br.gov.mg.meioambiente.simge.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import br.gov.mg.meioambiente.simge.entity.Hotel;
import br.gov.mg.meioambiente.simge.repository.HotelRepository;

@Service
public class HotelService extends AbstractService<Hotel, Long> {

	private static final Logger log = LoggerFactory.getLogger(HotelService.class);

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

}