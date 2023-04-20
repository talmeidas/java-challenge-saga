package br.com.security.company.insurance.dto;

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
public class InsuranceTypeItemResponseDTO {
    private Integer id;
    private Integer typeId;
    private Integer itemId;
    private Date created;
    private Date updated;
}
