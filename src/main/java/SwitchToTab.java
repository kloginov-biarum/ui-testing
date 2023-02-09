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
import java.util.ArrayList;


import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class SwitchToTab {
    ChromeDriver driver;




    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://qa.segterra.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @Test
    public void followLink () throws InterruptedException {
        sleep(3000);
        WebElement hippaLink = driver.findElement(By.cssSelector("[data-test-id=\"company-hipaa\"]"));
        hippaLink.click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        WebElement hippaTitleInNewTab = driver.findElement(By.id("hs_cos_wrapper_name"));
        assertTrue(hippaTitleInNewTab.getText().contains("HIPAA"));
        driver.close();
        sleep(3000);

        // assertTrue(driver.getCurrentUrl().contains("hipaa-compliant"));

    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
