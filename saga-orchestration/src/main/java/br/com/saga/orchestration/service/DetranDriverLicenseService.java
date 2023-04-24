package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.DetranDriverLicenseResponseDTO;
import br.com.saga.orchestration.repository.DetranDriverLicenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DetranDriverLicenseService {
    private final DetranDriverLicenseRepository repository;

    public DetranDriverLicenseResponseDTO getDriverLicenseStatusByCnhNumber(String cnhNumber) {
        return repository.getDriverLicenseStatusByCnhNumber(cnhNumber);
    }
}
