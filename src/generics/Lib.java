package generics;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pomClasses.RefundFormPage;

public class Lib extends BaseTest{
	
	public static Workbook wb;

	public static int getRowCount(String path, String sheetName) {
		int rowCount = 0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			rowCount = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public static String getCellValue(String path, String sheetName, int rowNum, int colNum) {
		String cellValue = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}
	
	public static int changeDateToNum(String path, String sheetName, int row, int col, int in1, int in2)
	{
		String day = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			String cellValue = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
			day = day+cellValue.charAt(in1)+cellValue.charAt(in2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(day);
		
	}
	
	public static void selectMonth(String path, String sheetName, int row, int col)
	{
		ArrayList<String> monthList = new ArrayList<String>();
		monthList.add("");
		monthList.add("January");
		monthList.add("February");
		monthList.add("March");
		monthList.add("April");
		monthList.add("May");
		monthList.add("June");
		monthList.add("July");
		monthList.add("Auguast");
		monthList.add("September");
		monthList.add("October");
		monthList.add("November");
		monthList.add("December");
		
		RefundFormPage rfp = new RefundFormPage(driver);
		String currentEndMonth = rfp.getEndMonthText();
		int index = monthList.indexOf(currentEndMonth);
		
		int mm = changeDateToNum(path, sheetName, row, col, 3, 4);
		int difference = mm-index;
		
		while(difference!=0)
		{
			if(difference<0)
			{
				rfp.clickPreviusForEndMonth();
				difference++;
			}
			else if(difference>0)
			{
				rfp.selectEndMonth();
				difference--;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
