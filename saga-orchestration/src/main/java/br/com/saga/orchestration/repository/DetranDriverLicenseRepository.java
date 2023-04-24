package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.DetranDriverLicenseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@Repository
@FeignClient(
        name = "detranDriverLicense",
        url = "${app.detran-driver-license.url}",
        configuration = FeignClientConfiguration.class
)
public interface DetranDriverLicenseRepository {
    @GetMapping("/v1/driver-license/{cnhNumber}")
    DetranDriverLicenseResponseDTO getDriverLicenseStatusByCnhNumber(@PathVariable("cnhNumber") final String cnhNumber);
}
