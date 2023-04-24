package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.RentalCompanyBookingRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyBookingResponseDTO;
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
@RequestMapping(path = "/v1/rental-company/booking", produces = "application/json")
@Tag(name = "Rental Company Booking Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class RentalCompanyBookingController {
    private final RentalCompanyBookingService rentalCompanyBookingService;

    @LogExecutionTime
    @Operation(summary = "Get all booking")
    @GetMapping
    public ResponseEntity<List<RentalCompanyBookingResponseDTO>> getAllBooking() {
        final List<RentalCompanyBookingResponseDTO> response = rentalCompanyBookingService.getAllBooking();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a booking by id")
    @GetMapping("/{id}")
    public ResponseEntity<RentalCompanyBookingResponseDTO> getBookingById(@PathVariable("id") final Integer id) {
        final RentalCompanyBookingResponseDTO response = rentalCompanyBookingService.getBookingById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a booking by CNH number")
    @GetMapping("/customer/{cnhNumber}")
    public ResponseEntity<List<RentalCompanyBookingResponseDTO>> getBookingByCnhNumber(
            @PathVariable("cnhNumber") final String cnhNumber) {
        final List<RentalCompanyBookingResponseDTO> response = rentalCompanyBookingService.getBookingByCnhNumber(cnhNumber);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a booking")
    @PostMapping
    public ResponseEntity<RentalCompanyBookingResponseDTO> saveBooking(@RequestBody final RentalCompanyBookingRequestDTO request) {
        final RentalCompanyBookingResponseDTO rentalCompanyBookingResponse = rentalCompanyBookingService.saveBooking(request);

        return ResponseEntity.ok(rentalCompanyBookingResponse);
    }

    @LogExecutionTime
    @Operation(summary = "Update a booking")
    @PutMapping("/{id}")
    public ResponseEntity<RentalCompanyBookingResponseDTO> updateBooking(@PathVariable("id") final Integer id, @RequestBody final RentalCompanyBookingRequestDTO request) {
        final RentalCompanyBookingResponseDTO response = rentalCompanyBookingService.updateBooking(id, request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a booking by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<RentalCompanyBookingResponseDTO> cancelBookingById(@PathVariable("id") final Integer id) {
        final RentalCompanyBookingResponseDTO response = rentalCompanyBookingService.cancelBookingById(id);

        return ResponseEntity.ok(response);
    }
}
