package br.gov.mg.meioambiente.simge.repository;


import org.springframework.data.repository.CrudRepository;

import br.gov.mg.meioambiente.simge.entity.AppUser;

public interface AppUserRepository extends BaseRepository<AppUser, Long> {
}