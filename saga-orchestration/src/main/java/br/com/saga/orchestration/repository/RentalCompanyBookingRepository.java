package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.RentalCompanyBookingRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyBookingResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Repository
@FeignClient(
        name = "rentalCompanyBooking",
        url = "${app.rental-company-booking.url}",
        configuration = FeignClientConfiguration.class
)
public interface RentalCompanyBookingRepository {
    @GetMapping("/v1/booking")
    List<RentalCompanyBookingResponseDTO> getAllBooking();

    @GetMapping("/v1/booking/{id}")
    RentalCompanyBookingResponseDTO getBookingById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/booking/customer/{cnhNumber}")
    List<RentalCompanyBookingResponseDTO> getBookingByCnhNumber(@PathVariable("cnhNumber") final String cnhNumber);

    @PostMapping("/v1/booking")
    RentalCompanyBookingResponseDTO saveBooking(@RequestBody final RentalCompanyBookingRequestDTO request);

    @PutMapping("/v1/booking/{id}")
    RentalCompanyBookingResponseDTO updateBooking(
            @PathVariable("id") final Integer id,
            @RequestBody final RentalCompanyBookingRequestDTO request);

    @DeleteMapping("/v1/booking/{id}")
    RentalCompanyBookingResponseDTO cancelBookingById(@PathVariable("id") final Integer id);
}
