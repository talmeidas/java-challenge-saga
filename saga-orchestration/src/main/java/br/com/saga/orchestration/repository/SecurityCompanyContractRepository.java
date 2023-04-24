package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.SecurityCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.SecurityCompanyContractResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Repository
@FeignClient(
        name = "securityCompanyContract",
        url = "${app.security-company-contract.url}",
        configuration = FeignClientConfiguration.class
)
public interface SecurityCompanyContractRepository {
    @GetMapping("/v1/contract")
    List<SecurityCompanyContractResponseDTO> getAllContract();

    @GetMapping("/v1/contract/{id}")
    SecurityCompanyContractResponseDTO getContractById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/contract/rental-booking/{rentalBookingId}")
    SecurityCompanyContractResponseDTO getContractByRetalBookingId(@PathVariable("rentalBookingId") final Integer rentalBookingId);

    @GetMapping("/v1/contract/rental-contract/{rentalContractId}")
    SecurityCompanyContractResponseDTO getContractByRentalContractId(@PathVariable("rentalContractId") final Integer rentalContractId);

    @PostMapping("/v1/contract")
    SecurityCompanyContractResponseDTO saveContract(@RequestBody final SecurityCompanyContractRequestDTO request);

    @DeleteMapping("/v1/contract/{id}")
    SecurityCompanyContractResponseDTO cancelContractById(@PathVariable("id") final Integer id);
}
