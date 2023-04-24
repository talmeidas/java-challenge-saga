package br.com.detran.driver.license.model;

import br.com.detran.driver.license.enumerable.Category;
import br.com.detran.driver.license.enumerable.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DRIVER_LICENSE")
public class DriverLicense {
    @Id
    @Column(name = "cnhNumber")
    private String cnhNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private Date issueDate;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Date created;

    private Date updated;
}
