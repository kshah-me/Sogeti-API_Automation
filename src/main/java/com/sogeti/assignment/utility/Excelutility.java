package com.sogeti.assignment.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {


	public Object[][] getExcelData(String fileName, String sheetname) throws IOException {
		Object[][] data = null;
        
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetname);
            int noOfRows = sheet.getLastRowNum() + 1;
            int noOfCols = sheet.getRow(0).getLastCellNum();
//            System.out.println(noOfRows);
//            System.out.println(noOfCols);
            Cell cell;
            DataFormatter formatter = new DataFormatter();
            data = new Object[noOfRows - 1][noOfCols];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    cell = sheet.getRow(i).getCell(j);
//                    System.out.println(formatter.formatCellValue(cell));
                    	data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
        return data;
    }

//
//	public static void main(String args[]) {
//		
//		Excelutility ex = new Excelutility();
//		try {
//			Object[][] ob=ex.getExcelData(System.getProperty("user.dir" )+ "/TestData.xlsx", "getMethodTestData");
//			System.out.println(ob[1][2]);
//			System.out.println(ex.getExcelData(System.getProperty("user.dir" )+ "/TestData.xlsx", "getMethodTestData"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("exception occur");
//		}
//	}
	
}


