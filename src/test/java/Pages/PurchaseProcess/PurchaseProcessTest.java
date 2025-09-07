package Pages.PurchaseProcess;

import Pages.ProductNavigation.Checkout;
import Pages.ProductNavigation.NavigateToProducts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class PurchaseProcessTest {

    @Test
    public void purchaseProcessTest() throws InterruptedException {
        NavigateToProducts.navigateToProducts();
        NavigateToProducts.addProductsToCart(3);
        Checkout.checkOut();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement div = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-confirmation\"]")));
        Assert.assertTrue(div.getText().contains("Thanks for your order! Your invoice number is"));

    }
}
