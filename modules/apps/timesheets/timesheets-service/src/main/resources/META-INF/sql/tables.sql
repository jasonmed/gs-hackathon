create table gw_Timesheet (
	uuid_ VARCHAR(75) null,
	timesheetId LONG not null primary key,
	groupId LONG,
	userId LONG,
	companyId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	startDate DATE null,
	endDate DATE null,
	status VARCHAR(75) null
);

create table gw_TimesheetApproval (
	uuid_ VARCHAR(75) null,
	timesheetApprovalId LONG not null primary key,
	groupId LONG,
	timesheetId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status VARCHAR(75) null,
	comment_ VARCHAR(75) null
);

create table gw_TimesheetTask (
	uuid_ VARCHAR(75) null,
	timesheetTaskId LONG not null,
	groupId LONG,
	timesheetId LONG not null,
	projectTaskId LONG not null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	billable BOOLEAN,
	primary key (timesheetTaskId, timesheetId, projectTaskId)
);

create table gw_TimesheetTaskDuration (
	uuid_ VARCHAR(75) null,
	timesheetTaskDurationId LONG not null,
	groupId LONG,
	timesheetId LONG not null,
	timesheetTaskId LONG not null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	duration DOUBLE,
	comment_ VARCHAR(75) null,
	taskDate DATE null,
	primary key (timesheetTaskDurationId, timesheetId, timesheetTaskId)
);