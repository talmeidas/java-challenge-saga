package br.com.security.company.contract;

import br.com.security.company.contract.dto.ContractRequestDTO;
import br.com.security.company.contract.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityCompanyContractApplication implements CommandLineRunner {
    private final ContractService contractService;

    public static void main(String[] args) {
        SpringApplication.run(SecurityCompanyContractApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Initial Load of contract
        var contract1 = ContractRequestDTO.builder()
                .rentalBookingId(1)
                .rentalContractId(1)
                .build();

        var contract2 = ContractRequestDTO.builder()
                .rentalBookingId(2)
                .rentalContractId(2)
                .build();

        var contract3 = ContractRequestDTO.builder()
                .rentalBookingId(3)
                .rentalContractId(3)
                .build();

        contractService.saveContract(contract1);
        contractService.saveContract(contract2);
        contractService.saveContract(contract3);
    }
}
