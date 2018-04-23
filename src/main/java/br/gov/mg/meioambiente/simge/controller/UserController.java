package br.gov.mg.meioambiente.simge.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.meioambiente.simge.controller.dto.UserListRequest;
import br.gov.mg.meioambiente.simge.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
        value = "",
        method = RequestMethod.GET)
    public ResponseEntity getAllUser(UserListRequest request, Pageable pageable) {
    	return null;
       // return userService.findAll(request, pageable).fold(
       //     this::errorToResponse,
       //     this::toResponse
       // );
    }
}