package br.com.rental.company.support.controller;

import br.com.rental.company.support.controller.metric.LogExecutionTime;
import br.com.rental.company.support.dto.AddressResponseDTO;
import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportResponseDTO;
import br.com.rental.company.support.service.AddressService;
import br.com.rental.company.support.service.CustomerSupportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/address", produces = "application/json")
@Tag(name = "Address Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class AddressController {
    private final AddressService service;

    @LogExecutionTime
    @Operation(summary = "Get all address")
    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> getAllAddress() {
        final List<AddressResponseDTO> response = service.getAllAddress();

        return ResponseEntity.ok(response);
    }
}
