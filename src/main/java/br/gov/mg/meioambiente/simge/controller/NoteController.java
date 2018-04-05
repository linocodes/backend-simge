package br.gov.mg.meioambiente.simge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import br.gov.mg.meioambiente.simge.entity.Note;
import br.gov.mg.meioambiente.simge.exception.DataFormatException;
import br.gov.mg.meioambiente.simge.service.NoteService;


@RestController
@RequestMapping(value = "note")
public class NoteController extends BaseRestController<Note, Long> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);	

	private final NoteService noteService;

	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public void createHotel(@RequestBody Note note, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Creating a new todo entry by using information: {}", note);
		Note createdHotel = null;// this.hotelService.createHotel(hotel);
		response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Note getHotel(@PathVariable("id") Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Note hotel = null;// this.hotelService.getHotel(id);
		checkResourceFound(hotel);
		// todo: http://goo.gl/6iNAkz
		return hotel;
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Note> getListHotel(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Note> hotel = null;// this.hotelService.teste();
		checkResourceFound(hotel);
		// todo: http://goo.gl/6iNAkz
		return hotel;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateHotel(@PathVariable("id") Long id, @RequestBody Note hotel, HttpServletRequest request,
			HttpServletResponse response) {
		// checkResourceFound(this.hotelService.getHotel(id));
		if (id != hotel.getId())
			throw new DataFormatException("ID doesn't match!");
		// this.hotelService.updateHotel(hotel);
	}

	// todo: @ApiImplicitParams, @ApiResponses
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteHotel(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		// checkResourceFound(this.hotelService.getHotel(id));
		// this.hotelService.deleteHotel(id);
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) public ResponseTemplate
	 * getModules(
	 * 
	 * @RequestParam(defaultValue = "0", required = false) int page,
	 * 
	 * @RequestParam(defaultValue = "10", required = false) int size,
	 * 
	 * @RequestParam(defaultValue = "0", required = false) long parentId,
	 * 
	 * @RequestParam(defaultValue = "-1", required = false) int status,
	 * 
	 * @RequestParam(required = false) String name) { ModuleSpecification spec = new
	 * ModuleSpecification(parentId, name, status); return
	 * ResponseTemplate.successResponse(this.moduleService.getByFilter(spec, new
	 * PageRequest(page, size))); }
	 * 
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Page<Note> getAllHotel(
			@RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = true, defaultValue = "10") Integer size,
			HttpServletRequest request, HttpServletResponse response) {
		return (Page<Note>) this.noteService.getAll();
	}

}