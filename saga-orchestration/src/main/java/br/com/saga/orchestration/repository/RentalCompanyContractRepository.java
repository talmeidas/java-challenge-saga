package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.RentalCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyContractResponseDTO;
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
    List<RentalCompanyContractResponseDTO> getAllContract();

    @GetMapping("/v1/contract/{id}")
    RentalCompanyContractResponseDTO getContractById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/contract/booking/{bookingId}")
    RentalCompanyContractResponseDTO getContractByBookingId(@PathVariable("bookingId") final Integer bookingId);

    @PostMapping("/v1/contract")
    RentalCompanyContractResponseDTO saveContract(@RequestBody final RentalCompanyContractRequestDTO request);

    @DeleteMapping("/v1/contract/{id}")
    RentalCompanyContractResponseDTO cancelContractById(@PathVariable("id") final Integer id);
}
