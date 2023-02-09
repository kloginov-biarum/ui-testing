import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Ebay {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.ebay.com/ ";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void invalidData() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.cssSelector("#gh-ug a[href*='signin']"));
        loginLink.click();
        WebElement emailInputField = driver.findElement(By.id("userid"));
        emailInputField.sendKeys("testtest@robot-mail.com");
        WebElement continueButton = driver.findElement(By.id("signin-continue-btn"));
        continueButton.click();
        WebElement passwordInputFiled = driver.findElement(By.id("pass"));
        passwordInputFiled.sendKeys("Qq12345!!");
        WebElement signInButton = driver.findElement(By.id("sgnBt"));
        signInButton.click();
        WebElement accountButton = driver.findElement(By.id("gh-ug"));
        assertTrue(accountButton.isDisplayed());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
