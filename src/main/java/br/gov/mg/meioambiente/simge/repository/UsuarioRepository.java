package br.gov.mg.meioambiente.simge.repository;

import java.util.List;
import java.util.Optional;
import br.gov.mg.meioambiente.simge.entity.Usuario;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

	public List<Usuario> findAllByOrderByNomeAsc();

	Optional<Usuario> findByCpf(String cpf);

}
