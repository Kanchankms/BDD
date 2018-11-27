package login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition
{
	WebDriver driver;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable
	{
		/*if using chrome driver then apply these steps
		System.setProperty("webdriver.chrome.driver", "D:\\BDD software\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();*/

		driver = new FirefoxDriver();
		driver.get("D:\\BDD software\\BDD STS Projects\\HotelBookingDemo\\login.html");
		System.out.println("page loaded in browser");
	}

	@When("^username password is blank$")
	public void username_password_is_blank() throws Throwable
	{

		WebElement userNameTxt=driver.findElement(By.name("userName"));
		userNameTxt.sendKeys("");
		WebElement loginBtn=driver.findElement(By.className("btn"));
		loginBtn.click();

	}

	@Then("^Display Error Message 'Please enter Username'$")
	public void display_Error_Message_Please_enter_Username() throws Throwable
	{

		WebElement divEle=driver.findElement(By.id("userErrMsg"));
		String actualErrorMsg=divEle.getText();
		String expErrorMsg="* Please enter userName.";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.close();

	}


	@When("^username is given but password is blank$")
	public void username_is_given_but_password_is_blank() throws Throwable
	{
		
		WebElement userNameTxt=driver.findElement(By.name("userName"));
		
		WebElement pwdTxt=driver.findElement(By.name("userPwd"));
		
		WebElement loginBtn=driver.findElement(By.className("btn"));
		userNameTxt.sendKeys("kanchan");
		pwdTxt.sendKeys("");
		loginBtn.click();
		
	}

	@Then("^Display Error Message 'Please enter password'$")
	public void display_Error_Message_Please_enter_password() throws Throwable 
	{
	
		WebElement divEle=driver.findElement(By.id("pwdErrMsg"));
		String actualErrorMsg=divEle.getText();
		String expErrorMsg="* Please enter password.";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.close();
		
	}
	
	@When("^invalid username password is entered$")
	public void invalid_username_password_is_entered() throws Throwable
	{

		WebElement userNameTxt=driver.findElement(By.name("userName"));
		
		WebElement pwdTxt=driver.findElement(By.name("userPwd"));
		
		WebElement loginBtn=driver.findElement(By.className("btn"));
		userNameTxt.sendKeys("kanchan");
		pwdTxt.sendKeys("KanchaKu");
		loginBtn.click();
	    
	}

	@Then("^Display alert 'Invalid login'$")
	public void display_alert_Invalid_login() throws Throwable
	{
	  
		
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Invalid login! Please try again!";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();				//to accept alert box automatically
		driver.close();
	}
	
	
	@When("^valid username password is entered$")
	public void valid_username_password_is_entered() throws Throwable
	{
	   
		WebElement userNameTxt=driver.findElement(By.name("userName"));
		
		WebElement pwdTxt=driver.findElement(By.name("userPwd"));
		
		WebElement loginBtn=driver.findElement(By.className("btn"));
		userNameTxt.sendKeys("kanchan");
		pwdTxt.sendKeys("kanchan");
		loginBtn.click();
	}

	@Then("^Navigate to Hotel Booking page$")
	public void navigate_to_Hotel_Booking_page() throws Throwable
	{
	   driver.navigate().to("D:\\BDD software\\BDD STS Projects\\HotelBookingDemo\\hotelbooking.html");
	   driver.close();
	}





}
