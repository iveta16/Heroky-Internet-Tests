import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicAuth {
    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/basic_auth/");
    }

    @Test
    public void correctCredentials(){
        setup();
        String username = "admin";
        String password = "admin";

        driver.navigate().to("http://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth/");
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        String actualMessage = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Correct Credentials Test - COMPLETE");
        quit();
    }

    @Test
    public void wrongCredentials(){
        setup();
        String username = "wrongUsername";
        String password = "wrongPassword";

        driver.navigate().to("http://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth/");
        String expectedTitle = "";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Wrong Credentials Test - COMPLETE");
        quit();
    }

    public void quit(){
        driver.quit();
    }
}
