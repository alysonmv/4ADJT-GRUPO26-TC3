package com.challenge.restaurant.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testFindByCustomerName() {
        Reservation reservation = new Reservation("Bob", LocalDate.of(2024, 10, 15), LocalTime.of(18, 0), 2);
        reservationRepository.save(reservation);

        Reservation foundReservation = reservationRepository.findByCustomerName("Bob");
        assertThat(foundReservation).isNotNull();
        assertThat(foundReservation.getNumberOfGuests()).isEqualTo(2);
    }
}
