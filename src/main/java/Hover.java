import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class Hover {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://crossbrowsertesting.github.io/hover-menu.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//li[@class='dropdown']/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement secondaryMenu = driver.findElement(By.cssSelector("[class='secondary-dropdown']>a"));
        actions.moveToElement(secondaryMenu).perform();
        WebElement secondaryAction = driver.findElement(By.cssSelector("[class='dropdown-menu secondary']"));
        secondaryAction.click();
        //WebElement
        //assert
        sleep(5000);


    }




    @After
    public void tearDown(){
        driver.quit();
    }

}
