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

public class JavaScript {

    ChromeDriver driver;







    public double funcCalc(double x){
        System.out.println("result" + log((abs(12*(sin(x))))));
        return log((abs(12*(sin(x)))));
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/execute_script.html  ";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void calculationTest()  {
        double result = 0;
        WebElement xValue = driver.findElement(By.id("input_value"));
        result=funcCalc(parseDouble((xValue.getText())));
        WebElement answerInputField= driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        WebElement robotCheckbox =driver.findElement(By.id("robotCheckbox"));
        robotCheckbox.click();
        WebElement robotsRule = driver.findElement(By.id("robotsRule"));
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(true);",robotsRule);
        robotsRule.click();
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }





    @After
    public void tearDown(){
        driver.quit();
    }
}
