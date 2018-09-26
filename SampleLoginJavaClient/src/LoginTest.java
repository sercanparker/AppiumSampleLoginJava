import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTest {

	
	private final static  String APPLICATION_PACKAGE_NAME = "sercanparker.com.samplelogin";
	private final static  String APPLICATION_ACTIVITY_NAME = ".MainActivity"; 
	private final static  String DEVICE_UDID = "";
	private final static  String BROWSER_NAME = ""; //it's empty to handle exception. 
	private final static  String DEVICE_NAME = "HTC HTC One_M8";
	
	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, org.openqa.selenium.Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.UDID, DEVICE_UDID);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APPLICATION_PACKAGE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APPLICATION_ACTIVITY_NAME);
        
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        
        
        driver.resetApp();
        
        //Enter username
        driver.findElement(By.id("username_EditText_LoginActivity")).sendKeys("sercanparker@foo.com");
        
        //Enter Password
        driver.findElement(By.id("password_EditText_LoginActivity")).sendKeys("bar");
		
        driver.findElement(By.id("loginButton_LoginActivity")).click();

        if (driver.findElement(By.id("loginInfoTextView_LoginActivity")).getText().toString().equals("Login Success")) 
        {
			System.out.println("PASSED UNDER TEST");
		}else{
			System.out.println("FAILED UNDER TEST");
		}
        
        driver.quit();
	}

}
