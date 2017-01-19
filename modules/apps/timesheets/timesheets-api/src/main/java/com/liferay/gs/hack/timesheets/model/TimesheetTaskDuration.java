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
 * The extended model interface for the TimesheetTaskDuration service. Represents a row in the &quot;TS_TimesheetTaskDuration&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDurationModel
 * @see com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationImpl
 * @see com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationImpl")
@ProviderType
public interface TimesheetTaskDuration extends TimesheetTaskDurationModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TimesheetTaskDuration, Long> TIMESHEET_TASK_DURATION_ID_ACCESSOR =
		new Accessor<TimesheetTaskDuration, Long>() {
			@Override
			public Long get(TimesheetTaskDuration timesheetTaskDuration) {
				return timesheetTaskDuration.getTimesheetTaskDurationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TimesheetTaskDuration> getTypeClass() {
				return TimesheetTaskDuration.class;
			}
		};

	public static final Accessor<TimesheetTaskDuration, Long> TIMESHEET_ID_ACCESSOR =
		new Accessor<TimesheetTaskDuration, Long>() {
			@Override
			public Long get(TimesheetTaskDuration timesheetTaskDuration) {
				return timesheetTaskDuration.getTimesheetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TimesheetTaskDuration> getTypeClass() {
				return TimesheetTaskDuration.class;
			}
		};

	public static final Accessor<TimesheetTaskDuration, Long> TIMESHEET_TASK_ID_ACCESSOR =
		new Accessor<TimesheetTaskDuration, Long>() {
			@Override
			public Long get(TimesheetTaskDuration timesheetTaskDuration) {
				return timesheetTaskDuration.getTimesheetTaskId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TimesheetTaskDuration> getTypeClass() {
				return TimesheetTaskDuration.class;
			}
		};
}