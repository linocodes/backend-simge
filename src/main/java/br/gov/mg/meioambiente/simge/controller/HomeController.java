package br.gov.mg.meioambiente.simge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.gov.mg.meioambiente.simge.entity.AppUser;
import br.gov.mg.meioambiente.simge.repository.AppUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//@RestController
//@RequestMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
/*
  final UserRepository userRepository;

  @Autowired
  public HomeController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  //@GetMapping
  //public ModelAndView home() {
  //  return new ModelAndView("index");
  //}

  @GetMapping(value = "/hello")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok().body("Hello there !");
  }

  @PostMapping(value = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AppUser> create(@PathVariable String username) {
    AppUser appUser = new AppUser();
    appUser.setUsername(username);
    AppUser saved = userRepository.save(appUser);
    return ResponseEntity.ok().body(saved);
  }

  @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AppUser>> findAll() {
    final List<AppUser> resultList = new ArrayList<>();
    final Iterable<AppUser> all = userRepository.findAll();
    all.forEach(resultList::add);
    return ResponseEntity.ok().body(resultList);
  }
  */

}