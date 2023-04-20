package br.com.rental.company.booking;

import br.com.rental.company.booking.dto.BookingRequestDTO;
import br.com.rental.company.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class RentalCompanyBookingApplication implements CommandLineRunner {
        private final BookingService bookingService;

        public static void main(String[] args) {
                SpringApplication.run(RentalCompanyBookingApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                // Initial Load of booking
                var booking1 = BookingRequestDTO.builder()
                        .name("Name 1")
                        .cpf("00000000191")
                        .cnh("07021871297")
                        .birthDate(Date.from(Instant.parse("1980-01-01T00:00:00.000Z")))
                        .email("user1@email.com")
                        .phone("11123456789")
                        .automobileId(1)
                        .insuranceTypeId(1)
                        .addressId(1)
                        .contractPeriod(12)
                        .build();

                var booking2 = BookingRequestDTO.builder()
                        .name("Name 2")
                        .cpf("27626137019")
                        .cnh("69457688418")
                        .birthDate(Date.from(Instant.parse("1990-01-01T00:00:00.000Z")))
                        .email("user2@email.com")
                        .phone("11123456789")
                        .automobileId(1)
                        .insuranceTypeId(1)
                        .addressId(1)
                        .contractPeriod(12)
                        .build();

                var booking3 = BookingRequestDTO.builder()
                        .name("Name 3")
                        .cpf("08565793001")
                        .cnh("21418336906")
                        .birthDate(Date.from(Instant.parse("2000-01-01T00:00:00.000Z")))
                        .email("user3@email.com")
                        .phone("11123456789")
                        .automobileId(1)
                        .insuranceTypeId(1)
                        .addressId(1)
                        .contractPeriod(12)
                        .build();

                bookingService.saveBooking(booking1);
                bookingService.saveBooking(booking2);
                bookingService.saveBooking(booking3);
        }
}
