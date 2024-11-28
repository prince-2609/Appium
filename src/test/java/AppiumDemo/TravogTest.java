package AppiumDemo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import io.appium.java_client.AppiumBy;
import Utilities.QaDataProvider;

@Listeners(Utilities.Listener.class)
public class TravogTest extends BaseClass {

	static By Allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
	static By WhileUsingApp = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	static By CompanyCode = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
	static By EmailId = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
	static By Password = By.xpath(
			"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
	static By SignIn = By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]");
	static By Flight = By.xpath("//android.widget.ImageView[@content-desc=\"Book Flight\"]");
	static By From = By.xpath("(//android.view.View[@content-desc=\"••••••\"])[1]");
	static By To = AppiumBy.xpath("(//android.view.View[@index='6'])[1]");
	static By Departure = By.xpath("//android.widget.EditText");
	static By DepartureLocation = By.xpath("(//android.view.View[@index='0'])[6]");
	static By Destination = By.xpath("//android.widget.EditText");
	static By DestinationLocation = By.xpath("(//android.view.View[@index='0'])[6]");
	static By OneWay = AppiumBy.xpath("//android.view.View[@index='9']");
	static By Calender = AppiumBy.xpath("(//android.view.View[@index='0'])[6]");
	static By CalenderNext = AppiumBy.xpath("//android.widget.Button[@index='3']");
	static By SelectDate = By.xpath("//android.widget.Button[@content-desc='15, Wednesday, May 15, 2024']");
	static By CalenderOk = By.xpath("//android.widget.Button[@content-desc='OK']");
	static By SearchFlight = By.xpath("//android.widget.Button[@content-desc='Search Flights']");
	static By SelectFlight = By.xpath("(//android.view.View[@index='0'])[8]");
	static By ProceedToBook = By.xpath("//android.view.View[@content-desc='Proceed to book']");

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("FlightBooking", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void travoTest(String TestCaseId, String TestScenario) throws InterruptedException, IOException {

		test = report.createTest(TestCaseId + "-" + TestScenario);

		extentScreenshot("Allow tab");
		ClickOnElement(Allow);
//		driver.findElement(Allow).click();

		extentScreenshot("While using app tab");
		driver.findElement(WhileUsingApp).click();

		driver.findElement(CompanyCode).click();
		driver.findElement(CompanyCode).clear();
		Thread.sleep(2000);
		driver.findElement(CompanyCode).sendKeys("AT");

		driver.findElement(EmailId).click();
		driver.findElement(EmailId).clear();
		Thread.sleep(2000);
		driver.findElement(EmailId).sendKeys("Anubhavanand");

		driver.findElement(Password).click();
		driver.findElement(Password).clear();
		Thread.sleep(2000);
		driver.findElement(Password).sendKeys("Q0JXVAUBCE8PSB9");
		extentScreenshot("Sign In Page");
		driver.findElement(SignIn).click();
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(50));
		wb.until(ExpectedConditions.elementToBeClickable(Flight));
		driver.findElement(Flight).click();
		driver.findElement(From).click();
		driver.findElement(Departure).sendKeys("delhi");
		driver.findElement(DepartureLocation).click();
		driver.findElement(To).click();
		driver.findElement(Destination).sendKeys("dxb");
		driver.findElement(DestinationLocation).click();
		driver.findElement(OneWay).click();
		driver.findElement(Calender).click();
		driver.findElement(CalenderNext).click();
		driver.findElement(SelectDate).click();
		driver.findElement(CalenderOk).click();
		extentScreenshot("Search Page");
		driver.findElement(SearchFlight).click();
		WebDriverWait wb1 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wb1.until(ExpectedConditions.elementToBeClickable(SelectFlight));
		extentScreenshot("Result Page");
		driver.findElement(SelectFlight).click();
		Thread.sleep(3000);
		extentScreenshot("Proceed To Book");
		driver.findElement(ProceedToBook).click();
		Thread.sleep(30000);
		extentScreenshot("Checkout Page");
		
		
		
		
		
		
		
	}
}
