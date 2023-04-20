package br.com.rental.company.contract.service;

import br.com.rental.company.contract.dto.ContractRequestDTO;
import br.com.rental.company.contract.dto.ContractResponseDTO;
import br.com.rental.company.contract.enumerable.StatusContract;
import br.com.rental.company.contract.mapper.ContractMapper;
import br.com.rental.company.contract.model.Contract;
import br.com.rental.company.contract.repository.ContractRepository;
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
public class ContractService {
    private final ContractMapper mapper;
    private final ContractRepository repository;

    public List<ContractResponseDTO> getAllContract() {
        log.info("Listing contract");

        final var listOfEntities = repository.findAll();

        return mapper.toResponse(listOfEntities);
    }

    public ContractResponseDTO getContractById(Integer id) {
        log.info("Getting contract id - {}", id);

        var contractOptional = repository.findById(id);
        var entity = contractOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        return mapper.toResponse(entity);
    }

    public ContractResponseDTO getContractByBookingId(Integer bookingId) {
        log.info("Getting contract by bookingId - {}", bookingId);

        var contractOptional = repository.findContractByBookingId(bookingId);
        var entity = contractOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        return mapper.toResponse(entity);
    }

    @Transactional
    public ContractResponseDTO saveContract(@Valid ContractRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving contract - {}", request);

        Contract contract = mapper.toEntity(request);

        contract.setCreated(new Date());
        contract.setStatus(StatusContract.ON_GOING);

        return mapper.toResponse(repository.save(contract));
    }

    @Transactional
    public ContractResponseDTO cancelContractById(Integer id) {
        log.info("Updating contract - {}", id);

        // find entities
        var contractOptional = repository.findById(id);

        // validate is not empty
        var contract = contractOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        contract.setUpdated(new Date());
        contract.setStatus(StatusContract.CANCELED);

        // Update
        repository.save(contract);

        return mapper.toResponse(contract);
    }
}
