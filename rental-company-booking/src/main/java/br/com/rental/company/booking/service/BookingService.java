package br.com.rental.company.booking.service;

import br.com.rental.company.booking.dto.BookingRequestDTO;
import br.com.rental.company.booking.dto.BookingResponseDTO;
import br.com.rental.company.booking.enumerable.StatusBooking;
import br.com.rental.company.booking.mapper.BookingMapper;
import br.com.rental.company.booking.model.Booking;
import br.com.rental.company.booking.repository.BookingRepository;
import br.com.rental.company.booking.utils.Validate;
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
public class BookingService {
    private final BookingMapper mapper;
    private final BookingRepository repository;

    public List<BookingResponseDTO> getAllBooking() {
        log.info("Listing booking");

        final var listOfEntities = repository.findAll();

        return mapper.toResponse(listOfEntities);
    }

    public BookingResponseDTO getBookingById(Integer id) {
        log.info("Getting booking id - {}", id);

        var bookingOptional = repository.findById(id);
        var entity = bookingOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        return mapper.toResponse(entity);
    }

    public List<BookingResponseDTO> getBookingByCnh(String cnh) {
        log.info("Getting booking cnh - {}", cnh);

        if (!Validate.cnh(cnh)) {
            throw new IllegalArgumentException("exception.illegal.argument.cnh");
        }

        var listOfEntities = repository.findBookingByCnh(cnh);

        if (listOfEntities.isEmpty()) {
            throw new EntityNotFoundException("exception.unexpected.not.found");
        }

        return mapper.toResponse(listOfEntities);
    }

    @Transactional
    public BookingResponseDTO saveBooking(@Valid BookingRequestDTO request) {
        Objects.requireNonNull(request, "request must not be null");

        if (!Validate.cnh(request.getCnh())) {
            throw new IllegalArgumentException("exception.illegal.argument.cnh");
        }

        log.info("Saving booking - {}", request);

        Booking booking = mapper.toEntity(request);

        booking.setCreated(new Date());
        booking.setStatus(StatusBooking.PENDING);

        return mapper.toResponse(repository.save(booking));
    }

    @Transactional
    public BookingResponseDTO updateBooking(Integer id, @Valid BookingRequestDTO request) {
        log.info("Updating booking id - {}", id);

        // find entities
        var bookingOptional = repository.findById(id);

        // validate is not empty
        var booking = bookingOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        booking.setName(request.getName());
        booking.setCpf(request.getCpf());
        booking.setCnh(request.getCnh());
        booking.setBirthDate(request.getBirthDate());
        booking.setEmail(request.getEmail());
        booking.setPhone(request.getPhone());
        booking.setAutomobileId(request.getAutomobileId());
        booking.setInsuranceTypeId(request.getInsuranceTypeId());
        booking.setAddressId(request.getAddressId());
        booking.setContractPeriod(request.getContractPeriod());
        booking.setUpdated(new Date());

        // Update
        repository.save(booking);

        return mapper.toResponse(booking);
    }

    @Transactional
    public BookingResponseDTO cancelBookingById(Integer id) {
        log.info("Updating booking - {}", id);

        // find entities
        var bookingOptional = repository.findById(id);

        // validate is not empty
        var booking = bookingOptional.orElseThrow(() -> new EntityNotFoundException("exception.unexpected.not.found"));

        booking.setUpdated(new Date());
        booking.setStatus(StatusBooking.CANCELED);

        // Update
        repository.save(booking);

        return mapper.toResponse(booking);
    }
}
