package br.com.saga.orchestration.dto.motor.company;

import br.com.saga.orchestration.enumerable.motor.company.EngineType;
import br.com.saga.orchestration.enumerable.motor.company.FuelType;
import br.com.saga.orchestration.enumerable.motor.company.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class AutomobileDetailResponseDTO {
    private Integer id;
    private String licensePlateNumber;
    private VehicleType vehicleType;
    private EngineType engineType;
    private FuelType fuelType;
    private Date created;
    private Date updated;
}
