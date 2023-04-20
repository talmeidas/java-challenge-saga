package br.com.rental.company.support.service;

import br.com.rental.company.support.dto.AddressRequestDTO;
import br.com.rental.company.support.dto.AddressResponseDTO;
import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportResponseDTO;
import br.com.rental.company.support.enumerable.StatusSupport;
import br.com.rental.company.support.mapper.AddressMapper;
import br.com.rental.company.support.model.Address;
import br.com.rental.company.support.model.CustomerSupport;
import br.com.rental.company.support.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressMapper mapper;
    private final AddressRepository repository;

    public List<AddressResponseDTO> getAllAddress() {
        log.info("Listing Addresses");

        final var listOfEntities = repository.findAll();

        return mapper.toResponse(listOfEntities);
    }

    @Transactional
    public AddressResponseDTO saveAddress(@Valid AddressRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving Address - {}", request);

        Address address = mapper.toEntity(request);

        address.setCreated(new Date());

        return mapper.toResponse(repository.save(address));
    }
}
