package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

public static long PAGE_LOAD_TIMEOUT = 20;
public static long IMPLICIT_WAIT = 10;

public static String TESTDATA_SHEET_PATH = "C:\\Users\\Guest1\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\excel file for page object model.xls" ;


public void moveMouseFor(String element) {
Actions myMouse = new Actions(driver);
WebElement e;
e = driver.findElement(By.xpath(element));
myMouse.moveToElement(e).build().perform();
}

    static Workbook book;
    static Sheet sheet;



public static Object[][]getTestData(String sheetname){
    FileInputStream file = null;
    try {
        file = new FileInputStream(TESTDATA_SHEET_PATH);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

     try {
    	 //book = new WorkbookFactory();
        book= WorkbookFactory.create(file);
    } catch (IOException e) {
        e.printStackTrace();
    }

     sheet = book.getSheet(sheetname);
     Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

     for (int i =0; i <sheet.getLastRowNum();i++){

         for (int k =0;k <sheet.getRow(0).getLastCellNum(); k++){
        	 if(sheet.getRow(i+1).getCell(k).toString().trim()!= null) {
             data[i][k]= sheet.getRow(i+1).getCell(k).toString().trim();
        	 }
         }
     }

     return data;

    }


}

