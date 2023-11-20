package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("  //h2[@class='page__heading']")).getText();
        Assert.assertEquals("Verify two texts:",expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        driver.findElement(By.id("user[email]")).sendKeys("ascd@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("123456789");
        driver.findElement(By.xpath("  //button[@class='button button-primary g-recaptcha']")).click();
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li[@class= 'form-error__list-item']")).getText();
        Assert.assertEquals("Verify two message: ",expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
