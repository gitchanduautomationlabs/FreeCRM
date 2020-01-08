package StepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class tagsStepdefination {
	WebDriver driver;
	String userN="",pwde="", browser = "";;
	WebDriverWait wait ;
	
	//******************************** #Scenario 1
	
	@When("^user is on login Page scenario1$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Test\\\\chromedriver.exe");
		driver = new ChromeDriver();// Launching Browser
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@Then("^Tile is Free CRM scenario1$")
	public void title_of_Free_Crm() {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^provide \"(.*)\" and \"(.*)\" scenario1$")
	public void login_authentication(String user, String pwd) {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys(user);
		password.sendKeys(pwd);
	}

	@Then("^Click on Login Button scenario1$")
	public void click_on_login_button() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		loginbtn.click();
	}

	@And("^User On Home Page scenario1$")
	public void user_on_home_page() {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
		assertEquals(title, "CRMPRO");
	}

	@Then("^Close the Browser \"(.*)\" scenario1$")
	public void Tear_the_Browser(String yesNo) {
		if(yesNo.equalsIgnoreCase("Yes"))
		driver.close();
		else
		System.out.println("No can't close the borwser refer steps in scenario in feature file");
	}
	

	//******************************** #Scenario 2
	
	@When("^user is on login Page for new Contact scenario2$")
	public void user_is_on_login_Page_for_new_Contact() throws Throwable {
		
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@Then("^Tile is Free CRM for new Contact scenario2$")
	public void tile_is_Free_CRM_for_new_Contact()  {
		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^provide \"([^\"]*)\" and \"([^\"]*)\" for new Contact scenario2$")
	public void provide_and_for_new_Contact(String user, String pwd)   {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		userN = user;
		pwde = pwd;
		username.sendKeys(user);
		password.sendKeys(pwd);
	}

	@Then("^Click on Login Button for new Contact scenario2$")
	public void click_on_Login_Button_for_new_Contact() throws Throwable {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		wait =new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));	
		loginbtn.click();
	}

	@Then("^User On Home Page and \"([^\"]*)\" for new Contact scenario2$")
	public void user_On_Home_Page_and_for_new_Contact(String browsercloseornot) throws Throwable {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
		browser = browsercloseornot;
		if (browsercloseornot.equalsIgnoreCase("Yes"))
			assertEquals(title, "CRMPRO");
		else
			System.out.println("Login Failed with these credentials " + userN + "and " + pwde);
	}

	@And("^User click on Contact Page scenario2$")
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

	
	@Then("^Provide deatils for contact page \"(.*)\" and \"(.*)\" and \"(.*)\" scenario2$")
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
	
//******************************** #Scenario 3	

	@Given("^user already Login page for Deals scenario3$")
	public void user_is_already_login_page() {

		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}

	@When("^Title of login Page is Free CRM for Deals scenario3$")
	public void title_of_login_Page_is_Free_CRM_for_Deals() {

		String title = driver.getTitle();
		System.out.println("Title of Free CRM is " + title);
	}

	@Then("^user Enters User Name and Password for Deals scenario3$")
	public void user_Enters_User_Name_and_Password_for_Deals(DataTable Credentials)  {
		
		List<List<String>> data= Credentials.raw();
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		username.sendKeys(data.get(0).get(0));
		password.sendKeys(data.get(0).get(1));
	}

	@Then("^user Clicks on Login Button for Deals scenario3$")
	public void user_Clicks_on_Login_Button_for_Deals() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}

	@Then("^user is on Home page for Deals scenario3$")
	public void user_is_on_Home_page_for_Deals()  {
		String title = driver.getTitle();
		System.out.println("Title of Home Page of Free CRM is " + title);
	}

	@Then("^Click on Deals Button for Deals scenario3$")
	public void click_on_Deals_Button_for_Deals() {
		
		driver.switchTo().frame("mainpanel");
		Actions action=new Actions(driver);
		WebElement delsbtn=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]"));
		action.moveToElement(delsbtn).build().perform();
		WebElement newdeal=driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(newdeal));
		action.moveToElement(newdeal).click().build().perform(); //newdeal.click();
		
	}

	@Then("^Provide details for Deals Page for Deals scenario3$")
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
