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

import com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration;
import com.liferay.gs.hack.timesheets.service.base.TimesheetTaskDurationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the timesheet task duration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.timesheets.service.TimesheetTaskDurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDurationLocalServiceBaseImpl
 * @see com.liferay.gs.hack.timesheets.service.TimesheetTaskDurationLocalServiceUtil
 */
@ProviderType
public class TimesheetTaskDurationLocalServiceImpl
	extends TimesheetTaskDurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.timesheets.service.TimesheetTaskDurationLocalServiceUtil} to access the timesheet task duration local service.
	 */

	public List<TimesheetTaskDuration> findByTimesheetId(long timesheetId) {
		return timesheetTaskDurationPersistence.findByTimesheetId(timesheetId);
	}

	public List<TimesheetTaskDuration> findByTimesheetTaskId(long timesheetTaskId) {
		return timesheetTaskDurationPersistence.findByTimesheetTaskId(timesheetTaskId);
	}

	public TimesheetTaskDuration createTimesheetTaskDuration(long timesheetId, long timesheetTaskId, double duration, String comment, int day) {
		long timesheetTaskDurationId = counterLocalService.increment();
		TimesheetTaskDuration timesheetTaskDuration = super.createTimesheetTaskDuration(timesheetTaskDurationId);
		timesheetTaskDuration.setTimesheetId(timesheetId);
		timesheetTaskDuration.setTimesheetTaskId(timesheetTaskId);
		timesheetTaskDuration.setDuration(duration);
		timesheetTaskDuration.setComment(comment);
		timesheetTaskDuration.setDay(day);
		return super.addTimesheetTaskDuration(timesheetTaskDuration);
	}
}