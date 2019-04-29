package generics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pomClasses.RefundFormPage;

public class DateHandler extends BasePage{
	
	public void selectDate (String xp1, String xp2, int dateVal)
	{
		boolean br=false;
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=7; j++)
			{
				
				WebElement calDate = driver.findElement(By.xpath(xp1+i+xp2+j+"]"));
				waitTillElementIsVisible(calDate);
				if(calDate.isEnabled())
				{
					int calDateNum = Integer.parseInt(calDate.getText());
					if(calDateNum==dateVal)
					{
						calDate.click();
						br=true;
						break;
						
					}
				}
				
			}
			if(br) {
				break;
			}
				
		}
	}
	

}
