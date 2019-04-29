package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generics.BaseTest;
import generics.Lib;
import pomClasses.RefundFormPage;
import pomClasses.RefundFormPage2;

public class RefundRequestTest2 extends BaseTest {
	
	@Test
	public void refundRequestTest() throws InterruptedException
	{
		RefundFormPage2 rf = new RefundFormPage2(driver);
		rf.clickCustomer();
		rf.selectRefundRequest();
		int rowCount = Lib.getRowCount(excelFilePath, "sheet1");
		for(int i=1; i<=1; i++)
		{
			for(int j=0; j<=5; j++)
			{
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
				
				String startDate = Lib.getCellValue(excelFilePath, "sheet1", i, ++j);
				startDate = startDate.replaceAll("_", "/");
				System.out.println(startDate);
				rf.setStartDateByJS(driver, startDate);
				Thread.sleep(60000);
				
				
				
				
				
				
				
				
				
				
			}
		}
	}

}
