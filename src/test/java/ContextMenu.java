import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void contextMenu(){
        setup();
        WebElement contextMenuElement = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(contextMenuElement).perform();

        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText = "You selected a context menu";

        Assert.assertEquals(actualAlertText, expectedAlertText);
        alert.dismiss();

        quit();
    }

    public void quit(){
        driver.quit();
    }
}
