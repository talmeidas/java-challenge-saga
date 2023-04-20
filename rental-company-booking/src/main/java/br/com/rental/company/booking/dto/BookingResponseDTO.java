package br.com.rental.company.booking.dto;

import br.com.rental.company.booking.enumerable.StatusBooking;
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
public class BookingResponseDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String cnh;
    private Date birthDate;
    private String email;
    private String phone;
    private Integer automobileId;
    private Integer insuranceTypeId;
    private Integer addressId;
    private Integer contractPeriod;
    private StatusBooking status;
    private Date created;
    private Date updated;
}
