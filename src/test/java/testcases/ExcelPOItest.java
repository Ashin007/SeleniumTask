package testcases;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelPOItest {

    public void getSheetData() throws IOException {
        FileInputStream fin = new FileInputStream("C:\\Users\\ashin\\Desktop\\sample_data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fin);
        int sheetNumber = workbook.getNumberOfSheets();
        XSSFSheet sheet = null;
        System.out.println(sheetNumber);
        for (int i = 0; i < sheetNumber; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
                sheet = workbook.getSheetAt(i);
                break;
            }
        }

        Iterator<Row> row = sheet.iterator();
        while (row.hasNext()) {
            Row firstRow = row.next();//first row
            Iterator<Cell> cell = firstRow.cellIterator();
            while (cell.hasNext()) {
                Cell value = cell.next();
                if (value.getCellType() == CellType.STRING) {
                    System.out.println(value.getStringCellValue());
                } else {
                    System.out.println(NumberToTextConverter.toText(value.getNumericCellValue()));
                }
            }


        }
    }

    @Test
    public void myData() throws IOException {
        ArrayList<String> data;
        ArrayList<String> beta;
        data = getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx","UFC","Email");
        beta = getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx","UFC","Pssword");
        for (String datya:beta){
            System.out.println(datya);
        }
    }

    public ArrayList<String> getColumnData(String path, String Sheet, String columnName) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        FileInputStream fin = new FileInputStream(path);
        XSSFWorkbook wbook = new XSSFWorkbook(fin);
        int sheetNumber = wbook.getNumberOfSheets();
        XSSFSheet sheet = null;
        for (int i = 0; i < sheetNumber; i++) {
            if (wbook.getSheetName(i).equalsIgnoreCase(Sheet)) {
                sheet = wbook.getSheetAt(i);
                break;
            }
        }

        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();
        Iterator<Cell> cell = firstRow.cellIterator();
        int i = 0;
        int column = 0;
        while (cell.hasNext()){
            Cell value = cell.next();
            if (value.getStringCellValue().equalsIgnoreCase(columnName)){
                column=i;
            }
            i++;
        }

        while (rows.hasNext()){

            Row row = rows.next();
            Iterator<Cell> cel = row.cellIterator();
            while (cel.hasNext()){
                Cell val = cel.next();
                if (val.getCellType()==CellType.STRING){
                    list.add(row.getCell(column).getStringCellValue());
                }
                else{

                }
            }

        }

        return list;
    }

}