package stepdefs;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDef {
	List<String> addedProducts;
	WebDriver driver = Hooks.driver;

	@When("I click add to cart for product {string}")
	public void i_click_add_to_cart_for_product(String string) throws InterruptedException {
		String xpath_toadd = "//div[@class='inventory_item_name' and text()='placeholder']/following::button[1]";
		String dynamic_xpath_toadd = xpath_toadd.replaceAll("placeholder", string);

		WebElement shopping_cart = driver.findElement(By.xpath(dynamic_xpath_toadd));
		shopping_cart.click();
	}

	@When("I click view cart to check product added")
	public void i_click_view_cart_to_check_product_added() {
		// Write code here that turns the phrase above into concrete actions
		WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		cart.click();
	}

	@Then("I should be able to see the product as {string}")
	public void i_should_be_able_to_see_the_product_as(String Expproduct) throws InterruptedException {
		WebElement productTitleOnCartPage = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		String actualProductName = productTitleOnCartPage.getText();
		Thread.sleep(2000);
		System.out.println("actualProductName  : " + actualProductName);
		String expectedProductName = "Sauce Labs Backpack";
		Assert.assertEquals(actualProductName, expectedProductName);
	}

}