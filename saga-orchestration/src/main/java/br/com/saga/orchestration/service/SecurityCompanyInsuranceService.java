package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.SecurityCompanyInsuranceItemResponseDTO;
import br.com.saga.orchestration.dto.SecurityCompanyInsuranceTypeResponseDTO;
import br.com.saga.orchestration.repository.SecurityCompanyInsuranceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SecurityCompanyInsuranceService {
    private final SecurityCompanyInsuranceRepository repository;

    public List<SecurityCompanyInsuranceTypeResponseDTO> getAllInsuranceType() {
        return repository.getAllInsuranceType();
    }

    public List<SecurityCompanyInsuranceItemResponseDTO> getInsuranceDetailByTypeId(Integer id) {
        return repository.getInsuranceDetailByTypeId(id);
    }
}
