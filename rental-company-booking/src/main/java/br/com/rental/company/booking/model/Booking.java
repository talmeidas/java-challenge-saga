package br.com.rental.company.booking.model;

import br.com.rental.company.booking.enumerable.StatusBooking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String cnh;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Integer automobileId;

    @Column(nullable = false)
    private Integer insuranceTypeId;

    @Column(nullable = false)
    private Integer addressId;

    @Column(nullable = false)
    private Integer contractPeriod;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusBooking status;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
