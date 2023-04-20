package br.com.rental.company.support.controller;

import br.com.rental.company.support.dto.*;
import br.com.rental.company.support.model.*;
import br.com.rental.company.support.service.CustomerSupportService;
import br.com.rental.company.support.repository.CustomerSupportRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;
import org.springframework.http.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerSupportControllerTest {

    @Autowired
    private CustomerSupportRepository customerSupportRepository;

    @Autowired
    private CustomerSupportService customerSupportService;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String URL;

    // @BeforeEach
    // void setup() {
    // URL = "http://localhost:" + port + "/v1/subject";
    //
    // customerSupportRepository.put(CustomerSupport.builder().name("Java").build(),
    // 1);
    // }
    //
    // @AfterEach
    // void tearDown() {
    // customerSupportRepository.clear();
    // }
    //
    // @Test
    // void retrieveAll() {
    // //GIVEN
    // var initialCounter = customerSupportRepository.findAll();
    //
    // //WHEN
    // var response = restTemplate.getForEntity(URL, CustomerSupport[].class);
    //
    // //THEN
    // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    // assertThat(Objects.requireNonNull(response.getBody())).hasSize(customerSupportRepository.count());
    // assertThat(customerSupportRepository).hasSize(initialCounter);
    // }
}