package br.gov.mg.meioambiente.simge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.gov.mg.meioambiente.simge.entity.Phone;

public interface PhoneRepository extends BaseRepository<Phone, Long> {
}
