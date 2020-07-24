import models.CodeReviewData;
import service.CsvDataFileIO;
import service.ExcelDataFileIO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenerateFisheyeReport {

    private TestDB testDB = new TestDB();
    private ExcelDataFileIO excelDataFileIO = new ExcelDataFileIO();

    public static void main(String[] args) {

        List<CodeReviewData> codeReviewDataAll = new ArrayList<>();

        GenerateFisheyeReport fisheyeReportData = new GenerateFisheyeReport();

        fisheyeReportData.populateData(codeReviewDataAll);

        /**
         * Updates in Report based on suggestions from Glooko Regulatory on July 23, 2020:
         * 1) Sort the Report based on Review Date: Oldest first
         * 2) Add comma + a space instead of just comma between reviewers (addressed in TestDB)
         * 3) Remove quotes around Jira Type and Jira Ticket Summary Text (Original script bug that pull Jira Report now)
         *    (Addressed in populate data method of this file)
         * 4) Only Date needed on Review Date and not time (Addressed with Query in TestDB)
         * 5) Change Column names Jira Ticket Number -> Jira #, Jira Type -> Type, Jira ticket summary text -> Summary.
         * 6) Columns Project and Version not needed (Addressed in ExcelDataFileIO.generateExcelFile() method).
         */
        // 1) Sort the report based on Review Date, oldest to most recent
        // Exclude header row for sorting
        CodeReviewData header = codeReviewDataAll.remove(0);
        Collections.sort(codeReviewDataAll, Comparator.comparing(CodeReviewData::getReviewDate));

        // 5) Change Column names Jira Ticket Number -> Jira #, Jira Type -> Type, Jira ticket summary text -> Summary.
        header.setJiraTicketNumber("Jira #");
        header.setJiraType("Type");
        header.setGetJiraTicketSummaryText("Summary");

        codeReviewDataAll.add(0, header);

        // Finally, generate the excel report
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

                // Remove double quotes around Type data - suggestions from Mary Beth on 07/23/2020
                String type = rowData.get(3);
                type = type.replace("\"", "");
                codeReviewData.setJiraType(type);

                // Remove double quotes around Summary data - suggestions from Mary Beth on 07/23/2020
                String summary = rowData.get(4);
                summary = summary.replace("\"", "");
                codeReviewData.setGetJiraTicketSummaryText(summary);

                // Set headers if i is top row, else, fetch Fisheye data from the DB
                if (isHeader) {
//                    codeReviewData.setCrucibleId("Crucible ID");
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
