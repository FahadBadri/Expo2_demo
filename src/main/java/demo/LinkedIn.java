package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class LinkedIn {
    ChromeDriver driver;
    public LinkedIn(){
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
     public void getCount() throws InterruptedException{
        // Navigate to URL  https://in.linkedin.com/
        driver.get("https://www.linkedin.com/?trk=seo-authwall-base_nav-header-logo");
        // Enter the username to the username text box Using Locator "XPath" //*[@id='username'] | sendKeys("testUser/sonalirana286@gmail.com")
        driver.findElement(By.xpath("//*[@id=\"session_key\"]")).sendKeys("7483186866");
        // Enter the password to the password text box Using Locator "XPath" //*[@id='password'] | sendKeys("@#Aug23 ")
        driver.findElement(By.xpath("//*[@id=\"session_password\"]")).sendKeys("Uniqu@123");
        // Click on the signIn button Using Locator "XPath" //*[@type='submit']  | click()
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // Print the count of Who's viewed your profile Using Locator "XPath" profile = (//div/span/strong)[1]| System.out.print(profile.getText())
        // WebElement views = driver.findElement(By.xpath("(//div/span/strong)[1]"));
        // System.out.println("Who viewd your profile :" + views.getText());
        // Print the count of Impressions of your post Using Locator "XPath" impressions = (//div/span/strong)[2] | System.out.print(impressions.getText())
        // WebElement impressions = driver.findElement(By.xpath("(//div/span/strong)[2]"));
        // System.out.println("Impressions on your post :" + impressions.getText());
        // click on Start a post Using Locator "ID" ember380 | click()
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
       // Thread.sleep(3000);
       //*[@id="ember199"]
        // click on Post to anyone Using Locator "XPath" //*[text()="Post to Anyone"] | click()
        

        driver.findElement(By.xpath("//*[@id=\"share-to-linkedin-modal__header\"]/button")).click();
        // Select Connction only options Using Locator "XPath" //*[@id="CONNECTIONS_ONLY"]/span[2]/span/span/strong | click()
        driver.findElement(By.xpath("//*[@id='CONNECTIONS_ONLY']/span[2]/span/span/strong")).click();
        // click on Done button Using Locator "XPath" //*[text()="Done"] | click()
        driver.findElement(By.xpath("//*[text()='Done']")).click();

        WebElement Content= driver.findElement(By.xpath("//div/div/p[1]"));
        Content.click();
        Content.sendKeys("Testt  Postt Creating");
        // click on post button Using Locator "XPath"  //*[text()="Post"] | click()
        driver.findElement(By.xpath("//*[text()='Post']")).click();
        // Confirm post Using Locator "XPath" //*[@id="ember650"] | confirm.getText()
       // boolean post = driver.findElement(By.xpath("//span[text()=\"Test Post Creating\"]")).isDisplayed();          
        WebElement Confirmpost = driver.findElement(By.xpath(" //*[@id=\"ember320\"]/div/p/span"));
        Confirmpost.getText();
        System.out.println("The post has been displayed in the feed :" + Confirmpost);
     }
    
}