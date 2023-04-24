package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.DetranDriverLicenseResponseDTO;
import br.com.saga.orchestration.repository.DetranDriverLicenseRepository;
import br.com.saga.orchestration.utils.CacheTimeDuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DetranDriverLicenseService {
    private final DetranDriverLicenseRepository repository;

    @Cacheable(cacheNames = CacheTimeDuration.DAY, key="'DetranDriverLicenseService_' + #root.method.name + '_' + #cnhNumber")
    public DetranDriverLicenseResponseDTO getDriverLicenseStatusByCnhNumber(String cnhNumber) {
        return repository.getDriverLicenseStatusByCnhNumber(cnhNumber);
    }
}
