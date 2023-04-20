package br.com.security.company.insurance.controller;

import br.com.security.company.insurance.controller.metric.LogExecutionTime;
import br.com.security.company.insurance.dto.InsuranceItemResponseDTO;
import br.com.security.company.insurance.dto.InsuranceTypeResponseDTO;
import br.com.security.company.insurance.service.InsuranceItemService;
import br.com.security.company.insurance.service.InsuranceTypeService;
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
@RequestMapping(path = "/v1/insurance-type", produces = "application/json")
@Tag(name = "Insurance Type Controller")
@SecurityRequirement(name = "basicAuth")
@Slf4j
public class InsuranceTypeController {
    private final InsuranceTypeService insuranceService;
    private final InsuranceItemService insuranceItemService;

    @LogExecutionTime
    @Operation(summary = "Get all insurance's type")
    @GetMapping
    public ResponseEntity<List<InsuranceTypeResponseDTO>> getAllInsuranceType() {
        final List<InsuranceTypeResponseDTO> response = insuranceService.getAllInsuranceType();

        return ResponseEntity.ok(response);
    }

    @LogExecutionTime
    @Operation(summary = "Get insurance's detail by type id")
    @GetMapping("/{id}/detail")
    public ResponseEntity<List<InsuranceItemResponseDTO>> getInsuranceDetailByTypeId(
            @PathVariable("id") final Integer id) {
        final List<InsuranceItemResponseDTO> response = insuranceItemService.getInsuranceDetailByTypeId(id);

        return ResponseEntity.ok(response);
    }
}
