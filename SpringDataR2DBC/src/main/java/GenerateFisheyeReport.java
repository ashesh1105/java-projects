import models.CodeReviewData;
import service.CsvDataFileIO;
import service.ExcelDataFileIO;

import java.util.ArrayList;
import java.util.List;

public class GenerateFisheyeReport {

    private TestDB testDB = new TestDB();
    private ExcelDataFileIO excelDataFileIO = new ExcelDataFileIO();

    public static void main(String[] args) {

        List<CodeReviewData> codeReviewDataAll = new ArrayList<>();

        GenerateFisheyeReport fisheyeReportData = new GenerateFisheyeReport();

        fisheyeReportData.populateData(codeReviewDataAll);

        fisheyeReportData.generateCodeReviewReport(codeReviewDataAll);
    }

    private void generateCodeReviewReport(List<CodeReviewData> codeReviewDataAll) {
        excelDataFileIO.generateExcelFile(codeReviewDataAll);
    }

    private void populateData(List<CodeReviewData> codeReviewDataAll) {

        try {

            List<List<String>> jiraCodeReviewReportsData = CsvDataFileIO.getCsvData("report.csv", ",");

            int counter = 0;
            boolean isHeader = true;

            while (counter < jiraCodeReviewReportsData.size()) {

                List<String> rowData = jiraCodeReviewReportsData.get(counter);
                CodeReviewData codeReviewData = new CodeReviewData();

                codeReviewData.setProject(rowData.get(0));
                codeReviewData.setVersion(rowData.get(1));
                codeReviewData.setJiraTicketNumber(rowData.get(2));
                codeReviewData.setJiraType(rowData.get(3));
                codeReviewData.setGetJiraTicketSummaryText(rowData.get(4));

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
                counter++;
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
