package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("A13");

		String value1 = sh.getRow(9).getCell(0).getStringCellValue();
		boolean value2 = sh.getRow(10).getCell(0).getBooleanCellValue();
		double value3 = sh.getRow(11).getCell(0).getNumericCellValue();
		String value4 = sh.getRow(12).getCell(0).getStringCellValue();

		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);

		wb.close();
		
		fis.close();
	}
}