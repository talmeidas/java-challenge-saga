package br.com.motor.company.automobile.controller;

import br.com.motor.company.automobile.controller.metric.LogExecutionTime;
import br.com.motor.company.automobile.dto.AutomobileDetailResponseDTO;
import br.com.motor.company.automobile.dto.AutomobileResponseDTO;
import br.com.motor.company.automobile.service.AutomobileDetailService;
import br.com.motor.company.automobile.service.AutomobileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/automobile", produces = "application/json")
@Tag(name = "Automobile Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class AutomobileController {
    private final AutomobileService automobileService;
    private final AutomobileDetailService automobileDetailService;

    @LogExecutionTime
    @Operation(summary = "Get all automobile")
    @GetMapping
    public ResponseEntity<List<AutomobileResponseDTO>> getAllAutomobile() {
        final List<AutomobileResponseDTO> response = automobileService.getAllAutomobile();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get automobile's details by id")
    @GetMapping("/{id}/detail")
    public ResponseEntity<AutomobileDetailResponseDTO> findDetailByAutomobileId(@PathVariable("id") final Integer id) {
        final AutomobileDetailResponseDTO response = automobileDetailService.findDetailByAutomobileId(id);

        return ResponseEntity.ok(response);
    }
}
