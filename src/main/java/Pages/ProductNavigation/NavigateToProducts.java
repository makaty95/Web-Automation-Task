package Pages.ProductNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static Utilities.Selenium.DriverFactory.driver;

public class NavigateToProducts {

    public static void navigateToProducts() throws InterruptedException {

        // navigate to the main page.
        Thread.sleep(2000);
        driver.get("https://practicesoftwaretesting.com/");
        Thread.sleep(2000);

    }

    public static void addProductsToCart(int purchases) throws InterruptedException {

        // div /html/body/app-root/div/app-overview/div[3]/div[2]/div[1]
        Random random = new Random();
        for(int i = 0; i<purchases; i++) {

            List<WebElement> products = driver.findElements(By.cssSelector("div.container > a.card"));
            Thread.sleep(3000);
            WebElement product = products.get(random.nextInt(products.size()-1));

            System.out.println(String.format("\n%s\n item is chosen", product.getText()));
            addProductToCart(product, 5);

            Thread.sleep(3000);
        }
        Thread.sleep(2000);
    }

    public static void addProductToCart(WebElement product, int maxAmount) throws InterruptedException {
        product.click();
        Thread.sleep(2000);

        // choose up to 5 instances
        int amount = new Random().nextInt(maxAmount);
        boolean outOfStock = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        for(int i = 0; i<amount; i++) {
            // click increase button

            boolean isClickable = false;
            try {
                isClickable = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//*[@id=\"btn-increase-quantity\"]")
                        )
                ) != null;
                isClickable = true;
            } catch (Exception _) {}

            if(!isClickable) {
                outOfStock = true;
                break;
            }

            driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/div[1]/button[2]")).click();
            Thread.sleep(500);
        }

        if(!outOfStock) {
            // add to cart
            driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/div[2]/button[1]")).click();
            Thread.sleep(2000);
        }

        driver.navigate().back();
        Thread.sleep(2000);
    }



}
