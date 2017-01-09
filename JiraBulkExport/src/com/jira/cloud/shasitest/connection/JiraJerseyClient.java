package com.jira.cloud.shasitest.connection;

import com.jira.cloud.shasitest.main.RunExport;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class JiraJerseyClient {
	Client client = null;

	public Client getClient() {
		return client;
	}

	public JiraJerseyClient() {
		client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter(RunExport.jiraUserName, RunExport.jiraPassword));
	}

}
