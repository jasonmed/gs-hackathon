<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="client_project_registration_ClientProjectRegistration.caption"/></b>
</p>

<%
Project dumpProject = null;

int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

int projectsCount = (int)request.getAttribute("projectsCount");
List<Project> activeProjects = (List<Project>)request.getAttribute("activeProjects");

PortletURL iteratorURL = renderResponse.createRenderURL();

iteratorURL.setParameter("cur", String.valueOf(cur));
%>

<portlet:renderURL var="portletURL">
	<portlet:param name="mvcRenderCommandName" value="/project/view" />
</portlet:renderURL>

<liferay-ui:search-container
	compactEmptyResultsMessage="<%= false %>"
	delta="<%= delta %>"
	deltaConfigurable="true"
	emptyResultsMessage="No Results found."
	iteratorURL="<%= iteratorURL %>"
	total="<%= projectsCount %>"
>
	<liferay-ui:search-container-results
		results="<%= activeProjects %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.gs.hack.projects.model.Project"
		escapedModel="<%= true %>"
		keyProperty="projectId"
		modelVar="project"
	>
		<c:set scope="request" value="<%= String.valueOf(project.getProjectId()) %>" var="projectId" />

		<portlet:renderURL var="editProjectURL">
			<portlet:param name="mvcRenderCommandName" value="/project/edit/view" />
			<portlet:param name="projectId" value="<%= String.valueOf(project.getProjectId()) %>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			name="project.name"
		>
			<aui:a href="<%= editProjectURL.toString() %>">
				<%= project.getName() %>
			</aui:a>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="project.startDate"
		>
			<%= Validator.isNull(project.getStartDate()) ? "-" : dateFormatDate.format(project.getStartDate()) %>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="project.endDate"
		>
			<%= Validator.isNull(project.getEndDate()) ? "-" : dateFormatDate.format(project.getEndDate()) %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		markupView="lexicon"
		searchContainer="<%= searchContainer %>"
	/>
</liferay-ui:search-container>