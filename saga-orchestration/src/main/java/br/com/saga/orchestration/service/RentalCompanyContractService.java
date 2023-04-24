package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.RentalCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyContractResponseDTO;
import br.com.saga.orchestration.repository.RentalCompanyContractRepository;
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
        return repository.saveContract(request);
    }

    public RentalCompanyContractResponseDTO cancelContractById(Integer id) {
        return repository.cancelContractById(id);
    }
}
