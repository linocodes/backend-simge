package br.gov.mg.meioambiente.simge.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mg.meioambiente.simge.entity.Tag;
import br.gov.mg.meioambiente.simge.entity.Usuario;
import br.gov.mg.meioambiente.simge.repository.TagRepository;
import br.gov.mg.meioambiente.simge.repository.UsuarioRepository;
import br.gov.mg.meioambiente.simge.validator.EntityOptionalValidator;



@Service
public class UsuarioService  extends AbstractService<Usuario, Long> {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super(usuarioRepository);
	}

	@Override
	boolean isValidacao(Usuario entity) {
		return false;
	}

	@Override
	void beforeCreate(Usuario entity) {
	}

	@Override
	void afterCreate(Usuario entity) {
	}

	@Override
	void beforeUpdate(Usuario entity) {
	}

	@Override
	void afterUpdate(Usuario entity) {
	}

	@Override
	void beforeDelete(Usuario entity) {
	}

	@Override
	void afterDelete(Usuario entity) {
	}	
	
	

	

}
