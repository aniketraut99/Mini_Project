package com.aniket.Utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelReader {
    public static final String excel_path = "src/test/resources/TestData1.xlsx";
    
    public static String getData(String scenarioName,String columnName){
        try {
            FileInputStream fis = new FileInputStream(excel_path);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet s= workbook.getSheet("Sheet1");
            Row headerRow = s.getRow(0);    //1st row for header

            Map<String, Integer> columnMap = new HashMap<>();
            for(Cell cell : headerRow){
                columnMap.put(cell.getStringCellValue().trim().toLowerCase(), cell.getColumnIndex());
            }

                // Loop through rows to find the matching scenario name
            for(int i = 1;i<=s.getLastRowNum();i++){
                Row row = s.getRow(i);
                if (row==null) continue;

                Cell scenarioCell = row.getCell(0);
                if(scenarioCell==null) continue;

                String currentScenario = scenarioCell.getStringCellValue().trim();
                if(currentScenario.equalsIgnoreCase(scenarioName)){
                    int colIndex = columnMap.get(columnName.toLowerCase());
                    Cell targetCell = row.getCell(colIndex);
                    return getCellValueAsString(targetCell);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    private static String getCellValueAsString(Cell cell) {
        if(cell==null) return "";
        switch (cell.getCellType()){
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            default: return "";
        }
    }

}
