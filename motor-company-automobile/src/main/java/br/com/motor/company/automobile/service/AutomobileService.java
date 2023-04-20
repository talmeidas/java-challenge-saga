package br.com.motor.company.automobile.service;

import br.com.motor.company.automobile.dto.AutomobileDetailRequestDTO;
import br.com.motor.company.automobile.dto.AutomobileDetailResponseDTO;
import br.com.motor.company.automobile.dto.AutomobileRequestDTO;
import br.com.motor.company.automobile.dto.AutomobileResponseDTO;
import br.com.motor.company.automobile.mapper.AutomobileDetailMapper;
import br.com.motor.company.automobile.mapper.AutomobileMapper;
import br.com.motor.company.automobile.model.Automobile;
import br.com.motor.company.automobile.model.AutomobileDetail;
import br.com.motor.company.automobile.repository.AutomobileDetailRepository;
import br.com.motor.company.automobile.repository.AutomobileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AutomobileService {
    private final AutomobileMapper mapper;
    private final AutomobileRepository repository;

    @Cacheable(value = "itemCache")
    public List<AutomobileResponseDTO> getAllAutomobile() {
        log.info("Listing automobile");

        final var listOfEntities = repository.findAll();

        return mapper.toResponse(listOfEntities);
    }

    @Transactional
    public AutomobileResponseDTO saveAutomobile(@Valid AutomobileRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving automobile - {}", request);

        Automobile automobile = mapper.toEntity(request);

        automobile.setCreated(new Date());

        return mapper.toResponse(repository.save(automobile));
    }
}
