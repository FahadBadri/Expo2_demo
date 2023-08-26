package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.util.concurrent.TimeUnit;
import java.util.List;
// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
    ChromeDriver driver;
    public WindowHandle(){
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

    public void Handle(){
        
// Navigate to Url    https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open
// driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
// // Switch to iframe which has 'Try it' Button   Using Locator "XPath" driver.switchTo().frame()
// driver.switchTo().frame(iframeResult);
// // Click on Try it Button Using Locator "Tag Name" //button[contains(text(),'Try it')] | button.click();
// WebElement TryButton = driver.findElement(By.xpath("/html/body/button"));
// TryButton.click();
// Sitch to new Window/Tab   //button[contains(text(),'Try it')] | button.click();
//  Get the URL of the new window  driver.getUrl(); 
// Get the Title of the new window  driver.getTitle();
// Get the Title of the new window  TakesScreenshot;
// Close the new window.  driver.close()
// "Switch back to the original window by 
// using the window handle.  driver.switchTo().window(originalHandle);"
// close the current window.  driver.quit()
// Navigate to URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open

driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

//Switch to the iframe containing the "Try it" button
driver.switchTo().frame("iframeResult");

// Click on "Try it" button Using Locator "XPath" //button[text()="Try it"] | click()

WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
tryItButton.click();

// Get the handles of all open windows Set<String> windowHandles = driver.getWindowHandles()
 Set<String> windowHandles = driver.getWindowHandles();
// Now switch to the new window   String handle = driver.getWindownHandles()
for (String windowHandle : windowHandles) {
   driver.switchTo().window(windowHandle);
}
// Get the URL of the new window  driver.getCurrentUrl()
String currentUrl = driver.getCurrentUrl();
  
// Get the title  driver.getTitle()
String title = driver.getTitle();
// take screenshot of the page  takeScreenshot()

String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

//  AShot ashot = new AShot();

//  Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
 
//  ImageIO.write(myScreenshot.getImage(), "PNG", new File("D:\\Crio\\BIAssignment\\app\\src\\Screenshots\\Screenshot_"+ timeStamp + ".png"));

//  System.out.println("Full page screenshot cature and saved at: Screenshot_"+ timeStamp + ".png");



    // TODO: Capture the full page screenshot
    String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

    AShot ashot = new AShot();

    Screenshot screenshot = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
    
    // Save the file  with a unique name
    String DestiPath = "C:\Users\fahad\Assignments\Automate pseudocode\selenium_starter\Screenshots" + timestamp + ".png";
   
    try {
        ImageIO.write(screenshot.getImage(), "PNG", new File(DestiPath));
    } catch (IOException e) {
        System.out.println("Fail to save" + e.getMessage());
    }
    System.out.println("Full Page Screenshot capture and saved at : " + DestiPath); // Print the path of the file






// Now close the new window  driver.close()
// "Switch back to the original window by using the window handle  driver.switchTo().window()"
    }
    
