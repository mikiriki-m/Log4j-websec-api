package com.example.websecurity.facade;


import com.example.websecurity.api.dto.MovieResponse;
import com.example.websecurity.persistence.Movie;
import com.example.websecurity.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieFacade {

    private static final Logger log = LogManager.getLogger(MovieFacade.class);

    private final MovieService movieService;

    public MovieResponse getMovieById(Long id) {
    log.info("Movie Facade: Getting movie by id: {}", id);
        Movie movie = movieService.getMovieById(id);
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .year(movie.getYear())
                .runningTime(movie.getRunningTime())
                .description(movie.getDescription())
                .build();
    }
}
