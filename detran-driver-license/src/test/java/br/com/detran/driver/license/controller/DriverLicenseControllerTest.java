package br.com.detran.driver.license.controller;

import br.com.detran.driver.license.service.DriverLicenseService;
import br.com.detran.driver.license.repository.DriverLicenseRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverLicenseControllerTest {

    @Autowired
    private DriverLicenseRepository driverLicenseRepository;

    @Autowired
    private DriverLicenseService driverLicenseService;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String URL;

    // @BeforeEach
    // void setup() {
    // URL = "http://localhost:" + port + "/v1/subject";
    //
    // driverLicenseRepository.put(DriverLicense.builder().name("Java").build(), 1);
    // }
    //
    // @AfterEach
    // void tearDown() {
    // driverLicenseRepository.clear();
    // }
    //
    // @Test
    // void retrieveAll() {
    // //GIVEN
    // var initialCounter = driverLicenseRepository.findAll();
    //
    // //WHEN
    // var response = restTemplate.getForEntity(URL, DriverLicense[].class);
    //
    // //THEN
    // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    // assertThat(Objects.requireNonNull(response.getBody())).hasSize(driverLicenseRepository.count());
    // assertThat(driverLicenseRepository).hasSize(initialCounter);
    // }
}