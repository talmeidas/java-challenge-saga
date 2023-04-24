package br.com.rental.company.support.model;

import br.com.rental.company.support.enumerable.MessageReason;
import br.com.rental.company.support.enumerable.StatusSupport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_SUPPORT")
public class CustomerSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String cnhNumber;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    private String attendantName;

    private Integer bookingId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageReason messageReason;

    private String message;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusSupport status;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
