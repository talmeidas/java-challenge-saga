package br.com.motor.company.automobile.service;

import br.com.motor.company.automobile.dto.AutomobileDetailRequestDTO;
import br.com.motor.company.automobile.dto.AutomobileDetailResponseDTO;
import br.com.motor.company.automobile.dto.AutomobileResponseDTO;
import br.com.motor.company.automobile.mapper.AutomobileDetailMapper;
import br.com.motor.company.automobile.mapper.AutomobileMapper;
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
public class AutomobileDetailService {
    private final AutomobileDetailMapper mapper;
    private final AutomobileDetailRepository repository;

    public AutomobileDetailResponseDTO findDetailByAutomobileId(Integer id) {
        log.info("Getting automobile's details by id - {}", id);

        var automobileDetailOptional = repository.findDetailByAutomobileId(id);
        var entity = automobileDetailOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        return mapper.toResponse(entity);
    }

    @Transactional
    public AutomobileDetailResponseDTO saveAutomobileDetail(@Valid AutomobileDetailRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving automobile detail - {}", request);

        AutomobileDetail automobileDetail = mapper.toEntity(request);

        automobileDetail.setCreated(new Date());

        return mapper.toResponse(repository.save(automobileDetail));
    }
}
