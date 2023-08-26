package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames{
    ChromeDriver driver;
    public NestedFrames(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases5");
        driver.close();
        driver.quit();

    }

    public void frames(){
//         Navigate to Url for nested frames  ("https://the-internet.herokuapp.com/nested_frames")
driver.get("https://the-internet.herokuapp.com/nested_frames");
// Switch to the top frame   driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
// "Switch to the LEFT subframe of the top frame and get text Using Locator ""XPath"" //body | frame-left.getText();"
        driver.switchTo().frame("frame-left");
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
// Switch to the top frame   //body | frame-left.getText();
        System.out.println("Text from LEFT subframe: " + leftFrameText);

 // Switch back to the top frame
 driver.switchTo().parentFrame();
// "Switch to the MIDDLE subframe of the top frame
 driver.switchTo().frame("frame-middle");
 //  and get text Using Locator ""TagName"" //body | frame-middle.getText();"
 String MiddleFrameText = driver.findElement(By.tagName("body")).getText();
 // Print text from the MIDDLE subframe of the top frame  System.out.println(middleFrameText)
 System.out.println("Text from Middle subframe: " + MiddleFrameText);
// Switch back to the top frame
 driver.switchTo().parentFrame();

 
// Switch to the top frame   driver.switchTo().parentFrame();
// "Switch to the RIGHT subframe of the top frame
//  and get text Using Locator ""XPath"" //body | frame-right.getText();"
// Print text from the RIGHT subframe of the top frame  System.out.println(rightFrameText)
// Switch to the top frame   driver.switchTo().parentFrame();
// Switch to the default frame   driver.switchTo().defaultFrame();

 driver.switchTo().frame("frame-right");
 String RightFrameText = driver.findElement(By.tagName("body")).getText();
 System.out.println("Text from Right subframe: " + RightFrameText);


// Switch to the bottom frame    
// "Switch to the BOTTOM subframe of the top frame
//  and get text Using Locator ""XPath"" //body | frame-bottom.text()"
// Print text from the BOTTOM subframe of the top frame  System.out.println(bottomFrameText)
// close the browser  System.out.println(bottomFrameText)
 driver.switchTo().defaultContent();


 driver.switchTo().frame("frame-bottom");
 String BottomFrameText = driver.findElement(By.tagName("body")).getText();
 System.out.println("Text from Right subframe: " + BottomFrameText);






    }

}