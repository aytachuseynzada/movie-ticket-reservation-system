package service;

import dao.entity.MovieEntity;
import dao.repository.MovieRepository;
import dto.MovieRequestDto;
import lombok.RequiredArgsConstructor;
import mapper.MovieMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public void createMovie(MovieRequestDto movieRequestDto) {
        MovieEntity movie = MovieMapper.mapToEntity(movieRequestDto);
        movieRepository.save(movie);
    }
    public List<MovieEntity> getAllMovies(){
        return movieRepository.findAll();
    }
}
