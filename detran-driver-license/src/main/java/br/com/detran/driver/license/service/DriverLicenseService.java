package br.com.detran.driver.license.service;

import br.com.detran.driver.license.dto.DriverLicenseRequestDTO;
import br.com.detran.driver.license.dto.DriverLicenseResponseDTO;
import br.com.detran.driver.license.mapper.DriverLicenseMapper;
import br.com.detran.driver.license.model.DriverLicense;
import br.com.detran.driver.license.repository.DriverLicenseRepository;
import br.com.detran.driver.license.utils.Validate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverLicenseService {
    private final DriverLicenseMapper mapper;
    private final DriverLicenseRepository repository;

    public DriverLicenseResponseDTO getDriverLicenseStatusByCnhNumber(String cnhNumber) {
        log.info("Getting driver license status by CNH number - {}", cnhNumber);

        if (!Validate.cnh(cnhNumber)) {
            throw new IllegalArgumentException("exception.illegal.argument.cnh");
        }

        var driverLicenseOptional = repository.findById(cnhNumber);
        var entity = driverLicenseOptional
                .orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        return mapper.toResponse(entity);
    }

    @Transactional
    public DriverLicenseResponseDTO saveDriverLicense(@Valid DriverLicenseRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        log.info("Saving driver license - {}", request);

        DriverLicense driverLicense = mapper.toEntity(request);

        driverLicense.setCreated(new Date());

        return mapper.toResponse(repository.save(driverLicense));
    }
}
