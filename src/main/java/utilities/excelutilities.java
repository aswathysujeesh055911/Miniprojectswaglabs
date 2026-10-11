package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutilities {
	
	public static Object[][] getTestData(String filepath , String sheetname ) throws IOException
	{
		FileInputStream fis = new FileInputStream(filepath); 

        XSSFWorkbook workbook = new XSSFWorkbook(fis); //get excel workbook

        XSSFSheet sheet = workbook.getSheet(sheetname); //get the sheet

        int rows = sheet.getLastRowNum(); //excluding header
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols]; //create 2d object array

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= rows; i++) { // start from 1 (skip header)

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));

            }
        }

        workbook.close();
        fis.close();

        return data;

}

}
