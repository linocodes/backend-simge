package br.gov.mg.meioambiente.simge.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.gov.mg.meioambiente.simge.entity.BaseEntity;
import br.gov.mg.meioambiente.simge.exception.DataFormatException;
import br.gov.mg.meioambiente.simge.service.AbstractService;

public abstract class BaseRestController<T, PK extends Serializable> extends AbstractRestHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseRestController.class);	

	private AbstractService<T, PK> service;

	public BaseRestController(AbstractService<T, PK> service) {
		this.service = service;
	}

	@RequestMapping(value = "", 
			        method = RequestMethod.POST, 
			        consumes = { "application/json","application/xml" }, 
			        produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createEntity(@Valid @RequestBody T entity, Errors errors, HttpServletRequest request, HttpServletResponse response) {
		
		if (errors.hasErrors()) {
			//throw new ParametrosInvalidosExceptionSade(MensagensErro.getAtributosInvalidos(errors));
		}		
		T registro = this.service.createEntity(entity);
		
		
		return new ResponseEntity<>(registro, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody T getHotel(@PathVariable("id") PK id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaseEntity<T> entity = null;// this.hotelService.getHotel(id);
		checkResourceFound(entity);
		// todo: http://goo.gl/6iNAkz
		return (T) entity;
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<T> getListHotel(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<T> listEntity = null;// this.hotelService.teste();
		checkResourceFound(listEntity);
		// todo: http://goo.gl/6iNAkz
		return listEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateHotel(@PathVariable("id") PK id, @RequestBody T entity, HttpServletRequest request,
			HttpServletResponse response) {
		// checkResourceFound(this.hotelService.getHotel(id));
		if (id !=  ((BaseEntity<T>) entity).getId())
			throw new DataFormatException("ID doesn't match!");
		// this.hotelService.updateHotel(hotel);
	}

	// todo: @ApiImplicitParams, @ApiResponses
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteHotel(@PathVariable("id") PK id, HttpServletRequest request, HttpServletResponse response) {
		// checkResourceFound(this.hotelService.getHotel(id));
		// this.hotelService.deleteHotel(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Page<T> getAllHotel(@PageableDefault(value = 10, page = 0) Pageable pageable,
			HttpServletRequest request, HttpServletResponse response) {
		// @RequestMapping(value = "/teste", method = RequestMethod.GET)
		// @ResponseStatus(HttpStatus.OK)
		// public @ResponseBody Page<Hotel> getAllHotelPage(@PageableDefault(value = 10,
		// page = 0) Pageable pageable,
		// @RequestParam(value = "search") String search, HttpServletRequest request,
		// HttpServletResponse response) {
		// return null; // this.service.getAllHotels(pageable);
		// }
		return this.service.getPageAll(pageable);
	}

}