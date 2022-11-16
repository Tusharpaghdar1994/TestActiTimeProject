package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	//generic reusable method to read the data
		public String readExcelData(String excelPath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(excelPath);//getting the specified File for read operation
			Workbook wb = WorkbookFactory.create(fis);//it makes the file ready for read operation
			Sheet sh = wb.getSheet(sheetName);//it specifies which sheet
			Row row = sh.getRow(rowCount);//Specifies the Row
			Cell cell = row.getCell(cellCount);// Specifies the column
			String data = cell.getStringCellValue();//it read the data from cell
			return data;
		}
		//generic reusable method to write the data
		public void writeExcelData(String excelPath,String sheetName,int rowCount,int cellCount,String data) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowCount);
			Cell cell = row.getCell(cellCount);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(excelPath);
			wb.write(fos);
		}
		
		public int getRowCountMethod(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(excelPath);//getting the specified File for read operation
			Workbook wb = WorkbookFactory.create(fis);//it makes the file ready for read operation
			Sheet sh = wb.getSheet(sheetName);//it specifies which sheet
			int rc = sh.getLastRowNum();
			return rc;
		}
		
		public String readPropertyData(String propPath,String key) throws IOException
		{	
			FileInputStream fis = new FileInputStream(propPath);
			Properties prop = new Properties();
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;
		}

}
