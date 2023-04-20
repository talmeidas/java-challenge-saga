package br.com.rental.company.booking.controller;

import br.com.rental.company.booking.service.BookingService;
import br.com.rental.company.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.web.client.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingControllerTest {

    @Autowired
    private BookingRepository customerSupportRepository;

    @Autowired
    private BookingService customerSupportService;

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