package br.com.security.company.insurance.mapper;

import br.com.security.company.insurance.dto.InsuranceTypeRequestDTO;
import br.com.security.company.insurance.dto.InsuranceTypeResponseDTO;
import br.com.security.company.insurance.model.InsuranceType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InsuranceTypeMapper {
    public List<InsuranceTypeResponseDTO> toResponse(List<InsuranceType> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public InsuranceTypeResponseDTO toResponse(InsuranceType entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = InsuranceTypeResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .describe(entity.getDescribe())
                .price(entity.getPrice())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public InsuranceType toEntity(InsuranceTypeRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return InsuranceType.builder()
                .name(request.getName())
                .describe(request.getDescribe())
                .price(request.getPrice())
                .build();
    }

    public InsuranceType toEntity(InsuranceTypeResponseDTO response) {
        if (Objects.isNull(response))
            return null;

        return InsuranceType.builder()
                .id(response.getId())
                .name(response.getName())
                .describe(response.getDescribe())
                .price(response.getPrice())
                .build();
    }
}
