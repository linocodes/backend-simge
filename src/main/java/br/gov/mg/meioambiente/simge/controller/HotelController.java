package br.gov.mg.meioambiente.simge.controller;

import br.gov.mg.meioambiente.simge.entity.Hotel;
import br.gov.mg.meioambiente.simge.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hotel")
public class HotelController extends BaseRestController<Hotel, Long> {

	@Autowired
	HotelController(HotelService hotelService) {
		super(hotelService);
	}

}