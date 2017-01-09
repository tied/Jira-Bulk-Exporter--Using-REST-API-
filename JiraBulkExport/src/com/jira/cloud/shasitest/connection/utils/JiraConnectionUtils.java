package com.jira.cloud.shasitest.connection.utils;

import com.jira.cloud.shasitest.connection.JiraJerseyClient;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

class JiraConnectionUtils {
	Client shasiJiraClient = new JiraJerseyClient().getClient();

	public String jsonGetRequest(String getUrl) {

		WebResource webResource = shasiJiraClient.resource(getUrl);

		ClientResponse response = webResource.accept("application/json")
				.get(ClientResponse.class);

		/*if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}*/
		return response.getEntity(String.class);
	}
}
