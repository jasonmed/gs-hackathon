<%@ include file="/init.jsp" %>

<liferay-ui:tabs names="comments,approval-details">
	<liferay-ui:section>
		<table>
			<tr>
				<th><liferay-ui:message key="date"/></th>
				<th><liferay-ui:message key="client-project-task"/></th>
				<th><liferay-ui:message key="duration"/></th>
				<th><liferay-ui:message key="comment"/></th>
			</tr>
			<c:forEach items="${timesheetTaskDurations}" var="taskDuration">
				<tr>
					<td><fmt:formatDate pattern="MMM dd, yyyy" value="${taskDuration.taskDate}"/></td>
					<td>${}</td>
					<td>${taskDuration.duration}</td>
					<td>${taskDuration.comment}</td>
				</tr>
			</c:forEach>
		</table>
	</liferay-ui:section>
	<liferay-ui:section>
		<table>
			<tr>
				<th><liferay-ui:message key="user"/></th>
				<th><liferay-ui:message key="status"/></th>
				<th><liferay-ui:message key="date"/></th>
				<th><liferay-ui:message key="comment"/></th>
			</tr>
			<c:forEach items="${timesheetApprovals}" var="approval">
				<tr>
					<td>${approval.userName}</td>
					<td>${approval.status}</td>
					<td><fmt:formatDate pattern="MMM dd, yyyy hh:mm:ss aa" value="${approval.createDate}"/></td>
					<td>${approval.comment}</td>
				</tr>
			</c:forEach>
		</table>
	</liferay-ui:section>
</liferay-ui:tabs>