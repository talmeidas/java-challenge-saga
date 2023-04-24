package br.com.saga.orchestration.dto;

import br.com.saga.orchestration.enumerable.DetranDriverLicenseCategory;
import br.com.saga.orchestration.enumerable.DetranDriverLicenseStatus;
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
public class DetranDriverLicenseResponseDTO {
    private String name;
    private String cpf;
    private String cnhNumber;
    private Date birthDate;
    private Date expirationDate;
    private Date issueDate;
    private String local;
    private DetranDriverLicenseCategory category;
    private DetranDriverLicenseStatus status;
    private Date created;
    private Date updated;
}
