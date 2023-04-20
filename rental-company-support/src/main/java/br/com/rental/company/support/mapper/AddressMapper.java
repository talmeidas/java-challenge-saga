package br.com.rental.company.support.mapper;

import br.com.rental.company.support.dto.AddressRequestDTO;
import br.com.rental.company.support.dto.AddressResponseDTO;
import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportResponseDTO;
import br.com.rental.company.support.enumerable.Country;
import br.com.rental.company.support.enumerable.StateAcronym;
import br.com.rental.company.support.model.Address;
import br.com.rental.company.support.model.CustomerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AddressMapper {
    public List<AddressResponseDTO> toResponse(List<Address> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public AddressResponseDTO toResponse(Address entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = AddressResponseDTO.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .number(entity.getNumber())
                .city(entity.getCity())
                .state(entity.getState())
                .country(entity.getCountry())
                .zipCode(entity.getZipCode())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public Address toEntity(AddressRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return Address.builder()
                .address(request.getAddress())
                .number(request.getNumber())
                .city(request.getCity())
                .state(request.getState())
                .country(request.getCountry())
                .zipCode(request.getZipCode())
                .build();
    }
}
