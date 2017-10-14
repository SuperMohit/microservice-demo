package com.search.engine1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.search.engine1.domain.Movie;
import com.search.engine1.repository.MovieRepository;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieDocumentTest {

	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	public void saveAndGetMovieId() {	
		Movie movie = new  Movie("Karate Kid", "Jackie Chan", "02-10-2008");
		movie = movieRepository.save(movie);
		System.out.println("Movie Id is :" + movie.getId());
		assertThat(movie.getId()).isNotNull();
	}

}
