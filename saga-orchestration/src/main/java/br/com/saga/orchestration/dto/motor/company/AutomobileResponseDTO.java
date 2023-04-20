package br.com.saga.orchestration.dto.motor.company;

import br.com.saga.orchestration.enumerable.motor.company.Brand;
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
public class AutomobileResponseDTO {
    private Integer id;
    private Brand brand;
    private String model;
    private Date created;
    private Date updated;
}
