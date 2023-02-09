import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Hvr {
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
    public void validData() throws InterruptedException{
        WebElement dropdown = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();

        WebElement secondaryMenu = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[2]"));
        actions.moveToElement(secondaryMenu).perform();
        WebElement secondaryAction = driver.findElement(By.cssSelector("[onclick='handleSecondaryAction()']"));
        secondaryAction.click();
        WebElement secondaryPageHeader = driver.findElement(By.xpath("(//h1)[2]"));
        assertTrue(secondaryPageHeader.getText().contains("Secondary Page"));



    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
