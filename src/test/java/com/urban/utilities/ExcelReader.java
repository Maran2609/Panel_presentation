package com.urban.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public static Object[][] getexceldata(String sheet) throws IOException
	{
		FileInputStream file =new FileInputStream(Propertyfilereader.getXllocation());
	    XSSFWorkbook workbook=new XSSFWorkbook(file);
	    XSSFSheet sheett=workbook.getSheet(sheet);
	    Object[][] data=new Object[sheett.getLastRowNum()][sheett.getRow(0).getLastCellNum()];
	    for(int i=0;i<sheett.getLastRowNum();i++)
	    {
	    	for(int j=0;j<sheett.getRow(0).getLastCellNum();j++)
	    	{
	    		data[i][j]=sheett.getRow(i+1).getCell(j).toString();
	    	}
	    	}
	 return data;
	}
	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream fis= new FileInputStream(Propertyfilereader.getXllocation());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets= workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("testData")) {
		XSSFSheet sheet= workbook.getSheetAt(i);
		//Identify testcases column by scanning the entire 1st row

		Iterator<Row> rows=sheet.iterator(); //sheet is collection of rows
		Row firstrow= rows.next();
		Iterator<Cell> ce= firstrow.cellIterator();//row is collection of cells
		int k=0;
		int column = 0;
		while(ce.hasNext()) {
		Cell value=ce.next();
		if(value.getStringCellValue().equalsIgnoreCase("Product")) {
		//desired column
		column=k;

		}
		k++;
		}
		//once column is identified the scan entire testcase column to identify purchase testcase row
		while(rows.hasNext()) {
		Row r= rows.next();
		if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
		//after you grab purchase testcase row =pull all the data of that row and feed into test
		Iterator<Cell> cv= r.cellIterator();
		while(cv.hasNext()) {
		Cell c=cv.next();
		if(c.getCellType()==CellType.STRING) {
		a.add(c.getStringCellValue());
		}
		else {
		a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

		}

	}
}

}


		}


		}
		return a;

}
	
	
	
}