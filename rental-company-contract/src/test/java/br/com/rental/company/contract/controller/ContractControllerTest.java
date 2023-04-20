package br.com.rental.company.contract.controller;

import br.com.rental.company.contract.repository.ContractRepository;
import br.com.rental.company.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContractControllerTest {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractService contractService;

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String URL;

    // @BeforeEach
    // void setup() {
    // URL = "http://localhost:" + port + "/v1/subject";
    //
    // contractRepository.put(Contract.builder().name("Java").build(),
    // 1);
    // }
    //
    // @AfterEach
    // void tearDown() {
    // contractRepository.clear();
    // }
    //
    // @Test
    // void retrieveAll() {
    // //GIVEN
    // var initialCounter = contractRepository.findAll();
    //
    // //WHEN
    // var response = restTemplate.getForEntity(URL, Contract[].class);
    //
    // //THEN
    // assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    // assertThat(Objects.requireNonNull(response.getBody())).hasSize(contractRepository.count());
    // assertThat(contractRepository).hasSize(initialCounter);
    // }
}