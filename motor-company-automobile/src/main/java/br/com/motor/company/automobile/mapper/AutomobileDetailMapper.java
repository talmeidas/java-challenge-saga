package br.com.motor.company.automobile.mapper;

import br.com.motor.company.automobile.dto.AutomobileDetailResponseDTO;
import br.com.motor.company.automobile.dto.AutomobileDetailRequestDTO;
import br.com.motor.company.automobile.model.Automobile;
import br.com.motor.company.automobile.model.AutomobileDetail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AutomobileDetailMapper {
    public List<AutomobileDetailResponseDTO> toResponse(List<AutomobileDetail> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AutomobileDetailResponseDTO toResponse(AutomobileDetail entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = AutomobileDetailResponseDTO.builder()
                .id(entity.getId())
                .licensePlateNumber(entity.getLicensePlateNumber())
                .vehicleType(entity.getVehicleType())
                .engineType(entity.getEngineType())
                .fuelType(entity.getFuelType())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public AutomobileDetail toEntity(AutomobileDetailRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return AutomobileDetail.builder()
                .licensePlateNumber(request.getLicensePlateNumber())
                .vehicleType(request.getVehicleType())
                .engineType(request.getEngineType())
                .fuelType(request.getFuelType())
                .automobileId(request.getAutomobileId())
                .build();
    }
}
