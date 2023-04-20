package br.com.rental.company.contract;

import br.com.rental.company.contract.dto.ContractRequestDTO;
import br.com.rental.company.contract.service.ContractService;
import lombok.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class RentalCompanyContractApplication implements CommandLineRunner {
        private final ContractService contractService;

        public static void main(String[] args) {
                SpringApplication.run(RentalCompanyContractApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                // Initial Load of contract
                var contract1 = ContractRequestDTO.builder()
                        .bookingId(1)
                        .build();

                var contract2 = ContractRequestDTO.builder()
                        .bookingId(2)
                        .build();

                var contract3 = ContractRequestDTO.builder()
                        .bookingId(3)
                        .build();

                contractService.saveContract(contract1);
                contractService.saveContract(contract2);
                contractService.saveContract(contract3);
        }
}
