package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
    ChromeDriver driver;
    public BookMyShow(){
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

    public void hyperLink(){
    // Navigaten to url  https://in.bookmyshow.com/explore/home/chennai
    driver.get("https://in.bookmyshow.com/explore/home/chennai");
    // find the list of hyperlinks Using Locator "Tag Name" a
    List<WebElement> list = driver.findElements(By.tagName("a"));
    // count of  the hyperlinks Using Locator "Tag Name" size()
    //size()
    System.out.println("Count of the hyperlink is :" +list.size());
    
    
    List<WebElement> list1 = driver.findElements(By.xpath("//*[@id='super-container']/div[2]/div[3]/div[1]/div[4]/div/div/div/div[2]/div//a"));
    
    //System.out.println("Recommended Movies Image URLs:");
    for (WebElement movie : list1) {
        String imageUrl = movie.getAttribute("href");
        System.out.println(imageUrl);
    }

   

    
        
        WebElement language =driver.findElement(By.xpath("//h2[text()='Premieres']/../../../../div[2]/div/div/div[2]/child::a/div/div[3]/div[2]/div"));
        System.out.println(language.getText());
        WebElement Name = driver.findElement(By.xpath("//h2[text()='Premieres']/../../../../div[2]/div/div/div[2]/child::a/div/div[3]/div[1]/div"));
        System.out.println(language.getText());

       


   
    }
    
}



// Navigate to Url  https://in.bookmyshow.com/explore/home/chennai
// Count HyperLinks on the landing Page Using Locator "XPath" Counts=("//a[@href]" );
// Print Counts of hyperlinks found on the landing page Using Locator "Tag Name" System.out.print(Counts.size());
//   System.out.print(Counts.size());

//*[@id="super-container"]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div[1]