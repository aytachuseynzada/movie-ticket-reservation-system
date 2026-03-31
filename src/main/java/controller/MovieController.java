package controller;

import dao.entity.MovieEntity;
import dto.MovieRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.MovieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieRequestDto movieRequestDto) {
        movieService.createMovie(movieRequestDto);
    }
    @GetMapping
    public List<MovieEntity> getAllMovies() {
        return movieService.getAllMovies();
    }
}
