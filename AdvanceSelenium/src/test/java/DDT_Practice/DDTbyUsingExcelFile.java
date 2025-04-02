package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTbyUsingExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace_Ranjitha\\AdvanceSelenium\\src\\test\\resources\\ChamphaignTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue();
		 String Targetsize = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		 System.out.println(Campaign);
		 System.out.println(Targetsize);
		
	}

}

