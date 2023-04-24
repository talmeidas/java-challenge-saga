package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.RentalCompanySupportCountry;
import br.com.saga.orchestration.enumerable.RentalCompanySupportStateAcronym;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class RentalCompanySupportAddressResponseDTO implements Serializable {
    private Integer id;
    private String address;
    private Integer number;
    private String city;
    private RentalCompanySupportStateAcronym state;
    private RentalCompanySupportCountry country;
    private Integer zipCode;
    private Date created;
    private Date updated;
}
