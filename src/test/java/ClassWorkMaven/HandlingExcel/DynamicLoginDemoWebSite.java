package ClassWorkMaven.HandlingExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicLoginDemoWebSite {

	public String login(String userName, String password) throws InterruptedException {

		// Driver set-up
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// launching URL

		System.out.println("\n*************Program using Maven Tool***********");
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		System.out.println("Demo Web Shop URL opened!");

		// Login to the site
		WebElement Loginlink = driver.findElement(By.xpath("//a[.='Log in']"));
		Loginlink.click();
		System.out.println("Login Link is clicked!");

		// Entering the email id
		WebElement emailIDText = driver.findElement(By.name("Email"));
		emailIDText.sendKeys(userName);
		System.out.println("Email ID is entered!");

		// Entering Password
		WebElement passwordText = driver.findElement(By.name("Password"));
		passwordText.sendKeys(password);
		System.out.println("Password ID is entered!");

		// Clicking on Login button
		WebElement loginButton = driver.findElement(By.cssSelector(".button-1.login-button"));
		loginButton.click();
		System.out.println("Login button is clicked!");

		// Getting Text value
		Thread.sleep(4000);
		WebElement getText = driver.findElement(By.className("account"));

		String inputgettextvalue = getText.getText();
		System.out.println("Getting value is " + inputgettextvalue);

		//Comparing the values
		if (inputgettextvalue.equals(userName)) {
			System.out.println(userName + " is logged in successfully.");

			// logout
			WebElement Logout = driver.findElement(By.xpath("//a[.='Log out']"));
			Logout.click();
			System.out.println("Logout button is clicked!");

			// Browser Closing
			Thread.sleep(4000);
			driver.quit();
			System.out.println("Browser Closed!");
			System.out.println("*****************Vaild End of Program!***************");
			return "Vaild User";

		} else {
			// Browser Closing
			Thread.sleep(4000);
			driver.quit();
			System.out.println("*****************Invaild End of Program!***************");
			return "Invaild User";

		}

	}

	private void excelHandingmethod(String filepath, String workBookName, String sheetname)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// create object for a file
		File login = new File(filepath + workBookName);
		System.out.println(login);

		// Creating an object of FileInputStream
		FileInputStream fileInput = new FileInputStream(login);
		Workbook readBook = null;

		// Creating an object for XSSFworkbook class
		readBook = new XSSFWorkbook(fileInput);

		// Creating an object for Sheet;
		Sheet sheet1 = readBook.getSheet(sheetname);

		// Identifing the total number of rows
		int rowCount = sheet1.getLastRowNum() - sheet1.getFirstRowNum();

		System.out.println("Total Number of Rows in sheet " + rowCount);

		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet1.getRow(i);
			String userName = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username is " + userName);
			String password = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password is " + password);
			String result = login(userName, password);
			System.out.println("Result is " + result);
			sheet1.getRow(i).createCell(2).setCellValue(result);

		}
		fileInput.close();

		FileOutputStream fileOutput = new FileOutputStream(login);
		readBook.write(fileOutput);
		readBook.close();
		fileOutput.close();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		DynamicLoginDemoWebSite objLogin = new DynamicLoginDemoWebSite();

		String Filepath = "D:\\Madesh\\Sample Excels\\";

		System.out.println("\n************Excel Handing ************");
		objLogin.excelHandingmethod(Filepath, "Loginusers.xlsx", "Sheet1");

	}

}
