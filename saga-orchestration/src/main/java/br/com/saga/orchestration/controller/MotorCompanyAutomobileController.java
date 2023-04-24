package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.MotorCompanyAutomobileDetailResponseDTO;
import br.com.saga.orchestration.dto.MotorCompanyAutomobileResponseDTO;
import br.com.saga.orchestration.service.MotorCompanyAutomobileService;
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
@RequestMapping(path = "/v1/motor-company/automobile", produces = "application/json")
@Tag(name = "Motor Company Automobile Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class MotorCompanyAutomobileController {
    private final MotorCompanyAutomobileService service;

    @LogExecutionTime
    @Operation(summary = "Get all automobile")
    @GetMapping
    public ResponseEntity<List<MotorCompanyAutomobileResponseDTO>> getAllAutomobile() {
        final List<MotorCompanyAutomobileResponseDTO> response = service.getAllAutomobile();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get automobile's details by id")
    @GetMapping("/{id}/detail")
    public ResponseEntity<MotorCompanyAutomobileDetailResponseDTO> findDetailByAutomobileId(@PathVariable("id") final Integer id) {
        final MotorCompanyAutomobileDetailResponseDTO response = service.findDetailByAutomobileId(id);

        return ResponseEntity.ok(response);
    }
}
