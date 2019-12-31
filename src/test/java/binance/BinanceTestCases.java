package binance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommenUsedMethods.CommenMethods;

public class BinanceTestCases {
	private static WebDriver driver;
	static Logger lg = Logger.getLogger(binance.BinanceTestCases.class.getName());
	String baseUrl = "";
	CommenMethods CM = new CommenMethods(driver, baseUrl);
	static Date currentDate = new Date();
	static long time = currentDate.getTime();
	String PreviouslyUsedEmail = time + "@email.com";

	@BeforeTest
	public void setUp() throws Exception {
		CommenMethods CM = new CommenMethods(driver, baseUrl);
		CM.setDrivers();
		driver = CM.setUpDriversWebDrivers();
		System.out.println("CM.baseUrl" + CM.baseUrl);
		baseUrl = CM.baseUrl;
		driver.get(baseUrl);
		// wait for view more market to load
		CM.wait("//a[contains(text(),'View more markets')]", "view more market", driver);
		

	}
 
//first end-to-end test test case
	@Test(priority = 0)
	public void firstEndToEnd() throws InterruptedException {
		//clicking view more market
		CM.click("//a[contains(text(),'View more markets')]", "view more market", driver);
		//waiting for ETH/BTC
		CM.wait("//strong[contains(text(),'ETH')]", "ETH/BTC", driver);
		//click on ETH/BTC
		CM.click("//strong[contains(text(),'ETH')]", "ETH/BTC", driver);
		//waiting chart 
		CM.wait("//div[@class='sc-1t2bpae-0 OXkQZ']", "chart view", driver);
		//asserting values in page 
		CM.Verify("//li[contains(text(),'Original')]", driver.findElement(By.xpath("//li[contains(text(),'Original')]")).getText(), "chart Header", driver);
		CM.Verify("//a/span[contains(text(),'Exchange')]", driver.findElement(By.xpath("//a/span[contains(text(),'Exchange')]")).getText(), "Exchange Header", driver);
		CM.Verify("//div/span[contains(text(),'Total(BTC)')]", driver.findElement(By.xpath("//div/span[contains(text(),'Total(BTC)')]")).getText(), "price  Header", driver);
		}
//Second end-to-end test test case
	@Test(priority = 1)
	public void SecondEndToEnd() throws InterruptedException {
		//waiting for price text field 
		CM.wait("//div/input[@id='FormRow-BUY-price']", "price", driver);
		//click and send keys in price text field
		CM.click("(//div[@class='sc-62mpio-0 sc-1c2873k-0 kadOVc']/div[@class='sc-62mpio-0 sc-1c2873k-4 jclRvn'])[1]", "price", driver);
		driver.findElement(By.xpath("//div/input[@id='FormRow-BUY-price']")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "10");
		//waiting for amount text field
		CM.wait("//div/input[@id='FormRow-BUY-quantity']", "amount", driver);
		//click and send keys in price text field
		CM.click("//div/input[@id='FormRow-BUY-quantity']", "amount", driver);
		driver.findElement(By.xpath("//div/input[@id='FormRow-BUY-quantity']")).clear();
		driver.findElement(By.xpath("//div/input[@id='FormRow-BUY-quantity']")).sendKeys("10");
		//waiting for total
		CM.wait("//div/input[@id='FormRow-BUY-total']", "total", driver);
		//asserting values in in total is multiplication 
		System.out.println("value is : " + driver.findElement(By.xpath("//div/input[@id='FormRow-BUY-total']")).getAttribute("value"));
		assertEquals("100.00000000",driver.findElement(By.xpath("//div/input[@id='FormRow-BUY-total']")).getAttribute("value"));
		}

	
		
	

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
