package br.com.motor.company.automobile.dto;

import br.com.motor.company.automobile.enumerable.Brand;
import br.com.motor.company.automobile.enumerable.EngineType;
import br.com.motor.company.automobile.enumerable.FuelType;
import br.com.motor.company.automobile.enumerable.VehicleType;
import br.com.motor.company.automobile.model.Automobile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
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
