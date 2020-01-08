package StepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Maps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealsMapStepDefination {

	WebDriver driver;
	String userN = "", pwde = "", browser = "";
	WebDriverWait wait;

	public DealsMapStepDefination() {
		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
	}

	@Given("^user already Login page for Dealsmap$")
	public void user_is_already_login_page() {

		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@When("^Title of login Page is Free CRM for Dealsmap$")
	public void title_of_login_Page_is_Free_CRM_for_Deals() {

		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@SuppressWarnings("unchecked")
	@Then("^user Enters User Name and Password for Dealsmap$")
	public void user_Enters_User_Name_and_Password_for_Deals(DataTable Credentials) {

		for (Map<String, String> data : Credentials.asMaps(String.class, String.class)) {
			// List<List<String>> data=Credentials.raw();
			WebElement username = driver.findElement(By.name("username"));
			WebElement password = driver.findElement(By.name("password"));
			/*
			 * username.sendKeys(data.get(0).get(0)); password.sendKeys(data.get(0).get(1));
			 */
			username.sendKeys(data.get("user"));
			password.sendKeys(data.get("pwd"));
		}
	}

	@Then("^user Clicks on Login Button for Dealsmap$")
	public void user_Clicks_on_Login_Button_for_Deals() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}

	@Then("^user is on Home page for Dealsmap$")
	public void user_is_on_Home_page_for_Deals() {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
	}

	@Then("^Click on Deals Button for Dealsmap$")
	public void click_on_Deals_Button_for_Deals() {

		driver.switchTo().frame("mainpanel");
		clickonNewDealsPage();
		/*
		 * Actions action=new Actions(driver); WebElement
		 * delsbtn=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]"));
		 * action.moveToElement(delsbtn).build().perform(); WebElement
		 * newdeal=driver.findElement(By.xpath(
		 * "//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a"));
		 * wait.until(ExpectedConditions.elementToBeClickable(newdeal));
		 * action.moveToElement(newdeal).click().build().perform()
		 */; // newdeal.click();

	}

	@Then("^Provide details for Deals Page for Dealsmap$")
	public void provide_details_for_Deals_Page_for_Deals(DataTable data) {

		try {
			for (Map<String, String> dealsdata : data.asMaps(String.class, String.class)) {
				WebElement title = driver.findElement(By.xpath("//*[@id=\"title\"]"));
				WebElement probability = driver.findElement(By.xpath("//*[@id=\"probability\"]"));
				WebElement amount = driver.findElement(By.xpath("//*[@id=\"amount\"]"));
				WebElement commision = driver.findElement(By.xpath("//*[@id=\"commission\"]"));
				WebElement savebtn = driver
						.findElement(By.xpath("//*[@id=\"prospectForm\"]/table/tbody/tr[1]/td/input[1]"));

				title.sendKeys(dealsdata.get("DealsTitle"));
				probability.sendKeys(dealsdata.get("probability"));
				amount.sendKeys(dealsdata.get("amount"));
				commision.sendKeys(dealsdata.get("commision"));
				savebtn.click();
				clickonNewDealsPage();

			}
		} catch (Exception e) {
			System.out.println("Error Message \n" + e.getMessage());
		}
	}

	public void clickonNewDealsPage() {
		Actions action = new Actions(driver);
		WebElement delsbtn = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]"));
		action.moveToElement(delsbtn).build().perform();
		WebElement newdeal = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(newdeal));
		action.moveToElement(newdeal).click().build().perform(); // newdeal.click();

	}

}
