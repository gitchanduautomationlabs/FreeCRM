package StepDefinations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination {
	WebDriver driver;

	@Given("^user already Login page$")
	public void user_alreay_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@When("^Title of login Page is Free CRM$")
	public void title_of_login_page_of_FRE_CRM() {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^user Enters User Name and Password$")
	public void user_enters_user_name_and_password() {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys("naveenk");
		password.sendKeys("test123");
	}

	@Then("^user Clicks on Login Button$")
	public void user_clicks_on_login_btn() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		loginbtn.click();
	}

	@And("^user is on Home page$")
	public void user_on_home_page() {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
		assertEquals(title, "CRMPRO");
	}
	/*
	 * @Then("^Close the Browser$") public void Tear_the_Browser() { driver.close();
	 * }
	 */

	/*
	 
Scenario: Free CRM Login Test Scenario2

When After Land on Home Page
Then  Click on logot Page
Then verify login Page title
Then Close the Browser

	 @When("^After Land on Home Page$")
	public void after_land_home_page() {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^Click on logot Page$")
	public void click_on_logout_page() {
		WebElement logoutLink = driver
				.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a"));
		logoutLink.click();
	}

	@Then("^verify login Page title$")
	public void verify_login_page_title_after_logout() {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^Close the Browser$")
	public void Tear_the_Browser() {
		driver.close();

	}*/
}
