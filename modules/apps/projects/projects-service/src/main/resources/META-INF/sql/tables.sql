create table PS_ProjectTask (
	uuid_ VARCHAR(75) null,
	projectTaskId LONG not null primary key,
	organizationId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);