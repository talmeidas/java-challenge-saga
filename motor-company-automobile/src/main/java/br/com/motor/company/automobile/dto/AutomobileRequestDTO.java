package br.com.motor.company.automobile.dto;

import br.com.motor.company.automobile.enumerable.Brand;
import br.com.motor.company.automobile.enumerable.EngineType;
import br.com.motor.company.automobile.enumerable.FuelType;
import br.com.motor.company.automobile.enumerable.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
