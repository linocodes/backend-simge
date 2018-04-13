package br.gov.mg.meioambiente.simge.repository;

import java.util.List;

import br.gov.mg.meioambiente.simge.entity.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);	
}