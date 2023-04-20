package br.com.rental.company.support.dto;

import br.com.rental.company.support.enumerable.Country;
import br.com.rental.company.support.enumerable.StateAcronym;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
