package br.com.rental.company.contract.model;

import br.com.rental.company.contract.enumerable.StatusContract;
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
    private Integer bookingId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusContract status;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
