package br.com.security.company.insurance.service;

import br.com.security.company.insurance.dto.InsuranceTypeItemRequestDTO;
import br.com.security.company.insurance.dto.InsuranceTypeItemResponseDTO;
import br.com.security.company.insurance.mapper.InsuranceTypeItemMapper;
import br.com.security.company.insurance.model.InsuranceTypeItem;
import br.com.security.company.insurance.repository.InsuranceTypeItemRepository;
import br.com.security.company.insurance.repository.InsuranceItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InsuranceTypeItemService {
    private final InsuranceTypeItemMapper mapper;
    private final InsuranceTypeItemRepository insuranceTypeItemRepository;

    @Transactional
    public InsuranceTypeItemResponseDTO saveInsuranceTypeItem(@Valid InsuranceTypeItemRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving insurance type item - {}", request);

        InsuranceTypeItem insuranceTypeItem = mapper.toEntity(request);

        insuranceTypeItem.setCreated(new Date());

        return mapper.toResponse(insuranceTypeItemRepository.save(insuranceTypeItem));
    }
}
