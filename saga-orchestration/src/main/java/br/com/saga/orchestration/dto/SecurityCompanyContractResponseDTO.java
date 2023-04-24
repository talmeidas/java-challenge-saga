package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.SecurityCompanyContractStatus;
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
public class SecurityCompanyContractResponseDTO {
    private Integer id;
    private Integer rentalBookingId;
    private Integer rentalContractId;
    private SecurityCompanyContractStatus status;
    private Date created;
    private Date updated;
}
