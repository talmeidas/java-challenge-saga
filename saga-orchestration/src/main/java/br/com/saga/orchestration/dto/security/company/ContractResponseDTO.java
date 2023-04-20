package br.com.saga.orchestration.dto.security.company;

import br.com.saga.orchestration.enumerable.security.company.StatusContract;
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
public class ContractResponseDTO {
    private Integer id;
    private Integer rentalBookingId;
    private Integer rentalContractId;
    private StatusContract status;
    private Date created;
    private Date updated;
}
