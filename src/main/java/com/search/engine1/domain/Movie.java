package com.search.engine1.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "searchengine", type = "movies")
public class Movie {
	
	    @Id
	    private String id;
		private String title;
	    private String actor;
	    private String releaseDate;
	    
	    public Movie() {
	    	
	    }
	    
	    public Movie(String title, String actor, String releaseDate) {
			this.title = title;
			this.actor = actor;
			this.releaseDate = releaseDate;
		}
	    
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getReleaseDate() {
			return releaseDate;
		}
		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
	
}
