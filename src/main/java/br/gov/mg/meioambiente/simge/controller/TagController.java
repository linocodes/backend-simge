package br.gov.mg.meioambiente.simge.controller;

import br.gov.mg.meioambiente.simge.entity.Tag;
import br.gov.mg.meioambiente.simge.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "tag")
public class TagController extends BaseRestController<Tag, Long> {

	@Autowired
	TagController(TagService tagService) {
		super(tagService);
	}

}