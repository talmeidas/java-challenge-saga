package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.RentalCompanyContractStatus;
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
public class RentalCompanyContractResponseDTO {
    private Integer id;
    private Integer bookingId;
    private RentalCompanyContractStatus status;
    private Date created;
    private Date updated;
}
