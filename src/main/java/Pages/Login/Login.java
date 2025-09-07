package Pages.Login;

import Utilities.TestData.Data;
import org.openqa.selenium.By;

import static Utilities.Selenium.DriverFactory.driver;

public class Login {

    public static void loginWithValidUser() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(Data.email_new);
        driver.findElement(By.id("password")).sendKeys(Data.password_new);
        driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
        Thread.sleep(2000);

    }
}
