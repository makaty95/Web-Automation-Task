package Pages.Registeration;

import org.testng.annotations.Test;

public class RegistrationTest {

    @Test(priority = 1)
    public void RegisterWithUser() throws InterruptedException {
        Registration.RegisterWithValidUser();
    }
}
