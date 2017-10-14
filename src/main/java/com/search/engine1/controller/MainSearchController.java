package com.search.engine1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.search.engine1.domain.Movie;
import com.search.engine1.dsl.ElasticSearchQueryBuilder;
import com.search.engine1.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class MainSearchController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	ElasticSearchQueryBuilder queryBuilder;
	
	@ApiOperation(value = "Fetch all movies")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Movie.class) })
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies(){						
		return ResponseEntity.ok(movieService.findAll());		
	}
	
	@GetMapping("movie/{id}")
	public ResponseEntity<Movie> findBy(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok(movieService.findOne(id));
	}
	
	@PutMapping("movie/save")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok(movieService.save(movie));
	}
	
	@DeleteMapping("movie/delete/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") String id) {
		movieService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("movie/textsearch/{text}")
	public ResponseEntity<List<Movie>> searchText(@PathVariable(value = "text") String text) {
		return ResponseEntity.ok(queryBuilder.getAllMoviesThatMatch(text));
	}
	
	@GetMapping("movie/find/{releaseDate}")
	public ResponseEntity<List<Movie>> getByReleaseDate(@PathVariable(value = "releaseDate") String releaseDate) {
		return ResponseEntity.ok(movieService.findByReleaseDate(releaseDate));
	}
	
	@GetMapping("movie/find/{releaseDate}/{actor}")
	public ResponseEntity<List<Movie>> getByReleaseDateAndActor(@PathVariable(value = "releaseDate") String releaseDate, 
			@PathVariable(value = "actor") String actor) {
		return ResponseEntity.ok(movieService.findByReleaseDateAndActor(releaseDate,actor));
	}
	
	@GetMapping("movie/find/sorted/{releaseDate}/{id}")
	public ResponseEntity<List<Movie>> getByReleaseDateOrderByActorAsc(@PathVariable(value = "releaseDate") String releaseDate, 
			@PathVariable(value = "id") String id) {
		return ResponseEntity.ok(movieService.findByReleaseDateOrderByActorAsc(releaseDate,id));
	}
	
}
