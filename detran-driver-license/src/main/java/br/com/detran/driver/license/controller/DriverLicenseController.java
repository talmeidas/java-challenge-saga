package br.com.detran.driver.license.controller;

import br.com.detran.driver.license.controller.metric.LogExecutionTime;
import br.com.detran.driver.license.dto.DriverLicenseResponseDTO;
import br.com.detran.driver.license.service.DriverLicenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/driver-license", produces = "application/json")
@Tag(name = "Driver License Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class DriverLicenseController {
    private final DriverLicenseService service;

    @LogExecutionTime
    @Operation(summary = "Get a driver license status by CNH")
    @GetMapping("/{cnh}")
    public ResponseEntity<DriverLicenseResponseDTO> getDriverLicenseStatusByCnh(@PathVariable("cnh") final String cnh) {
        final DriverLicenseResponseDTO response = service.getDriverLicenseStatusByCnh(cnh);

        return ResponseEntity.ok(response);
    }
}
