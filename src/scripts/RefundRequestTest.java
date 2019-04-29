package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generics.BaseTest;
import generics.DateHandler;
import generics.Lib;
import pomClasses.RefundFormPage;

public class RefundRequestTest extends BaseTest {
	
	public static int startday;
	public static int endDay;
	public static int disconnectDay;
	public boolean isDisplayErrEndDateGreater;
	public boolean isDisplayErrDisconnectAfter4Days;
	
	@Test
	
	public void testRefundRequest() throws InterruptedException
	{
		
		RefundFormPage rf = new RefundFormPage(driver);
		DateHandler dh = new DateHandler();
		rf.clickCustomer();
		rf.selectRefundRequest();
		int rowCount = Lib.getRowCount(excelFilePath, "sheet1");
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<9; j++)
			{
				isDisplayErrEndDateGreater = false;
				isDisplayErrDisconnectAfter4Days = false;
				
				String lcoNwkName = Lib.getCellValue(excelFilePath, "sheet1", i, j);
				Reporter.log("LCO Network name is: "+lcoNwkName, true);
				rf.setLCONwkName(lcoNwkName);
				
				String email = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				Reporter.log("LCO email id is "+email, true);
				rf.setEmail(email);
				
				String customerId = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				Reporter.log("Customer Id is: "+customerId, true);
				rf.setCustomerId(customerId);
				
				String packageName = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				Reporter.log("Package name is: "+packageName, true);
				rf.setPackageName(packageName);
				
				String packageRate = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				Reporter.log("Pack Rate is: "+packageRate, true);
				rf.setPackageRate(packageRate);
				
				rf.clickpackStartDateCalendar();
				String startDate = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				Reporter.log("Pack start date is "+startDate, true);
				startday = Lib.changeDateToNum(excelFilePath, "sheet1", i, j, 0, 1);
				dh.selectDate("//*[@id=\"start_date\"]/div[2]/table/tbody/tr[", "]/td[", startday);
				Thread.sleep(3000);
				
				rf.clickPackEndCalendar();
				Lib.selectMonth(excelFilePath, "sheet1", i, ++j);
				String endDate = Lib.getCellValue(excelFilePath, "sheet1", i, j);
				Reporter.log("Pack End date is "+endDate, true);
				endDay = Lib.changeDateToNum(excelFilePath, "sheet1", i, j, 0, 1);
				dh.selectDate("//*[@id=\"end_date\"]/div[2]/table/tbody/tr[", "]/td[", endDay);
				Thread.sleep(2000);
				
				
				rf.clickRefundRequestCalendar();
				
				Thread.sleep(2000);
				String disconnectDate = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				Reporter.log("Pack disconnect date is "+disconnectDate, true);
				disconnectDay = Lib.changeDateToNum(excelFilePath, "sheet1", i, j, 0, 1);
				dh.selectDate("//*[@id=\"disc_date\"]/div[2]/table/tbody/tr[", "]/td[", disconnectDay);
				Thread.sleep(2000);
				
				String reasonOfDisconnect = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				
				
				
				rf.clickGoButton();
				
				try 
				{
					isDisplayErrEndDateGreater = rf.isDisplayederrEndDateGreater();
					if(isDisplayErrEndDateGreater)
					{
						String errEndDateGreaterMsg = rf.getTexterrEndDateGreater();
						Reporter.log(errEndDateGreaterMsg, true);
					}
				}
				catch (Exception e) 
				{
					
				}
				
				try 
				{
					isDisplayErrDisconnectAfter4Days = rf.isDisplayederrDisconnectAfter4days();
					if(isDisplayErrDisconnectAfter4Days)
					{
						String errDisconnectAfter4DaysMsg = rf.getTexterrDisconnectAfter4days();
						Reporter.log(errDisconnectAfter4DaysMsg, true);
					}
				}
				catch (Exception e) {
					System.out.println("exception:-"+e.getMessage());
					
				}
				
				try 
				{
					if(isDisplayErrDisconnectAfter4Days==false && isDisplayErrEndDateGreater==false)
					{
						//calculate the refound amound and validate it
						//if refund amount is also correct then click submit button
						rf.setReason(reasonOfDisconnect);
						
						rf.submitForm();
					}
				} 
				catch (Exception e) 
				{
					
				}
				
				System.out.println();
				System.out.println();			
			}
			
		}
	}
	
	

}
