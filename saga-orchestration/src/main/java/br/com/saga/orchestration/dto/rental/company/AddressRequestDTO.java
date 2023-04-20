package br.com.saga.orchestration.dto.rental.company;

import br.com.saga.orchestration.enumerable.rental.company.Country;
import br.com.saga.orchestration.enumerable.rental.company.StateAcronym;
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
public class AddressRequestDTO {
    @NotNull
    @Size(min = 3, message = "Minimum length 3 characters")
    private String address;

    @NotNull
    @Size(min = 1, message = "Minimum length 1 characters")
    private Integer number;

    @NotNull
    @Size(min = 3, message = "Minimum length 3 characters")
    private String city;

    @NotNull
    private StateAcronym state;

    @NotNull
    private Country country;

    @NotNull
    @Size(min = 8, max = 8, message = "Should have 8 characters")
    private Integer zipCode;
}
