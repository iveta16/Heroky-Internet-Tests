import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Digest_Auth {

    WebDriver driver;
    String username = "admin";
    String password = "admin";

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/basic_auth/");
    }

    public void sendCredentials(){
        setup();
        driver.navigate().to("http://"+username+":"+password+"@the-internet.herokuapp.com/digest_auth/");
        quit();
    }

    public void quit(){
        driver.quit();
    }

}
