package page;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;


public class Utils {
    static String[][] getTestData() throws IOException {
        String[][] data = null;
        Workbook book = WorkbookFactory.create(new File("src/main/resources/data.xlsx"));
        Sheet sheet = book.getSheet("Customer");
        int numRows = sheet.getLastRowNum(); // 0 based
        int numCols = sheet.getRow(0).getLastCellNum(); // 1 based
        data = new String[numRows + 1][numCols];
        for (int i = 0; i <= numRows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < numCols; j++) {
                Cell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }

        book.close();
        return data;
    }


    static String[][] getTestDataDay5() {
        String[][] result = {
                {"mngr193327","AsYvyhU","t"},
                {"invalid","AsYvyhU","f"},
                {"mngr193327","invalid","f"},
                {"invalid","invalid","f"}
        };

        return result;
    }
}
