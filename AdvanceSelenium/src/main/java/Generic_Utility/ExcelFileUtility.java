package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readingDataFroemExcel(String sheet,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\user\\git\\AdvanceSelenium7pm\\AdvanceSelenium\\src\\test\\resources\\ChamphaignTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
		}

}
