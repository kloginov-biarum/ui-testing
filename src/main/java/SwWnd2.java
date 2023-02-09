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

public class SwWnd2 {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://demoqa.com/browser-windows";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void validData() throws InterruptedException{
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        //sleep(3000);
        ArrayList<String> handles = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(handles.size());
        driver.switchTo().window(handles.get(1));
        System.out.println(driver.getCurrentUrl());
        WebElement header = driver.findElement(By.id("sampleHeading"));
        assertTrue(header.getText().contains("This is a sample page"));
        driver.close();
        driver.switchTo().window(handles.get(0));
        System.out.println(driver.getCurrentUrl());
        sleep(3000);


        //  sleep(10000);
    }





    @After
    public void tearDown(){
        driver.quit();
    }
}
