package br.com.saga.orchestration.controller;

import br.com.saga.orchestration.controller.metric.LogExecutionTime;
import br.com.saga.orchestration.dto.SecurityCompanyInsuranceItemResponseDTO;
import br.com.saga.orchestration.dto.SecurityCompanyInsuranceTypeResponseDTO;
import br.com.saga.orchestration.service.SecurityCompanyInsuranceService;
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
@RequestMapping(path = "/v1/security-company-insurance", produces = "application/json")
@Tag(name = "Security Company Insurance Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class SecurityCompanyInsuranceController {
    private final SecurityCompanyInsuranceService service;

    @LogExecutionTime
    @Operation(summary = "Get all insurance's type")
    @GetMapping("/type")
    public ResponseEntity<List<SecurityCompanyInsuranceTypeResponseDTO>> getAllInsuranceType() {
        final List<SecurityCompanyInsuranceTypeResponseDTO> response = service.getAllInsuranceType();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get insurance's detail by type id")
    @GetMapping("/type/{id}/detail")
    public ResponseEntity<List<SecurityCompanyInsuranceItemResponseDTO>> getInsuranceDetailByTypeId(
            @PathVariable("id") final Integer id) {
        final List<SecurityCompanyInsuranceItemResponseDTO> response = service.getInsuranceDetailByTypeId(id);

        return ResponseEntity.ok(response);
    }
}
