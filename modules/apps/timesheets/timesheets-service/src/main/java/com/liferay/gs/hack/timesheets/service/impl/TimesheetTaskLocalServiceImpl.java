/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gs.hack.timesheets.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.timesheets.model.TimesheetTask;
import com.liferay.gs.hack.timesheets.service.base.TimesheetTaskLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the timesheet task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.timesheets.service.TimesheetTaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskLocalServiceBaseImpl
 * @see com.liferay.gs.hack.timesheets.service.TimesheetTaskLocalServiceUtil
 */
@ProviderType
public class TimesheetTaskLocalServiceImpl
	extends TimesheetTaskLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.timesheets.service.TimesheetTaskLocalServiceUtil} to access the timesheet task local service.
	 */

	public List<TimesheetTask> findByTimesheetId(long timesheetId) {
		return timesheetTaskPersistence.findByTimesheetId(timesheetId);
	}

	public List<TimesheetTask> findByProjectTaskId(long projectTaskId) {
		return timesheetTaskPersistence.findByProjectTaskId(projectTaskId);
	}

	public TimesheetTask createTimesheetTask(long timesheetId, long projectTaskId, boolean billable) {
		long timesheetTaskId = counterLocalService.increment();
		TimesheetTask timesheetTask = super.createTimesheetTask(timesheetTaskId);
		timesheetTask.setTimesheetId(timesheetId);
		timesheetTask.setProjectTaskId(projectTaskId);
		timesheetTask.setBillable(billable);
		return super.addTimesheetTask(timesheetTask);
	}
}