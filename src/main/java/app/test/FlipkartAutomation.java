package app.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FlipkartAutomation {
	WebDriver driver;

	@Test(groups = "Chrome")
	public void LaunchChrome() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Kavya Vallepu\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	@Test(groups = "Chrome", dependsOnMethods = "LaunchChrome")
	public void flipkartTesting() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		System.out.println("The title of the page is :" + driver.getTitle()); 
		
		
		//Printing Load Time in seconds on console

		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the website is :- " + loadtime/1000+" Seconds");

		//Searching IPhone 13 on search bar

		driver.findElement(By.name("q")).sendKeys("iphone 13");
		Thread.sleep(5000);
		driver.findElement(By.className("_2iLD__")).click();

		WebElement i = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div/div/img"));
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		if (p) {
			System.out.println("Image is loaded");
		} else {
			System.out.println("Image not loaded");
		}
		Thread.sleep(5000);
		driver.get("https://www.flipkart.com/apple-iphone-13-midnight-128-gb/p/itmca361aab1c5b0?pid=MOBG6VF5Q82T3XRS&lid=LSTMOBG6VF5Q82T3XRSOXJLM9&marketplace=FLIPKART&q=iphone+13&store=tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=organic&iid=a2b529bf-6e47-4950-b0e3-33ca14d03be1.MOBG6VF5Q82T3XRS.SEARCH&ppt=hp&ppn=homepage&ssid=2dpx9e0d7k0000001665379065155&qH=c68a3b83214bb235\"");
		Thread.sleep(5000);
	      
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("scrollBy(0, 2500)");

		try {
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(5000);

				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 driver.close(); 
	}
	
	@Test(groups = "Firefox")
	public void LaunchFirefox() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Kavya Vallepu\\Downloads\\Firebox webdriver\\geckodriver.exe");
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(groups="Firefox", dependsOnMethods="LaunchFirefox")
	public void firefox() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		//To find the load time and print on console

		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the website is :- " + loadtime);

		//To search the given text in search bar

		driver.findElement(By.name("q")).sendKeys("iphone 13");
		driver.findElement(By.className("_2iLD__")).click();

		WebElement i = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div/div/img"));
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		if (p) {
			System.out.println("Image is loaded");
		} else {
			System.out.println("Image not loaded");
		}
		
		driver.get("https://www.flipkart.com/apple-iphone-13-midnight-128-gb/p/itmca361aab1c5b0?pid=MOBG6VF5Q82T3XRS&lid=LSTMOBG6VF5Q82T3XRSOXJLM9&marketplace=FLIPKART&q=iphone+13&store=tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=organic&iid=a2b529bf-6e47-4950-b0e3-33ca14d03be1.MOBG6VF5Q82T3XRS.SEARCH&ppt=hp&ppn=homepage&ssid=2dpx9e0d7k0000001665379065155&qH=c68a3b83214bb235\"");
		Thread.sleep(5000);
	      
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("scrollBy(0, 2500)");
		try {
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}