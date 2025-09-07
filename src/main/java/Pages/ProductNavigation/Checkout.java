package Pages.ProductNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class Checkout {

    public static void checkOut() throws InterruptedException {
        // go to cart
        driver.findElement(By.cssSelector("a[data-test='nav-cart']")).click();
        Thread.sleep(3000);

        // proceed
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div/button")).click();
        Thread.sleep(2000);

        // select
        WebElement paymentMethodSelect = driver.findElement(By.id("payment-method"));
        paymentMethodSelect.click();
        Select select = new Select(paymentMethodSelect);
        select.selectByIndex(2);

        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("Selected payment method: " + selectedOption);



        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button")).click();
        Thread.sleep(3000);



    }
}
