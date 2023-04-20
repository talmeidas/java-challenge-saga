package br.com.security.company.insurance.mapper;

import br.com.security.company.insurance.dto.InsuranceTypeItemRequestDTO;
import br.com.security.company.insurance.dto.InsuranceTypeItemResponseDTO;
import br.com.security.company.insurance.model.InsuranceTypeItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceTypeItemMapper {
    public List<InsuranceTypeItemResponseDTO> toResponse(List<InsuranceTypeItem> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public InsuranceTypeItemResponseDTO toResponse(InsuranceTypeItem entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = InsuranceTypeItemResponseDTO.builder()
                .id(entity.getId())
                .typeId(entity.getTypeId())
                .itemId(entity.getItemId())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public InsuranceTypeItem toEntity(InsuranceTypeItemRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return InsuranceTypeItem.builder()
                .typeId(request.getTypeId())
                .itemId(request.getItemId())
                .build();
    }
}
