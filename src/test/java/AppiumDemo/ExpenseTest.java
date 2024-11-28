package AppiumDemo;

import java.io.IOException;
import java.text.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.QaDataProvider;

@Listeners(Utilities.Listener.class)
public class ExpenseTest extends BaseClass {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ExpenseTest", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void travoTest(String TestCaseId, String TestScenario, String UserType, String FirstName,
			String LastName, String Email, String CountryCode, String Country, String CityCode, String City,
			String MobileNo, String CompanyName, String Password, String ConfirmPassword, String OTP,
			String CompanyCode, String UserName, String PasswordLog, String ReportName, String DestCode,
			String Destination, String ReportType, String StartDate, String EndDate, String CostCenter, String Project,
			String Department, String Remark, String SelectType, String Category, String Marchant, String Currency,
			String Amount, String EStartDate, String EEndDate, String Ecomment, String EPaymentMode,
			String MarkAsPersonal) throws InterruptedException, IOException, ParseException {

		test = report.createTest(TestCaseId + "-" + TestScenario);
		Thread.sleep(10000);
//		extentScreenshot("Allow tab");
//		ClickOnElement(Locators.Allow);

//		ClickOnElement(Locators.NewVersion);

		if (UserType.equalsIgnoreCase("SignUp")) {
			extentScreenshot("Get Started");
			ClickOnElement(Locators.GetStarted);
			ClickOnElement(Locators.FirstName1);
			SendKeys(Locators.FirstName1, FirstName);
			ClickOnElement(Locators.LastName1);
			SendKeys(Locators.LastName1, LastName);
			ClickOnElement(Locators.Email1);
			SendKeys(Locators.Email1, Email);
			ClickOnElement(Locators.Country1);
			listofautosuggestion(Locators.SearchCountry, Locators.Contries, CountryCode, Country);
			back();
			listofautosuggestion(Locators.City1, Locators.Cities, CityCode, City);
			back();
			ClickOnElement(Locators.MobileNumber);
			SendKeys(Locators.MobileNumber, MobileNo);
			back();
			ClickOnElement(Locators.CompanyName1);
			SendKeys(Locators.CompanyName1, CompanyName);
			back();
			ClickOnElement(Locators.Password1);
			SendKeys(Locators.Password1, Password);
			back();
			ClickOnElement(Locators.ConfirmPassword1);
			SendKeys(Locators.ConfirmPassword1, ConfirmPassword);
			back();
			ClickOnElement(Locators.Submit);
			String a[] = OTP.split("");
			ClickOnElement(Locators.OTP1);
			SendKeys(Locators.OTP1, a[0]);
			back();
			ClickOnElement(Locators.OTP2);
			SendKeys(Locators.OTP2, a[1]);
			back();
			ClickOnElement(Locators.OTP3);
			SendKeys(Locators.OTP3, a[2]);
			back();
			ClickOnElement(Locators.OTP4);
			SendKeys(Locators.OTP4, a[3]);
			back();
			ClickOnElement(Locators.OTP5);
			SendKeys(Locators.OTP5, a[4]);
			back();
			ClickOnElement(Locators.OTP6);
			SendKeys(Locators.OTP6, a[5]);
			back();
			ClickOnElement(Locators.VerifyPhoneNo);

		} else if (UserType.equalsIgnoreCase("Login")) {
			extentScreenshot("Log In");
			ClickOnElement(Locators.LogIn);
			ClickOnElement(Locators.CompanyCode);
			ClearAndSend(Locators.CompanyCode, CompanyCode);
			ClickOnElement(Locators.LogEmail);
			ClearAndSend(Locators.LogEmail, UserName);
			ClickOnElement(Locators.LogPassoword);
			ClearAndSend(Locators.LogPassoword, ConfirmPassword);
			back();
			extentScreenshot("Log In");
//			ClickOnElement(Locators.LogInTravog);
//			Thread.sleep(2000); 
			
			//ClickOnElement(Locators.LogSignIn);
			
//			extentScreenshot("While using app tab");
//			ClickOnElement(Locators.WhileUsingApp);
//			extentScreenshot("Dashboard");
//			ClickOnElement(Locators.Expenses);
//			extentScreenshot("Expense Dashboard");
//			ClickOnElement(Locators.ExpenseSheet);
//			ClickOnElement(Locators.ExpenseSheetAdd);
//			ClickOnElement(Locators.ExpenseReportName);
//			SendKeys(Locators.ExpenseReportName, ReportName);
//			ClickOnElement(Locators.ExpenseReportDestination);
//			listofautosuggestion(Locators.ExpenseReportDestination1, Locators.ExpenseReportDestinations, DestCode,
//					Destination);
//			back();
//			dropDown(Locators.ExpenseReportType, Locators.ExpenseReportTypes, ReportType);
//			extentScreenshot("Expense Sheet");
//			ClickOnElement(Locators.Date1);
//			Thread.sleep(3000);
//			String DateSelection[] = StartDate.split("-");
//			String year = DateSelection[2];
//			String month = DateSelection[1];
//			String expDate = DateSelection[0];
//			String DateSelection1[] = EndDate.split("-");
//			String year1 = DateSelection1[2];
//			String month1 = DateSelection1[1];
//			String expDate1 = DateSelection1[0];
//			CalenderForReport(expDate, month, year, expDate1, month1, year1);
//
//			dropDown(Locators.CostCenterType, Locators.CostCenterTypes, CostCenter); //
//			back();
//			// dropDown(Locators.ProjectType, Locators.ProjectTypes, Project); //
//			back();
//			// dropDown(Locators.DepartmentType, Locators.DepartmentTypes,Department);
//			// back();
//
//			// ClickOnElement(Locators.Remark1); // SendKeys(Locators.Remark1, Remark);
//			// back(); scrollPage("Per diem allowance");
//
//			ClickOnElement(Locators.PerDiemAllowance);
//			extentScreenshot("Expense Sheet");
//			ClickOnElement(Locators.ReportCreate);
//			Thread.sleep(10000);
//			extentScreenshot("Expense Sheets");
//			Thread.sleep(2000); //
//			ClickOnElement(Locators.ReportCreateOk);
//
//			// Search Expense report Name
//
//			ClickOnElement(Locators.SearchReport);
//			SendKeys(Locators.SearchReport, ReportName);
//			ClickOnElement(Locators.ClickOnReport);
//			extentScreenshot("Expense Details");
//
//			// Add new Expense
//
//			ClickOnElement(Locators.AddExpense);
//			ClickOnElement(Locators.AddNewExpense);
//			if (SelectType.equalsIgnoreCase("ExpenseManually")) {
//				ClickOnElement(Locators.ExpenseManually);
//			} else if (SelectType.equalsIgnoreCase("Conveyance")) {
//				ClickOnElement(Locators.AddConveyance);
//				ClickOnElement(Locators.SelectConveyanceType);
//				ClickOnElement(Locators.ConveyanceTypeCab);
//				ClickOnElement(Locators.ConveyanceOrigin);
//				ClickOnElement(Locators.SearchOrigin);
//				// SendKeys(Locators.SearchOrigin,COrigin);
//
//			}
//			ClickOnElement(Locators.ECategory);
//			ClickOnElement(Locators.SelectCategory);
//			SendKeys(Locators.SelectCategory, Category);
//			back();
//			ClickOnElement(Locators.SelectACategory);
//			ClickOnElement(Locators.SelectMarchant);
//			SendKeys(Locators.SelectMarchant, Marchant);
//			back();
//			ClickOnElement(Locators.ECurrency);
//			ClickOnElement(Locators.SelectCurrency);
//			SendKeys(Locators.SelectCurrency, Currency);
//			back();
//			ClickOnElement(Locators.SelectACurrency);
//			ClickOnElement(Locators.EAmount);
//			SendKeys(Locators.EAmount, Amount);
//			back();
//			extentScreenshot("New Expense Add");
//			ClickOnElement(Locators.NEDate1);
//
//			String EDateSelection[] = EStartDate.split("-");
//			String Eyear = EDateSelection[2];
//			String Emonth = EDateSelection[1];
//			String EexpDate = EDateSelection[0];
//			String EDateSelection1[] = EEndDate.split("-");
//			String Eyear1 = EDateSelection1[2];
//			String Emonth1 = EDateSelection1[1];
//			String EexpDate1 = EDateSelection1[0];
//			CalenderForExpences(EexpDate, Emonth, Eyear, EexpDate1, Emonth1, Eyear1);
//			// ClickOnElement(Locators.NEComment);
//			SendKeys(Locators.NEComment1, Ecomment);
//			back();
//			scrollPage("Billable to client");
//			ClickOnElement(Locators.NEModeOfPayment);
//			ClickOnElement(Locators.NESelectPayment);
//			SendKeys(Locators.NESelectPayment, EPaymentMode);
//			back();
//			ClickOnElement(Locators.SelectAPayment);
//			back();
//			scrollPage("Billable to client");
//			if (MarkAsPersonal.equalsIgnoreCase("Yes")) {
//				ClickOnElement(Locators.NEMarkAsPersonal);
//			}
//			ClickOnElement(Locators.NEBillableToClient);
//			extentScreenshot("New Expense Add");
//			ClickOnElement(Locators.NEDone);
//			ClickOnElement(Locators.NEExpense);
//			extentScreenshot("Expense Details");
//			ClickOnElement(Locators.NESendForApproval);
//			ClickOnElement(Locators.NEConfirm);
//			Thread.sleep(7000);
		}
	}
}
