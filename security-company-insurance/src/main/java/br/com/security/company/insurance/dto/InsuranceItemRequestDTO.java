package br.com.security.company.insurance.dto;

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
public class InsuranceItemRequestDTO {
    @NotNull
    @Size(min = 3, message = "Minimum length 3 characters")
    private String name;

    @NotNull
    @Size(min = 10, message = "Minimum length 10 characters")
    private String describe;
}
