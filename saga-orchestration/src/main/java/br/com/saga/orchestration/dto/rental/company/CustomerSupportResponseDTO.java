package br.com.saga.orchestration.dto.rental.company;

import br.com.saga.orchestration.enumerable.rental.company.MessageReason;
import br.com.saga.orchestration.enumerable.rental.company.StatusSupport;
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
public class CustomerSupportResponseDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String cnh;
    private Date birthDate;
    private String email;
    private String phone;
    private Integer bookingId;
    private String attendantName;
    private MessageReason messageReason;
    private String message;
    private StatusSupport status;
    private Date created;
    private Date updated;
}
