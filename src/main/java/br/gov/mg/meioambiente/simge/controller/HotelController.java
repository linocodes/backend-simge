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
		this.hotelService = hotelService;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public void createHotel(@RequestBody Hotel hotel, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Creating a new todo entry by using information: {}", hotel);
		Hotel createdHotel = null;//this.hotelService.createHotel(hotel);
		response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Page<Hotel> getAllHotel(@PageableDefault(value = 10, page = 0) Pageable pageable,
			HttpServletRequest request, HttpServletResponse response) {
		//@RequestMapping(value = "/teste", method = RequestMethod.GET)
		//@ResponseStatus(HttpStatus.OK)
		//public @ResponseBody Page<Hotel> getAllHotelPage(@PageableDefault(value = 10, page = 0) Pageable pageable,
		//		@RequestParam(value = "search") String search, HttpServletRequest request, HttpServletResponse response) {
		//	return null; // this.service.getAllHotels(pageable);
		//}		
		return this.hotelService.getPageAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Hotel getHotel(@PathVariable("id") Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Hotel hotel = null;//this.hotelService.getHotel(id);
		checkResourceFound(hotel);
		// todo: http://goo.gl/6iNAkz
		return hotel;
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Hotel> getListHotel(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Hotel> hotel = null;//this.hotelService.teste();
		checkResourceFound(hotel);
		// todo: http://goo.gl/6iNAkz
		return hotel;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateHotel(@PathVariable("id") Long id, @RequestBody Hotel hotel, HttpServletRequest request,
			HttpServletResponse response) {
		//checkResourceFound(this.hotelService.getHotel(id));
		if (id != hotel.getId())
			throw new DataFormatException("ID doesn't match!");
		//this.hotelService.updateHotel(hotel);
	}

	// todo: @ApiImplicitParams, @ApiResponses
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteHotel(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		//checkResourceFound(this.hotelService.getHotel(id));
		//this.hotelService.deleteHotel(id);
	}
	
}