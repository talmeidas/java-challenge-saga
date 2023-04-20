package br.com.rental.company.booking.mapper;

import br.com.rental.company.booking.dto.BookingRequestDTO;
import br.com.rental.company.booking.dto.BookingResponseDTO;
import br.com.rental.company.booking.model.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookingMapper {
    public List<BookingResponseDTO> toResponse(List<Booking> listOfEntities) {
        if (Objects.isNull(listOfEntities))
            return new ArrayList<>();

        return listOfEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

    }

    public BookingResponseDTO toResponse(Booking entity) {
        Objects.requireNonNull(entity, "entity must not be null");

        var response = BookingResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .cnh(entity.getCnh())
                .birthDate(entity.getBirthDate())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .automobileId(entity.getAutomobileId())
                .insuranceTypeId(entity.getInsuranceTypeId())
                .addressId(entity.getAddressId())
                .contractPeriod(entity.getContractPeriod())
                .status(entity.getStatus())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();

        return response;
    }

    public Booking toEntity(BookingRequestDTO request) {
        if (Objects.isNull(request))
            return null;

        return Booking.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .cnh(request.getCnh())
                .birthDate(request.getBirthDate())
                .email(request.getEmail())
                .phone(request.getPhone())
                .automobileId(request.getAutomobileId())
                .insuranceTypeId(request.getInsuranceTypeId())
                .addressId(request.getAddressId())
                .contractPeriod(request.getContractPeriod())
                .build();
    }
}
