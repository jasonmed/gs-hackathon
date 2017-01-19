<%@ page import="com.liferay.gs.hack.clients.model.Client" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>

<%
	List<Client> allClients = (List<Client>)request.getAttribute("clientList");

%>

<portlet:actionURL name="/project/update" var="updateProjectURL" />


<aui:form action="${updateProjectURL}" method="POST">

	<aui:input label="project-name" name="projectName" required="true" />

	<%--//TODO add form fields--%>
	<aui:button name="saveButton" primary="false" type="submit" value="update" />
</aui:form>