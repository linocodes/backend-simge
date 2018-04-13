package br.gov.mg.meioambiente.simge.validator;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.gov.mg.meioambiente.simge.exception.NotFoundException;

@Component
public class EntityOptionalValidator<ENTITY> {

	final static String log_nao_encontrado = "Não foram encontrados registros para a entidade:";

	/**
	 * Valida se o objeto em questão está nulo ou vazio. Caso esteja, retorna uma
	 * exceção para o usuário. HTTP Status 404
	 * 
	 * @author Filipe Santos
	 * @since 11/01/2017
	 * 
	 **/
	public void validadatorOptional(ENTITY entidade) {
		Optional.ofNullable(entidade).orElseThrow(() -> new NotFoundException(log_nao_encontrado));
		Optional.of(entidade).orElseThrow(() -> new NotFoundException(log_nao_encontrado));
	}

	/**
	 * Valida se o objeto em questão está nulo ou vazio. Caso esteja, retorna uma
	 * exceção para o usuário. HTTP Status 404
	 * 
	 * @author Filipe Santos
	 * @since 11/01/2017
	 * 
	 **/
	public void validadatorOptional(List<ENTITY> entidades) {
		Optional.ofNullable(entidades).orElseThrow(() -> new NotFoundException(log_nao_encontrado));
		Optional.of(entidades).orElseThrow(() -> new NotFoundException(log_nao_encontrado));
	}

	public void validadatorOptional(Page<ENTITY> entidades) {
		Optional.ofNullable(entidades).orElseThrow(() -> new NotFoundException(log_nao_encontrado));
		Optional.of(entidades).orElseThrow(() -> new NotFoundException(log_nao_encontrado));
	}
	

}
