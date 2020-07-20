package service;

import models.CodeReviewData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataFileIO {

    // If source Jira Report to read is in Excel format, use this method
    // Ensure there's file with name "report.xlsx" available under resources folder
    public static List<List<String>> getExcelData(String fileName) {

        URL url = ExcelDataFileIO.class
                .getClassLoader()
                .getResource(fileName);

        if (url == null) throw new RuntimeException("Could not create URL object with specified file name "
                + fileName + ". Make sure the file is available at src/main/resources folder in Java app.");

        File file = new File(url.getPath());
        XSSFWorkbook wb = null;
        FileInputStream fis = null;   //obtaining bytes from the file

        List<List<String>> excelData = new ArrayList<>();

        try {
            fis = new FileInputStream(file);
            //creating Workbook instance that refers to .xlsx file
            wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file

            while (itr.hasNext()) {

                List<String> rowData = new ArrayList<>();

                Row row = itr.next();
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                Cell cell3 = row.getCell(2);
                Cell cell4 = row.getCell(3);
                Cell cell5 = row.getCell(4);

                rowData.add(cell1.getStringCellValue());
                rowData.add(cell2.getStringCellValue());
                rowData.add(cell3.getStringCellValue());
                rowData.add(cell4.getStringCellValue());
                rowData.add(cell5.getStringCellValue());

                excelData.add(rowData);

                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return excelData;
    }

    public void generateExcelFile(List<CodeReviewData> codeReviewDataList) {

        //Creating a Work Book
        XSSFWorkbook workbook = new XSSFWorkbook();

        // First row will be headers. We need at least 1 data row to do anything
        if (codeReviewDataList == null || codeReviewDataList.size() <= 1) return;

        //Creating a Spread Sheet
        XSSFSheet spreadsheet = workbook.createSheet(codeReviewDataList.get(1).getVersion());

        XSSFRow row;
        XSSFCell cell;

        int size = codeReviewDataList.size();
        int rowNum = 0;

        for (CodeReviewData crData : codeReviewDataList) {

            // Create row
            row = spreadsheet.createRow(rowNum++);

            // Create cells
            int cellNum = 0;

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getProject());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getVersion());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getJiraTicketNumber());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getJiraType());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getGetJiraTicketSummaryText());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getCrucibleId());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getAuthor());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getReviewers());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getReviewDescription());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getStatus());

            cell = row.createCell(cellNum++);
            cell.setCellValue(crData.getReviewDate());
        }

        try {
//            URL url = FileIO.class.getClassLoader().getResource("report.xlsx");
            FileOutputStream out = new FileOutputStream(
              new File("SpringDataR2DBC/src/main/resources/code_review_reports/CodeReviewReport.xlsx"));

            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
