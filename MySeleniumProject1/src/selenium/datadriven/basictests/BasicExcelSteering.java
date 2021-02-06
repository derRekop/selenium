package selenium.datadriven.basictests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BasicExcelSteering {

	public static void main(String[] args) throws IOException {
		// uses java class to create a reference to an existing excel sheet
		FileInputStream excelFile = new FileInputStream("//Users//fvargas//eclipse-workspace//MySeleniumProject1//XLSTestFile.xlsx");
		
		// uses POI class to create a reference to the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		
		// uses POI class to create a reference to the sheet
		XSSFSheet sheet = workbook.getSheet("MyFirstSheet"); // provide sheet name
		
		//XSSFSheet sheet = workbook.getSheetAt(0); // optional to use index to identify sheet
		
		// getting rows count
		int rowCount = sheet.getLastRowNum();
		
		// getting columns (cells) count
		int colCount = sheet.getRow(0).getLastCellNum();
		
		// reading excel content and printout data
		for(int i = 0; i <= rowCount; i++) {
			XSSFRow currentRow = sheet.getRow(i); //focus on current row
			for(int j = 0; j < colCount; j++) {
				System.out.print(currentRow.getCell(j) + " ");			
			}
			System.out.println();
		}
		
		workbook.close();

	}

}
