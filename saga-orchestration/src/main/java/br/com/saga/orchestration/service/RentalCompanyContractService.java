package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.rental.company.ContractRequestDTO;
import br.com.saga.orchestration.dto.rental.company.ContractResponseDTO;
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

    public List<ContractResponseDTO> getAllContract() {
        return repository.getAllContract();
    }

    public ContractResponseDTO getContractById(Integer id) {
        return repository.getContractById(id);
    }

    public ContractResponseDTO getContractByBookingId(Integer bookingId) {
        return repository.getContractByBookingId(bookingId);
    }

    public ContractResponseDTO saveContract(@Valid ContractRequestDTO request) {
        return repository.saveContract(request);
    }

    public ContractResponseDTO cancelContractById(Integer id) {
        return repository.cancelContractById(id);
    }
}
