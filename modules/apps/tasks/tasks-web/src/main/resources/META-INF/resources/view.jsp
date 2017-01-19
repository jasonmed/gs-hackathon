<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.model.Organization" %>
<%@ page import="com.liferay.gs.hack.tasks.web.portlet.ClientProjectProviderUtil" %>
<%@ page import="java.util.List" %>

<%
List<Organization> clients = ClientProjectProviderUtil.getAllClients();
%>

<liferay-ui:error key="Task with this name already exists for this project" message="Task with this name already exists for this project" />

<portlet:actionURL name="/task/update" var="updateTaskURL" />


<aui:form action="${updateTaskURL}" method="POST">
	<aui:select label="select-a-client" name="clientId" required="true" showEmptyOption="true">

	<%
	for(Organization client : clients) {
	%>

		<aui:option label="<%= client.getName() %>" value="<%= client.getOrganizationId() %>" />

	<%
	}
	%>

	</aui:select>

	<aui:select label="select-a-project" name="projectId" required="true" showEmptyOption="false" />
	
	<aui:input label="task-name" name="name" required="true" />

	<aui:input label="task-description" name="description" />

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
						clientId: ct.attr('value')
					},
					function(data) {
						data.forEach(
							function(item) {
								var option = A.Node.create('<option/>');
								
								option.text(item.name);
								option.val(item.organizationId);
								
								option.appendTo(projectIdSelect);
							}
						);
					}
				);
			}
		}
	);
</aui:script>
