package com.jira.cloud.shasitest.connection.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jira.cloud.shasitest.entities.Issue;
import com.jira.cloud.shasitest.entities.IssuesResult;
import com.jira.cloud.shasitest.main.RunExport;

public class JiraMethodUtils extends JiraConnectionUtils {

	ObjectMapper mapper = new ObjectMapper();

	protected List<Issue> getIssuesByFilterId(String filterId) throws JsonParseException, JsonMappingException, IOException {

		int startAt = 0;
		int maxCount = 100;
		int total = 0;

		List<Issue> issuesList = new ArrayList<Issue>();
		do {
			String getURL = RunExport.jiraURL + "/rest/api/2/search?jql=filter=" + filterId + "&startAt=" + startAt + "&maxResults=" + maxCount;
			String response = jsonGetRequest(getURL);
			if(response == null)
				return null;
			IssuesResult issueResult = mapper.readValue(response, IssuesResult.class);
			if(issueResult == null)
				return null;

			total = issueResult.getTotal();
			startAt += maxCount;

			issuesList.addAll(issueResult.getIssues());
			System.out.println("Fetched Issues : " + issuesList.size());
		} while(total > maxCount);
		return issuesList; 
	}
}
