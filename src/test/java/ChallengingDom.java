import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDom {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
    }

    public void selectTitle(){
        WebElement title = driver.findElement(By.cssSelector(".example h3"));
    }

    public void selectDescription(){
        WebElement description = driver.findElement(By.cssSelector(".example p"));
    }

    public void selectBlueButton(){
        WebElement blueButton = driver.findElement(By.cssSelector(".example .button:not(.alert):not(.success)"));
        blueButton.click();
    }

    public void selectRedButton(){
        WebElement redButton = driver.findElement(By.cssSelector("a[class$=\"alert\"]"));
        redButton.click();
    }

    public void selectGreenButton(){
        WebElement greenButton = driver.findElement(By.cssSelector("a[id*=\"fbccd220\"]"));
        greenButton.click();
    }

    public void selectFirstRow(){
        List<WebElement> firstRow;
        firstRow = driver.findElements(By.cssSelector("tbody> tr:first-of-type>td"));

        for(int i = 0; i < firstRow.size(); i++){
            if(firstRow.get(i).getText().contains("0"))
            {
                System.out.println("Selected: " + firstRow.get(i).getText());
            }
        }
    }

    public void selectEditButton(){
        WebElement fourthRowEditButton = driver.findElement(By.cssSelector("tbody > tr:nth-of-type(4) td:last-of-type [href=\"#edit\"]"));
        fourthRowEditButton.click();
    }

    public void quit(){
        driver.quit();
    }
}
