package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.RentalCompanySupportAddressResponseDTO;
import br.com.saga.orchestration.dto.RentalCompanySupportCustomerRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanySupportCustomerResponseDTO;
import br.com.saga.orchestration.service.RentalCompanySupportService;
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
@RequestMapping(path = "/v1/rental-company/support", produces = "application/json")
@Tag(name = "Rental Company Support Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class RentalCompanySupportController {
    private final RentalCompanySupportService service;

    @LogExecutionTime
    @Operation(summary = "Get all customer support")
    @GetMapping
    public ResponseEntity<List<RentalCompanySupportCustomerResponseDTO>> getAllSchedule() {
        final List<RentalCompanySupportCustomerResponseDTO> response = service.getAllSchedule();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a customer support by support id")
    @GetMapping("/{id}")
    public ResponseEntity<RentalCompanySupportCustomerResponseDTO> getScheduleById(@PathVariable("id") final Integer id) {
        final RentalCompanySupportCustomerResponseDTO response = service.getScheduleById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a customer support by CNH number")
    @GetMapping("/customer/{cnhNumber}")
    public ResponseEntity<List<RentalCompanySupportCustomerResponseDTO>> getScheduleByCnhNumber(
            @PathVariable("cnhNumber") final String cnhNumber) {
        final List<RentalCompanySupportCustomerResponseDTO> response = service.getScheduleByCnhNumber(cnhNumber);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a customer support")
    @PostMapping
    public ResponseEntity<RentalCompanySupportCustomerResponseDTO> saveSchedule(
            @RequestBody final RentalCompanySupportCustomerRequestDTO request) {
        final RentalCompanySupportCustomerResponseDTO response = service.saveSchedule(request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a customer support by support id")
    @DeleteMapping("/{id}")
    public ResponseEntity<RentalCompanySupportCustomerResponseDTO> cancelScheduleById(
            @PathVariable("id") final Integer id) {
        final RentalCompanySupportCustomerResponseDTO response = service.cancelScheduleById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get all address")
    @GetMapping("address")
    public ResponseEntity<List<RentalCompanySupportAddressResponseDTO>> getAllAddress() {
        final List<RentalCompanySupportAddressResponseDTO> response = service.getAllAddress();

        return ResponseEntity.ok(response);
    }
}
