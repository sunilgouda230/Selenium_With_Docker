package helper;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static XSSFWorkbook wb;

    public static Object[][] getDataFromSheet(String sheetName){
        System.out.println("************ Loading From Sheet **********************");

        Object [] [] arr = null;

        try {
            wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/TestData.xlsx")));
            XSSFSheet sheet = wb.getSheet(sheetName);
            int row = sheet.getPhysicalNumberOfRows();
            int column = sheet.getRow(0).getPhysicalNumberOfCells();
            arr = new Object[row-1][column];

            for (int i = 1; i < row; i++) {

                for (int j = 0; j < column; j++) {

                    arr[i-1][j] = getData(sheetName,i,j);
                 }
            }

        } catch (IOException e){
            System.out.println("could not load th file"+e.getMessage());
        }

        return arr;

    }

    public static String  getData(String sheetName, int row, int coloum) {

        XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(coloum);

        String data = "";

        if (cell.getCellType() == CellType.NUMERIC) {
            double dataInDouble = cell.getNumericCellValue();
            data = String.valueOf(dataInDouble);
        } else if (cell.getCellType() == CellType.BLANK) {
            data = "";
        } else if (cell.getCellType() == CellType.STRING) {
            data = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            boolean dataInBool = cell.getBooleanCellValue();
            data = String.valueOf(dataInBool);
        }

        return data;

    }

}
