package br.com.detran.driver.license.dto;

import br.com.detran.driver.license.enumerable.Category;
import br.com.detran.driver.license.enumerable.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class DriverLicenseRequestDTO {
    @NotNull
    @Size(min = 3, message = "Minimum length 3 characters")
    private String name;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    @Size(min = 11, max = 11, message = "Should have 11 characters")
    private String cnh;

    @NotNull
    private Date birthDate;

    @NotNull
    private Date expirationDate;

    @NotNull
    private Date issueDate;

    @NotNull
    @Size(min = 5, max = 100, message = "Minimum length 5 and Maximum length 100 characters")
    private String local;

    @NotNull
    private Category category;

    @NotNull
    private Status status;
}
