import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import java.util.List;

public class BrokenImages {

    private int brokenImageCount;
    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\\Users\\BOB\\Downloads\\qa_software\\chromedriver.exe");
        driver.get("http://the-internet.herokuapp.com/broken_images");
    }
    public void checkForBrokenImages(){
        setup();
        try {
            brokenImageCount = 0;
            List<WebElement> imageList = driver.findElements(By.tagName("img"));
            for (WebElement image : imageList) {
                if (image != null) {
                    checkIfBroken(image);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        quit();
    }

    private void checkIfBroken(WebElement image){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(image.getAttribute("src"));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200){
                //System.out.println("Status code broken = " + response.getStatusLine().getStatusCode());
                brokenImageCount++;
                //System.out.println("Broken image count: " + brokenImageCount);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void quit(){
        driver.quit();
    }
}
