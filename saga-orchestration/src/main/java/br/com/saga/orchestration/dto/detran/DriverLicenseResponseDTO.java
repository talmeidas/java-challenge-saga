package br.com.saga.orchestration.dto.detran;

import br.com.saga.orchestration.enumerable.Category;
import br.com.saga.orchestration.enumerable.Status;
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
public class DriverLicenseResponseDTO {
    private String name;
    private String cpf;
    private String cnh;
    private Date birthDate;
    private Date expirationDate;
    private Date issueDate;
    private String local;
    private Category category;
    private Status status;
    private Date created;
    private Date updated;
}
