package app_Saudia;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.QaDataProvider;

@Listeners(Utilities.Listener.class)
public class Flight_booking extends BaseClass {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("SaudiaTest", "Sheet5");
	}

	@Test(dataProvider = "getexceldata")
	public static void travoTest(String TestCaseId, String TestScenario, String UserName, String ConfirmPassword,
			String TripType, String OCode, String Origin, String DCode, String Destination, String SDate, String EDate,
			String PassName, String PassNo, String MobNo, String EmailAdd)
			throws InterruptedException, IOException, ParseException {

		test = report.createTest(TestCaseId + "-" + TestScenario);

//		extentScreenshot("Allow tab");
//		ClickOnElement(Locators.Allow);
		Thread.sleep(5000);
		back();
		ClickOnElement(Saudia_Locators.UserName);
		ClearAndSend(Saudia_Locators.UserName, UserName);
		ClickOnElement(Saudia_Locators.LogPassoword);
		ClearAndSend(Saudia_Locators.LogPassoword, ConfirmPassword);
		back();
		extentScreenshot("Log In");
		ClickOnElement(Saudia_Locators.LogInSaudiya);
		Thread.sleep(5000);
		ClickOnElement(Saudia_Locators.FlightSearchTab);
		Thread.sleep(3000);
		if (TripType.equalsIgnoreCase("OneWay")) {
			ClickOnElement(Saudia_Locators.FOneWay);
			ClickOnElement(Saudia_Locators.FSelectOrigin);
			listofautosuggestion(Saudia_Locators.OriginTab, Saudia_Locators.OriginCities, OCode, Origin);
			ClickOnElement(Saudia_Locators.FSelectDestination);
			listofautosuggestion(Saudia_Locators.DestinationTab, Saudia_Locators.DestinationCities, DCode, Destination);
			ClickOnElement(Saudia_Locators.Date1);
			Thread.sleep(3000);
			WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
			wb.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='" + SDate + "'])[2]")));
			driver.findElement(By.xpath("(//android.view.View[@content-desc='" + SDate + "'])[2]")).click();
			ClickOnElement(Saudia_Locators.DConfirm);
			extentScreenshot("Search Page");
			ClickOnElement(Saudia_Locators.SearchFlight);
			Thread.sleep(5000);
			extentScreenshot("Result Page");
			ClickOnElement(Saudia_Locators.FlightDetails);
			extentScreenshot("Flight Details");
			back();
			ClickOnElement(Saudia_Locators.OWSelectflight);
			ClickOnElement(Saudia_Locators.OWMoreDetails);
			extentScreenshot("More Details");
			ClickOnElement(Saudia_Locators.OWSelectFare);
			ClickOnElement(Saudia_Locators.OWFareConfirm);
			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.AddPassengerTab);
			ClickOnElement(Saudia_Locators.PassengerTitle);
			ClickOnElement(Saudia_Locators.SPassTitle);
			String PassN[] = PassName.split(" ");
			String FN = PassN[0];
			String LN = PassN[1];
			ClickOnElement(Saudia_Locators.PassFN);
			SendKeys(Saudia_Locators.PassFN, FN);
			ClickOnElement(Saudia_Locators.PassLN);
			SendKeys(Saudia_Locators.PassLN, LN);
			back();
			ClickOnElement(Saudia_Locators.DateTab);
			ClickOnElement(Saudia_Locators.SDate);
			ClickOnElement(Saudia_Locators.SDateO);
			ClickOnElement(Saudia_Locators.NationalityTab);
			ClickOnElement(Saudia_Locators.SNationality);
			ClickOnElement(Saudia_Locators.NDone);
			ClickOnElement(Saudia_Locators.PassN);
			SendKeys(Saudia_Locators.PassN1, PassNo);
			back();
			ClickOnElement(Saudia_Locators.EDateTab);
			ClickOnElement(Saudia_Locators.ESDate);
			ClickOnElement(Saudia_Locators.ESDateO);
			ClickOnElement(Saudia_Locators.ENationalityTab);
			ClickOnElement(Saudia_Locators.ESNationality);
			ClickOnElement(Saudia_Locators.NDone);
			ClickOnElement(Saudia_Locators.ENationalityTab);
			ClickOnElement(Saudia_Locators.ESNationality);
			ClickOnElement(Saudia_Locators.NDone);
			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.ANDone);
			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.CountryCode);
			ClickOnElement(Saudia_Locators.SCountryCode);
			ClickOnElement(Saudia_Locators.NDone);
			ClickOnElement(Saudia_Locators.MobileNo);
			SendKeys(Saudia_Locators.MobileNo, MobNo);
			back();
			ClickOnElement(Saudia_Locators.Email);
			SendKeys(Saudia_Locators.Email, EmailAdd);
			back();
			ClickOnElement(Saudia_Locators.SkipToPayment);
			Thread.sleep(5000);
