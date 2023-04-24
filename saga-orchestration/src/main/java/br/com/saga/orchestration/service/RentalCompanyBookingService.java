package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.DetranDriverLicenseResponseDTO;
import br.com.saga.orchestration.dto.RentalCompanyBookingRequestDTO;
import br.com.saga.orchestration.dto.RentalCompanyBookingResponseDTO;
import br.com.saga.orchestration.enumerable.DetranDriverLicenseStatus;
import br.com.saga.orchestration.repository.RentalCompanyBookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentalCompanyBookingService {
    private final RentalCompanyBookingRepository repository;

    private final DetranDriverLicenseService detranDriverLicenseService;

    public List<RentalCompanyBookingResponseDTO> getAllBooking() {
        return repository.getAllBooking();
    }

    public RentalCompanyBookingResponseDTO getBookingById(Integer id) {
        return repository.getBookingById(id);
    }

    public List<RentalCompanyBookingResponseDTO> getBookingByCnhNumber(String cnhNumber) {
        return repository.getBookingByCnhNumber(cnhNumber);
    }

    public RentalCompanyBookingResponseDTO saveBooking(@Valid RentalCompanyBookingRequestDTO request) {
        final DetranDriverLicenseResponseDTO detranDriverLicenseResponse = detranDriverLicenseService.getDriverLicenseStatusByCnhNumber(request.getCnhNumber());

        if (detranDriverLicenseResponse.getStatus() != DetranDriverLicenseStatus.REGULAR) {
            throw new IllegalArgumentException("exception.illegal.argument.cnh.irregular");
        }

        return repository.saveBooking(request);
    }

    public RentalCompanyBookingResponseDTO updateBooking(Integer id, @Valid RentalCompanyBookingRequestDTO request) {
        return repository.updateBooking(id, request);
    }

    public RentalCompanyBookingResponseDTO cancelBookingById(Integer id) {
        return repository.cancelBookingById(id);
    }
}
