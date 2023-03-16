import io.cucumber.java.en.*;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class swagdemo {

    WebDriver driver;
//    LoginPage loginPage;LoginPage
    String baseUrl = "https://www.saucedemo.com/";
    @Given("I am on the Sauce Demo Login Page")
    public void i_am_on_the_sauce_demo_login_page() {
        System.setProperty("web-driver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @When("I fill the account information for account StandardUser into the Username field and the Password field")
    public void iFillInTheAccountInformation() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
//        loginPage.enterUserName("standard_user");
//        loginPage.enterPassword("secret_sauce");
    }
    @When("I fill the account information for account LockedOutUser into the Username field and the Password field")
    public void iFillInTheAccountInformationLockedUser() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");
    }
    @And("I click the Login Button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    @Then("I am redirected to the Sauce Demo Main Page")
    public void i_am_redirected_to_the_sauce_demo_main_page() {
        assert driver.getTitle().contains("Swag Labs");
//        or
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @And("I verify the App Logo exists")
    public void i_verify_the_app_logo_exists() {
       WebElement logo = driver.findElement(By.xpath("//div[@class='app_logo']"));
       assert logo.isDisplayed();
//          or another way
//        if (logo.isDisplayed())
//            Assert.assertTrue("Logo exists on the website", true);
//        else
//            Assert.assertTrue("Logo does not exists on the website", false);
    }
    @Then("I verify the Error Message contains the text {string}")
    public void iVerifyTheErrorMessage(String errorMessage) {
        WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assert error.getText().contains(errorMessage);
    }
    @After
    public void close() {
        driver.quit();
    }
}
