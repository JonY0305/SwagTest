import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By password = By.id("password");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String user) {
        driver.findElement(usernameField).sendKeys(user);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
}