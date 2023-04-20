package br.com.motor.company.automobile.mapper;

import br.com.motor.company.automobile.dto.AutomobileDetailRequestDTO;
import br.com.motor.company.automobile.dto.AutomobileRequestDTO;
import br.com.motor.company.automobile.dto.AutomobileResponseDTO;
import br.com.motor.company.automobile.model.Automobile;
import br.com.motor.company.automobile.model.AutomobileDetail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AutomobileMapper {
    public List<AutomobileResponseDTO> toResponse(List<Automobile> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public AutomobileResponseDTO toResponse(Automobile entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = AutomobileResponseDTO.builder()
                .id(entity.getId())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public Automobile toEntity(AutomobileRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return Automobile.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .build();
    }
}
