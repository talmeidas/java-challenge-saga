package br.com.security.company.insurance.controller;

import br.com.security.company.insurance.service.InsuranceItemService;
import br.com.security.company.insurance.repository.InsuranceItemRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InsuranceTypeControllerTest {

    @Autowired
    private InsuranceItemRepository insuranceItemRepository;

    @Autowired
    private InsuranceItemService insuranceItemService;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String URL;

    // @BeforeEach
    // void setup() {
    // URL = "http://localhost:" + port + "/v1/subject";
    //
    // insuranceItemRepository.put(InsuranceItem.builder().name("Java").build(), 1);
    // }
    //
    // @AfterEach
    // void tearDown() {
    // insuranceItemRepository.clear();
    // }
    //
    // @Test
    // void retrieveAll() {
    // //GIVEN
    // var initialCounter = insuranceItemRepository.findAll();
    //
    // //WHEN
    // var response = restTemplate.getForEntity(URL, InsuranceItem[].class);
    //
    // //THEN
    // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    // assertThat(Objects.requireNonNull(response.getBody())).hasSize(insuranceItemRepository.count());
    // assertThat(insuranceItemRepository).hasSize(initialCounter);
    // }
}