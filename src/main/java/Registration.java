import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class Registration {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "http://suninjuly.github.io/registration1.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);

    }

    @Test
    public void onlyRequiredFields(){
       WebElement header = driver.findElement(By.cssSelector("h1"));
       assertTrue(header.isDisplayed());
       WebElement firstName = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
       firstName.sendKeys("John");
       WebElement lastName = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
       lastName.sendKeys("Snow");
       WebElement email = driver.findElement(By.cssSelector("[class='form-group third_class'] input"));
       email.sendKeys("djhbdfdj@gfg.com");
       WebElement submitButton = driver.findElement(By.cssSelector("[class='btn btn-default']"));
       submitButton.click();
       WebElement successSubmitMessage = driver.findElement(By.cssSelector("h1"));
       assertTrue (successSubmitMessage.getText().contains("Congratulations! You have successfully registered!"));

    }

    @Test
    public void negativeNotAllRequiredFields(){
        WebElement header = driver.findElement(By.cssSelector("h1"));
        assertTrue(header.isDisplayed());
        WebElement firstName = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastName.sendKeys("Snow");
        //WebElement email = driver.findElement(By.cssSelector("[class='form-group third_class'] input"));
        //email.sendKeys("djhbdfdj@gfg.com");
        WebElement submitButton = driver.findElement(By.cssSelector("[class='btn btn-default']"));
        submitButton.click();
        WebElement successSubmitMessage = driver.findElement(By.cssSelector("h1"));
        assertFalse (successSubmitMessage.getText().contains("Congratulations! You have successfully registered!"));
        assertFalse(driver.getCurrentUrl().contains("result"));

    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
