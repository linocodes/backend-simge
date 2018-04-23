package br.gov.mg.meioambiente.simge.repository;

import org.springframework.stereotype.Repository;
import br.gov.mg.meioambiente.simge.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}