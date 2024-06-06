package com.demoWorkshopFrameWork.Genric.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getStringDataFromExcelFile(String sheetName,int Row,int cell) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/DDTfiles/ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(Row).getCell(cell).getStringCellValue();
		return value;
	}
   public static double getNumricDataFromExcelFile(String sheetName,int Row,int cell) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/DDTfiles/ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		double value = wb.getSheet(sheetName).getRow(Row).getCell(cell).getNumericCellValue();
           return value;
	}
   public static boolean getBoolianDataFromExcelFile(String sheetName,int Row,int cell) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/DDTfiles/ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 boolean value = wb.getSheet(sheetName).getRow(Row).getCell(cell).getBooleanCellValue();
          return value;
	}
   public static int getRowNumberFromExcelFile(String sheetName) throws IOException {
    
	   FileInputStream fis = new FileInputStream("./src/test/resources/DDTfiles/ExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 int value = wb.getSheet(sheetName).getLastRowNum();
		return value;   
    }
   public  void setDataintoExelFile(String sheetname, int rowNum,int cellNum, String Data ) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./resource/TestscriptData.xlsx");
	    Workbook  wb=WorkbookFactory.create(fis);
	    wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum).setCellValue(Data);
	    FileOutputStream fos =new FileOutputStream("./resource/TestscriptData.xlsx");
	    wb.write(fos);
	    wb.close();
		
	}
   
		

}
