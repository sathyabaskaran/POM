package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public  String[][]  readData(String filename) throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook("./data./"+filename+".xlsx");
		
		XSSFSheet sh = wb.getSheetAt(0);
		
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();
		
		System.out.println(rowCount);
		System.out.println(cellCount);
		String[][] data = new String[rowCount][cellCount];
		
		for(int i = 0; i < rowCount; i++)
		{
			for(int j =0 ; j < cellCount; j++)
			{
				 data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		
		wb.close();
	
		return data;
	}

}
