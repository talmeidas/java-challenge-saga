package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.DetranDriverLicenseCategory;
import br.com.saga.orchestration.enumerable.DetranDriverLicenseStatus;
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
public class DetranDriverLicenseRequestDTO {
    @NotNull
    @Size(min = 3, message = "Minimum length 3 characters")
    private String name;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    @Size(min = 11, max = 11, message = "Should have 11 characters")
    private String cnhNumber;

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
    private DetranDriverLicenseCategory category;

    @NotNull
    private DetranDriverLicenseStatus status;
}
