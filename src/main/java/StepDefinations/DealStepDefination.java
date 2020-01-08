package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealStepDefination {

	WebDriver driver;
	String userN = "", pwde = "", browser = "";
	WebDriverWait wait ;

	public DealStepDefination() {
		System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
	}

	@Given("^user already Login page for Deals$")
	public void user_is_already_login_page() {

		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@When("^Title of login Page is Free CRM for Deals$")
	public void title_of_login_Page_is_Free_CRM_for_Deals() {

		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^user Enters User Name and Password for Deals$")
	public void user_Enters_User_Name_and_Password_for_Deals(DataTable Credentials)  {
		
		List<List<String>> data= Credentials.raw();
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys(data.get(0).get(0));
		password.sendKeys(data.get(0).get(1));
	}

	@Then("^user Clicks on Login Button for Deals$")
	public void user_Clicks_on_Login_Button_for_Deals() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}

	@Then("^user is on Home page for Deals$")
	public void user_is_on_Home_page_for_Deals()  {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
	}

	@Then("^Click on Deals Button for Deals$")
	public void click_on_Deals_Button_for_Deals() {
		
		driver.switchTo().frame("mainpanel");
		Actions action=new Actions(driver);
		WebElement delsbtn=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]"));
		action.moveToElement(delsbtn).build().perform();
		WebElement newdeal=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(newdeal));
		action.moveToElement(newdeal).click().build().perform(); //newdeal.click();
		
	}

	@Then("^Provide details for Deals Page for Deals$")
	public void provide_details_for_Deals_Page_for_Deals(DataTable data)  {
	
		
		try
		{
			WebElement title=driver.findElement(By.xpath("//*[@id=\"title\"]"));
			WebElement probability=driver.findElement(By.xpath("//*[@id=\"probability\"]"));
			WebElement amount=driver.findElement(By.xpath("//*[@id=\"amount\"]"));
			WebElement commision=driver.findElement(By.xpath("//*[@id=\"commission\"]"));
			WebElement savebtn=driver.findElement(By.xpath("//*[@id=\"prospectForm\"]/table/tbody/tr[1]/td/input[1]"));
			List<List<String>> dealsdata=data.raw();
			title.sendKeys(dealsdata.get(0).get(0));
			probability.sendKeys(dealsdata.get(0).get(1));
			amount.sendKeys(dealsdata.get(0).get(2));
			commision.sendKeys(dealsdata.get(0).get(3));
			savebtn.click();
 			
		}
		catch(Exception e)
		{
			System.out.println("Error Message \n" +e.getMessage());
		}
	}

}
