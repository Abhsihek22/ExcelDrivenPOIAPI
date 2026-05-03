package DataProviderAndExcelData.excelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	
	
	@Test(dataProvider="diverTest")
	public void testCasedata(String greeting, String Communication,String id)
	{
		System.out.println(greeting+Communication+id);
	}
	
	
	@DataProvider(name="diverTest")
	public Object[][] getData() throws IOException
	
	{
		//Object[][] data= {{"hello","text","1"},{"bye","message","451"},{"solo","call","567"}};
		//every row of excel should be send to 1 array
		
		DataFormatter formatter=new DataFormatter();
		FileInputStream fis = new FileInputStream("D:\\Rahul Arora\\DataDriven\\TestCaseData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(2);
		int rowcount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colcount=row.getLastCellNum();
		Object data[][]=new Object[rowcount-1][colcount];
		for(int i=0;i<rowcount-1;i++)
		{
			
			row=sheet.getRow(i+1);
			for(int j=0;j<colcount;j++)
			{
				
			
				XSSFCell cell=row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
				
			}
		}
		
		
	
		
		
		
		
		
		return data;
	}
}
