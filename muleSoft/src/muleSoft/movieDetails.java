package muleSoft;

import java.util.ArrayList;
import java.util.*;

public class movieDetails {
	ArrayList<addMovieDetails> movieList = new ArrayList<addMovieDetails>();
	addMovieDetails movieDetails = new addMovieDetails();
	dbConnection dbCon = new dbConnection();
	Scanner sc = new Scanner(System.in);
	
	public void readData() throws Exception{
		movieList = dbCon.readData();
		verifyMovieDetails();
	}
	
	public void verifyMovieDetails() throws Exception {
		movieList = dbCon.readData();
		System.out.println("Enter Movie Name");
		movieDetails.setMovieName(sc.next());
		System.out.println("Enter year of release");
		movieDetails.setYrOfRelease(sc.nextInt());
		System.out.println("Enter the name of the actor");
		movieDetails.setActor(sc.next());
		System.out.println("Enter the name of the actress");
		movieDetails.setActress(sc.next());
		System.out.println("Enter the name of the director");
		movieDetails.setDirectorName(sc.next());	
		
		boolean checkDb = checkDb(movieDetails);
		int count=0;
		if(checkDb==true) {
			System.out.println("Sorry! The details entered by you are duplicate. Kindly re enter the details");
			verifyMovieDetails();
		}
		else
			count = dbCon.addMovieDetailsToDB(movieDetails);
		
		if(count>0)
			System.out.println("Thanks! Your favourite movie details are stored securely in the database");
	}

	private boolean checkDb(addMovieDetails vmd) throws Exception {	
		movieList = dbCon.readData();
		for(addMovieDetails md : movieList) {
			if(md.getMovieName().equalsIgnoreCase(vmd.getMovieName()) && md.getYrOfRelease()==vmd.getYrOfRelease()) {
				return true;
			}				
		}
		return false;
	}
	
	

}
