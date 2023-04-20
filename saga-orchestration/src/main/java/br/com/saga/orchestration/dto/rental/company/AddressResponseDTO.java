package br.com.saga.orchestration.dto.rental.company;

import br.com.saga.orchestration.enumerable.rental.company.Country;
import br.com.saga.orchestration.enumerable.rental.company.StateAcronym;
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
public class AddressResponseDTO {
    private Integer id;
    private String address;
    private Integer number;
    private String city;
    private StateAcronym state;
    private Country country;
    private Integer zipCode;
    private Date created;
    private Date updated;
}
