package br.com.detran.driver.license;

import br.com.detran.driver.license.dto.DriverLicenseRequestDTO;
import br.com.detran.driver.license.enumerable.Category;
import br.com.detran.driver.license.enumerable.Status;
import br.com.detran.driver.license.service.DriverLicenseService;
import lombok.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class DetranDriverLicenseApplication implements CommandLineRunner {
    private final DriverLicenseService driverLicenseService;

    public static void main(String[] args) {
        SpringApplication.run(DetranDriverLicenseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Initial Load of driver license
        var driverLicense1 = DriverLicenseRequestDTO.builder()
                .name("Nome 1")
                .cpf("00000000191")
                .cnh("07021871297")
                .birthDate(Date.from(Instant.parse("1980-01-01T00:00:00.000Z")))
                .expirationDate(Date.from(Instant.parse("2030-01-01T00:00:00.000Z")))
                .issueDate(Date.from(Instant.parse("2000-01-01T00:00:00.000Z")))
                .local("São Paulo, SP")
                .category(Category.C)
                .status(Status.REGULAR)
                .build();

        var driverLicense2 = DriverLicenseRequestDTO.builder()
                .name("Nome 2")
                .cpf("27626137019")
                .cnh("69457688418")
                .birthDate(Date.from(Instant.parse("1990-01-01T00:00:00.000Z")))
                .expirationDate(Date.from(Instant.parse("2030-01-01T00:00:00.000Z")))
                .issueDate(Date.from(Instant.parse("2010-01-01T00:00:00.000Z")))
                .local("São Paulo, SP")
                .category(Category.B)
                .status(Status.IRREGULAR)
                .build();

        var driverLicense3 = DriverLicenseRequestDTO.builder()
                .name("Nome 3")
                .cpf("08565793001")
                .cnh("21418336906")
                .birthDate(Date.from(Instant.parse("2000-01-01T00:00:00.000Z")))
                .expirationDate(Date.from(Instant.parse("2030-01-01T00:00:00.000Z")))
                .issueDate(Date.from(Instant.parse("2020-01-01T00:00:00.000Z")))
                .local("São Paulo, SP")
                .category(Category.A)
                .status(Status.REGULAR)
                .build();

        driverLicenseService.saveDriverLicense(driverLicense1);
        driverLicenseService.saveDriverLicense(driverLicense2);
        driverLicenseService.saveDriverLicense(driverLicense3);
    }
}
