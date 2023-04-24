package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.MotorCompanyBrand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class MotorCompanyAutomobileRequestDTO {
    @NotNull
    private MotorCompanyBrand brand;

    @NotNull
    private String model;
}
