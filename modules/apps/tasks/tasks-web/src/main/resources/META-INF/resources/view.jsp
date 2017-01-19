<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.model.Organization" %>
<%@ page import="com.liferay.gs.hack.tasks.web.portlet.ClientProjectProviderUtil" %>
<%@ page import="java.util.List" %>

<%
List<Organization> clients = ClientProjectProviderUtil.getAllClients();
%>

<p>
	<b><liferay-ui:message key="tasks_web_TasksWeb.caption"/></b>
</p>

<liferay-ui:error key="Task with this name already exists for this project" message="Task with this name already exists for this project" />

<portlet:actionURL name="/task/update" var="updateTaskURL" />


<aui:form action="${updateTaskURL}" method="POST">

	<aui:input label="task-name" name="name" required="true" />

	<aui:input label="task-description" name="description" />

	<aui:select label="select-a-client" name="clientId" required="true" showEmptyOption="false">

	<%
		for(Organization client : clients) {
	%>

	<aui:option label="<%= client.getName() %>" value="<%= client.getOrganizationId() %>" />

	<%
		}
	%>

	</aui:select>

	<aui:select label="select-a-project" name="projectId" required="true" showEmptyOption="false" />

	<aui:button name="saveButton" primary="false" type="submit" value="update" />
</aui:form>

<aui:script use="aui-base,event-valuechange">
	var clientIdSelect = A.one('#<portlet:namespace/>clientId');
	var projectIdSelect = A.one('#<portlet:namespace/>projectId');
		
	clientIdSelect.on(
		'valuechange',
		function(event) {
			var ct = event.currentTarget;
			
			if (event.newVal != event.prevVal){
				projectIdSelect.all('option').remove();
				
				Liferay.Service(
					'/ps.projecttask/get-all-projects',
					{
						companyId: themeDisplay.getCompanyId(),
						clientId: ct.attr('value');
					},
					function(data) {
						var option = A.Node.create('<option/>');

						console.log(data);
					}
				);
			}
		}
	);
</aui:script>
