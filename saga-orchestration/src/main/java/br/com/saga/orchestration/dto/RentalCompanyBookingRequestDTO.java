package br.com.saga.orchestration.dto;

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
public class RentalCompanyBookingRequestDTO {
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
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 11, message = "Minimum length 10 and Maximum length 11 characters")
    private String phone;

    @NotNull
    private Integer automobileId;

    @NotNull
    private Integer insuranceTypeId;

    @NotNull
    private Integer addressId;

    @NotNull
    private Integer contractPeriod;
}
