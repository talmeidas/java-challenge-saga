package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.RentalCompanySupportAddressResponseDTO;
import br.com.saga.orchestration.dto.RentalCompanySupportCustomerRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanySupportCustomerResponseDTO;
import br.com.saga.orchestration.repository.RentalCompanySupportRepository;
import br.com.saga.orchestration.utils.CacheTimeDuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentalCompanySupportService {
    private final RentalCompanySupportRepository repository;

    public List<RentalCompanySupportCustomerResponseDTO> getAllSchedule() {
        return repository.getAllSchedule();
    }

    public RentalCompanySupportCustomerResponseDTO getScheduleById(Integer id) {
        return repository.getScheduleById(id);
    }

    public List<RentalCompanySupportCustomerResponseDTO> getScheduleByCnhNumber(String cnhNumber) {
        return repository.getScheduleByCnhNumber(cnhNumber);
    }

    public RentalCompanySupportCustomerResponseDTO saveSchedule(@Valid RentalCompanySupportCustomerRequestDTO request) {
        return repository.saveSchedule(request);
    }

    public RentalCompanySupportCustomerResponseDTO cancelScheduleById(Integer id) {
        return repository.cancelScheduleById(id);
    }

    @Cacheable(value = CacheTimeDuration.WEEK, key="#root.targetClass + '_' + #root.method.name")
    public List<RentalCompanySupportAddressResponseDTO> getAllAddress() {
        return repository.getAllAddress();
    }
}
