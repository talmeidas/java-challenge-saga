package br.com.security.company.insurance.service;

import br.com.security.company.insurance.dto.InsuranceItemRequestDTO;
import br.com.security.company.insurance.dto.InsuranceItemResponseDTO;
import br.com.security.company.insurance.dto.InsuranceTypeResponseDTO;
import br.com.security.company.insurance.mapper.InsuranceItemMapper;
import br.com.security.company.insurance.model.InsuranceItem;
import br.com.security.company.insurance.repository.InsuranceItemRepository;
import br.com.security.company.insurance.repository.InsuranceTypeItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InsuranceItemService {
    private final InsuranceItemMapper mapper;
    private final InsuranceItemRepository insuranceItemRepository;
    private final InsuranceTypeItemRepository insuranceTypeItemRepository;

    public List<InsuranceItemResponseDTO> getInsuranceDetailByTypeId(Integer id) {
        log.info("Get insurance's detail by type id - {}", id);

        var insuranceTypeItemByTypeIdOptional = insuranceTypeItemRepository.getAllByTypeId(id);
        var listOfEntities = insuranceTypeItemByTypeIdOptional
                .orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        var Items = listOfEntities.stream().map(item -> item.getItemId()).collect(Collectors.toList());

        var insuranceDetailOptional = insuranceItemRepository.findAllById(Items);

        if (insuranceDetailOptional.isEmpty()) {
            throw new EntityNotFoundException("exception.unexpected.not.found");
        }

        return mapper.toResponse(insuranceDetailOptional);
    }

    @Transactional
    public InsuranceItemResponseDTO saveInsuranceItem(@Valid InsuranceItemRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving insurance item - {}", request);

        InsuranceItem insuranceItem = mapper.toEntity(request);

        insuranceItem.setCreated(new Date());

        return mapper.toResponse(insuranceItemRepository.save(insuranceItem));
    }
}
