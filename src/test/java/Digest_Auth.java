import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Digest_Auth {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/basic_auth/");
    }

    @Test
    public void sendCorrectCredentials(){
        setup();
        String username = "admin";
        String password = "admin";

        driver.navigate().to("http://"+username+":"+password+"@the-internet.herokuapp.com/digest_auth/");

        String expectedMessage = "Congratulations! You must have the proper credentials.";
        String actualMessage = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);

        quit();
    }

    @Test
    public void sendWrongCredentials(){
        setup();
        String username = "wrongUsername";
        String password = "wrongPassword";

        driver.navigate().to("http://"+username+":"+password+"@the-internet.herokuapp.com/digest_auth/");

        String expectedTitle = "";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        quit();
    }

    public void quit(){
        driver.quit();
    }

}
