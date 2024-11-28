package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import AppiumDemo.Locators;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AndroidDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static File file;

	@BeforeSuite
	public static void initialiseExtentReport() {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MMM-yy & HH-mm-ss");
		String NewDate = d.format(date);

		report = new ExtentReports();

		file = new File("C:\\Users\\Shubham.Natkar\\git\\Appium\\Reports\\" + NewDate + " report" + ".html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config = sparkreporter.config();
		config.setTheme(Theme.STANDARD);
		config.setReportName("Extent Report");
		config.setDocumentTitle("Appium");

		report.attachReporter(sparkreporter);
	}

	@BeforeTest
	public static void setup() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// SAMSUNG
		capabilities.setCapability("deviceName", "samsung SM-M045F");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("udid", "R9ZTC08ZM7V");
		capabilities.setCapability("platformVersion", "14");

		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("fullReset", false);
//		capabilities.setCapability("autoLaunch", true);

		// OPPO
//		capabilities.setCapability("deviceName", "OPPO A16");
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("automationName", "UIAutomator2");
//		capabilities.setCapability("udid", "D6W4ZD5TK77SAUN7");

		// For TRAVOG APP
//		capabilities.setCapability("appPackage", "in.quadlabs.travog");
//		capabilities.setCapability("appActivity", "in.quadlabs.travog.MainActivity");
//		capabilities.setCapability("noReset", false);
//		capabilities.setCapability("autoLaunch", true);

		// For SAUDIA APP
		capabilities.setCapability("appPackage", "com.quadlabs.saudia_dev");
		capabilities.setCapability("appActivity", "com.quadlabs.saudia_dev.MainActivity");
//		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("fullReset", true);
//		capabilities.setCapability("autoLaunch", true);

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		driver = new AndroidDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Start Test");
	}

	public static String captureScreenshot(String text) throws IOException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yy & HH-mm-ss");
		String NewDate = d.format(date);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\Shubham.Natkar\\git\\Appium\\Screenshot\\" + NewDate + " " + text + ".jpg");
		FileUtils.copyFile(Source, Dest);
		return Dest.getAbsolutePath();
	}

	public static void extentScreenshot(String txt) throws IOException, InterruptedException {
		Thread.sleep(3000);
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(txt), txt).build());
		Thread.sleep(2000);
	}

	@AfterTest
	public static void tearDown() {
//		driver.terminateApp("com.quadlabs.saudia_dev");
		System.out.println("End Test");
		driver.quit();
	}

	@AfterSuite
	public static void flush() {
		test.getExtent().flush();
	}

	public static void ClickOnElement(By a) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.elementToBeClickable(a));
		driver.findElement(a).click();
	}

	public static void Clear(By a) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.visibilityOfElementLocated(a));
		driver.findElement(a).clear();
	}

	public static void SendKeys(By a, String b) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.visibilityOfElementLocated(a));
		driver.findElement(a).sendKeys(b);
	}

	public static void ClearAndSend(By a, String b) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.visibilityOfElementLocated(a));
		driver.findElement(a).clear();
		driver.findElement(a).sendKeys(b);
	}

	public static void ExplicitWait(int a, By b) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(a));
		wb.until(ExpectedConditions.elementToBeClickable(b));
	}

	public static void back() {
		driver.navigate().back();
	}

	public static List<WebElement> listofautosuggestion(By a, By suggestiontxt, String txt, String city_name)
			throws InterruptedException {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.elementToBeClickable(a));
		driver.findElement(a).click();
		WebDriverWait wb1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb1.until(ExpectedConditions.visibilityOfElementLocated(a));
		driver.findElement(a).sendKeys(txt);
		Thread.sleep(3000);
		ArrayList<WebElement> autosuggestions = (ArrayList<WebElement>) driver.findElements(suggestiontxt);
		for (WebElement autosuggestion : autosuggestions) {
			System.out.println(autosuggestion.getAttribute("content-desc"));
//			System.out.println(autosuggestion.getAttribute(suggestiontxt));
//			System.out.println(autosuggestion.getText());
			if (autosuggestion.getAttribute("content-desc").equalsIgnoreCase(city_name)) {
				autosuggestion.click();
				break;
			}
		}
		return autosuggestions;
	}

	public static List<WebElement> dropDown(By a, By suggestiontxt, String city_name) throws InterruptedException {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.elementToBeClickable(a));
		driver.findElement(a).click();
		Thread.sleep(3000);
		ArrayList<WebElement> autosuggestions = (ArrayList<WebElement>) driver.findElements(suggestiontxt);
		for (WebElement autosuggestion : autosuggestions) {
			System.out.println(autosuggestion.getAttribute("content-desc"));
			if (autosuggestion.getAttribute("content-desc").equalsIgnoreCase(city_name)) {
				autosuggestion.click();
				break;
			}
		}
		return autosuggestions;
	}

	public static void scrollPage(int value) {
		JavascriptExecutor mo = (JavascriptExecutor) driver;
		mo.executeScript("window.scrollBy(0," + value + ")");
	}

	public static void scrollPage(String elementName) {
//		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wb.until(ExpectedConditions.elementToBeClickable(a));
//		driver.findElement(
//				new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
//						+ ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + a + "\").instance(0))"))
//				.click();
		driver.findElement(
				new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector()" + ".description(\"" + elementName + "\").instance(0))"));
	}

	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}
		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
		}

		WebElement monthYearSelect = driver
				.findElement(By.xpath("(//android.view.View[@index='0']/android.view.View)[4]"));

		String monthYear = monthYearSelect.getAttribute("content-desc");
		System.out.println(monthYear);
		String SelectDate[] = monthYear.split(",");
		System.out.println(SelectDate[1]);
		String Date1[] = SelectDate[1].split(" ");
		System.out.println(Date1[2]);
		System.out.println(Date1[3]);
		String month = Date1[2];
		String year = Date1[3];

