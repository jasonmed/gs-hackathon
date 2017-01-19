create table GS_Project (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	name VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	active_ BOOLEAN
);

create table GS_ProjectUser (
	uuid_ VARCHAR(75) null,
	projectUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	projectId LONG,
	employeeId LONG,
	roleId LONG,
	billRate DOUBLE
);