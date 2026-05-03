package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven3 {
	
	
	
	
	public ArrayList<String> getData(String testname) throws  IOException, InvalidFormatException
	{
		
		ArrayList<String> a=new ArrayList<String>();
		File fis=new File("D:\\Rahul Arora\\DataDriven\\TestCaseData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		
		
		for(int i=0;i<sheets;i++)
		{
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				Iterator<Row>rows=sheet.iterator();
				Row firstrow=rows.next();
				
				Iterator<Cell>cell=firstrow.iterator();
				int k=0;
				int column=0;
				while (cell.hasNext())
				{
					Cell value=cell.next();
					
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
					{
						
						Iterator<Cell>cv=r.cellIterator();
						while(cv.hasNext())
						{
							a.add(cv.next().getStringCellValue());
						}
					}
				}
			}
			
			
		}
		return a;
		
	}

	public static void main(String[] args) throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub

		// FileInputStream argument
		// FileInputStream is class in java were it will create object have power to
		// read any file
	
		
		
	
	}

}
