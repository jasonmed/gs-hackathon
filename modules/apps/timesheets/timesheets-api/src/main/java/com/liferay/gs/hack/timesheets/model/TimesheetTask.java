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

package com.liferay.gs.hack.timesheets.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TimesheetTask service. Represents a row in the &quot;TS_TimesheetTask&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskModel
 * @see com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskImpl
 * @see com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskImpl")
@ProviderType
public interface TimesheetTask extends TimesheetTaskModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TimesheetTask, Long> TIMESHEET_TASK_ID_ACCESSOR =
		new Accessor<TimesheetTask, Long>() {
			@Override
			public Long get(TimesheetTask timesheetTask) {
				return timesheetTask.getTimesheetTaskId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TimesheetTask> getTypeClass() {
				return TimesheetTask.class;
			}
		};

	public java.util.List<TimesheetTaskDuration> getTimesheetTaskDurations();

	public void setTimesheetTaskDurations(
		java.util.List<TimesheetTaskDuration> timesheetTaskDurations);
}