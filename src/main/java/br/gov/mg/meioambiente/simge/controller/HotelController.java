package br.gov.mg.meioambiente.simge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.gov.mg.meioambiente.simge.entity.Hotel;
import br.gov.mg.meioambiente.simge.exception.DataFormatException;
import br.gov.mg.meioambiente.simge.service.HotelService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "hotel")
public class HotelController extends BaseRestController<Hotel, Long> {

	private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

	private HotelService hotelService;

	@Autowired
	HotelController(HotelService hotelService) {
		super(hotelService);
		this.hotelService = hotelService;
	}


	
}