create index IX_1934FF01 on TS_Timesheet (endDate);
create index IX_6EC97C8 on TS_Timesheet (startDate);
create index IX_5DB1D2FE on TS_Timesheet (status[$COLUMN_LENGTH:75$]);
create index IX_50184F4E on TS_Timesheet (userId, startDate);
create index IX_EF5D80C on TS_Timesheet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8FECF18E on TS_Timesheet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_69DBF082 on TS_TimesheetApproval (timesheetId);
create index IX_B68FA0EF on TS_TimesheetApproval (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_90199731 on TS_TimesheetApproval (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9CC60C00 on TS_TimesheetTask (timesheetId);
create index IX_AFC10431 on TS_TimesheetTask (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_896EE2F3 on TS_TimesheetTask (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_913F82CC on TS_TimesheetTaskDuration (timesheetId);
create index IX_65F12A71 on TS_TimesheetTaskDuration (timesheetTaskId);
create index IX_56DDECE5 on TS_TimesheetTaskDuration (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4C5668A7 on TS_TimesheetTaskDuration (uuid_[$COLUMN_LENGTH:75$], groupId);