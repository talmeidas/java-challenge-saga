package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.DetranDriverLicenseResponseDTO;
import br.com.saga.orchestration.dto.RentalCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyContractResponseDTO;
import br.com.saga.orchestration.dto.SecurityCompanyContractRequestDTO;
import br.com.saga.orchestration.enumerable.DetranDriverLicenseStatus;
import br.com.saga.orchestration.repository.RentalCompanyContractRepository;
import br.com.saga.orchestration.repository.SecurityCompanyContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentalCompanyContractService {
    private final RentalCompanyContractRepository repository;

    private final SecurityCompanyContractService securityCompanyContractService;

    public List<RentalCompanyContractResponseDTO> getAllContract() {
        return repository.getAllContract();
    }

    public RentalCompanyContractResponseDTO getContractById(Integer id) {
        return repository.getContractById(id);
    }

    public RentalCompanyContractResponseDTO getContractByBookingId(Integer bookingId) {
        return repository.getContractByBookingId(bookingId);
    }

    public RentalCompanyContractResponseDTO saveContract(@Valid RentalCompanyContractRequestDTO request) {
        final RentalCompanyContractResponseDTO rentalCompanyContractResponse = repository.saveContract(request);

        try {
            var securityCompanyContractRequest = SecurityCompanyContractRequestDTO.builder()
                    .rentalBookingId(rentalCompanyContractResponse.getBookingId())
                    .rentalContractId(rentalCompanyContractResponse.getId())
                    .build();

            securityCompanyContractService.saveContract(securityCompanyContractRequest);
        } catch (Exception e) {
            repository.cancelContractById(rentalCompanyContractResponse.getId());
            throw new Error(e);
        }

        return rentalCompanyContractResponse;
    }

    public RentalCompanyContractResponseDTO cancelContractById(Integer id) {
        return repository.cancelContractById(id);
    }
}
