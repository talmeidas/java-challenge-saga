package br.com.rental.company.support.dto;

import br.com.rental.company.support.enumerable.MessageReason;
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
public class CustomerSupportRequestDTO {
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

    private Integer bookingId;

    @NotNull
    private MessageReason messageReason;

    @NotNull
    @Size(min = 50, message = "Minimum length 50 characters")
    private String message;
}
