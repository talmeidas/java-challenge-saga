package br.com.security.company.contract.mapper;

import br.com.security.company.contract.dto.ContractRequestDTO;
import br.com.security.company.contract.dto.ContractResponseDTO;
import br.com.security.company.contract.model.Contract;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ContractMapper {
    public List<ContractResponseDTO> toResponse(List<Contract> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public ContractResponseDTO toResponse(Contract entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = ContractResponseDTO.builder()
                .id(entity.getId())
                .rentalBookingId(entity.getRentalBookingId())
                .rentalContractId(entity.getRentalContractId())
                .status(entity.getStatus())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public Contract toEntity(ContractRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return Contract.builder()
                .rentalBookingId(request.getRentalBookingId())
                .rentalContractId(request.getRentalContractId())
                .build();
    }
}
