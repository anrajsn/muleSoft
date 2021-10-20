package muleSoft;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class dbConnection {
	addMovieDetails movieDetails = new addMovieDetails();
	ArrayList<addMovieDetails> movieList = new ArrayList<addMovieDetails>();
	private Connection  connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "#Racs@230916#";
	final private String database = "sys";
	
	public String getPasswd() {
		return passwd;
	}
	
	public void connectToDB() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, passwd);
			statement = connect.createStatement();
			
			DatabaseMetaData dbm = connect.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "movies", null);
			
			if(!tables.next()) {
				String query = "create table movies("+"movieName varchar(100) primary key not null,"+"actor varchar(30) not null,"
						       +"actress varchar(30) not null,"+"directorName varchar(30) not null,"+"yearOfRelease int not null)";
				statement.execute(query);   
			}
			resultSet = statement.executeQuery("select * from movies");
		}catch(Exception e) {
			throw e;
		}
	}
	
	public ArrayList<addMovieDetails> readData() throws Exception{
		connectToDB();
		
		
		try {
				while(resultSet.next()) {
					String movieName = resultSet.getString("movieName");
					String actor = resultSet.getString("actor");
					String actress = resultSet.getString("actress");
					String directorName = resultSet.getString("directorName");
					int yrOfRelease = resultSet.getInt("yearOfRelease");
					movieDetails = new addMovieDetails(movieName, actor, actress, directorName, yrOfRelease);
					movieList.add(movieDetails); 
				}return movieList;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public int addMovieDetailsToDB(addMovieDetails newMovieDetails) throws Exception {
		String query = "Insert into movies(" + "movieName," + "actor," + "actress," + "directorName," + "yearOfRelease) values(?,?,?,?,?)";
		int count=0;
		
		try {
			preparedStatement = connect.prepareStatement(query);
			preparedStatement.setString(1, newMovieDetails.getMovieName());
			preparedStatement.setString(2, newMovieDetails.getActor());
			preparedStatement.setString(3, newMovieDetails.getActress());
			preparedStatement.setString(4, newMovieDetails.getDirectorName());
			preparedStatement.setInt(5, newMovieDetails.getYrOfRelease());
			count=preparedStatement.executeUpdate();	
		}catch(Exception e) {
			throw e;
		}
		return count;
	}

	public ArrayList<addMovieDetails> readDataForMovie(String nameOfTheMovie) throws Exception {
		
		ArrayList<addMovieDetails> movieList1 = new ArrayList<addMovieDetails>();
		String query = "select * from movies where movieName='"+nameOfTheMovie+"'";
		resultSet = statement.executeQuery(query);
				
		try {
			while(resultSet.next()) {
				String movieName = resultSet.getString("movieName");
				String actor = resultSet.getString("actor");
				String actress = resultSet.getString("actress");
				String directorName = resultSet.getString("directorName");
				int yrOfRelease = resultSet.getInt("yearOfRelease");
				movieDetails = new addMovieDetails(movieName, actor, actress, directorName, yrOfRelease);
				movieList1.add(movieDetails);
			}return movieList1;
	}
	catch(Exception e) {
		throw e;
	}
}

	public ArrayList<addMovieDetails> readDataForActor(String nameOfTheActor) throws SQLException {
		ArrayList<addMovieDetails> movieList1 = new ArrayList<addMovieDetails>();
		String query = "select * from movies where actor='"+nameOfTheActor+"'";
		resultSet = statement.executeQuery(query);
				
		try {
			while(resultSet.next()) {
				String movieName = resultSet.getString("movieName");
				String actor = resultSet.getString("actor");
				String actress = resultSet.getString("actress");
				String directorName = resultSet.getString("directorName");
				int yrOfRelease = resultSet.getInt("yearOfRelease");
				movieDetails = new addMovieDetails(movieName, actor, actress, directorName, yrOfRelease);
				movieList1.add(movieDetails);
			}return movieList1;
	}
	catch(Exception e) {
		throw e;
	}
}

	public ArrayList<addMovieDetails> readDataForActress(String nameOfTheActress) throws SQLException {
		ArrayList<addMovieDetails> movieList1 = new ArrayList<addMovieDetails>();
		String query = "select * from movies where actress='"+nameOfTheActress+"'";
		resultSet = statement.executeQuery(query);
				
		try {
			while(resultSet.next()) {
				String movieName = resultSet.getString("movieName");
				String actor = resultSet.getString("actor");
				String actress = resultSet.getString("actress");
				String directorName = resultSet.getString("directorName");
				int yrOfRelease = resultSet.getInt("yearOfRelease");
				movieDetails = new addMovieDetails(movieName, actor, actress, directorName, yrOfRelease);
				movieList1.add(movieDetails);
			}return movieList1;
	}
	catch(Exception e) {
		throw e;
	}
	}

	public ArrayList<addMovieDetails> readDataForDirector(String nameOfTheDirector) throws SQLException {
		ArrayList<addMovieDetails> movieList1 = new ArrayList<addMovieDetails>();
		String query = "select * from movies where directorName='"+nameOfTheDirector+"'";
		resultSet = statement.executeQuery(query);
				
		try {
			while(resultSet.next()) {
				String movieName = resultSet.getString("movieName");
				String actor = resultSet.getString("actor");
				String actress = resultSet.getString("actress");
				String directorName = resultSet.getString("directorName");
				int yrOfRelease = resultSet.getInt("yearOfRelease");
				movieDetails = new addMovieDetails(movieName, actor, actress, directorName, yrOfRelease);
				movieList1.add(movieDetails);
			}return movieList1;
	}
	catch(Exception e) {
		throw e;
	}
}

	public ArrayList<addMovieDetails> readDataForYear(int yearOfRelease) throws SQLException {
		ArrayList<addMovieDetails> movieList1 = new ArrayList<addMovieDetails>();
		String query = "select * from movies where yearOfRelease="+yearOfRelease;
		resultSet = statement.executeQuery(query);
				
		try {
			while(resultSet.next()) {
				String movieName = resultSet.getString("movieName");
				String actor = resultSet.getString("actor");
				String actress = resultSet.getString("actress");
				String directorName = resultSet.getString("directorName");
				int yrOfRelease = resultSet.getInt("yearOfRelease");
				movieDetails = new addMovieDetails(movieName, actor, actress, directorName, yrOfRelease);
				movieList1.add(movieDetails);
			}return movieList1;
	}
	catch(Exception e) {
		throw e;
	}
	}

}
