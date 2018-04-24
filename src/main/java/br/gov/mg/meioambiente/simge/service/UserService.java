package br.gov.mg.meioambiente.simge.service;


import org.springframework.beans.factory.annotation.Autowired;
//import io.vavr.control.Either;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.mg.meioambiente.simge.service.errors.ErrorResponse;

import br.gov.mg.meioambiente.simge.controller.dto.UserDto;
import br.gov.mg.meioambiente.simge.controller.dto.UserListRequest;
import br.gov.mg.meioambiente.simge.controller.mapper.UserMapper;
import br.gov.mg.meioambiente.simge.controller.specification.UserListSpecification;
import br.gov.mg.meioambiente.simge.entity.Tag;
import br.gov.mg.meioambiente.simge.entity.User;
import br.gov.mg.meioambiente.simge.filter.Filter;
import br.gov.mg.meioambiente.simge.repository.TagRepository;
import br.gov.mg.meioambiente.simge.repository.UserRepository;

@Service
public class UserService extends AbstractService<User, Long> {
	
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}	

	@Override
	boolean isValidacao(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void beforeCreate(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void afterCreate(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void beforeUpdate(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void afterUpdate(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void beforeDelete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void afterDelete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	Filter search(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void entityUpdate(User origem, User destino) {
		// TODO Auto-generated method stub
		
	}
/*
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserListSpecification userListSpecification;

    public UserService(UserRepository userRepository, UserMapper userMapper, UserListSpecification userListSpecification) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userListSpecification = userListSpecification;
    }
    */

    //public Either<ErrorResponse, Page<UserDto>> findAll(UserListRequest request, Pageable pageable) {
    //    Page<User> userPage = userRepository.findAll(userListSpecification.getFilter(request), pageable);
    //    return Either.right(userPage.map(userMapper::map));
    //}
    
            
}