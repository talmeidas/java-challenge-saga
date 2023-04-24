package br.com.saga.orchestration.repository;

import br.com.saga.orchestration.configuration.FeignClientConfiguration;
import br.com.saga.orchestration.dto.MotorCompanyAutomobileDetailResponseDTO;
import br.com.saga.orchestration.dto.MotorCompanyAutomobileResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Repository
@FeignClient(
        name = "motorCompanyAutomobile",
        url = "${app.motor-company-automobile.url}",
        configuration = FeignClientConfiguration.class
)
public interface MotorCompanyAutomobileRepository {
    @GetMapping("/v1/automobile")
    List<MotorCompanyAutomobileResponseDTO> getAllAutomobile();

    @GetMapping("/v1/automobile/{id}/detail")
    MotorCompanyAutomobileDetailResponseDTO findDetailByAutomobileId(@PathVariable("id") final Integer id);
}
