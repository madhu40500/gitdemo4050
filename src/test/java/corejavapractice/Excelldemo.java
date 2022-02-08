package corejavapractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelldemo {
	
		
public static	Object[][] getdata(String testname, FileInputStream fis)
	{
XSSFWorkbook wb = null;
try {
	 wb = new XSSFWorkbook(fis);
} catch (IOException e) {
	e.printStackTrace();
}
	String testName=testname;	
XSSFSheet sheet = wb.getSheet(Constants.sheetname);
int rowcount= sheet.getLastRowNum();
System.out.println(rowcount);
//System.out.println(sheet.getLastRowNum());
int i=sheet.getFirstRowNum();
for(i=0;i<rowcount;i++)
{
	while((sheet.getRow(i)==null))
	{
		i++;
	}
	while(!sheet.getRow(i).getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK ).getStringCellValue().equalsIgnoreCase(testName))
	{
		i++;
		if((sheet.getRow(i)==null))
		{
			break;
		}
	}
	if((sheet.getRow(i)!=null)&&sheet.getRow(i).getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK ).getStringCellValue().equalsIgnoreCase(testName))
	{
		break;
	}
	
}
int testCaseRowNum=i;

while(!sheet.getRow(i).getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK ).getStringCellValue().equals(""))
{
	i++;
	if((sheet.getRow(i)==null))
	{
		break;
	}
}
XSSFRow row ;
	
Hashtable<String,String> table = null;
int dataEndsRowNum=i;
int dataStartsRowNum=testCaseRowNum+2;
System.out.println("datastars@: "+dataStartsRowNum);
System.out.println("dataens@: "+dataEndsRowNum);

int dataEndsCellNum=sheet.getRow(testCaseRowNum+1).getLastCellNum();
System.out.println("dataendscell @"+dataEndsCellNum);
Object[][] data=new Object[dataEndsRowNum-dataStartsRowNum][1];
int index=0;
for(dataStartsRowNum=testCaseRowNum+2;dataStartsRowNum<dataEndsRowNum;dataStartsRowNum++)
{
	table = new Hashtable<String,String>();
	for(int j=0;j<dataEndsCellNum;j++)
	{
	row = sheet.getRow(dataStartsRowNum);
	String cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
	table.put(sheet.getRow(testCaseRowNum+1).getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString(), cell);
	}
	data[index][0]=table;
	index++;
}

return data;
	}

}
