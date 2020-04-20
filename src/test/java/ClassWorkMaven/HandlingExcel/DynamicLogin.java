package ClassWorkMaven.HandlingExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Driver set-up
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// launching URL

		System.out.println("\n*************Program using Maven Tool***********");
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println("Amazon URL opened!");
		
		//Login
		WebElement accountListLink = driver.findElement(By.id("nav-link-accountList"));
		accountListLink.click();
		System.out.println("1");

		WebElement enterEmailText = driver.findElement(By.id("ap_email"));
		enterEmailText.sendKeys("8144405756");
		System.out.println("phone number entered");

		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		System.out.println("continue button clicked");

		WebElement enterPasswordText = driver.findElement(By.name("password"));
		enterPasswordText.sendKeys("karuppu1214");
		System.out.println("password entered");

		WebElement signInButton = driver.findElement(By.id("signInSubmit"));
		signInButton.click();
		System.out.println("Signin button clicked");


		
		
		// Browser Closing
		Thread.sleep(4000);
		driver.quit();
		System.out.println("Browser Closed!");
		System.out.println("*****************End of Program!***************");

	}

}
