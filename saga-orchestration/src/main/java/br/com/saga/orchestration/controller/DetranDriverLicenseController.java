package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.DetranDriverLicenseResponseDTO;
import br.com.saga.orchestration.service.DetranDriverLicenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/detran-driver/license", produces = "application/json")
@Tag(name = "Detran Driver License Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class DetranDriverLicenseController {
    private final DetranDriverLicenseService service;

    @LogExecutionTime
    @Operation(summary = "Get a driver license status by CNH number")
    @GetMapping("/{cnhNumber}")
    public ResponseEntity<DetranDriverLicenseResponseDTO> getDriverLicenseStatusByCnhNumber(@PathVariable("cnhNumber") final String cnhNumber) {
        final DetranDriverLicenseResponseDTO response = service.getDriverLicenseStatusByCnhNumber(cnhNumber);

        return ResponseEntity.ok(response);
    }
}
