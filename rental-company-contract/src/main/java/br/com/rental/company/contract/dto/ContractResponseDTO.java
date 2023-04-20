package br.com.rental.company.contract.dto;

import br.com.rental.company.contract.enumerable.StatusContract;
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
    private Integer bookingId;
    private StatusContract status;
    private Date created;
    private Date updated;
}
