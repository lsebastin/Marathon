package practiceNG;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	public static String[][] data() throws IOException {
		XSSFWorkbook wb =new XSSFWorkbook("./data/saucedemoex.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		String stringCellValue = ws.getRow(1).getCell(0).getStringCellValue();
		System.out.println(stringCellValue);
		int lastRowNum = ws.getLastRowNum();
		System.out.println(lastRowNum);
		int lastCellNum = ws.getRow(1).getLastCellNum();
		System.out.println(lastCellNum);
		
		
		String[] [] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				String stringCellValue2 = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue2);
				data[i-1][j] = stringCellValue2;
				
			}
			
		}
		wb.close();
		return data;
		
			
	}
	
}


