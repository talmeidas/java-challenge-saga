package br.com.detran.driver.license.mapper;

import br.com.detran.driver.license.dto.DriverLicenseRequestDTO;
import br.com.detran.driver.license.dto.DriverLicenseResponseDTO;
import br.com.detran.driver.license.model.DriverLicense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DriverLicenseMapper {
    public List<DriverLicenseResponseDTO> toResponse(List<DriverLicense> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public DriverLicenseResponseDTO toResponse(DriverLicense entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = DriverLicenseResponseDTO.builder()
                .name(entity.getName())
                .cpf(entity.getCpf())
                .cnh(entity.getCnh())
                .birthDate(entity.getBirthDate())
                .expirationDate(entity.getExpirationDate())
                .issueDate(entity.getIssueDate())
                .local(entity.getLocal())
                .category(entity.getCategory())
                .status(entity.getStatus())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public DriverLicense toEntity(DriverLicenseRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return DriverLicense.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .cnh(request.getCnh())
                .birthDate(request.getBirthDate())
                .expirationDate(request.getExpirationDate())
                .issueDate(request.getIssueDate())
                .local(request.getLocal())
                .category(request.getCategory())
                .status(request.getStatus())
                .build();
    }
}
