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
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DatePicker {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://demo.guru99.com/test/ ";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void validData() throws InterruptedException{
        WebElement datepicker = driver.findElement(By.cssSelector("[name='bdaytime']"));
        datepicker.sendKeys("10101992", Keys.TAB, "2320");
        //datepicker.sendKeys("1010");
        WebElement submitbutton = driver.findElement(By.cssSelector("[type='submit']"));
        submitbutton.click();
        WebElement dateAndTime = driver.findElement(By.xpath("//body//div[@style='font-size:15px;margin-left:50px;']"));

       // System.out.println( datepicker.getAttribute("validationMessage"));
        assertTrue("",dateAndTime.getText().contains("23:20"));
        assertTrue("",dateAndTime.getText().contains("1992"));

        //sleep(10000);
    }

    @Test
    public void invalidData() throws InterruptedException{
        WebElement datepicker = driver.findElement(By.cssSelector("[name='bdaytime']"));
        datepicker.sendKeys("1010");
        WebElement submitbutton = driver.findElement(By.cssSelector("[type='submit']"));
        submitbutton.click();
        assertTrue(datepicker.getAttribute("validationMessage").contains("Введите верное значение"));
        assertFalse(driver.getCurrentUrl().contains("birthdate"));
        assertTrue(submitbutton.isDisplayed());

    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
