import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AddRemoveElement {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addButton(){
        setup();
        WebElement addButton = driver.findElement(By.cssSelector("button"));
        addButton.click();

        Assert.assertTrue(driver.findElement(By.cssSelector("button.added-manually")).isDisplayed());
        quit();
    }

    @Test
    public void deleteButton(){
        setup();
        WebElement addButton = driver.findElement(By.cssSelector("button"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.cssSelector("button.added-manually"));
        deleteButton.click();

        Assert.assertFalse(driver.findElements(By.cssSelector("button.added-manually")).size() > 0);
        quit();
    }

    public void quit(){
        driver.quit();
    }
}
