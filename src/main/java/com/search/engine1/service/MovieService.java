package com.search.engine1.service;

import java.util.List;
import com.search.engine1.domain.Movie;

public interface MovieService {
	
	Movie save(Movie movie);
    void delete(String id);
    Movie findOne(String id);
    List<Movie> findAll();
    List<Movie>   findByReleaseDate(String releaseDate);
    List<Movie> findByReleaseDateAndActor(String releaseDate, String id);
    List<Movie> findByReleaseDateOrderByActorAsc(String releaseDate, String id);
    List<Movie> findByReleaseDateOrderByActorDesc(String releaseDate, String id);

}
