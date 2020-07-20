import models.CodeReviewData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.ExcelDataFileIO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateFisheyeReport {

    private TestDB testDB = new TestDB();
    private ExcelDataFileIO excelDataFileIO = new ExcelDataFileIO();

    public static void main(String[] args) {

        List<CodeReviewData> codeReviewDataAll = new ArrayList<>();

        GenerateFisheyeReport fisheyeReportData = new GenerateFisheyeReport();

        fisheyeReportData.populateData(codeReviewDataAll);

        // ToDO: Remove below print statement after testing
//        codeReviewDataAll.forEach(e -> {
//            System.out.println(e.getProject()
//                    + " | " + e.getVersion()
//                    + " | " + e.getJiraTicketNumber()
//                    + " | " + e.getJiraType()
//                    + " | " + e.getGetJiraTicketSummaryText()
//                    + " | " + e.getCrucibleId()
//                    + " | " + e.getAuthor()
//                    + " | " + e.getReviewers()
//                    + " | " + e.getReviewDescription()
//                    + " | " + e.getStatus()
//                    + " | " + e.getReviewDate());
//        });

        fisheyeReportData.generateCodeReviewReport(codeReviewDataAll);
    }

    private void generateCodeReviewReport(List<CodeReviewData> codeReviewDataAll) {
        excelDataFileIO.generateExcelFile(codeReviewDataAll);
    }

    private void populateData(List<CodeReviewData> codeReviewDataAll) {

        try {
            XSSFWorkbook wb = ExcelDataFileIO.getExcelData("Jira_CodeReviewReport.xlsx");
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file

//            int counter = 0;
            boolean isHeader = true;

            while (itr.hasNext()) {


                Row row = itr.next();
                Cell projectCell = row.getCell(0);
                Cell versionCell = row.getCell(1);
                Cell jiraTicketNumberCell = row.getCell(2);
                Cell jiraTypeCell = row.getCell(3);
                Cell jiraTicketSummaryTextCell = row.getCell(4);

                CodeReviewData codeReviewData = new CodeReviewData();

                codeReviewData.setProject(projectCell.getStringCellValue());
                codeReviewData.setVersion(versionCell.getStringCellValue());
                codeReviewData.setJiraTicketNumber(jiraTicketNumberCell.getStringCellValue());
                codeReviewData.setJiraType(jiraTypeCell.getStringCellValue());
                codeReviewData.setGetJiraTicketSummaryText(jiraTicketSummaryTextCell.getStringCellValue());

                // Set headers if i is top row, else, fetch Fisheye data from the DB
                if (isHeader) {
                    codeReviewData.setCrucibleId("Crucible ID");
                    codeReviewData.setAuthor("Author");
                    codeReviewData.setReviewers("Reviewers");
                    codeReviewData.setReviewDescription("Review Description");
                    codeReviewData.setStatus("Status");
                    codeReviewData.setReviewDate("Review Date");

                    // Make sure to add the header row
                    codeReviewDataAll.add(codeReviewData);
                    isHeader = false;
                } else {
                    List<CodeReviewData> fishEyeData = testDB.getFishEyeData(codeReviewData);

                    // Jira ticket which do not have reviews don't need to be on report
                    for (CodeReviewData crData : fishEyeData) {
                        if (crData.getAuthor() != null && crData.getReviewers() != null) {
                            codeReviewDataAll.add(crData);
                        }
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } finally {
            // Make sure to close PostreSQL DB Connection once done with code run
            TestDB.closeConnection();
        }
    }
}
