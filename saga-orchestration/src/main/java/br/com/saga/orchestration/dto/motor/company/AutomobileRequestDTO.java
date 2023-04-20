package br.com.saga.orchestration.dto.motor.company;

import br.com.saga.orchestration.enumerable.motor.company.Brand;
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
public class AutomobileRequestDTO {
    @NotNull
    private Brand brand;

    @NotNull
    private String model;
}
