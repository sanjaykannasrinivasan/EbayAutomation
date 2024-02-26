package Selenium;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	public static String readExcel(int r,int c)throws IOException
	{
		String filepath = System.getProperty("user.dir")+"\\Excel\\TestData.xlsx";
		FileInputStream file=new FileInputStream(filepath);
		XSSFWorkbook work = new XSSFWorkbook(file);
		XSSFSheet sheet=work.getSheetAt(0);
		String testData = String.valueOf(sheet.getRow(r).getCell(c));
		work.close();
		return testData;
	}

}
