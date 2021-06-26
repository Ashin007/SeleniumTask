package ExcelUtil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelUtility {

    //first identify the column by scanning the entire row
    //then identify all the element in the column- cell



    public ArrayList<String> getColumnData(String path, String Sheet, String columnName) throws IOException {
        ArrayList<String> data = new ArrayList<String>();
        FileInputStream fin = new FileInputStream(path);
        XSSFWorkbook wbook = new XSSFWorkbook(fin);
        int sheetNumber = wbook.getNumberOfSheets();
        XSSFSheet sheet = null;
        int k=0;
        int column;
        for (int i = 0; i < sheetNumber; i++) {
            if (wbook.getSheetName(i).equalsIgnoreCase(Sheet)) {
                sheet = wbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();//sheet is collections of rows
                    Row firstRow = rows.next();
                  Iterator<Cell> cellIterator = firstRow.cellIterator();//row is the collections of cells
                  while (cellIterator.hasNext()){
                      Cell cell = cellIterator.next();
                      if(cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                          column = k;
                          System.out.println(k);
                          while(rows.hasNext()){
                              Row row = rows.next();
                              if(row.getCell(column).getCellType()==CellType.STRING){

                                  data.add(row.getCell(column).getStringCellValue());
                              }
                              else{
                                  data.add(NumberToTextConverter.toText(row.getCell(column).getNumericCellValue()));
                              }
                          }
                      }
                      k++;
                  }
                }
            }
        return data;

    }
}
