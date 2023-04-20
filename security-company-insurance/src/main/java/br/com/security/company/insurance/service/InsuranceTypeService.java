package br.com.security.company.insurance.service;

import br.com.security.company.insurance.dto.InsuranceItemRequestDTO;
import br.com.security.company.insurance.dto.InsuranceItemResponseDTO;
import br.com.security.company.insurance.dto.InsuranceTypeRequestDTO;
import br.com.security.company.insurance.dto.InsuranceTypeResponseDTO;
import br.com.security.company.insurance.mapper.InsuranceTypeMapper;
import br.com.security.company.insurance.model.InsuranceItem;
import br.com.security.company.insurance.model.InsuranceType;
import br.com.security.company.insurance.repository.InsuranceTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class InsuranceTypeService {
    private final InsuranceTypeMapper mapper;
    private final InsuranceTypeRepository repository;

    public List<InsuranceTypeResponseDTO> getAllInsuranceType() {
        log.info("Listing all insurance's type");

        final var listOfEntities = repository.findAll();

        return mapper.toResponse(listOfEntities);
    }

    @Transactional
    public InsuranceTypeResponseDTO saveInsuranceType(@Valid InsuranceTypeRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving insurance type - {}", request);

        InsuranceType insuranceType = mapper.toEntity(request);

        insuranceType.setCreated(new Date());

        return mapper.toResponse(repository.save(insuranceType));
    }
}
