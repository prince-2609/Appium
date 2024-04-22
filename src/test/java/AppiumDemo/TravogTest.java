package AppiumDemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TravogTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "samsung SM-M045F");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UIAutomator2");
		capabilities.setCapability("udid", "R9ZTC08ZM7V");
		capabilities.setCapability("appPackage", "in.quadlabs.travog");
		capabilities.setCapability("appActivity", "in.quadlabs.travog.MainActivity");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Start");
		Thread.sleep(5000);

		WebElement Allow = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		Allow.click();
		Thread.sleep(5000);
		WebElement WhileUsingApp = driver
				.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
		WhileUsingApp.click();

//		WebElement ComanyCode = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
//		ComanyCode.click();

		Thread.sleep(5000);
		driver.quit();

	}
}
