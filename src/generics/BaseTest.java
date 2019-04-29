package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pomClasses.RefundFormPage;

public class BaseTest implements IAutoConst {
	
	public static WebDriver driver; 
	  static 
	  { 
		  System.setProperty(chromKey,chromeDriverPath); 
	  }
	  
	  @BeforeMethod public void openApplication() 
	  {
		  	driver = new ChromeDriver();
		  	driver.get(url); driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS); 
		  	driver.manage().window().maximize();
		  	RefundFormPage rfp = new RefundFormPage(driver);
		  	rfp.setUserName("LCO200000955.01");
		  	rfp.setpassword("Grant@123");
		  	rfp.clickProceed();
	  	}
	  
	  @AfterMethod
	  public void closeApplication() { 
		  driver.close(); 
	  }

}
