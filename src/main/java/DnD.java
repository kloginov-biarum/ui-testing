import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DnD {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://crossbrowsertesting.github.io/drag-and-drop.html ";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void validData() throws InterruptedException{
        WebElement dragableElement = driver.findElement(By.id("draggable"));
        WebElement dropableElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dragableElement).clickAndHold().
                moveToElement(dropableElement).release().build().perform();
        assertTrue(dropableElement.getText().contains("Dropped!"));
    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
