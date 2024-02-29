package setup;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String[] readExcelData(String sheet1Name) throws IOException{ 

        String path = System.getProperty("user.dir")+"\\TestData\\DisplayBookShelvesData.xlsx";
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet ws = wb.getSheet(sheet1Name);        
        XSSFRow r = ws.getRow(0);
        int c_no = r.getLastCellNum();
        String Data[] = new String[c_no];
        for(int j=0; j<c_no; j++)
        {
            Data[j] = String.valueOf(r.getCell(j));
        }
        System.out.println(Data);
        return Data;
    }
	
	public void writeData(String sheetName,  List<String> a,int rowNo, int colNo) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\DisplayBookShelves.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file); 
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		 
		for(int i = rowNo; i<a.size(); i++) {
					
			if(sheet.getRow(i)==null)
			{
				sheet.createRow(i);
			}
			XSSFRow row =sheet.getRow(i);   
			
			row.createCell(colNo).setCellValue(a.get(i));
						
		}
		 
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\DisplayBookShelves.xlsx");
		workbook.write(fo);		
		file.close();
		fo.close();

	}
	
	
}
