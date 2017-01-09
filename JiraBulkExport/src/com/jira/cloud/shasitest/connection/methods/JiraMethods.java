package com.jira.cloud.shasitest.connection.methods;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jira.cloud.shasitest.connection.utils.JiraMethodUtils;
import com.jira.cloud.shasitest.entities.Issue;

public class JiraMethods extends JiraMethodUtils{

	public List<Issue> getIssuesFromFilter(String filterId) throws JsonParseException, JsonMappingException, IOException {
		return getIssuesByFilterId(filterId);
	}
}
