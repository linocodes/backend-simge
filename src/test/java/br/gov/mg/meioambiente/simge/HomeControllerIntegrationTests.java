package br.gov.mg.meioambiente.simge;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.gov.mg.meioambiente.simge.entity.AppUser;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestPropertySource(locations = {"classpath:application-test.yml"})
public class HomeControllerIntegrationTests {
/*
  RestTemplate restTemplate = new RestTemplate();

  @Test
  public void shouldAdd_AppUser_ToDb() {

    ResponseEntity<AppUser> responseEntity = restTemplate
      .postForEntity("http://localhost:9095/user/Abderrazak BOUADMA",
        MockHttpServletRequest.DEFAULT_PROTOCOL,
        AppUser.class);

    final AppUser appUser = responseEntity.getBody();

    Assertions.assertThat(appUser).isNotNull();
    Assertions.assertThat(appUser.getUsername()).isNotNull().isEqualTo("Abderrazak BOUADMA");
  }
  */
}