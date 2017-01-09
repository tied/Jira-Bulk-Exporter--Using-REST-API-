package com.jira.cloud.shasitest.export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jira.cloud.shasitest.entities.Issue;

public class ExcelExportIssues {
	String FILE_NAME = "export/JiraBulkExportIssues.xlsx";

	public void exportToExel(List<Issue> issuesList) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Issues");

		int rowNum = 0;

		Row headerRow = sheet.createRow(rowNum++);
		int colNum = 0;
		Cell cellh1 = headerRow.createCell(colNum++);
		cellh1.setCellValue("S.No");

		Cell cellh2 = headerRow.createCell(colNum++);
		cellh2.setCellValue("Issue Key");

		Cell cellh3 = headerRow.createCell(colNum++);
		cellh3.setCellValue("Summary");

		Cell cellh4 = headerRow.createCell(colNum++);
		cellh4.setCellValue("Description");

		Cell cellh5 = headerRow.createCell(colNum++);
		cellh5.setCellValue("IssueType");

		Cell cellh6 = headerRow.createCell(colNum++);
		cellh6.setCellValue("Project");

		Cell cellh7 = headerRow.createCell(colNum++);
		cellh7.setCellValue("Resolution");

		Cell cellh8 = headerRow.createCell(colNum++);
		cellh8.setCellValue("Priority");

		Cell cellh9 = headerRow.createCell(colNum++);
		cellh9.setCellValue("Assignee");

		Cell cellh10 = headerRow.createCell(colNum++);
		cellh10.setCellValue("Status");

		Cell cellh11 = headerRow.createCell(colNum++);
		cellh11.setCellValue("Reporter");

		int sNo=1;

		for (Issue issue : issuesList) {
			Row contentRow = sheet.createRow(rowNum++);
			colNum=0;

			Cell cell1 = contentRow.createCell(colNum++);
			cell1.setCellValue(sNo);

			Cell cell2 = contentRow.createCell(colNum++);
			if(issue.getKey() != null && issue.getKey().length() > 0) {
				cell2.setCellValue(issue.getKey());
			} else {
				cell2.setCellValue("");
			}

			Cell cell3 = contentRow.createCell(colNum++);
			if(issue.getFields().getSummary() != null && issue.getFields().getSummary().length() > 0) {
				cell3.setCellValue(issue.getFields().getSummary());
			} else {
				cell3.setCellValue("");
			}

			Cell cell4 = contentRow.createCell(colNum++);
			if(issue.getFields().getDescription() != null && issue.getFields().getDescription().toString().length() > 0) {
				cell4.setCellValue(issue.getFields().getDescription().toString());
			} else {
				cell4.setCellValue("");
			}

			Cell cell5 = contentRow.createCell(colNum++);
			if(issue.getFields().getIssuetype() != null && issue.getFields().getIssuetype().getName().length() > 0) {
				cell5.setCellValue(issue.getFields().getIssuetype().getName());
			} else {
				cell5.setCellValue("");
			}

			Cell cell6 = contentRow.createCell(colNum++);
			if(issue.getFields().getProject() != null && issue.getFields().getProject().getName().toString().length() > 0) {
				cell6.setCellValue(issue.getFields().getProject().getName());
			} else {
				cell6.setCellValue("");
			}

			Cell cell7 = contentRow.createCell(colNum++);
			if(issue.getFields().getResolution() != null && issue.getFields().getResolution().getName().length() > 0) {
				cell7.setCellValue(issue.getFields().getResolution().getName());
			} else {
				cell7.setCellValue("");
			}

			Cell cell8 = contentRow.createCell(colNum++);
			if(issue.getFields().getPriority() != null && issue.getFields().getPriority().getName().length() > 0) {
				cell8.setCellValue(issue.getFields().getPriority().getName());
			} else {
				cell8.setCellValue("");
			}

			Cell cell9 = contentRow.createCell(colNum++);
			if(issue.getFields().getAssignee() != null && issue.getFields().getAssignee().getName().length() > 0) {
				cell9.setCellValue(issue.getFields().getAssignee().getName());
			} else {
				cell9.setCellValue("");
			}

			Cell cell10 = contentRow.createCell(colNum++);
			if(issue.getFields().getStatus() != null && issue.getFields().getStatus().getName().length() > 0) {
				cell10.setCellValue(issue.getFields().getStatus().getName());
			} else {
				cell10.setCellValue("");
			}

			Cell cell11 = contentRow.createCell(colNum++);
			if(issue.getFields().getReporter() != null && issue.getFields().getReporter().getName().length() > 0) {
				cell11.setCellValue(issue.getFields().getReporter().getName());
			} else {
				cell11.setCellValue("");
			}

			sNo++;

		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
