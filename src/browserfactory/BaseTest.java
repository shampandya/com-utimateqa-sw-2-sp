package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver=new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new EdgeDriver();
        }else{
            System.out.println("The browser name not mentioned in the condition.");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void closeBrowser(){
        driver.quit();
    }
}
