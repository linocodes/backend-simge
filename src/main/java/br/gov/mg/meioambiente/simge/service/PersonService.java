package br.gov.mg.meioambiente.simge.service;


//import io.vavr.control.Either;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.mg.meioambiente.simge.service.errors.ErrorResponse;

import br.gov.mg.meioambiente.simge.controller.dto.UserDto;
import br.gov.mg.meioambiente.simge.controller.dto.UserListRequest;
import br.gov.mg.meioambiente.simge.controller.mapper.UserMapper;
import br.gov.mg.meioambiente.simge.controller.specification.UserListSpecification;
import br.gov.mg.meioambiente.simge.entity.User;
import br.gov.mg.meioambiente.simge.repository.UserRepository;

@Service
public class PersonService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserListSpecification userListSpecification;

    public PersonService(UserRepository userRepository, UserMapper userMapper, UserListSpecification userListSpecification) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userListSpecification = userListSpecification;
    }

    //public Either<ErrorResponse, Page<UserDto>> findAll(UserListRequest request, Pageable pageable) {
    //    Page<User> userPage = userRepository.findAll(userListSpecification.getFilter(request), pageable);
    //    return Either.right(userPage.map(userMapper::map));
    //}
    /*
    Person example = new Person();
    example.setLastName("James");
    example.setEmployed(true);
    PersonSpec personSpec = new PersonSpec(example);
    List<Person> persons = personRepository.findAll(personSpec);  
    */  
    
            
}