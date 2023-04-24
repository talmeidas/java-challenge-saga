package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.MotorCompanyAutomobileDetailResponseDTO;
import br.com.saga.orchestration.dto.MotorCompanyAutomobileResponseDTO;
import br.com.saga.orchestration.repository.MotorCompanyAutomobileRepository;
import br.com.saga.orchestration.utils.CacheTimeDuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MotorCompanyAutomobileService {
    private final MotorCompanyAutomobileRepository repository;

    @Cacheable(cacheNames = CacheTimeDuration.WEEK, key="'MotorCompanyAutomobileService_' + #root.method.name")
    public List<MotorCompanyAutomobileResponseDTO> getAllAutomobile() {
        return repository.getAllAutomobile();
    }

    @Cacheable(cacheNames = CacheTimeDuration.WEEK, key="'MotorCompanyAutomobileService_' + #root.method.name + '_' + #id")
    public MotorCompanyAutomobileDetailResponseDTO findDetailByAutomobileId(Integer id) {
        return repository.findDetailByAutomobileId(id);
    }
}
