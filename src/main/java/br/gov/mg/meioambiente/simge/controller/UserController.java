package br.gov.mg.meioambiente.simge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.simge.entity.User;
import br.gov.mg.meioambiente.simge.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseRestController<User, Long> {

	@Autowired
    public UserController(UserService userService) {
		super(userService);
    }

    /*
    @RequestMapping(
        value = "",
        method = RequestMethod.GET)
    public ResponseEntity getAllUser(UserListRequest request, Pageable pageable) {
    	return null;
       // return userService.findAll(request, pageable).fold(
       //     this::errorToResponse,
       //     this::toResponse
       // );
    }*/
}