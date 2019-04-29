package VehicleLookup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class VehicleLookupClass {

	public static WebDriver driver;

@Given("^user launches the dealer portal$")
public void user_launches_the_dealer_portal() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://covercheck.vwfsinsuranceportal.co.uk/");
}

@When("^user performs Vehicle lookup for \"([^\"]*)\"$")
public void user_performs_Vehicle_lookup_for(String arg1) throws Throwable {
	
	driver.findElement(By.xpath("//input[@id='vehicleReg']")).click();
	driver.findElement(By.xpath("//input[@id='vehicleReg']")).sendKeys(arg1);
	driver.findElement(By.xpath("//span[text()='Find vehicle']")).click();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
}


@Then("^results for \"([^\"]*)\" should be displayed$")
public void results_for_should_be_displayed(String arg1) throws Throwable {
	String result;
	try {
	if (driver.findElement(By.xpath("//div[text()='Result for : "+arg1+"']")).isDisplayed() == true)
	{
		result = "Pass";
		System.out.println("      Test Result: valid Vehicle Registraiton Number");
	}
	
	} catch(Exception e) {
		System.out.println("      Test Result:please check Vehicle Registraiton Number");
	}
	driver.quit();
}

}
