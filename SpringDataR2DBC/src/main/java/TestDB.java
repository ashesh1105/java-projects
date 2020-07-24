import models.CodeReviewData;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


// ToDO:
// 1) Change the SQL query to Batch Query where Fisheye data for entire Code Review Report can be pulled in one shot.
// 2) Spring Data Batch SQL set up will help.
public class TestDB {

    private static Connection conn = null;

    public List<CodeReviewData> getFishEyeData(CodeReviewData codeReviewData) {

        Statement st1 = null;
        Statement st2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;

        int cruReview_id;
        int cruCreator;
        String author_id;
        String author;
        String cruName;
        String cruDescription;
        String reviewDate;

        String sql1, sql2;
        Set<String> reviewers = null;

        // We may have multiple reviews per Jira ticket
        List<CodeReviewData> result = new ArrayList<>();

        try {

            if (conn == null) {
                System.out.println("Need to create connection to PostgreSQL for this code run. Proceeding to create it.");
                setConnection();
            }

            st1 = conn.createStatement();

            sql1 = "Select A.cru_review_id, A.cru_creator, B.cru_user_name, " +
                    "concat_ws(' ', C.first_name, C.last_name) as Author, " +
                    "A.cru_name, A.cru_description, to_char(TO_TIMESTAMP(A.cru_create_date/1000), 'YYYY-MM-DD')" +
                    " as \"Review Date\"\n" +
                    "From cru_review A \n" +
                    "Inner Join cru_user B on A.cru_creator = B.cru_user_id\n" +
                    "Inner Join cwd_user C on B.cru_user_name = C.user_name\n" +
                    "Where A.cru_name like '%" + codeReviewData.getJiraTicketNumber() + "%';";

            rs1 = st1.executeQuery(sql1);

            while (rs1.next()) {

                cruReview_id = rs1.getInt(1);
                author = rs1.getString(4);
                cruName = rs1.getString(5);
                reviewDate = rs1.getString(7);

                sql2 = "Select concat_ws(' ', C.first_name, C.last_name) as Reviewers " +
                        "From cru_review_participant A " +
                        "Inner Join cru_user B on A.cru_user = B.cru_user_id " +
                        "Inner Join cwd_user C on B.cru_user_name = C.user_name " +
                        "Where A.cru_review_id = " + cruReview_id + " " +
                        "And A.cru_author = " + false;
                st2 = conn.createStatement();
                rs2 = st2.executeQuery(sql2);
                reviewers = new LinkedHashSet<String>();
                String reviewer;

                while (!rs2.isClosed() && rs2.next()) {
                    reviewer = rs2.getString(1);
                    reviewers.add(reviewer);
                }

                // TODO: Optimize below code to concatenate reviewers
                String temp = "";
                int len = reviewers.size();
                String [] emptyArr = new String[len];
                String [] arr = reviewers.toArray(emptyArr);

                // Get comma separated list of reviewers
                for (int i=0; i<arr.length; i++) {
                    if (i == arr.length - 1) {
                        temp += arr[i];
                    } else {
                        temp += arr[i];
                        temp += ", ";   // Mary Beth suggestion Dtd 7/23/2020: comma + one space between reviewers
                    }
                }

                CodeReviewData resultObj = new CodeReviewData();

                // Get a copy of passed object and populate Fisheye Data in it
                resultObj.setProject(codeReviewData.getProject());
                resultObj.setVersion(codeReviewData.getVersion());
                resultObj.setJiraTicketNumber(codeReviewData.getJiraTicketNumber());
                resultObj.setJiraType(codeReviewData.getJiraType());
                resultObj.setGetJiraTicketSummaryText(codeReviewData.getGetJiraTicketSummaryText());

                // TODO: Not able to fetch CrucibleId from DB as of now. Find a solve for it
//                resultObj.setCrucibleId("Unknown");
                resultObj.setAuthor(author);
                resultObj.setReviewers(temp);
                resultObj.setReviewDescription(cruName);

                // Status is always "Accepted" in the report
                resultObj.setStatus("Accepted");
                resultObj.setReviewDate(reviewDate);

                result.add(resultObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st1 != null) {
                    st1.close();
                }
                if (st2 != null) {
                    st2.close();
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private void setConnection() {

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test");
            Class.forName("org.postgresql.Driver");
            System.out.println("Connection to PostgreSQL created successfully! Proceeding with DB Fetch.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Make sure to call this in the app once done with DB Operations
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
