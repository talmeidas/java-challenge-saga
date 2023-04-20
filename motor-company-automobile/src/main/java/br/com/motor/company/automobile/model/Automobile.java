package br.com.motor.company.automobile.model;

import br.com.motor.company.automobile.enumerable.Brand;
import br.com.motor.company.automobile.enumerable.EngineType;
import br.com.motor.company.automobile.enumerable.FuelType;
import br.com.motor.company.automobile.enumerable.VehicleType;
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
@Table(name = "AUTOMOBILE")
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
