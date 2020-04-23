import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Checkboxes {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    public void firstCheckBox(){
        setup();
        WebElement checkBoxOne = driver.findElement(By.cssSelector("#checkboxes input[type=checkbox]:first-of-type"));
        checkBoxOne.click();
        quit();
    }

    public void secondCheckBox(){
        setup();
        WebElement checkBoxTwo = driver.findElement(By.cssSelector("#checkboxes input[type=checkbox]:nth-of-type(2)"));
        checkBoxTwo.click();
        quit();
    }

    public void quit(){
        driver.quit();
    }
}
