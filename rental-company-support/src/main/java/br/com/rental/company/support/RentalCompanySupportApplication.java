package br.com.rental.company.support;

import br.com.rental.company.support.dto.AddressRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.enumerable.Country;
import br.com.rental.company.support.enumerable.MessageReason;
import br.com.rental.company.support.enumerable.StateAcronym;
import br.com.rental.company.support.service.AddressService;
import br.com.rental.company.support.service.CustomerSupportService;
import lombok.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class RentalCompanySupportApplication implements CommandLineRunner {
        private final AddressService addressService;
        private final CustomerSupportService customerSupportService;

        public static void main(String[] args) {
                SpringApplication.run(RentalCompanySupportApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                // Initial Load of customer support
                var support1 = CustomerSupportRequestDTO.builder()
                        .name("Name 1")
                        .cpf("00000000191")
                        .cnh("07021871297")
                        .birthDate(Date.from(Instant.parse("1980-01-01T00:00:00.000Z")))
                        .email("user1@email.com")
                        .phone("11123456789")
                        .bookingId(1)
                        .messageReason(MessageReason.REQUEST)
                        .message("message 1")
                        .build();

                var support2 = CustomerSupportRequestDTO.builder()
                        .name("Name 2")
                        .cpf("27626137019")
                        .cnh("69457688418")
                        .birthDate(Date.from(Instant.parse("1990-01-01T00:00:00.000Z")))
                        .email("user2@email.com")
                        .phone("11123456789")
                        .bookingId(2)
                        .messageReason(MessageReason.COMPLAINT)
                        .message("message 2")
                        .build();

                var support3 = CustomerSupportRequestDTO.builder()
                        .name("Name 3")
                        .cpf("08565793001")
                        .cnh("21418336906")
                        .birthDate(Date.from(Instant.parse("2000-01-01T00:00:00.000Z")))
                        .email("user3@email.com")
                        .phone("11123456789")
                        .bookingId(3)
                        .messageReason(MessageReason.PRAISE)
                        .message("message 3")
                        .build();

                customerSupportService.saveSchedule(support1);
                customerSupportService.saveSchedule(support2);
                customerSupportService.saveSchedule(support3);

                // Initial Load of addresses
                var address1 = AddressRequestDTO.builder()
                                .address("Rua sem nome 1")
                                .number(123)
                                .city("São Paulo")
                                .state(StateAcronym.SP)
                                .country(Country.BRASIL)
                                .zipCode(12345678)
                                .build();

                var address2 = AddressRequestDTO.builder()
                                .address("Rua sem nome 2")
                                .number(456)
                                .city("São Paulo")
                                .state(StateAcronym.SP)
                                .country(Country.BRASIL)
                                .zipCode(12345678)
                                .build();

                var address3 = AddressRequestDTO.builder()
                                .address("Rua sem nome 3")
                                .number(789)
                                .city("São Paulo")
                                .state(StateAcronym.SP)
                                .country(Country.BRASIL)
                                .zipCode(12345678)
                                .build();

                addressService.saveAddress(address1);
                addressService.saveAddress(address2);
                addressService.saveAddress(address3);
        }
}
