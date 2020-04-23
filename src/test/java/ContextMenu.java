import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    public void contextMenu(){
        setup();
        WebElement contextMenuElement = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(contextMenuElement).perform();

        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
        quit();
    }

    public void quit(){
        driver.quit();
    }
}