//		(//android.view.View[@index='0']/android.view.View)[9]/android.view.View

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();

				monthYear = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			List<WebElement> allDates = driver
					.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
			for (WebElement ele : allDates) {
				String dt = ele.getText();
				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			Thread.sleep(2000);

			String monthYear1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				test.log(Status.FAIL,
						"<b><i>Invalid Return date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
					monthYear1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}
				List<WebElement> allDates1 = driver
						.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();
					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}

	public static void CalenderForReport(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException {

		WebElement monthYearSelect = driver
				.findElement(By.xpath("(//android.view.View[@index='0']/android.view.View)[4]"));
		String monthYear = monthYearSelect.getAttribute("content-desc");
		System.out.println(monthYear);
		String SelectDate[] = monthYear.split(",");
		System.out.println(SelectDate[1]);
		String Date1[] = SelectDate[1].split(" ");
		System.out.println(Date1[2]);
		String month = Date1[2];

		if (month.equalsIgnoreCase("Jan")) {
			if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Feb")) {
			if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Mar")) {
			if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Apr")) {
			if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("May")) {
			if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Jun")) {
			if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Jul")) {
			if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Aug")) {
			if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Sep")) {
			if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Oct")) {
			if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Nov")) {
			if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Dec")) {
			if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("(//android.view.View[@index='0']/android.view.View)[9]/android.view.View"));
		for (WebElement ele : allDates) {
			String ele1 = ele.getAttribute("content-desc");
			String SelectDate1[] = ele1.split(",");
			System.out.println(SelectDate1[0]);
			if (SelectDate1[0].equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
		ClickOnElement(Locators.Ok);
		ClickOnElement(Locators.Date2);

		List<WebElement> allDatess = driver
				.findElements(By.xpath("(//android.view.View[@index='0']/android.view.View)[9]/android.view.View"));
		for (WebElement elee : allDatess) {
			String elee1 = elee.getAttribute("content-desc");
			String SelectDatee1[] = elee1.split(",");
			System.out.println(SelectDatee1[0]);
			if (SelectDatee1[0].equalsIgnoreCase(Day1)) {
				elee.click();
				break;
			}
		}
		ClickOnElement(Locators.Ok);
	}

	public static void CalenderForExpences(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException {

		WebElement monthYearSelect = driver
				.findElement(By.xpath("(//android.view.View[@index='0']/android.view.View)[4]"));
		String monthYear = monthYearSelect.getAttribute("content-desc");
		System.out.println(monthYear);
		String SelectDate[] = monthYear.split(",");
		System.out.println(SelectDate[1]);
		String Date1[] = SelectDate[1].split(" ");
		System.out.println(Date1[2]);
		String month = Date1[2];

		if (month.equalsIgnoreCase("Jan")) {
			if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Feb")) {
			if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Mar")) {
			if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Apr")) {
			if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("May")) {
			if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Jun")) {
			if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Jul")) {
			if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Apr")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Aug")) {
			if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("May")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Sep")) {
			if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jun")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Oct")) {
			if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jul")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Nov")) {
			if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Aug")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Dec")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		} else if (month.equalsIgnoreCase("Dec")) {
			if (Month.equalsIgnoreCase("Nov")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Oct")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Sep")) {
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalBack);
				Thread.sleep(2000);
			}
			if (Month.equalsIgnoreCase("Jan")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Feb")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			} else if (Month.equalsIgnoreCase("Mar")) {
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
				ClickOnElement(Locators.CalNext);
				Thread.sleep(2000);
			}
		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("(//android.view.View[@index='0']/android.view.View)[9]/android.view.View"));
		for (WebElement ele : allDates) {
			String ele1 = ele.getAttribute("content-desc");
			String SelectDate1[] = ele1.split(",");
			System.out.println(SelectDate1[0]);
			if (SelectDate1[0].equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
		ClickOnElement(Locators.Ok);
		ClickOnElement(Locators.NEDate2);

		List<WebElement> allDatess = driver
				.findElements(By.xpath("(//android.view.View[@index='0']/android.view.View)[9]/android.view.View"));
		for (WebElement elee : allDatess) {
			String elee1 = elee.getAttribute("content-desc");
			String SelectDatee1[] = elee1.split(",");
			System.out.println(SelectDatee1[0]);
			if (SelectDatee1[0].equalsIgnoreCase(Day1)) {
				elee.click();
				break;
			}
		}
		ClickOnElement(Locators.Ok);
	}
}
