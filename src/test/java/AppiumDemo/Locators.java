package AppiumDemo;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class Locators {

	static By Allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
	static By NewVersion = AppiumBy.xpath("//android.view.View[@content-desc='Cancel']");
	static By GetStarted = AppiumBy.xpath("//android.view.View[@content-desc='Get Started']");
	static By FirstName1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	static By LastName1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
	static By Email1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[3]");
	static By Country1 = AppiumBy.xpath("//android.widget.EditText[@index='0']");
	static By SearchCountry = AppiumBy.xpath("//android.widget.EditText");
	static By Contries = AppiumBy.xpath(
			"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View");
	static By City1 = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[2]");
	static By Cities = AppiumBy
			.xpath("//android.widget.ScrollView/android.view.View[3]/android.view.View/android.view.View");
	static By MobileNumber = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	static By CompanyName1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[4]");
	static By Password1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[5]");
	static By ConfirmPassword1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[6]");
	static By Submit = AppiumBy.xpath("//android.view.View[@content-desc='Submit']");
	static By OTP1 = AppiumBy.xpath("//android.widget.EditText[@index='2']");
	static By OTP2 = AppiumBy.xpath("//android.widget.EditText[@index='3']");
	static By OTP3 = AppiumBy.xpath("//android.widget.EditText[@index='4']");
	static By OTP4 = AppiumBy.xpath("//android.widget.EditText[@index='5']");
	static By OTP5 = AppiumBy.xpath("//android.widget.EditText[@index='6']");
	static By OTP6 = AppiumBy.xpath("//android.widget.EditText[@index='7']");
	static By VerifyPhoneNo = AppiumBy.xpath("(//android.view.View[@content-desc='Verify Phone Number'])[2]");
	static By OTP1E = AppiumBy.xpath("//android.widget.EditText[@index='2']");
	static By OTP2E = AppiumBy.xpath("//android.widget.EditText[@index='3']");
	static By OTP3E = AppiumBy.xpath("//android.widget.EditText[@index='4']");
	static By OTP4E = AppiumBy.xpath("//android.widget.EditText[@index='5']");
	static By OTP5E = AppiumBy.xpath("//android.widget.EditText[@index='6']");
	static By OTP6E = AppiumBy.xpath("//android.widget.EditText[@index='7']");
	static By VerifyEmail = AppiumBy.xpath("(//android.view.View[@content-desc='Verify Email Address'])[2]");
	static By IAgree = AppiumBy.xpath("//android.view.View[@content-desc='I Agree']");
	static By ClickHereToContinue = AppiumBy.xpath("//android.view.View[@content-desc='Click here to continue']");
	static By LogIn = AppiumBy.xpath("//android.view.View[@content-desc='Log in']");
	static By CompanyCode = AppiumBy.xpath("(//android.widget.EditText)[1]");
	static By LogEmail = AppiumBy.xpath("(//android.widget.EditText)[2]");
	static By LogNext = AppiumBy.xpath("//android.view.View[@content-desc='Next']");
	static By LogPassoword = AppiumBy.xpath("(//android.widget.EditText)[3]");
	static By LogSignIn = AppiumBy.xpath("//android.view.View[@content-desc='Sign in']");
	static By LogInTravog = AppiumBy.xpath("//android.view.View[@content-desc='Login']");
	static By WhileUsingApp = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	static By Expenses = AppiumBy.xpath("//android.view.View[@index='5']");
	static By ExpenseSheet = AppiumBy.xpath("//android.view.View[@content-desc='Expense sheet']");
	static By ExpenseSheetAdd = AppiumBy.xpath("(//android.view.View[@index='2'])[1]");
	static By ExpenseReportName = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	static By ExpenseReportDestination = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[2]");
	static By ExpenseReportDestination1 = AppiumBy.xpath("//android.widget.EditText");
	static By ExpenseReportDestinations = AppiumBy.xpath("(//android.view.View[@index='0'])[7]");
	static By ExpenseReportType = AppiumBy.xpath("//android.widget.Button[@index='2']");
	static By ExpenseReportTypes = AppiumBy.xpath(
			"//android.view.View[@index='0']/android.view.View/android.view.View//android.view.View//android.view.View/android.view.View/android.view.View");
	static By Date1 = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[3]");
	static By SelectDate1 = AppiumBy.xpath("//android.view.View[@content-desc='28, Tuesday, May 28, 2024']");
	public static By Ok = AppiumBy.xpath("//android.widget.Button[@content-desc='OK']");
	public static By Date2 = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[4]");
	static By SelectDate2 = AppiumBy.xpath("//android.view.View[@content-desc='30, Thursday, May 30, 2024']");
	static By CostCenterType = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[5]");
	static By CostCenterTypes = AppiumBy.xpath(
			"//android.view.View[@index='0']/android.view.View/android.view.View//android.view.View//android.view.View/android.view.View/android.view.View/android.view.View");
	static By ProjectType = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[6]");
	static By ProjectTypes = AppiumBy.xpath(
			"//android.view.View[@index='0']/android.view.View/android.view.View//android.view.View//android.view.View/android.view.View/android.view.View/android.view.View");
	static By DepartmentType = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[7]");
	static By DepartmentTypes = AppiumBy.xpath(
			"//android.view.View[@index='0']/android.view.View/android.view.View//android.view.View//android.view.View/android.view.View/android.view.View/android.view.View");
	static By Remark1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]");
	static By Remark11 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText");
	static By PerDiemAllowance = AppiumBy.xpath("//android.widget.ScrollView/android.widget.Switch[1]");
	static By ReportCreate = AppiumBy.xpath("//android.view.View[@content-desc='Create']");
	static By ReportCreateOk = AppiumBy.xpath("//android.view.View[@content-desc='Create']");
	public static By CalBack = AppiumBy.xpath("//android.widget.Button[@index='1']");
	public static By CalNext = AppiumBy.xpath("//android.widget.Button[@index='2']");
	static By SearchReport = AppiumBy.xpath("//android.widget.EditText");
	static By ClickOnReport = AppiumBy.xpath("//android.widget.ImageView[@index='0']");
	static By AddExpense = AppiumBy.xpath("(//android.view.View[@index='1'])[2]");
	static By AddNewExpense = AppiumBy.xpath("(//android.view.View[@index='2'])[1]");
	static By ExpenseManually = AppiumBy.xpath("//android.view.View[@index='3']");
	static By AddConveyance = AppiumBy.xpath("//android.widget.ImageView[@index='4']");
	static By ECategory = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[1]");
	static By SelectCategory = AppiumBy.xpath("(//android.widget.EditText[@index='2'])[1]");
	static By SelectACategory = AppiumBy.xpath("(//android.view.View[@index='0'])[7]");
	static By SelectMarchant = AppiumBy.xpath("//android.widget.EditText[@index='1']");
	static By ECurrency = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[2]");
	static By SelectCurrency = AppiumBy.xpath("(//android.widget.EditText[@index='2'])[1]");
	static By SelectACurrency = AppiumBy.xpath("(//android.view.View[@index='0'])[7]");
	static By EAmount = AppiumBy.xpath("//android.widget.EditText[@index='4']");
	static By NEDate1 = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[3]");
	public static By NEDate2 = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[4]");
	static By NEComment = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[3]");
	static By NEComment1 = AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[2]");
	static By NEModeOfPayment = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[4]");
	static By NESelectPayment = AppiumBy.xpath("//android.widget.EditText");
	static By SelectAPayment = AppiumBy.xpath("(//android.view.View[@index='0'])[7]");
	static By NEMarkAsPersonal = AppiumBy.xpath("//android.widget.ScrollView/android.widget.Switch[1]");
	static By NEBillableToClient = AppiumBy.xpath("//android.widget.ScrollView/android.widget.Switch[2]");
	static By NEDone = AppiumBy.xpath("//android.view.View[@content-desc='Done']");
	static By NEExpense = AppiumBy.xpath("(//android.view.View[@index='1'])[2]");
	static By NESendForApproval = AppiumBy.xpath("//android.view.View[@content-desc='Send for Approval']");
	static By NEConfirm = AppiumBy.xpath("//android.view.View[@content-desc='Confirm']");
	
	static By SelectConveyanceType = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[1]");
	static By ConveyanceTypeCab = AppiumBy.xpath("//android.view.View[@content-desc='CAB']");
	static By ConveyanceOrigin = AppiumBy.xpath("(//android.widget.EditText[@index='0'])[3]");
	static By SearchOrigin = AppiumBy.xpath("(//android.widget.EditText[@index='2'])[1]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
