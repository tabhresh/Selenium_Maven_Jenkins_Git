package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scenario {

	WebDriver driver;

	@Test
	public void openApp() {

		// Browser Instantiating Or Open Browser
		System.setProperty("webdriver.chrome.driver", "D:\\Training\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		// Open AUT
		driver.get("http://newtours.demoaut.com/");
		
		System.out.println("AUT opened Succesfully");
	}

	@Test(dependsOnMethods = "openApp")
	public void Login() throws InterruptedException {
		// Enter UserID
		driver.findElement(By.name("userName")).sendKeys("tutorial");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("tutorial");

		// Click on Sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		System.out.println("Logged In Successfully");

	}

	@Test(dependsOnMethods = "Login")
	public void Logout() throws InterruptedException {
		// Click on Sign off
		driver.findElement(By.linkText("SIGN-OFF")).click();
		System.out.println("Logged Off successfully");
		Thread.sleep(3000);
		driver.quit();
	}

}
