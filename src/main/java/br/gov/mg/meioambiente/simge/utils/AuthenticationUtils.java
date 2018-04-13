package br.gov.mg.meioambiente.simge.utils;

import br.gov.mg.meioambiente.simge.entity.Usuario;

//import org.springframework.security.core.context.SecurityContextHolder;

//import br.gov.mg.meioambiente.sade.enuns.Orgao;
//import br.gov.mg.meioambiente.sade.model.Usuario;

public class AuthenticationUtils {

	private static Usuario usuario;

	public AuthenticationUtils() {

	}

	/*
	public static Orgao retornaOrgaoUsuarioLogado() {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof Usuario) {
				usuario = ((Usuario) principal);
			}

			return usuario.getOrgao();
		} catch (Exception e) {
			return null;
		}
	}
	*/

	public static Usuario retornaUsuarioLogado() {
/*
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof Usuario) {
				usuario = ((Usuario) principal);
			}
			return usuario;
		} catch (Exception e) {
			return usuario;
		}
		*/
		return null;

	}

}
