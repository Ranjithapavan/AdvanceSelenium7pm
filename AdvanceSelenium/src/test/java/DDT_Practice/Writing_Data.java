package DDT_Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writing_Data {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace_Ranjitha\\AdvanceSelenium\\src\\test\\resources\\ChamphaignTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet("StoreData").createRow(2).createCell(1).setCellValue("AdvanceSelenium");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\user\\eclipse-workspace_Ranjitha\\AdvanceSelenium\\src\\test\\resources\\ChamphaignTest.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Data Added Successfully");

	}

}
