package app_Saudia;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class Saudia_Locators {

	static By UserName = AppiumBy.xpath("(//android.widget.EditText)[1]");
	static By LogPassoword = AppiumBy.xpath("(//android.widget.EditText)[2]");
	static By LogInSaudiya = AppiumBy.xpath("//android.view.View[@content-desc='Login']");
	static By FlightSearchTab = AppiumBy.xpath("(//android.view.View)[8]");
	static By FOneWay = AppiumBy.xpath("(//android.view.View)[10]");
	static By FRoundTrip = AppiumBy.xpath("(//android.view.View)[9]");
	static By FSelectOrigin = AppiumBy.xpath("(//android.view.View)[15]");
	static By FSelectDestination = AppiumBy.xpath("(//android.view.View)[17]");
	static By OriginTab = AppiumBy.xpath("//android.widget.EditText");
	static By OriginCities = AppiumBy.xpath("//android.widget.ImageView");
	static By DestinationTab = AppiumBy.xpath("//android.widget.EditText");
	static By DestinationCities = AppiumBy.xpath("//android.widget.ImageView");
	static By Date1 = AppiumBy.xpath("//android.view.View[@index='3']");
	static By DConfirm = AppiumBy.xpath("//android.view.View[@content-desc='Confirm']");
	static By SearchFlight = AppiumBy.xpath("//android.view.View[@content-desc='Search Flight']");
	static By FlightDetails = AppiumBy.xpath("//android.view.View[@content-desc='Flight Details']");
	static By OWSelectflight = AppiumBy.xpath("(//android.view.View[@index='0'])[9]");
	static By OWMoreDetails = AppiumBy.xpath("(//android.view.View[@content-desc='More details'])[1]");
	static By OWSelectFare = AppiumBy.xpath("(//android.view.View[@index='0'])[8]");
	static By OWFareConfirm = AppiumBy.xpath("(//android.view.View[@index='2'])[3]");
	static By AddPassengerTab = AppiumBy.xpath("(//android.view.View[@index='1'])[2]");
	static By PassengerTitle = AppiumBy.xpath("//android.widget.Button[@content-desc='Title']");
	static By SPassTitle = AppiumBy.xpath("//android.widget.Button[@content-desc='Mr.']");
	static By PassFN = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	static By PassLN = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
	static By DateTab = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[6]/android.widget.EditText");
	static By SDate = AppiumBy.xpath("//android.view.View[@content-desc='2, Tuesday, October 2, 2012']");
	static By SDateO = AppiumBy.xpath("//android.widget.Button[@content-desc='OK']");
	static By NationalityTab = AppiumBy
			.xpath("//android.widget.ScrollView/android.view.View[7]/android.widget.EditText");
	static By SNationality = AppiumBy.xpath("//android.widget.ImageView[@content-desc='Saudi Arabian']");
	static By NDone = AppiumBy.xpath("//android.widget.Button[@content-desc='Done']");
	static By PassN = AppiumBy.xpath(
			"//android.widget.ScrollView/android.view.View[10]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
	static By PassN1 = AppiumBy.xpath(
			"//android.widget.ScrollView/android.view.View[5]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
	static By EDateTab = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[4]");
	static By ESDate = AppiumBy.xpath("//android.view.View[@content-desc='30, Wednesday, April 30, 2025']");
	static By ESDateO = AppiumBy.xpath("//android.widget.Button[@content-desc='OK']");
	static By ENationalityTab = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[5]");
	static By ESNationality = AppiumBy.xpath("//android.widget.ImageView[@content-desc='Saudi Arabia']");
	static By ANDone = AppiumBy.xpath("//android.view.View[@content-desc='Done']");
	static By CountryCode = AppiumBy.xpath("//android.widget.EditText[@index='0']");
	static By SCountryCode = AppiumBy.xpath("//android.widget.ImageView[@index='0']");
	static By MobileNo = AppiumBy.xpath("//android.widget.EditText[@index='1']");
	static By Email = AppiumBy.xpath("//android.widget.EditText[@index='2']");
	static By SkipToPayment = AppiumBy.xpath("//android.view.View[@content-desc='Skip to payment']");
	static By SeatExtras = AppiumBy.xpath("//android.view.View[@content-desc='Select seats & extras']");

}
