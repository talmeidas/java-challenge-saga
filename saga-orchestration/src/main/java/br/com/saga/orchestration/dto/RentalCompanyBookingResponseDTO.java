package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.RentalCompanyBookingStatus;
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
public class RentalCompanyBookingResponseDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String cnhNumber;
    private Date birthDate;
    private String email;
    private String phone;
    private Integer automobileId;
    private Integer insuranceTypeId;
    private Integer addressId;
    private Integer contractPeriod;
    private RentalCompanyBookingStatus status;
    private Date created;
    private Date updated;
}
