import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveElement {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void addButton(){
        setup();
        WebElement addButton = driver.findElement(By.cssSelector("button"));
        addButton.click();
        try {
            driver.findElement(By.cssSelector("button"));
            System.out.println("Button was added");
        } catch (NoSuchElementException buttonDisappeared){
            System.out.println("Button was not added");
        }
        quit();
    }

    public void deleteButton(){
        setup();
        addButton();
        WebElement deleteButton = driver.findElement(By.cssSelector("button.added-manually"));
        deleteButton.click();

        try {
            driver.findElement(By.cssSelector("button.added-manually"));
            System.out.println("Button was not deleted");
        } catch (NoSuchElementException buttonDisappeared){
            System.out.println("Button was deleted");
        }
        quit();
    }

    public void quit(){
        driver.quit();
    }
}
