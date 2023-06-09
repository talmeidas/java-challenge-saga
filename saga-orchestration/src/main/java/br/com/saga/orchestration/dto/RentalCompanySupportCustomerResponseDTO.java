package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.RentalCompanySupportMessageReason;
import br.com.saga.orchestration.enumerable.RentalCompanySupportStatus;
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
public class RentalCompanySupportCustomerResponseDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String cnhNumber;
    private Date birthDate;
    private String email;
    private String phone;
    private Integer bookingId;
    private String attendantName;
    private RentalCompanySupportMessageReason messageReason;
    private String message;
    private RentalCompanySupportStatus status;
    private Date created;
    private Date updated;
}
