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
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PartitialLink {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "http://suninjuly.github.io/huge_form.html";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);

    }

    @Test
    public void onlyRequiredFields(){
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement input: inputs ){
            input.sendKeys("fgshfdgjsh");
        }
        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Text od alert: "+ alert.getText());
    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
