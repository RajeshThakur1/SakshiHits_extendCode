package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage implements IAutoConst {
	
	public WebDriver driver;
	
	public BasePage() {
		this.driver=BaseTest.driver;
	}
	
	public  void waitTillElementIsVisible(WebElement element)
	{
		
		 new WebDriverWait(driver, ETO).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillElementIsClickable(WebElement ele)
	{
		new WebDriverWait(driver, ETO).until(ExpectedConditions.elementToBeClickable(ele));
	}

}
