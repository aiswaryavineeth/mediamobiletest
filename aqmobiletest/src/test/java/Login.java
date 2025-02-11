import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends Main {

    private final By loginButton = By.xpath("//android.widget.ImageView[@content-desc='Login']");
    private final By usernameField = By.xpath("//android.widget.EditText[1]");
    private final By passwordField = By.xpath("//android.widget.EditText[2]");
    private final By forgotPasswordButton = By.xpath("//android.widget.Button[@content-desc='Forget Password']");
    private final By submitButton = By.xpath("//android.view.View[@content-desc='Submit']");
    private final By createAccountButton = By.xpath("//android.widget.Button[@content-desc='Create Account']");

    @Test(priority = 1)
    public void clickLogin() {
        click(loginButton);
        System.out.println("Clicked on login button");
    }

    @Test(priority = 2)
    public void enterUsername() {
        enterText(usernameField, "mark@admin.com");
    }

    @Test(priority = 3)
    public void enterPassword() {
        enterText(passwordField, "mark");
        click(loginButton);
    }

    @Test(priority = 4)
    public void forgotPassword() {
        click(forgotPasswordButton);
        enterText(usernameField, "test@gmail.com");
        click(submitButton);
    }

    @Test(priority = 5)
    public void createAccount() {
        click(createAccountButton);
        enterText(usernameField, "testusername");
        enterText(passwordField, "testpassword");
        enterText(passwordField, "testpassword");
        click(loginButton);
    }
}
