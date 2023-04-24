package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.MotorCompanyEngineType;
import br.com.saga.orchestration.enumerable.MotorCompanyFuelType;
import br.com.saga.orchestration.enumerable.MotorCompanyVehicleType;
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
public class MotorCompanyAutomobileDetailResponseDTO {
    private Integer id;
    private String licensePlateNumber;
    private MotorCompanyVehicleType vehicleType;
    private MotorCompanyEngineType engineType;
    private MotorCompanyFuelType motorCompanyFuelType;
    private Date created;
    private Date updated;
}
