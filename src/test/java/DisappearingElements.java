import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DisappearingElements {

    WebDriver driver;
    int buttonCount = 0;
    int buttonCount2 = 0;
    List<WebElement> listOne;
    List<WebElement> listTwo;
    List<WebElement> tempList;
    String locator = "ul > li";
    int testIterations = 5;
    Boolean brokenElements = false;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/disappearing_elements");
    }

    public void compareLists(){
        if(buttonCount > buttonCount2) {
            System.out.println("Disappearance!");
            brokenElements = true;
        }
        else if(buttonCount < buttonCount2)
        {
            System.out.println("Reappearance!");
            brokenElements = true;
        }
        else
            System.out.println("Nothing happened here!");
    }

    @Test
    public void checkLists(){
        //listOne is empty when first loading the page
        if(buttonCount == 0){
            //Load first list
            fillListOne(locator);
            refreshPage();
            fillListTwo(locator);
            compareLists();
        }
        //listOne has value so we have performed one check already
        //reassign listOne with value of listTwo
        //reset listTwo
        else{
            fillListTwo(locator);
            compareLists();
            System.out.println("else");
        }

        Assert.assertTrue(brokenElements == false);
        quit();
    }

    public void fillListOne(String locator){
        listOne = driver.findElements(By.cssSelector(locator));
        for(int i = 0; i<listOne.size(); i++) {
            buttonCount++;
        }
        System.out.println("listOne has: " + buttonCount + "buttons");
    }

    public void fillListTwo(String locator){
        listTwo = driver.findElements(By.cssSelector(locator));
        for(int i = 0; i<listTwo.size(); i++) {
            buttonCount2++;
        }
        System.out.println("listTwo has: " + buttonCount2 + " buttons");
    }

    public void reset(){
        buttonCount = buttonCount2;
        buttonCount2 = 0;

        tempList = listTwo;

        listTwo.removeAll(listTwo);
        listOne.removeAll(listOne);

        listOne = tempList;

        tempList.removeAll(tempList);
    }

    public void repeatTest(){
        while(testIterations > 1)
        {
            reset();
            refreshPage();
            waitAMinute();
            checkLists();
            testIterations--;
        }
    }

    public void waitAMinute(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    }

    public void refreshPage(){
        driver.navigate().to(driver.getCurrentUrl());
    }

    public void quit(){
        driver.quit();
    }
}
