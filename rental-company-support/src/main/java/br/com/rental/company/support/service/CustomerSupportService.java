package br.com.rental.company.support.service;

import br.com.rental.company.support.dto.CustomerSupportRequestDTO;
import br.com.rental.company.support.dto.CustomerSupportResponseDTO;
import br.com.rental.company.support.enumerable.StatusSupport;
import br.com.rental.company.support.mapper.CustomerSupportMapper;
import br.com.rental.company.support.model.CustomerSupport;
import br.com.rental.company.support.repository.CustomerSupportRepository;
import br.com.rental.company.support.utils.Validate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class CustomerSupportService {
    private final CustomerSupportMapper mapper;
    private final CustomerSupportRepository repository;

    public List<CustomerSupportResponseDTO> getAllSchedule() {
        log.info("Listing schedule");

        final var listOfEntities = repository.findAll();

        return mapper.toResponse(listOfEntities);
    }

    public CustomerSupportResponseDTO getScheduleById(Integer id) {
        log.info("Getting schedule by id - {}", id);

        var customerSupportOptional = repository.findById(id);
        var entity = customerSupportOptional
                .orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        return mapper.toResponse(entity);
    }

    public List<CustomerSupportResponseDTO> getScheduleByCnh(String cnh) {
        log.info("Getting schedule by cnh - {}", cnh);

        if (!Validate.cnh(cnh)) {
            throw new IllegalArgumentException("exception.illegal.argument.cnh");
        }

        var listOfEntities = repository.findScheduleByCnh(cnh);

        if (listOfEntities.isEmpty()) {
            throw new EntityNotFoundException("exception.unexpected.not.found");
        }

        return mapper.toResponse(listOfEntities);
    }

    @Transactional
    public CustomerSupportResponseDTO saveSchedule(@Valid CustomerSupportRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        if (!Validate.cnh(request.getCnh())) {
            throw new IllegalArgumentException("exception.illegal.argument.cnh");
        }

        log.info("Saving Customer Support - {}", request);

        CustomerSupport customerSupport = mapper.toEntity(request);

        customerSupport.setCreated(new Date());
        customerSupport.setStatus(StatusSupport.PENDING);

        return mapper.toResponse(repository.save(customerSupport));
    }

    @Transactional
    public CustomerSupportResponseDTO cancelScheduleById(Integer id) {
        log.info("Updating Customer Support id - {}", id);

        // find entities
        var customerSupportOptional = repository.findById(id);

        // validate is not empty
        var subject = customerSupportOptional
                .orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        subject.setUpdated(new Date());
        subject.setStatus(StatusSupport.CANCELED);

        // Update
        repository.save(subject);

        return mapper.toResponse(subject);
    }
}
