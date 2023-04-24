package br.com.saga.orchestration.service;

import br.com.saga.orchestration.dto.rental.company.BookingRequestDTO;
import br.com.saga.orchestration.dto.rental.company.BookingResponseDTO;
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

    public List<BookingResponseDTO> getAllBooking() {
        return repository.getAllBooking();
    }

    public BookingResponseDTO getBookingById(Integer id) {
        return repository.getBookingById(id);
    }

    public List<BookingResponseDTO> getBookingByCnhNumber(String cnhNumber) {
        return repository.getBookingByCnhNumber(cnhNumber);
    }

    public BookingResponseDTO saveBooking(@Valid BookingRequestDTO request) {
        return repository.saveBooking(request);
    }

    public BookingResponseDTO updateBooking(Integer id, @Valid BookingRequestDTO request) {
        return repository.updateBooking(id, request);
    }

    public BookingResponseDTO cancelBookingById(Integer id) {
        return repository.cancelBookingById(id);
    }
}
