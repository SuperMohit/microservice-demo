FROM openjdk:8
ADD target/movie-engine.jar movie-engine.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "movie-engine.jar"]

#docker build -t movie-search .