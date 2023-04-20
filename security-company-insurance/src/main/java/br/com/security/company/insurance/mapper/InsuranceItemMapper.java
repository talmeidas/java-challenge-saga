package br.com.security.company.insurance.mapper;

import br.com.security.company.insurance.dto.InsuranceItemRequestDTO;
import br.com.security.company.insurance.dto.InsuranceItemResponseDTO;
import br.com.security.company.insurance.dto.InsuranceTypeResponseDTO;
import br.com.security.company.insurance.model.InsuranceItem;
import br.com.security.company.insurance.model.InsuranceType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InsuranceItemMapper {
    public List<InsuranceItemResponseDTO> toResponse(List<InsuranceItem> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public InsuranceItemResponseDTO toResponse(InsuranceItem entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = InsuranceItemResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .describe(entity.getDescribe())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public InsuranceItem toEntity(InsuranceItemRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return InsuranceItem.builder()
                .name(request.getName())
                .describe(request.getDescribe())
                .build();
    }

    public InsuranceItem toEntity(InsuranceItemResponseDTO response) {
        if (Objects.isNull(response))
            return null;

        return InsuranceItem.builder()
                .id(response.getId())
                .name(response.getName())
                .describe(response.getDescribe())
                .build();
    }
}
