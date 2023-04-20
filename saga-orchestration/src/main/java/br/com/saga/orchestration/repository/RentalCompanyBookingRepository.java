package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.rental.company.BookingRequestDTO;
import br.com.saga.orchestration.dto.rental.company.BookingResponseDTO;
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
    List<BookingResponseDTO> getAllBooking();

    @GetMapping("/v1/booking/{id}")
    BookingResponseDTO getBookingById(@PathVariable("id") final Integer id);

    @GetMapping("/v1/booking/customer/{cnh}")
    List<BookingResponseDTO> getBookingByCnh(@PathVariable("cnh") final String cnh);

    @PostMapping("/v1/booking")
    BookingResponseDTO saveBooking(@RequestBody final BookingRequestDTO request);

    @PutMapping("/v1/booking/{id}")
    BookingResponseDTO updateBooking(
            @PathVariable("id") final Integer id,
            @RequestBody final BookingRequestDTO request);

    @DeleteMapping("/v1/booking/{id}")
    BookingResponseDTO cancelBookingById(@PathVariable("id") final Integer id);
}
