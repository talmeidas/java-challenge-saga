package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.rental.company.BookingRequestDTO;
import br.com.saga.orchestration.dto.rental.company.BookingResponseDTO;
import br.com.saga.orchestration.service.RentalCompanyBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/rental-company", produces = "application/json")
@Tag(name = "Rental Company Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class RentalCompanyBookingController {
    private final RentalCompanyBookingService service;

    @LogExecutionTime
    @Operation(summary = "Get all booking")
    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBooking() {
        final List<BookingResponseDTO> response = service.getAllBooking();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a booking by id")
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable("id") final Integer id) {
        final BookingResponseDTO response = service.getBookingById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a booking by cnh")
    @GetMapping("/customer/{cnh}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingByCnh(
            @PathVariable("cnh") final String cnh) {
        final List<BookingResponseDTO> response = service.getBookingByCnh(cnh);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a booking")
    @PostMapping
    public ResponseEntity<BookingResponseDTO> saveBooking(@RequestBody final BookingRequestDTO request) {
        final BookingResponseDTO response = service.saveBooking(request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Update a booking")
    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable("id") final Integer id, @RequestBody final BookingRequestDTO request) {
        final BookingResponseDTO response = service.updateBooking(id, request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a booking by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> cancelBookingById(@PathVariable("id") final Integer id) {
        final BookingResponseDTO response = service.cancelBookingById(id);

        return ResponseEntity.ok(response);
    }
}
