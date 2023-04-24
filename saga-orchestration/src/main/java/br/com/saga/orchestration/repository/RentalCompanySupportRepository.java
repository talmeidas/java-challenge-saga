package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.RentalCompanySupportAddressResponseDTO;
import br.com.saga.orchestration.dto.RentalCompanySupportCustomerRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanySupportCustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Repository
@FeignClient(
        name = "rentalCompanySupport",
        url = "${app.rental-company-support.url}",
        configuration = FeignClientConfiguration.class
)
public interface RentalCompanySupportRepository {
    @GetMapping("/v1/customer-support")
    List<RentalCompanySupportCustomerResponseDTO> getAllSchedule();

    @GetMapping("/v1/customer-support/{id}")
    RentalCompanySupportCustomerResponseDTO getScheduleById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/customer-support/customer/{cnhNumber}")
    List<RentalCompanySupportCustomerResponseDTO> getScheduleByCnhNumber(@PathVariable("cnhNumber") final String cnhNumber);

    @PostMapping("/v1/customer-support")
    RentalCompanySupportCustomerResponseDTO saveSchedule(@RequestBody final RentalCompanySupportCustomerRequestDTO request);

    @DeleteMapping("/v1/customer-support/{id}")
    RentalCompanySupportCustomerResponseDTO cancelScheduleById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/address")
    List<RentalCompanySupportAddressResponseDTO> getAllAddress();
}
