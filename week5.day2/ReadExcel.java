package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	/*
	 * This program helps to read the excel
	 * 
	 */
	
	public static String[][] getData(String filename) throws IOException {
		
		// Step 1: Open the excel workbook
		XSSFWorkbook wbook = new XSSFWorkbook("./data/"+filename+".xlsx");
		// Step 2: Go to the Sheet
		XSSFSheet sheet = wbook.getSheetAt(0);
			// Step a) Get the number of the rows of the sheet
			int rowCount = sheet.getLastRowNum();
			// Step b) Get the number of the columns of the sheet
			int colCount = sheet.getRow(0).getLastCellNum();
			String[][] data = new String[rowCount][colCount];
		for (int j = 1; j <= rowCount; j++) {
			// Step 3: Go to the Row
			XSSFRow row = sheet.getRow(j);
			for (int i = 0; i < colCount; i++) {
				// Step 4: Go to the cell (Column)
				XSSFCell cell = row.getCell(i);
				// Step 5: Read the contents of the cell
				String value = cell.getStringCellValue();
				System.out.println(value);
				data[j-1][i] = value;
			} 
		}
		// Step 6: Close the workbook
		wbook.close();
		return data;
		
		
		
		
		
		
		
	}

}
