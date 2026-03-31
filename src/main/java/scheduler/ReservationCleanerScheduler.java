package scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import service.ReservationCleanerService;
@RequiredArgsConstructor
@Service
public class ReservationCleanerScheduler {
    private final ReservationCleanerService reservationCleanerService;
    @Scheduled(fixedRate = 600000)
    public void cleanReservations() {
        reservationCleanerService.cleanReservations();
    }
}
