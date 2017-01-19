<%@ include file="/init.jsp" %>

<%

%>

<p>
	<b><liferay-ui:message key="tasks_web_TasksWeb.caption"/></b>
</p>

<liferay-ui:error key="Task with this name already exists for this project" message="Task with this name already exists for this project" />

<portlet:actionURL name="/task/update" var="updateTaskURL" />


<aui:form action="${updateTaskURL}" method="POST">

	<aui:input label="task-name" name="name" required="true" />

	<aui:input label="task-description" name="description" />

	<%--//TODO add form fields--%>
	<aui:button name="saveButton" primary="false" type="submit" value="update" />
</aui:form>