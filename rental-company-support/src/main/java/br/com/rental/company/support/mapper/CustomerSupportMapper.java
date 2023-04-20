package br.com.rental.company.support.mapper;

import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportResponseDTO;
import br.com.rental.company.support.enumerable.MessageReason;
import br.com.rental.company.support.enumerable.StatusSupport;
import br.com.rental.company.support.model.CustomerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerSupportMapper {
    public List<CustomerSupportResponseDTO> toResponse(List<CustomerSupport> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public CustomerSupportResponseDTO toResponse(CustomerSupport entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = CustomerSupportResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .cnh(entity.getCnh())
                .birthDate(entity.getBirthDate())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .attendantName(entity.getAttendantName())
                .bookingId(entity.getBookingId())
                .messageReason(entity.getMessageReason())
                .message(entity.getMessage())
                .status(entity.getStatus())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public CustomerSupport toEntity(CustomerSupportRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return CustomerSupport.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .cnh(request.getCnh())
                .birthDate(request.getBirthDate())
                .email(request.getEmail())
                .phone(request.getPhone())
                .bookingId(request.getBookingId())
                .messageReason(request.getMessageReason())
                .message(request.getMessage())
                .build();
    }
}
