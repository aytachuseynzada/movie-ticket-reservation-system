package service;

import dao.entity.MovieEntity;
import dao.entity.ReservationEntity;
import dao.entity.UserEntity;
import dao.repository.MovieRepository;
import dao.repository.ReservationRepository;
import dao.repository.UserRepository;
import dto.ReservationRequestDto;
import exceptions.*;
import lombok.RequiredArgsConstructor;
import mapper.ReservationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    public void createReservation(ReservationRequestDto reservationRequestDto) {
        var user = fetchUserIfExist(reservationRequestDto.getUserId());
        if(!user.getActive()){
            throw new UserNotActiveException("USER IS NOT ACTIVE");
        }
        var movie = fetchMovieIfExist(reservationRequestDto.getMovieId());
        if(movie.getAvailableSeats() <= 0){
            throw new NoAvailableSeatsException("NO SEATS AVAILABLE");
        }
        long approvedCount = reservationRepository.countByUserIdAndStatus(user.getId(), "APPROVED");
        if(approvedCount >= 5){
            throw new ReservationNotEnoughException("USER HAS MAX 5 APPROVED RESERVATIONS");
        }
        ReservationEntity reservation = ReservationMapper.mapToEntity(reservationRequestDto);
        reservation.setStatus("PENDING");
        reservation.setCreatedAt(LocalDateTime.now());
        reservationRepository.save(reservation);
    }
    @Transactional
    public void approveReservation(Long id){
        var reservation = fetchReservationIfExist(id);
        var movie = fetchMovieIfExist(reservation.getMovieId());

        if (movie.getAvailableSeats() <= 0)
            throw new NoAvailableSeatsException("NO SEATS AVAILABLE");

        reservation.setStatus("APPROVED");
        reservation.setApprovedAt(LocalDateTime.now());

        movie.setAvailableSeats(movie.getAvailableSeats() - 1);

        movieRepository.save(movie);
        reservationRepository.save(reservation);
    }
    private ReservationEntity fetchReservationIfExist(Long id){
        var reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new ReservationNotEnoughException("RESERVATION NOT FOUND");
        }
        return reservation.get();
    }
    private UserEntity fetchUserIfExist(Long id){
        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("USER NOT FOUND");
        }
        return user.get();
    }
    private MovieEntity fetchMovieIfExist(Long id){
        var movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new MovieNotFoundException("MOVIE NOT FOUND");
        }
        return movie.get();
    }
}


