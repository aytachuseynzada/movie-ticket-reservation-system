package dao.repository;

import dao.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    long countByUserIdAndStatus(long userId, String status);
    List<ReservationEntity> findAllByStatusAndCreatedAtBefore(String status, LocalDateTime time);
}
