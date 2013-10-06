package com.madhusudhan.jh.domain;

import java.util.Date;
import java.util.Random;


public class DomainUtil {
	
	private static Random r = null;
	
	public static Movie createNewMovie() {
		
		r = new Random();
		
		Movie movie = new Movie();
		movie.setId(r.nextInt(1000));
		movie.setTitle("Jaws");
		movie.setSynopsis("A tale of a Big Shark!");
		movie.setDirector("Steven Speilberg");
//		movie.setReleaseYear(new Date());	
		return movie;
	}
	
}
