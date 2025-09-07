package Pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class LoginTest {

    @Test(priority = 1)
    public void Login() throws InterruptedException {
        Thread.sleep(5000);
        Login.loginWithValidUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement label_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-overview/h1")));
        Assert.assertEquals("My account", label_name.getText());
        System.out.println(label_name.getText());
    }
}
