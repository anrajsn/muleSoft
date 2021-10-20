package muleSoft;
import java.util.*;
import java.io.*;

public class executionMain {

	public static void main(String[] args) throws Exception {
		movieDetails md = new movieDetails();
		ArrayList<addMovieDetails> movieList = new ArrayList<addMovieDetails>();
		dbConnection db = new dbConnection();
		
		movieList=db.readData();
		Scanner sc = new Scanner(System.in);
		int option=0;
		
		System.out.println("Do you want to enter your favourite movie details? Please enter yes or no");
		String inp=sc.next();
		if(inp.equalsIgnoreCase("yes"))
			md.readData();
		else {
			System.out.println("Displaying details");
			System.out.println("Movie Name \t\t Actor \t\t\t Actress \t\t Director \t\t YearOfRelease");
			for(addMovieDetails movieDetails : movieList) {
				System.out.println(movieDetails.getMovieName()+"\t\t\t"+movieDetails.getActor()+"\t\t\t"+movieDetails.getActress()+"\t\t\t"+movieDetails.getDirectorName()+"\t\t\t"+movieDetails.getYrOfRelease());
			}
		}
		
		System.out.println("Please select one of the below category to display details");
		System.out.println("1. Movie Name");
		System.out.println("2. Actor");
		System.out.println("3. Actress");
		System.out.println("4. Director");
		System.out.println("5. Year Of Release");
		option = sc.nextInt();
		
		switch(option){
		case 1: 
			System.out.println("Enter Movie Name");
			movieList = db.readDataForMovie(sc.next());
			break;
			
		case 2:
			System.out.println("Enter name of the actor");
			movieList = db.readDataForActor(sc.next());
			break;
						
		case 3: 
			System.out.println("Enter the name of the actress");
			movieList = db.readDataForActress(sc.next());
			break;
			
		case 4: 
			System.out.println("Enter the name of the director");
			movieList = db.readDataForDirector(sc.next());
			break;
			
		case 5:
			System.out.println("Enter the year of Release");
			movieList = db.readDataForYear(sc.nextInt());
			break;
			
		default:
			System.out.println("Invalid option! Please choose the correct option");
			break;
		}
		if(movieList.size()!=0) {
			for(addMovieDetails movieDetails : movieList) {
				System.out.println(movieDetails.getMovieName()+"\t\t\t"+movieDetails.getActor()+"\t\t\t"+movieDetails.getActress()+"\t\t\t"+movieDetails.getDirectorName()+"\t\t\t"+movieDetails.getYrOfRelease());
			}
		}
		else 
		{
			System.out.println("Sorry! there is no data found matching your query");
		}

	}

}
