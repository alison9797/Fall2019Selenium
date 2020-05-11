package com.automation.tests.day25_excel_io;

import com.automation.tests.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;


public class ReadDataFromExcel {


    @Test
    //any kind of file operations provides exceptions
    public void readExcelFileTest() throws Exception {
        //we need to get a file as an object

        File file = new File("VytrackTestUsers.xlsx");

        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //to specify what spreadsheet(page ) in a file we need
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);


        int lastCell = firstRow.getLastCellNum();
        System.out.println("##############################");
        for (int i = 0; i <lastCell ; i++){
            System.out.println(firstRow.getCell(i) + " | ");

        }
        //returns indexes
        int numberOfRows = workSheet.getLastRowNum();
        //actual count of rows
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();
        System.out.println("\nNumber of rows: " + numberOfRows);

        System.out.println("\nActual count of rows: " + numberOfRows2);


        System.out.println("####################");
        //how to pring the whole spreadsheet

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.println(cellValue + " | ");
            }
            System.out.println();

        }
    }

    @Test
    public void excelUtilityTest(){

        String path = "VytrackTestUsers.xlsx";
        String spreadsheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadsheet);
        //                      shortcut for for each loop
        // or can do this way         (p -> System.out.println(p))
        //excelUtil.getDataList().forEach(System.out::println);


        //alternative way
        for (Map<String, String> record : excelUtil.getDataList() ){
            System.out.println(record);

        }

    }

    /**
     * this method returns a;; column names as a List of String
     */
    @Test
    public void getColumnNamesTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadsheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadsheet);

        System.out.println(excelUtil.getColumnsNames());

    }

}
