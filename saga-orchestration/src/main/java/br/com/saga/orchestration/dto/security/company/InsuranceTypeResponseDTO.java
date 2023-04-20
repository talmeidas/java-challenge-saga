package br.com.saga.orchestration.dto.security.company;

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
public class InsuranceTypeResponseDTO {
    private Integer id;
    private String name;
    private String describe;
    private Double price;
    private Date created;
    private Date updated;
}
