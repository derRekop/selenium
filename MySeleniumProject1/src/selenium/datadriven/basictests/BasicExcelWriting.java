package selenium.datadriven.basictests;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BasicExcelWriting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream excelFile = new FileOutputStream("//Users//fvargas//eclipse-workspace//MySeleniumProject1//XLSWriteTestFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("MyFirstSheet");
		
		for(int i = 0; i <= 5; i++) {
			XSSFRow row = sheet.createRow(i);
			for(int j = 0; j <= 3; j++) {
				row.createCell(j).setCellValue("Row: " + i + " Cell: " + j);
			}
		}
		workbook.write(excelFile);
		workbook.close();
		excelFile.close();
		System.out.println("Writing into Excel is Completed");

	}

}
