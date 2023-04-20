package br.com.rental.company.support.controller;

import br.com.rental.company.support.controller.metric.LogExecutionTime;
import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportResponseDTO;
import br.com.rental.company.support.service.CustomerSupportService;
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
@RequestMapping(path = "/v1/customer-support", produces = "application/json")
@Tag(name = "Customer Support Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class CustomerSupportController {
    private final CustomerSupportService service;

    @LogExecutionTime
    @Operation(summary = "Get all customer support")
    @GetMapping
    public ResponseEntity<List<CustomerSupportResponseDTO>> getAllSchedule() {
        final List<CustomerSupportResponseDTO> response = service.getAllSchedule();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a customer support by support id")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerSupportResponseDTO> getScheduleById(@PathVariable("id") final Integer id) {
        final CustomerSupportResponseDTO response = service.getScheduleById(id);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get a customer support by cnh")
    @GetMapping("/customer/{cnh}")
    public ResponseEntity<List<CustomerSupportResponseDTO>> getScheduleByCnh(
            @PathVariable("cnh") final String cnh) {
        final List<CustomerSupportResponseDTO> response = service.getScheduleByCnh(cnh);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Create a customer support")
    @PostMapping
    public ResponseEntity<CustomerSupportResponseDTO> saveSchedule(
            @RequestBody final CustomerSupportRequestDTO request) {
        final CustomerSupportResponseDTO response = service.saveSchedule(request);

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Cancel a customer support by support id")
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerSupportResponseDTO> cancelScheduleById(
            @PathVariable("id") final Integer id) {
        final CustomerSupportResponseDTO response = service.cancelScheduleById(id);

        return ResponseEntity.ok(response);
    }
}
