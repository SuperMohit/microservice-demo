package com.search.engine1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.search.engine1.domain.Movie;
import com.search.engine1.exception.MovieNotFoundException;
import com.search.engine1.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void delete(String id) {
	 if(id.equals("x"))
		 throw new MovieNotFoundException("Movie doesn't exist.");
	 else 	 
		movieRepository.delete(id);		
	}

	@Override
	public Movie findOne(String id) {
		return movieRepository.findOne(id);
	}

	@Override
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movies::add);
		return movies;
		
	}

	@Override
	public List<Movie> findByReleaseDate(String releaseDate) {
		return movieRepository.findByReleaseDate(releaseDate).collect(Collectors.toList());
	}

	@Override
	public List<Movie> findByReleaseDateAndActor(String releaseDate, String actor) {
		return movieRepository.findByReleaseDateAndActor(releaseDate,actor).collect(Collectors.toList());
	}

	@Override
	public List<Movie> findByReleaseDateOrderByActorAsc(String releaseDate, String id) {
		return movieRepository.findByReleaseDateOrderByActorAsc(releaseDate,id)
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> findByReleaseDateOrderByActorDesc(String releaseDate, String id) {
		return movieRepository.findByReleaseDateOrderByActorDesc(releaseDate,id)
				.collect(Collectors.toList());
	}

}
