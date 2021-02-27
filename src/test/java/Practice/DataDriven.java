package Practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class DataDriven {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/maryannroshani/Desktop/Demodata.xlsx");
        XSSFWorkbook excelSheet = new XSSFWorkbook(fileInputStream);
        int sheets = excelSheet.getNumberOfSheets();
        for(int i = 0; sheets>i; i++)
        {
            if(excelSheet.getSheetName(i).equalsIgnoreCase("Sheet1"))
            {
                XSSFSheet sheet = excelSheet.getSheetAt(i);
                Iterator<Row>  rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator();
//                cell.next();
                int k =0;
                int column = 0;
                while (cell.hasNext())
                {
                    Cell value = cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Data1"))
                    {
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);
            }
        }
    }
}
