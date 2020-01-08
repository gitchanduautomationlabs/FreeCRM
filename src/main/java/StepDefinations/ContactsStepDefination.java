package StepDefinations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactsStepDefination {

	WebDriver driver;
	
	String userN = "", pwde = "", browser = "";
	WebDriverWait wait ;
	
	public ContactsStepDefination() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
	}

	@When("^user is on login Page for new Contact$")
	public void user_is_on_login_Page_for_new_Contact() throws Throwable {
		
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@Then("^Tile is Free CRM for new Contact$")
	public void tile_is_Free_CRM_for_new_Contact()  {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^provide \"([^\"]*)\" and \"([^\"]*)\" for new Contact$")
	public void provide_and_for_new_Contact(String user, String pwd)   {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		userN = user;
		pwde = pwd;
		username.sendKeys(user);
		password.sendKeys(pwd);
	}

	@Then("^Click on Login Button for new Contact$")
	public void click_on_Login_Button_for_new_Contact() throws Throwable {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		wait =new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));	
		loginbtn.click();
	}

	@Then("^User On Home Page and \"([^\"]*)\" for new Contact$")
	public void user_On_Home_Page_and_for_new_Contact(String browsercloseornot) throws Throwable {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
		browser = browsercloseornot;
		if (browsercloseornot.equalsIgnoreCase("Yes"))
			assertEquals(title, "CRMPRO");
		else
			System.out.println("Login Failed with these credentials " + userN + "and " + pwde);
	}

	@And("^User click on Contact Page$")
	public void User_Click_On_Contact_Page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
		action.moveToElement(ele).build().perform();
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a"));
		 wait =new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(contact));
		action.moveToElement(contact).click().build().perform();
	}

	/*@When("^user is on new Contact Page$")
	public void user_is_on_new_contact_page() {
System.out.println("current url   "+driver.getCurrentUrl());		
		String title = driver.getTitle();
		System.out.println("Title of Contact page " + title);
	}*/

	@Then("^Provide deatils for contact page \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void adding_new_contact(String firstName, String lastNae, String position) {

		/* driver.switchTo().frame("mainpanel"); */
		try {
			WebElement firstname = driver.findElement(By.id("first_name"));
			 wait = new WebDriverWait(driver, 50);
			 wait.until(ExpectedConditions.visibilityOf(firstname));
			
			WebElement lastname = driver.findElement(By.id("surname"));
			WebElement pos = driver.findElement(By.id("company_position"));
			WebElement save = driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]"));
			firstname.sendKeys(firstName);
			lastname.sendKeys(lastNae);
			pos.sendKeys(position);
			save.click();
		} catch (Exception e) {

			System.out.println(e.getMessage()+""+e.getStackTrace());
		}

	}
	/*
	 * @Then("^Close the Browser for new Contact$") public void
	 * close_the_Browser_for_new_Contact() throws Throwable {
	 * if(browser.equalsIgnoreCase("Yes")) driver.close(); else System.out.
	 * println("No can't close the borwser refer steps in scenario in feature file"
	 * ); }
	 */

}
