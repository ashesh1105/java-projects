package service;

import models.CodeReviewData;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelDataFileIO {

    public static List<List<String>> getCsvData(String fileName, String delimiter) {

        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("book.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static XSSFWorkbook getExcelData(String fileName) {
        URL url = ExcelDataFileIO.class
                .getClassLoader()
                .getResource(fileName);

        File file = new File(url.getPath());
        XSSFWorkbook wb = null;
        FileInputStream fis = null;   //obtaining bytes from the file
        try {
            fis = new FileInputStream(file);
            //creating Workbook instance that refers to .xlsx file
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
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
