package br.com.security.company.insurance.dto;

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
public class InsuranceTypeItemRequestDTO {
    @NotNull
    private Integer typeId;

    @NotNull
    private Integer itemId;
}
