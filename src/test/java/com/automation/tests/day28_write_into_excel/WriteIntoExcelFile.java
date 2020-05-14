package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExcelFile {


    @Test
    public void  writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);
        //get physical number
        Cell cell = row.getCell(5);//last column


        System.out.println("Before: " + cell.getStringCellValue());
        cell.setCellValue("FAILED");//changing n/a to passed
        System.out.println("After : " + cell.getStringCellValue());

        Row firstRow = sheet.getRow(0);//get first row , index=0
        Cell newCell = firstRow.createCell(row.getLastCellNum());//to create new cell
        newCell.setCellValue("Date of Execution"); //give the name to this cell




        //write date and time info into second row, last column:
        Row secondRow = sheet.getRow(1);
        Cell newCell2 = secondRow.createCell(6);//to create a cell
        //to set current date and time info into new cell
        newCell2.setCellValue(LocalDateTime.now().toString());





        //create if I want to write smtg into the file
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        //don;t forget to close excel file if you opened it
        workbook.close();


    }

}
