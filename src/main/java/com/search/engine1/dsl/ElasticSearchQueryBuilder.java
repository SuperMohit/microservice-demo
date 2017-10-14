package com.search.engine1.dsl;
import java.util.List;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.search.engine1.domain.Movie;

@Component
public class ElasticSearchQueryBuilder {

	@Autowired
	ElasticsearchTemplate esTemplate;
	
	public List<Movie> getAllMoviesThatMatch(String text){
		
		QueryBuilder qBuilder = getQueryBuilder(text);		
		NativeSearchQuery searchQuery = createQuery(qBuilder);		
		return esTemplate.queryForList(searchQuery, Movie.class);
	}

	private NativeSearchQuery createQuery(QueryBuilder qBuilder) {
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(qBuilder)
				.build();
		return searchQuery;
	}

	private QueryBuilder getQueryBuilder(String text) {
		QueryBuilder qBuilder = QueryBuilders.boolQuery()
				.should(QueryBuilders.
						queryStringQuery("*"+text+"*")
						.lenient(true)
						.field("title")
						.field("actor"));
		return qBuilder;
	}
	
}