//			String DateSelection[] = StartDate.split("-");
//			String year = DateSelection[2];
//			String month = DateSelection[1];
//			String expDate = DateSelection[0];
//			String DateSelection1[] = EndDate.split("-");
//			String year1 = DateSelection1[2];
//			String month1 = DateSelection1[1];
//			String expDate1 = DateSelection1[0];
//			CalenderForReport(expDate, month, year, expDate1, month1, year1);

//			ClickOnElement(Saudia_Locators.Calendar);

		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			ClickOnElement(Saudia_Locators.FRoundTrip);
			ClickOnElement(Saudia_Locators.FSelectOrigin);
			listofautosuggestion(Saudia_Locators.OriginTab, Saudia_Locators.OriginCities, OCode, Origin);
			ClickOnElement(Saudia_Locators.FSelectDestination);
			listofautosuggestion(Saudia_Locators.DestinationTab, Saudia_Locators.DestinationCities, DCode, Destination);
			ClickOnElement(Saudia_Locators.Date1);
			Thread.sleep(3000);
			WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
			wb.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='" + SDate + "'])[2]")));
			driver.findElement(By.xpath("(//android.view.View[@content-desc='" + SDate + "'])[2]")).click();
			WebDriverWait wb1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wb1.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='" + EDate + "'])[2]")));
			driver.findElement(By.xpath("(//android.view.View[@content-desc='" + EDate + "'])[2]")).click();
			Thread.sleep(3000);
			ClickOnElement(Saudia_Locators.DConfirm);
			extentScreenshot("Search Page");
			ClickOnElement(Saudia_Locators.SearchFlight);
			Thread.sleep(5000);
			extentScreenshot("Result Page");
			ClickOnElement(Saudia_Locators.FlightDetails);
			extentScreenshot("Flight Details");
			back();
			ClickOnElement(Saudia_Locators.OWSelectflight);
			ClickOnElement(Saudia_Locators.OWMoreDetails);
			extentScreenshot("More Details");
			ClickOnElement(Saudia_Locators.OWSelectFare);
			ClickOnElement(Saudia_Locators.OWFareConfirm);
			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.OWSelectflight);
			ClickOnElement(Saudia_Locators.OWMoreDetails);
			extentScreenshot("More Details");
			ClickOnElement(Saudia_Locators.OWSelectFare);
			ClickOnElement(Saudia_Locators.OWFareConfirm);
			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.AddPassengerTab);
			ClickOnElement(Saudia_Locators.PassengerTitle);
			ClickOnElement(Saudia_Locators.SPassTitle);
			String PassN[] = PassName.split(" ");
			String FN = PassN[0];
			String LN = PassN[1];
			ClickOnElement(Saudia_Locators.PassFN);
			SendKeys(Saudia_Locators.PassFN, FN);
			ClickOnElement(Saudia_Locators.PassLN);
			SendKeys(Saudia_Locators.PassLN, LN);
			back();
			ClickOnElement(Saudia_Locators.DateTab);
			ClickOnElement(Saudia_Locators.SDate);
			ClickOnElement(Saudia_Locators.SDateO);
//			ClickOnElement(Saudia_Locators.NationalityTab);
//			ClickOnElement(Saudia_Locators.SNationality);
//			ClickOnElement(Saudia_Locators.NDone);
//			ClickOnElement(Saudia_Locators.PassN);
//			SendKeys(Saudia_Locators.PassN1, PassNo);
//			back();
//			ClickOnElement(Saudia_Locators.EDateTab);
//			ClickOnElement(Saudia_Locators.ESDate);
//			ClickOnElement(Saudia_Locators.ESDateO);
//			ClickOnElement(Saudia_Locators.ENationalityTab);
//			ClickOnElement(Saudia_Locators.ESNationality);
//			ClickOnElement(Saudia_Locators.NDone);
//			ClickOnElement(Saudia_Locators.ENationalityTab);
//			ClickOnElement(Saudia_Locators.ESNationality);
//			ClickOnElement(Saudia_Locators.NDone);
//			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.ANDone);
			Thread.sleep(5000);
			ClickOnElement(Saudia_Locators.CountryCode);
			ClickOnElement(Saudia_Locators.SCountryCode);
			ClickOnElement(Saudia_Locators.NDone);
			ClickOnElement(Saudia_Locators.MobileNo);
			SendKeys(Saudia_Locators.MobileNo, MobNo);
			back();
			ClickOnElement(Saudia_Locators.Email);
			SendKeys(Saudia_Locators.Email, EmailAdd);
			back();
			ClickOnElement(Saudia_Locators.SkipToPayment);
			Thread.sleep(5000);
			driver.terminateApp("com.quadlabs.saudia_dev");
		}
	}
}
