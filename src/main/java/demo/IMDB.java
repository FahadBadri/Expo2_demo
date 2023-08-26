package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB {
    ChromeDriver driver;
    public IMDB(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
public void Rating(){
// Navigaten to url https://www.imdb.com/chart/top
    driver.get("https://www.imdb.com/chart/top");
    
 WebElement HighestRatedMovie = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        String HighestRatedMovieTitle = HighestRatedMovie.getText();
    System.out.println("Highest rated movie: " + HighestRatedMovieTitle);

   // Numbers movies are included in the table 
 List<WebElement> MovieRows = driver.findElements(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li"));
            int NumberOfMovies = MovieRows.size();
        System.out.println("Number of movies: " + NumberOfMovies);

        
       
        Select drpDown = new Select(driver.findElement(By.xpath("//*[@id=\"sort-by-selector\"]")));
        
        drpDown.selectByVisibleText("Release date");
       // driver.navigate().refresh();
       
        WebElement swapSortOrderButton = driver.findElement(By.xpath("//*[@id=\"swap-sort-order-button\"]"));
        swapSortOrderButton.click(); 
 // the oldest movie on the list

        WebElement OldestdMovie = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        String OldestdMovieTitle = OldestdMovie.getText();
    System.out.println("oldest movie on the list: " + OldestdMovieTitle);

    swapSortOrderButton.click(); 

// Get the most recent movie on the list
    WebElement MostRecentMovie = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
    String MostRecentTitle = MostRecentMovie.getText();
System.out.println("most recent movie on the list: " + MostRecentTitle);

// Get the most rating movie on the list
Select drppDown = new Select(driver.findElement(By.xpath("//*[@id=\"sort-by-selector\"]")));
drpDown.selectByVisibleText("Number of ratings");
WebElement MostRatedtMovie = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
String MostRatedtMovieTitle = MostRatedtMovie.getText();
System.out.println("most user ratings on the list: " + MostRatedtMovieTitle);

}
}
 
 
 
 
 
 
 
 
 
