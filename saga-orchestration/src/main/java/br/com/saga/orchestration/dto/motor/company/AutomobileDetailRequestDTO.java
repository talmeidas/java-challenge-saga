package br.com.saga.orchestration.dto.motor.company;

import br.com.saga.orchestration.enumerable.motor.company.EngineType;
import br.com.saga.orchestration.enumerable.motor.company.FuelType;
import br.com.saga.orchestration.enumerable.motor.company.VehicleType;
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
public class AutomobileDetailRequestDTO {
    @NotNull
    @Size(min = 7, message = "Should have 7 characters")
    private String licensePlateNumber;

    @NotNull
    private VehicleType vehicleType;

    @NotNull
    private EngineType engineType;

    @NotNull
    private FuelType fuelType;

    @NotNull
    private Integer automobileId;
}
