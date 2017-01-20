<%@ include file="/init.jsp" %>

<h1>Timesheet Tasks</h1>
<c:forEach items="${timesheetTasks}" var="timesheetTask" varStatus="theCount">
	<h2>Timesheet Task: </h2>${timesheetTask}
	<h2>Timesheet Task Duration</h2>
	<c:forEach items="${timesheetTask.timesheetTaskDurations}" var="timesheetTaskDuration" varStatus="theCount">
		${timesheetTaskDuration}
	</c:forEach>
</c:forEach>
<h1>Clients</h1>
<c:forEach items="${clients}" var="client" varStatus="theCount">
	${client}
</c:forEach>
<h1>Projects</h1>
<c:forEach items="${projects}" var="project" varStatus="theCount">
	${project}
</c:forEach>