package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSauceDmoStepDef {
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String UserName) {
		WebElement userName = driver.findElement(By.xpath("//input[@name='user-name']"));
		userName.sendKeys(UserName);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String Password) {
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(Password);
	}

	@When("Click on login")
	public void click_on_login() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='login-button']"));
		loginBtn.click();
	}

	@Then("I should be able to login successfully")
	public void i_should_be_able_to_login_successfully() {
		String expected_url = "https://www.saucedemo.com/inventory.html";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(expected_url, actual_url);
	}

	@Then("I should get error message {string}")
	public void i_should_get_error_message(String ExpError) throws InterruptedException {		
		WebElement error = driver.findElement(By.xpath("//*[@data-test='error']"));
		String ActError = error.getText();
		Assert.assertEquals(ActError, ExpError);
	}
}