package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.MotorCompanyEngineType;
import br.com.saga.orchestration.enumerable.MotorCompanyFuelType;
import br.com.saga.orchestration.enumerable.MotorCompanyVehicleType;
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
public class MotorCompanyAutomobileDetailRequestDTO {
    @NotNull
    @Size(min = 7, message = "Should have 7 characters")
    private String licensePlateNumber;

    @NotNull
    private MotorCompanyVehicleType vehicleType;

    @NotNull
    private MotorCompanyEngineType engineType;

    @NotNull
    private MotorCompanyFuelType motorCompanyFuelType;

    @NotNull
    private Integer automobileId;
}
