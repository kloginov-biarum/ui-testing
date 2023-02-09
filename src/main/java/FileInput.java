import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileInput {

    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "http://suninjuly.github.io/file_input.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void validData() throws InterruptedException{
        WebElement firstName = driver.findElement(By.cssSelector("[name='firstname']"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.cssSelector("[name='lastname']"));
        lastName.sendKeys("Snow");
        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        email.sendKeys("asdas2dd@cc");
        WebElement fileUpload = driver.findElement(By.id("file"));
        fileUpload.sendKeys("/Users/ergrevegvrg/Downloads/textfile.txt");
        WebElement submitbutton = driver.findElement(By.cssSelector("[type='submit']"));
        submitbutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

      //  sleep(10000);
    }

    @Test





    @After
    public void tearDown(){
        driver.quit();
    }

}
