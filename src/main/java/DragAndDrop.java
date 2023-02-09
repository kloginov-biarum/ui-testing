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

public class DragAndDrop {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://crossbrowsertesting.github.io/drag-and-drop.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
     WebElement draggable = driver.findElement(By.id("draggable"));
     WebElement droppable = driver.findElement(By.id("droppable"));
     Actions actions = new Actions(driver);
     //actions.dragAndDrop(draggable, droppable).perform();
     actions.moveToElement(draggable).clickAndHold().
             moveToElement(droppable).release().build().perform();

     //assert

    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
