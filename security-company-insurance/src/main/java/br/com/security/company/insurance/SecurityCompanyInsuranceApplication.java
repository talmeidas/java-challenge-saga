package br.com.security.company.insurance;

import br.com.security.company.insurance.dto.*;
import br.com.security.company.insurance.service.InsuranceTypeItemService;
import br.com.security.company.insurance.service.InsuranceTypeService;
import br.com.security.company.insurance.service.InsuranceItemService;
import lombok.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityCompanyInsuranceApplication implements CommandLineRunner {
        private final InsuranceTypeService insuranceTypeService;
        private final InsuranceItemService insuranceItemService;
        private final InsuranceTypeItemService insuranceTypeItemService;

        public static void main(String[] args) {
                SpringApplication.run(SecurityCompanyInsuranceApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                // Initial Load of insurance
                var insuranceType1 = InsuranceTypeRequestDTO.builder()
                                .name("Basico")
                                .describe("Basico Mensal Zero Km")
                                .price(0.00)
                                .build();

                var insuranceType2 = InsuranceTypeRequestDTO.builder()
                                .name("Intermediário")
                                .describe("Intermediário Mensal Zero Km")
                                .price(14.90)
                                .build();

                var insuranceType3 = InsuranceTypeRequestDTO.builder()
                                .name("Completo")
                                .describe("Completo Mensal Zero Km")
                                .price(29.90)
                                .build();

                InsuranceTypeResponseDTO insuranceTypeSaved1 = insuranceTypeService.saveInsuranceType(insuranceType1);
                InsuranceTypeResponseDTO insuranceTypeSaved2 = insuranceTypeService.saveInsuranceType(insuranceType2);
                InsuranceTypeResponseDTO insuranceTypeSaved3 = insuranceTypeService.saveInsuranceType(insuranceType3);

                var insuranceItem1 = InsuranceItemRequestDTO.builder()
                                .name("Condutor Adicional")
                                .describe("Inclua um condutor adicional para dirigir o seu possante!")
                                .build();

                var insuranceItem2 = InsuranceItemRequestDTO.builder()
                                .name("Carro Reserva Ilimitado")
                                .describe("Carro reserva ilimitado de categoria similar para os contratantes Zero Km.")
                                .build();

                var insuranceItem3 = InsuranceItemRequestDTO.builder()
                                .name("Carro Reserva 7 Dias")
                                .describe("Carro reserva para os contratantes Zero Km.")
                                .build();

                var insuranceItem4 = InsuranceItemRequestDTO.builder()
                                .name("Sem Parar")
                                .describe("O Sem Parar é um meio de pagamento automático que facilita a sua vida na hora de passar em pedágios e estacionamentos.")
                                .build();

                var insuranceItem5 = InsuranceItemRequestDTO.builder()
                                .name("Reboque com Cobertura Nacional")
                                .describe("Solicite o reboque sempre que precisar.")
                                .build();

                var insuranceItem6 = InsuranceItemRequestDTO.builder()
                                .name("Seguro por Danos a Terceiros")
                                .describe("Fique tranquilo em casos de acidentes envolvendo terceiros.")
                                .build();

                InsuranceItemResponseDTO insuranceItemSaved1 = insuranceItemService.saveInsuranceItem(insuranceItem1);
                InsuranceItemResponseDTO insuranceItemSaved2 = insuranceItemService.saveInsuranceItem(insuranceItem2);
                InsuranceItemResponseDTO insuranceItemSaved3 = insuranceItemService.saveInsuranceItem(insuranceItem3);
                InsuranceItemResponseDTO insuranceItemSaved4 = insuranceItemService.saveInsuranceItem(insuranceItem4);
                InsuranceItemResponseDTO insuranceItemSaved5 = insuranceItemService.saveInsuranceItem(insuranceItem5);
                InsuranceItemResponseDTO insuranceItemSaved6 = insuranceItemService.saveInsuranceItem(insuranceItem6);

                var insuranceTypeItem1 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved1.getId())
                                .itemId(insuranceItemSaved1.getId())
                                .build();

                var insuranceTypeItem2 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved2.getId())
                                .itemId(insuranceItemSaved1.getId())
                                .build();

                var insuranceTypeItem2_2 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved2.getId())
                                .itemId(insuranceItemSaved2.getId())
                                .build();

                var insuranceTypeItem2_3 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved2.getId())
                                .itemId(insuranceItemSaved3.getId())
                                .build();

                var insuranceTypeItem3 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved3.getId())
                                .itemId(insuranceItemSaved1.getId())
                                .build();

                var insuranceTypeItem3_2 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved3.getId())
                                .itemId(insuranceItemSaved2.getId())
                                .build();

                var insuranceTypeItem3_3 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved3.getId())
                                .itemId(insuranceItemSaved3.getId())
                                .build();

                var insuranceTypeItem3_4 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved3.getId())
                                .itemId(insuranceItemSaved4.getId())
                                .build();

                var insuranceTypeItem3_5 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved3.getId())
                                .itemId(insuranceItemSaved5.getId())
                                .build();

                var insuranceTypeItem3_6 = InsuranceTypeItemRequestDTO.builder()
                                .typeId(insuranceTypeSaved3.getId())
                                .itemId(insuranceItemSaved6.getId())
                                .build();

                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem1);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem2);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem2_2);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem2_3);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem3);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem3_2);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem3_3);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem3_4);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem3_5);
                insuranceTypeItemService.saveInsuranceTypeItem(insuranceTypeItem3_6);
        }
}
