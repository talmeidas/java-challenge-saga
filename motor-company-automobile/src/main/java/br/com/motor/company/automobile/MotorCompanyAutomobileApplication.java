package br.com.motor.company.automobile;

import br.com.motor.company.automobile.dto.AutomobileDetailRequestDTO;
import br.com.motor.company.automobile.dto.AutomobileRequestDTO;
import br.com.motor.company.automobile.enumerable.Brand;
import br.com.motor.company.automobile.enumerable.EngineType;
import br.com.motor.company.automobile.enumerable.FuelType;
import br.com.motor.company.automobile.enumerable.VehicleType;
import br.com.motor.company.automobile.model.AutomobileDetail;
import br.com.motor.company.automobile.service.AutomobileDetailService;
import br.com.motor.company.automobile.service.AutomobileService;
import lombok.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@RequiredArgsConstructor
public class MotorCompanyAutomobileApplication implements CommandLineRunner {
    private final AutomobileService automobileService;
    private final AutomobileDetailService automobileDetailService;

    public static void main(String[] args) {
        SpringApplication.run(MotorCompanyAutomobileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Initial Load of automobile
        var automobile1 = AutomobileRequestDTO.builder()
                .brand(Brand.TOYOTA)
                .model("Corolla")
                .build();

        var automobile2 = AutomobileRequestDTO.builder()
                .brand(Brand.FERRARI)
                .model("GTB 250")
                .build();

        var automobile3 = AutomobileRequestDTO.builder()
                .brand(Brand.TESLA)
                .model("Roadster")
                .build();

        var automobileSaved1 = automobileService.saveAutomobile(automobile1);
        var automobileSaved2 = automobileService.saveAutomobile(automobile2);
        var automobileSaved3 = automobileService.saveAutomobile(automobile3);

        var automobileDetail1 = AutomobileDetailRequestDTO.builder()
                .licensePlateNumber("1234567")
                .vehicleType(VehicleType.SEDAN)
                .engineType(EngineType.HYBRID)
                .fuelType(FuelType.ALCOHOL)
                .automobileId(automobileSaved1.getId())
                .build();

        var automobileDetail2 = AutomobileDetailRequestDTO.builder()
                .licensePlateNumber("0000001")
                .vehicleType(VehicleType.HATCH_BACK)
                .engineType(EngineType.COMBUSTION)
                .fuelType(FuelType.GASOLINE)
                .automobileId(automobileSaved2.getId())
                .build();

        var automobileDetail3 = AutomobileDetailRequestDTO.builder()
                .licensePlateNumber("7654321")
                .vehicleType(VehicleType.HATCH_BACK)
                .engineType(EngineType.ELECTRIC)
                .fuelType(FuelType.ELECTRICITY)
                .automobileId(automobileSaved3.getId())
                .build();

        automobileDetailService.saveAutomobileDetail(automobileDetail1);
        automobileDetailService.saveAutomobileDetail(automobileDetail2);
        automobileDetailService.saveAutomobileDetail(automobileDetail3);
    }
}
