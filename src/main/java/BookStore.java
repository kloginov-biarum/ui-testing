import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class BookStore {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://demoqa.com/login";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void invalidData() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.id("userName"));
        emailInputField.sendKeys("testtest");
        WebElement passwordInputFiled = driver.findElement(By.id("password"));
        passwordInputFiled.sendKeys("Qq12345!!");
        WebElement logInButton = driver.findElement(By.id("login"));
        logInButton.click();
        WebElement accountButton = driver.findElement(By.id("gh-ug"));
        assertTrue(accountButton.isDisplayed());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
