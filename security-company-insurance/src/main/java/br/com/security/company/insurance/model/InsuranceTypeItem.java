package br.com.security.company.insurance.model;

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
@Table(name = "INSURANCE_TYPE_ITEM")
public class InsuranceTypeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    private Integer typeId;

    @Column(nullable = false)
    private Integer itemId;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
