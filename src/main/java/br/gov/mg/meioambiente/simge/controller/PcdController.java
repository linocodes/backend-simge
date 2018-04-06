package br.gov.mg.meioambiente.simge.controller;

import br.gov.mg.meioambiente.simge.entity.Pcd;
import br.gov.mg.meioambiente.simge.service.PcdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pcd")
public class PcdController extends BaseRestController<Pcd, Long> {

	@Autowired
	PcdController(PcdService pcdService) {
		super(pcdService);
	}

}