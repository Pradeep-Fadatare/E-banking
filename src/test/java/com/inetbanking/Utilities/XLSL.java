package com.inetbanking.Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class XLSL {

    @Test
    @DataProvider(name = "ebanking")
    public Object[][] getit(Method m) throws IOException {
        String sheetname=m.getName();
        File file=new File("C:\\Users\\91956\\IdeaProjects\\FirstProject\\src\\test\\java\\com\\inetbanking\\Utilities\\TestData.XLSX");
        FileInputStream fis=new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet=wb.getSheet(sheetname);

        int totalrows=sheet.getLastRowNum();
        System.out.println(totalrows);
        int cellno=sheet.getRow(0).getLastCellNum();
        System.out.println(cellno);

        DataFormatter dataFormatter=new DataFormatter();
        String testdata[][]=new String[totalrows][cellno];
        for(int i=1;i<=totalrows;i++){
            for (int j=0;j<cellno;j++){
                testdata [i-1][j]=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(testdata[i-1][j]);
            }
        }
        return testdata;
    }


}
