package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// FileInputStream argument
		// FileInputStream is class in java were it will create object have power to
		// read any file
		FileInputStream fis = new FileInputStream("D:\\Rahul Arora\\DataDriven\\TestCaseData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // access the work book pass the file path object
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> cell = firstrow.iterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {

						
						column=k;
						
					}
					k++;
				}
				System.out.println(column);

			}

		}

	}


	

}
