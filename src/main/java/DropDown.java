import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;


public class DropDown {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/selects1.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTest(){
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        int sum = parseInt(num1.getText()) + parseInt(num2.getText());

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();

        String s1="Hello ";
        String s2="Peter";
        System.out.println(s1+","+s2+sum);
        WebElement answerOption = driver.findElement(By.cssSelector("[value='"+sum+"']"));



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
