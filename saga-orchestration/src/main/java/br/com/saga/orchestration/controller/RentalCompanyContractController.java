package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.RentalCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyContractResponseDTO;
import br.com.saga.orchestration.service.RentalCompanyContractService;
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
@RequestMapping(path = "/v1/rental-company/contract", produces = "application/json")
@Tag(name = "Rental Company Contract Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class RentalCompanyContractController {
    private final RentalCompanyContractService service;

    @LogExecutionTime
    @Operation(summary = "Get all contract")
    @GetMapping
    public ResponseEntity<List<RentalCompanyContractResponseDTO>> getAllContract() {
        final List<RentalCompanyContractResponseDTO> response = service.getAllContract();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by id")
    @GetMapping("/{id}")
    public ResponseEntity<RentalCompanyContractResponseDTO> getContractById(@PathVariable("id") final Integer id) {
        final RentalCompanyContractResponseDTO response = service.getContractById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by bookingId")
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<RentalCompanyContractResponseDTO> getContractByBookingId(@PathVariable("bookingId") final Integer bookingId) {
        final RentalCompanyContractResponseDTO response = service.getContractByBookingId(bookingId);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a contract")
    @PostMapping
    public ResponseEntity<RentalCompanyContractResponseDTO> saveContract(@RequestBody final RentalCompanyContractRequestDTO request) {
        final RentalCompanyContractResponseDTO response = service.saveContract(request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a contract by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<RentalCompanyContractResponseDTO> cancelContractById(@PathVariable("id") final Integer id) {
        final RentalCompanyContractResponseDTO response = service.cancelContractById(id);

        return ResponseEntity.ok(response);
    }
}
