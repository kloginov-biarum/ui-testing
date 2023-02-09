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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cats {
    ChromeDriver driver;

@Before
public void setUp(){
    System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
    driver = new ChromeDriver();
    String BASE_URL = "http://suninjuly.github.io/cats.html";
    driver.get(BASE_URL);

}

@Test
public void checkHeaderText(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated
            (By.className("jumbotron-heading")));
    String expectedHeaderText = "Cat memes";
    assertEquals("Element does not contains text:" + expectedHeaderText ,expectedHeaderText,
            header.getText());
}
@Test
public void checkCatsCardsQuantity(){
    List<WebElement> catsCards = driver.findElements(By.className("col-sm-4"));
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(catsCards.get(0)));
    assertEquals("Quantity of cat cards is not 6!",6, catsCards.size());
}


public void checkTimeSecondCat(){

}


@After
public void tearDown(){
    driver.quit();
}



}
