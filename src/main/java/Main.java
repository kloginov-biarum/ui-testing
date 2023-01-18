import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");


        WebElement searchBar = driver.findElement(By.cssSelector("[name='q']"));
        searchBar.sendKeys("bicycle", Keys.ENTER);



    /*    WebElement searchButton =
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[6]/center/input[1]"));
*/
       // searchButton.click();


    }
}
