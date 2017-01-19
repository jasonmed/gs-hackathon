create index IX_61BF8126 on PS_Project (active_);
create index IX_EDB07A6C on PS_Project (clientId, active_);
create index IX_F47FBAC2 on PS_Project (name[$COLUMN_LENGTH:75$]);
create index IX_70208077 on PS_Project (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_71ECB8B9 on PS_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_65D2649C on PS_ProjectTask (projectId);
create index IX_B13B7F1C on PS_ProjectTask (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4A911C9E on PS_ProjectTask (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4637778B on PS_ProjectUser (employeeId);
create index IX_8AC59418 on PS_ProjectUser (projectId, employeeId, roleId);
create index IX_8DDBB97B on PS_ProjectUser (projectId, roleId);
create index IX_45958553 on PS_ProjectUser (roleId);
create index IX_E1985662 on PS_ProjectUser (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A8A70D64 on PS_ProjectUser (uuid_[$COLUMN_LENGTH:75$], groupId);