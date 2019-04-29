package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.BasePage;

public class RefundFormPage extends BasePage{
	
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
	
	@FindBy(xpath="(//span/i[@class='glyphicon glyphicon-calendar'])[2]")
	WebElement packageStartCal;
	
	//@FindBy(xpath="(//td[text()='23'])[2])")
	//WebElement packSatrtdate;
	
	String xp1="(//td[text()='";
	
	String xp2="'])[2]";
	
	@FindBy(xpath="(//span/i[@class='glyphicon glyphicon-calendar'])[3]")
	WebElement packageEndCal;
	
	@FindBy(xpath="(//i[@class='glyphicon glyphicon-chevron-right'])[5]")
	WebElement packageEndMonth;
	
//	@FindBy(xpath="(//td[text()='22'])[3]")
//	WebElement packageEndDate;
	
	String endXp1 = "(//td[text()='";
	String endXp2 = "'])[3]";
	
	@FindBy(xpath="(//i[@class='glyphicon glyphicon-calendar'])[4]")
	WebElement packDisconnectCal;
	
//	@FindBy(xpath="//td[text()='25'])[4]")
//	WebElement packDisconnectDate;
	
	String disconnectXp1 = "(//td[text()='";
	String disconnectXp2 = "'])[4]";
	
	
	@FindBy(xpath="//input[@value='GO']")
	WebElement goButton;
	
	@FindBy(xpath="//input[@name='reason']")
	WebElement reason;
	
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitFormButton;
	
	@FindBy(xpath = "//p[text()='Start Date Cannot greater than End Date']")
	WebElement errEndDateGreater;
	
	@FindBy(xpath = "/html/body/div[1]")
	WebElement errDisconnectAfter4days;
	
	@FindBy(xpath = "//*[@id=\"end_date\"]/div[2]/table/thead/tr[1]/th[1]/span")
	WebElement endMonth;
	
	@FindBy(xpath = "(//a[@class='previous'])[5]")
	WebElement endDatePreviousMonth;
	
	
	
	
	WebDriver driver;
	public RefundFormPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void setUserName(String un) {
		waitTillElementIsVisible(username);
		username.clear();
		username.sendKeys(un);
	}
	
	
	public void setpassword(String pw) {
		waitTillElementIsVisible(password);
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
		waitTillElementIsVisible(refundRequest);
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
	
	public void clickpackStartDateCalendar()
	{
		waitTillElementIsVisible(packageStartCal);
		packageStartCal.click();
	}
	
//	public void selectPackStartDate()
//	{
//		packSatrtdate.click();
//	}
	
	
	public void clickPackEndCalendar()
	{
		waitTillElementIsVisible(packageEndCal);
		packageEndCal.click();
	}
	
	
	public void selectEndMonth()
	{
		waitTillElementIsVisible(packageEndMonth);
		packageEndMonth.click();
	}
	
//	public void selectPackEndDate()
//	{
//		packageEndDate.click();
//	}
//	
	public void clickRefundRequestCalendar() throws InterruptedException
	{
		waitTillElementIsVisible(packDisconnectCal);
		packDisconnectCal.click();
	}
	
//	public void selectRefundRequestDate()
//	{
//		packDisconnectDate.click();
//	}
	
	public void clickGoButton()
	{
		goButton.click();
	}
	
	public void setReason(String reasonToDisconnect)
	{
		reason.clear();
		reason.sendKeys(reasonToDisconnect);
	}
	
	public void submitForm()
	{
		submitFormButton.click();
	}
	
	public boolean isDisplayederrEndDateGreater()
	{
		return errEndDateGreater.isDisplayed();
	}
	
	public String getTexterrEndDateGreater()
	{
		return errEndDateGreater.getText();
	}
	
	public boolean isDisplayederrDisconnectAfter4days()
	{
		waitTillElementIsVisible(errDisconnectAfter4days);
		return errDisconnectAfter4days.isDisplayed();
	}
	
	public String getTexterrDisconnectAfter4days()
	{
		waitTillElementIsVisible(errDisconnectAfter4days);
		return errDisconnectAfter4days.getText();
	}
	
	public String getEndMonthText()
	{
		waitTillElementIsVisible(endMonth);
		return endMonth.getText();
	}
	
	public void clickPreviusForEndMonth()
	{
		waitTillElementIsVisible(endDatePreviousMonth);
		endDatePreviousMonth.click();
	}
	
	public void runXpathForStartDate(int num) {
		waitTillElementIsVisible(driver.findElement(By.xpath(xp1+num+xp2)));
		driver.findElement(By.xpath(xp1+num+xp2)).click();
		
	}
	
	public void runXpathForEndDay(int endDay)
	{
		waitTillElementIsVisible(driver.findElement(By.xpath(endXp1+endDay+endXp2)));
		driver.findElement(By.xpath(endXp1+endDay+endXp2)).click();
	}
	
	public void runXpathForDisconnectDate(int disconnectDate)
	{
		waitTillElementIsVisible(driver.findElement(By.xpath(disconnectXp1+disconnectDate+disconnectXp2)));
		driver.findElement(By.xpath(disconnectXp1+disconnectDate+disconnectXp2)).click();
	}

}
