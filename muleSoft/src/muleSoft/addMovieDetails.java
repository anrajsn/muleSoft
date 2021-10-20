package muleSoft;

public class addMovieDetails {

	private String movieName;
	private String actor;
	private String actress;
	private String directorName;
	private int yrOfRelease;
	
	public addMovieDetails(String movieName, String actor, String actress, String directorName, int yrOfRelease) {
		super();
		this.movieName = movieName;
		this.actor = actor;
		this.actress = actress;
		this.directorName = directorName;
		this.yrOfRelease = yrOfRelease;
	}
	
	public addMovieDetails() {
		super();
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public int getYrOfRelease() {
		return yrOfRelease;
	}
	public void setYrOfRelease(int yrOfRelease) {
		this.yrOfRelease = yrOfRelease;
	}
	
	
}
