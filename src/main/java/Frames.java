import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Math.sin;
import static org.junit.Assert.assertTrue;

public class Frames {
    ChromeDriver driver;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://demoqa.com/frames";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void frameTest()  {
       driver.switchTo().frame("frame1");
       WebElement header1 = driver.findElement(By.id("sampleHeading"));
       System.out.println(header1.getText());
       driver.switchTo().defaultContent();
       driver.switchTo().frame("frame2");
    }





    @After
    public void tearDown(){
        driver.quit();
    }
}
