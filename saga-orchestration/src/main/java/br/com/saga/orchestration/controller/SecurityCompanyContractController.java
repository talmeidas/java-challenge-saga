package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.SecurityCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.SecurityCompanyContractResponseDTO;
import br.com.saga.orchestration.service.SecurityCompanyContractService;
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
@RequestMapping(path = "/v1/security-company-contract", produces = "application/json")
@Tag(name = "Security Company Contract Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class SecurityCompanyContractController {
    private final SecurityCompanyContractService service;

    @LogExecutionTime
    @Operation(summary = "Get all contract")
    @GetMapping
    public ResponseEntity<List<SecurityCompanyContractResponseDTO>> getAllContract() {
        final List<SecurityCompanyContractResponseDTO> response = service.getAllContract();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by id")
    @GetMapping("/{id}")
    public ResponseEntity<SecurityCompanyContractResponseDTO> getContractById(@PathVariable("id") final Integer id) {
        final SecurityCompanyContractResponseDTO response = service.getContractById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by rentalBookingId")
    @GetMapping("/rental-booking/{rentalBookingId}")
    public ResponseEntity<SecurityCompanyContractResponseDTO> getContractByRetalBookingId(@PathVariable("rentalBookingId") final Integer rentalBookingId) {
        final SecurityCompanyContractResponseDTO response = service.getContractByRetalBookingId(rentalBookingId);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by rentalContractId")
    @GetMapping("/rental-contract/{rentalContractId}")
    public ResponseEntity<SecurityCompanyContractResponseDTO> getContractByRentalContractId(@PathVariable("rentalContractId") final Integer rentalContractId) {
        final SecurityCompanyContractResponseDTO response = service.getContractByRentalContractId(rentalContractId);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a contract")
    @PostMapping
    public ResponseEntity<SecurityCompanyContractResponseDTO> saveContract(@RequestBody final SecurityCompanyContractRequestDTO request) {
        final SecurityCompanyContractResponseDTO response = service.saveContract(request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a contract by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<SecurityCompanyContractResponseDTO> cancelContractById(@PathVariable("id") final Integer id) {
        final SecurityCompanyContractResponseDTO response = service.cancelContractById(id);

        return ResponseEntity.ok(response);
    }
}
