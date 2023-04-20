package br.com.security.company.contract.model;

import br.com.security.company.contract.enumerable.StatusContract;
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
@Table(name = "CONTRACT")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer rentalBookingId;

    @Column(nullable = false, unique = true)
    private Integer rentalContractId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusContract status;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
