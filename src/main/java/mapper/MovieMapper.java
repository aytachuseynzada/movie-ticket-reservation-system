package mapper;

import dao.entity.MovieEntity;
import dao.entity.ReservationEntity;
import dto.MovieRequestDto;
import dto.ReservationRequestDto;

public class MovieMapper {
    public static MovieEntity mapToEntity(MovieRequestDto movieRequestDto) {
        MovieEntity movie = new MovieEntity();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setGenre(movieRequestDto.getGenre());
        movie.setTotalSeats(movieRequestDto.getTotalSeats());
        movie.setAvailableSeats(movieRequestDto.getTotalSeats());
        return movie;
    }
}
