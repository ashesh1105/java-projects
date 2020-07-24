package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeReviewData {

    private String project;
    private String version;
    private String jiraTicketNumber;
    private String jiraType;
    private String getJiraTicketSummaryText;
//    private String crucibleId;
    private String author;
    private String reviewers;
    private String reviewDescription;
    private String status;
    private String reviewDate;
}
