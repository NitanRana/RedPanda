package redPanda;

import java.sql.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class DatabaseConnectivity extends IMDbTop250Movies{
	
	@Test
	 public Connection createNewTable() {
	        // SQLite connection string
	        String url = "jdbc:sqlite:C:\\Users\\Nitan\\IMDb\\src\\redPanda\\IMDBTopRated250Moives.sqlite";
	        
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS Top250Movies (\n"
	                + "	name varchar NOT NULL,\n"
	                +");";
	        
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	            System.out.println("Table Created#############################");
	         
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			return null;
			
	    }
	@Test
	 public void insert() throws ClassNotFoundException {
		
		List<WebElement> movies=driver.findElements(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody"));
		for(WebElement TopMovies:movies){
			String s = TopMovies.getText();
			System.out.println(s);
			String sql = "INSERT INTO Top250Movies(name) VALUES("+s+");";
			try (Connection conn = this.createNewTable();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        		}
		}
	} 
}
