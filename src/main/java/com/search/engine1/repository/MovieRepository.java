package com.search.engine1.repository;

import java.util.stream.Stream;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.search.engine1.domain.Movie;


@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {
	Stream<Movie> findByReleaseDate(String releaseDate);
	Stream<Movie> findByReleaseDateAndActor(String releaseDate, String actor);
	Stream<Movie> findByReleaseDateOrderByActorAsc(String releaseDate, String id);
	Stream<Movie> findByReleaseDateOrderByActorDesc(String releaseDate, String id);
}
