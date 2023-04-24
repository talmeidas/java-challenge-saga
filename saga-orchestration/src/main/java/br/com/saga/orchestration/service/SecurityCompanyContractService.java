package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.SecurityCompanyContractRequestDTO;
import br.com.saga.orchestration.dto.SecurityCompanyContractResponseDTO;
import br.com.saga.orchestration.repository.SecurityCompanyContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SecurityCompanyContractService {
    private final SecurityCompanyContractRepository repository;

    public List<SecurityCompanyContractResponseDTO> getAllContract() {
        return repository.getAllContract();
    }

    public SecurityCompanyContractResponseDTO getContractById(Integer id) {
        return repository.getContractById(id);
    }

    public SecurityCompanyContractResponseDTO getContractByRetalBookingId(Integer rentalBookingId) {
        return repository.getContractByRetalBookingId(rentalBookingId);
    }

    public SecurityCompanyContractResponseDTO getContractByRentalContractId(Integer rentalContractId) {
        return repository.getContractByRentalContractId(rentalContractId);
    }

    public SecurityCompanyContractResponseDTO saveContract(@Valid SecurityCompanyContractRequestDTO request) {
        return repository.saveContract(request);
    }

    public SecurityCompanyContractResponseDTO cancelContractById(Integer id) {
        return repository.cancelContractById(id);
    }
}
