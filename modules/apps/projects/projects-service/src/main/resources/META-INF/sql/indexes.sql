create index IX_F05EDF9D on GS_Project (active_);
create index IX_31817023 on GS_Project (clientId, active_);
create index IX_B5EC7AB on GS_Project (name[$COLUMN_LENGTH:75$]);
create index IX_6A0E77E0 on GS_Project (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FA937662 on GS_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_61F8CDD3 on GS_ProjectTask (projectId);
create index IX_8B1D9A05 on GS_ProjectTask (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_80DEDDC7 on GS_ProjectTask (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CEDE3534 on GS_ProjectUser (employeeId);
create index IX_697A3BCF on GS_ProjectUser (projectId, employeeId, roleId);
create index IX_F03CFBB2 on GS_ProjectUser (projectId, roleId);
create index IX_69877F7C on GS_ProjectUser (roleId);
create index IX_BB7A714B on GS_ProjectUser (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DEF4CE8D on GS_ProjectUser (uuid_[$COLUMN_LENGTH:75$], groupId);