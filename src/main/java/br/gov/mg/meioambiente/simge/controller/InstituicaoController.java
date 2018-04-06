package br.gov.mg.meioambiente.simge.controller;

import br.gov.mg.meioambiente.simge.entity.Instituicao;
import br.gov.mg.meioambiente.simge.service.InstituicaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "instituicao")
public class InstituicaoController extends BaseRestController<Instituicao, Long> {

	@Autowired
	InstituicaoController(InstituicaoService instituicaoService) {
		super(instituicaoService);
	}

}