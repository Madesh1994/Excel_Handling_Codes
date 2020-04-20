package ClassWorkMaven.HandlingExcel;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MSHandling {

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

		
		// Browser Closing
		Thread.sleep(4000);
		driver.quit();
		System.out.println("Browser Closed!");
		System.out.println("*****************End of Program!***************");
		

	}

}
