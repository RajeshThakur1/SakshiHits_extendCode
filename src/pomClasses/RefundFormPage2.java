package pomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefundFormPage2 {
	
	@FindBy(xpath="//input[@placeholder='User Name']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Proceed']")
	WebElement proceed;
	
	@FindBy(xpath="//a[text()='Customer ']")
	WebElement subscriberLink;
	
	@FindBy(xpath="//a[text()='Refund Request']")
	WebElement refundRequest;
	
	@FindBy(xpath="//input[@name='lconame']")
	WebElement lcoNwkName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='customerid']")
	WebElement customerId;
	
	
	@FindBy(xpath="//input[@name='packagename']")
	WebElement packageNameField;
	
	@FindBy(name="packagerate")
	WebElement packageRateField;
	
	@FindBy(xpath = "//*[@id=\"start_date\"]/div[1]/input")
	WebElement packStartDate;
	
	WebDriver driver;
	public RefundFormPage2(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un) {
		username.clear();
		username.sendKeys(un);
	}
	
	
	public void setpassword(String pw) {
		password.clear();
		password.sendKeys(pw);
	}
	
	public void clickProceed() {
		proceed.click();
	}
	
	public void clickCustomer()
	{
		subscriberLink.click();
	}
	
	
	public void selectRefundRequest()
	{
		refundRequest.click();
	}
	
	public void setLCONwkName(String lconame)
	{
		lcoNwkName.sendKeys(lconame);
	}
	
	public void setEmail(String emailId)
	{
		email.clear();
		email.sendKeys(emailId);
	}
	
	public void setCustomerId(String canNo)
	{
		customerId.clear();
		customerId.sendKeys(canNo);
	}
	
	public void setPackageName(String packageName)
	{
		packageNameField.clear();
		packageNameField.sendKeys(packageName);
	}
	
	public void setPackageRate(String packageRate)
	{
		packageRateField.clear();
		packageRateField.sendKeys(packageRate);
	}
	
	public void setStartDateByJS(WebDriver driver, String dateVal)
	{
		JavascriptExecutor js = (JavascriptExecutor)(driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", packStartDate);
	}
	
	
	

}
