package br.com.detran.driver.license.dto;

import br.com.detran.driver.license.enumerable.Category;
import br.com.detran.driver.license.enumerable.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
