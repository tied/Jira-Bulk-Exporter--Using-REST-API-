# Jira-Bulk-Exporter--Using-REST-API-

An add on developed in JAVA using JIRA REST API capable of exporting bulk issues from JIRA.

JIRA server normally have a performance issue while quering for more number of issues(~9000 issues) in a single shot. This would almost bring the JIRA server down. Though these kind of situations is eradicated by configuring the maximum issues that can be returned in a single response, still we might end up in situation where we will not be able to fetch all the bulk records.

In order to resolve the above issue we can use this "Jira-Bulk-Exporter" developed using JIRA REST APi. Using this we can query for N no.of records while still maintainig the JIRA performance too.

This tool is also capable of bulk exporting all the issues into an excel file for the specified issue fields which can be used for migrating issues from one jira system to another.

A sample bulk excel export is available under Jira-Bulk-Exporter/export/JiraBulkExportIssues.xlsx

![Alt text](/JiraBulkExport/export/2017-01-09_23h27_10.png?raw=true "Bulk export sample")

Happy coding !! :smiley:
