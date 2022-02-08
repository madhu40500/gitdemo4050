package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
@Test
	public String[][] getdata() throws IOException
	{
	String path = System.getProperty("user.dir")+"/src/main/java/utilities/document.xlsx";	
		FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = null;
	int sheets= wb.getNumberOfSheets();
	String[][] data=null;
	for(int i=0;i<sheets;i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("data"))
		{
		sheet = wb.getSheetAt(i);
		}
	}
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell;
	   int norows= sheet.getPhysicalNumberOfRows();
	int nocells= row.getLastCellNum();
	data = new String[norows-1][nocells-1];
	for(int i=1;i<norows;i++)
	{
		for(int j=1;j<nocells;j++)
		{
			row= sheet.getRow(i);
		 cell = row.getCell(j);	
		CellType type = cell.getCellType();
		if(type==CellType.STRING)
		{
			data[i-1][j-1]=cell.getStringCellValue();
			//System.out.println(data[i-1][j-1]);
		}
		if(type==CellType.NUMERIC)
		{
			data[i-1][j-1]=  NumberToTextConverter.toText(cell.getNumericCellValue());
			//System.out.println(data[i-1][j-1]);
		}
		}	
	}
	return data;
	}
	
	
}
