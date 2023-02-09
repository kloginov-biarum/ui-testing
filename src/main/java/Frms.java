import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class Frms {
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
    public void validData() throws InterruptedException{
        driver.switchTo().frame("frame1");
        WebElement header = driver.findElement(By.id("sampleHeading"));
        System.out.println(header.getText());
        //sleep(3000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement header2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(header2.getText());
        //  sleep(10000);
    }





    @After
    public void tearDown(){
        driver.quit();
    }
}
