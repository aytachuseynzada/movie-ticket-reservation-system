package service;

import dao.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationCleanerService {
    private final ReservationRepository reservationRepository;
    public void cleanReservations() {
        var time = LocalDateTime.now().minusHours(1);
        var reservations = reservationRepository.findAllByStatusAndCreatedAtBefore("PENDING", time);
        reservationRepository.deleteAll(reservations);
    }
}
