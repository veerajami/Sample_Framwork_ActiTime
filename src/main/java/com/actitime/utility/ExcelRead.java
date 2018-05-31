package com.actitime.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	
	
	public static void main(String[] args) {
		
		System.out.println(getData(0,0,0));
		setData(0, 0,2,"pass");
		
		
		
	}
	
	
	
	public static String getData(int sheetnum,int rownum, int cellnum)
	{
		File src=new File("C:\\Users\\lenovo\\Desktop\\Book1.xlsx");
		FileInputStream fis;
		Workbook workbook;
		Sheet sheet;
		String data=null;
		try {
			fis=new FileInputStream(src);
			workbook = WorkbookFactory.create(fis);
			sheet=workbook.getSheetAt(sheetnum);
			data=sheet.getRow(rownum+1).getCell(cellnum).toString();
			workbook.close();
		
		} catch (Exception e) {
				e.printStackTrace();
			} 
		
		return data;
	}
	
	public static String setData(int sheetnum,int rownum,int cellnum,String result)
	{
		File src=new File("C:\\Users\\lenovo\\Desktop\\Book1.xlsx");
		FileInputStream fis;
		Workbook workbook;
		Sheet sheet;
		String data=null;
		try {
			fis=new FileInputStream(src);
			workbook = WorkbookFactory.create(fis);
			sheet=workbook.getSheetAt(sheetnum);
			sheet.getRow(rownum).createCell(cellnum).setCellValue(result);
			FileOutputStream fout=new FileOutputStream(src);
			workbook.write(fout);
			workbook.close();
			System.out.println("Result Updated");
			
		
		} catch (Exception e) {
				e.printStackTrace();
			} 
		
		return data;
	}
	
	
		
}

	
