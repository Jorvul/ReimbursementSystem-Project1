package com.jorge.selenium.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	
	public static WebDriver driver;
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\revature\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.get("http://localhost:8080/Login.html");
        //driver.get("https://www.mlb.com");
        // Maximizing window
        driver.manage().window().fullscreen();
		
		//System.err.println("Given ::: User is on Home Page");
	    //System.out.println("1");
	}
	
	
	@When("User Navigate to LogIn Page")
	public void user_navigate_to_log_in_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //System.out.println("2");
		System.out.println("Title of the page is " + driver.getTitle());
	}
	
	@When("User enters username and password")
	public void user_enters_user_name_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    System.err.println("When::: User enters username and password");
		WebElement uname = driver.findElement(By.cssSelector("#username"));
		WebElement password = driver.findElement(By.cssSelector("#password"));
		WebElement loginButton = driver.findElement(By.tagName("button"));
		uname.sendKeys("Thor123");
		password.sendKeys("dawgsss3350?");
		loginButton.click();
		
	
		
	}
//	@Then("Message displayed Login Successfully")
//	public void message_displayed_login_successfully() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //System.err.println("Then::: Message displayed Login Successfully");
//		System.out.println("Login Successful");
//		driver.quit();
//	}
	
}
