package br.com.motor.company.automobile.controller;

import br.com.motor.company.automobile.service.AutomobileService;
import br.com.motor.company.automobile.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AutoControllerTest {

    @Autowired
    private AutomobileRepository autoRepository;

    @Autowired
    private AutomobileService autoService;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String URL;

    // @BeforeEach
    // void setup() {
    // URL = "http://localhost:" + port + "/v1/subject";
    //
    // autoRepository.put(Auto.builder().name("Java").build(), 1);
    // }
    //
    // @AfterEach
    // void tearDown() {
    // autoRepository.clear();
    // }
    //
    // @Test
    // void retrieveAll() {
    // //GIVEN
    // var initialCounter = autoRepository.findAll();
    //
    // //WHEN
    // var response = restTemplate.getForEntity(URL, Auto[].class);
    //
    // //THEN
    // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    // assertThat(Objects.requireNonNull(response.getBody())).hasSize(autoRepository.count());
    // assertThat(autoRepository).hasSize(initialCounter);
    // }
}