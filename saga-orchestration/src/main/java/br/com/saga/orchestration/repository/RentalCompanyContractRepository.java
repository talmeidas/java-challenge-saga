package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.rental.company.ContractRequestDTO;
import br.com.saga.orchestration.dto.rental.company.ContractResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Repository
@FeignClient(
        name = "rentalCompanyContract",
        url = "${app.rental-company-contract.url}",
        configuration = FeignClientConfiguration.class
)
public interface RentalCompanyContractRepository {

    @GetMapping("/v1/contract")
    List<ContractResponseDTO> getAllContract();

    @GetMapping("/v1/contract/{id}")
    ContractResponseDTO getContractById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/contract/booking/{bookingId}")
    ContractResponseDTO getContractByBookingId(@PathVariable("bookingId") final Integer bookingId);

    @PostMapping("/v1/contract")
    ContractResponseDTO saveContract(@RequestBody final ContractRequestDTO request);

    @DeleteMapping("/v1/contract/{id}")
    ContractResponseDTO cancelContractById(@PathVariable("id") final Integer id);
}
