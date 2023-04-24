package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.SecurityCompanyInsuranceItemResponseDTO;
import br.com.saga.orchestration.dto.SecurityCompanyInsuranceTypeResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@Repository
@FeignClient(
        name = "securityCompanyInsurance",
        url = "${app.security-company-insurance.url}",
        configuration = FeignClientConfiguration.class
)
public interface SecurityCompanyInsuranceRepository {
    @GetMapping("/v1/insurance-type")
    List<SecurityCompanyInsuranceTypeResponseDTO> getAllInsuranceType();

    @GetMapping("/v1/insurance-type/{id}/detail")
    List<SecurityCompanyInsuranceItemResponseDTO> getInsuranceDetailByTypeId(
            @PathVariable("id") final Integer id);
}
