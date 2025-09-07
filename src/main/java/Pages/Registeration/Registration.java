package Pages.Registeration;

import Utilities.Selenium.DriverFactory;
import Utilities.TestData.Data;
import Utilities.TestData.TestDataGenerator;
import org.openqa.selenium.By;

import static Utilities.Selenium.DriverFactory.driver;

public class Registration {

    public static void RegisterWithValidUser() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.get("https://practicesoftwaretesting.com/auth/register");

        // filling the form.
        driver.findElement(By.id("first_name")).sendKeys("Mohamed");
        driver.findElement(By.id("last_name")).sendKeys("Makaty");
        driver.findElement(By.id("dob")).sendKeys("2002-01-12");
        driver.findElement(By.id("street")).sendKeys("Maged");
        driver.findElement(By.id("postal_code")).sendKeys("27882");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("state")).sendKeys("Giza");
        driver.findElement(By.id("country")).sendKeys("Germany");
        driver.findElement(By.id("phone")).sendKeys("09188918989");
        String email = TestDataGenerator.generateEmail();
        Data.email_new = email;
        driver.findElement(By.id("email")).sendKeys(email);
        String password = TestDataGenerator.generatePassword();
        Data.password_new = password;
        driver.findElement(By.id("password")).sendKeys(password);

        // clicking the button
        driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button")).click();
        Thread.sleep(3000);
    }
}
