package br.com.rental.company.contract.controller;

import br.com.rental.company.contract.controller.metric.LogExecutionTime;
import br.com.rental.company.contract.dto.ContractRequestDTO;
import br.com.rental.company.contract.dto.ContractResponseDTO;
import br.com.rental.company.contract.service.ContractService;
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
@RequestMapping(path = "/v1/contract", produces = "application/json")
@Tag(name = "Contract Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class ContractController {
    private final ContractService service;

    @LogExecutionTime
    @Operation(summary = "Get all contract")
    @GetMapping
    public ResponseEntity<List<ContractResponseDTO>> getAllContract() {
        final List<ContractResponseDTO> response = service.getAllContract();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by id")
    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> getContractById(@PathVariable("id") final Integer id) {
        final ContractResponseDTO response = service.getContractById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a contract by bookingId")
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<ContractResponseDTO> getContractByBookingId(@PathVariable("bookingId") final Integer bookingId) {
        final ContractResponseDTO response = service.getContractByBookingId(bookingId);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a contract")
    @PostMapping
    public ResponseEntity<ContractResponseDTO> saveContract(@RequestBody final ContractRequestDTO request) {
        final ContractResponseDTO response = service.saveContract(request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a contract by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> cancelContractById(@PathVariable("id") final Integer id) {
        final ContractResponseDTO response = service.cancelContractById(id);

        return ResponseEntity.ok(response);
    }
}
