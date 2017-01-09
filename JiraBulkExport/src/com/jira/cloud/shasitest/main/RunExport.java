package com.jira.cloud.shasitest.main;

import java.util.List;

import com.jira.cloud.shasitest.connection.methods.JiraMethods;
import com.jira.cloud.shasitest.entities.Issue;
import com.jira.cloud.shasitest.export.ExcelExportIssues;

public class RunExport {

	public static String jiraURL = "https://shasitest.atlassian.net";
	public static String filterId = "10000";

	public static String jiraUserName = "test";
	public static String jiraPassword = "test@123";

	public static void main(String[] args) {

		try {
			System.out.println("Bulk Export Begins..");
			JiraMethods jiraMethods = new JiraMethods();
			ExcelExportIssues exportToexcel = new ExcelExportIssues();

			System.out.println("Fetching all the issues..");
			List<Issue> issues = jiraMethods.getIssuesFromFilter(filterId);

			System.out.println("Exporting to excel..");
			exportToexcel.exportToExel(issues);

			System.out.println("Bulk Export completed..");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
