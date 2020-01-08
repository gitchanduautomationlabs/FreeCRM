package StepDefinations;

import static org.testng.Assert.assertEquals;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitionFile1 {
	WebDriver driver;
	String userN="",pwde="";
	// with out Examples Keyword  with Scenario
	/*@When("^user is on login Page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Test\\\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@Then("^Tile is Free CRM$")
	public void title_of_Free_Crm() {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^provide \"(.*)\" and \"(.*)\"$")
	public void login_authentication(String user, String pwd) {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys(user);
		password.sendKeys(pwd);
	}

	@Then("^Click on Login Button$")
	public void click_on_login_button() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		loginbtn.click();
	}

	@And("^User On Home Page$")
	public void user_on_home_page() {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
		assertEquals(title, "CRMPRO");
	}

	@Then("^Close the Browser \"(.*)\"$")
	public void Tear_the_Browser(String yesNo) {
		if(yesNo.equalsIgnoreCase("Yes"))
		driver.close();
		else
		System.out.println("No can't close the borwser refer steps in scenario in feature file");
	}*/
	
	
	// with  Examples Keyword with Scenario Outline 
	@When("^user is on login Page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@Then("^Tile is Free CRM$")
	public void title_of_Free_Crm() {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	
	@Then("^provide \"(.*)\" and \"(.*)\"$")
	public void login_authentication(String user, String pwd) {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		userN=user; pwde=pwd;
		username.sendKeys(user);
		password.sendKeys(pwd);
	}

	@Then("^Click on Login Button$")
	public void click_on_login_button() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		loginbtn.click();
	}

	@And("^User On Home Page and \"(.*)\"$")
	public void user_on_home_page(String browsercloseornot) {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
		if(browsercloseornot.equalsIgnoreCase("Yes"))			
		assertEquals(title, "CRMPRO");
		else
			System.out.println("Login Failed with these credentials " +userN + "and "+ pwde);
	}

	@Then("^Close the Browser \"(.*)\"$")
	public void Tear_the_Browser(String yesNo) {
		if(yesNo.equalsIgnoreCase("Yes"))
		driver.close();
		else
		System.out.println("No can't close the borwser refer steps in scenario in feature file");
	}

}
