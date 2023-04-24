package br.com.rental.company.booking.repository;

import br.com.rental.company.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingByCnhNumber(final String cnhNumber);
}
