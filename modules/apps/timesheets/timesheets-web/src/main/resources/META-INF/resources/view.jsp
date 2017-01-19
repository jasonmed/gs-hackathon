<%@ include file="/init.jsp" %>

<%
List<Organization> userOrganizations = OrganizationLocalServiceUtil.getUserOrganizations(themeDisplay.getUserId());

for (Organzation userOrganization : userOrganizations) {
	System.out.println(userOrganization.getName());
}
%>


<aui:form>
<%
SearchFacet searchFacet = (SearchFacet)request.getAttribute("facet_configuration.jsp-searchFacet");

JSONObject dataJSONObject = searchFacet.getData();

JSONArray rangesJSONArray = dataJSONObject.getJSONArray("ranges");
%>

<aui:fieldset id='<%= renderResponse.getNamespace() + "rangesId" %>'>

	<%
	int[] rangesIndexes = new int[rangesJSONArray.length()];

	for (int i = 0; i < rangesJSONArray.length(); i++) {
		rangesIndexes[i] = i;
	%>

		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields flex-container">
				<aui:select cssClass="client-container" name='<%= "client_" + i %>'>
					<aui:option label="<%= client.getName() %>" value="<%= client.getOrganizationId() %>" />
				</aui:select>
				
				<aui:select cssClass="project-container" name='<%= "project_" + i %>'>
					<%
					for (Organzation project : projects) {
						Map<String, String> projectOptionData = new HashMap<String, String>();
						
						projectOptionData.put("parent-organization-id", String.valueOf(project.getParentOrganizationId()));
					%>
						<aui:option data="<%= projectOptionData %>" label="<%= project.getName() %>" value="<%= project.getOrganizationId() %>" />
					<%
					}
					%>
				</aui:select>
				
				<aui:select cssClass="task-container" name='<%= "task_" + i %>'>
					<%
					for (Task task : tasks) {
						Map<String, String> taskData = new HashMap<String, String>();
						
						taskData.put("parent-organization-id", String.valueOf(task.getParentOrganizationId()));
					%>
						<aui:option data="<%= taskData %>" label="<%= task.getName() %>" value="<%= task.getTaskId() %>" />
					<%
					}
					%>
				</aui:select>
				
				
				<aui:input name='<%= "day0_" + i %>' type="text" value="<%= task.getDay0() %>" />
				
				<aui:input name='<%= "day1_" + i %>' type="text" value="<%= task.getDay1() %>" />
				
				<aui:input name='<%= "day2_" + i %>' type="text" value="<%= task.getDay2() %>" />
				
				<aui:input name='<%= "day3_" + i %>' type="text" value="<%= task.getDay3() %>" />
				
				<aui:input name='<%= "day4_" + i %>' type="text" value="<%= task.getDay4() %>" />
			</div>
		</div>

	<%
	}
	%>

	<aui:input name="rangesIndexes" type="hidden" value="<%= StringUtil.merge(rangesIndexes) %>" />
</aui:fieldset>

</aui:form>

<aui:script use="aui-base,liferay-auto-fields,event-valuechange">
	var clientContainer = A.all('.client-container');
	var projectContainer = A.all('.project-container')
	
	clientContainer.on(
		'valuechange',
		function(event) {
			var ct = event.currentTarget;
			var siblingProjectContainer = ct.siblings('.project-container');
			var val = event.newVal;
			
			if (siblingProjectContainer) {
				siblingProjectContainer.all('option').each(
					function(option) {
						option.show();

						if (option.attr('data-parent-organization-id') != val) {
							option.hide()
						}
					}
				);
			}
		}
	);
	
	projectContainer.on(
		'valuechange',
		function(event) {
			var ct = event.currentTarget;
			var siblingTaskContainer = ct.siblings('.task-container');
			var val = event.newVal;
			
			if (siblingTaskContainer) {
				siblingTaskContainer.all('option').each(
					function(option) {
						option.show();

						if (option.attr('data-parent-organization-id') != val) {
							option.hide()
						}
					}
				);
			}
		}
	);
	
	var autoFields = new Liferay.AutoFields(
		{
			contentBox: 'fieldset#<portlet:namespace />rangesId',
			fieldIndexes: '<portlet:namespace />rangesIndexes',
			namespace: '<portlet:namespace />'
		}
	).render();
</aui:script>
