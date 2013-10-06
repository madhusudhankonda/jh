package com.madhusudhan.jh.basics.pseudo;

import com.madhusudhan.jh.domain.Movie;

public class MoviePersistorTest {
	MoviePersistor moviePersistor = new MoviePersistor();

	private void test() {
		Movie movie = new Movie();

		movie.setId(1);
		movie.setTitle("Jaws");
		movie.setDirector("Steven Spielberg");
		movie.setSynopsis("Story of a gigantic great white shark!");

		moviePersistor.perist(movie);
		
		
	}

	public static void main(String[] args) {

	}
}