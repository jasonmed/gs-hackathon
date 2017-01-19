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

package com.liferay.gs.hack.timesheets.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TimesheetTaskPK implements Comparable<TimesheetTaskPK>,
	Serializable {
	public long timesheetTaskId;
	public long timesheetId;
	public long projectTaskId;

	public TimesheetTaskPK() {
	}

	public TimesheetTaskPK(long timesheetTaskId, long timesheetId,
		long projectTaskId) {
		this.timesheetTaskId = timesheetTaskId;
		this.timesheetId = timesheetId;
		this.projectTaskId = projectTaskId;
	}

	public long getTimesheetTaskId() {
		return timesheetTaskId;
	}

	public void setTimesheetTaskId(long timesheetTaskId) {
		this.timesheetTaskId = timesheetTaskId;
	}

	public long getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		this.timesheetId = timesheetId;
	}

	public long getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(long projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	@Override
	public int compareTo(TimesheetTaskPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (timesheetTaskId < pk.timesheetTaskId) {
			value = -1;
		}
		else if (timesheetTaskId > pk.timesheetTaskId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (timesheetId < pk.timesheetId) {
			value = -1;
		}
		else if (timesheetId > pk.timesheetId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (projectTaskId < pk.projectTaskId) {
			value = -1;
		}
		else if (projectTaskId > pk.projectTaskId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetTaskPK)) {
			return false;
		}

		TimesheetTaskPK pk = (TimesheetTaskPK)obj;

		if ((timesheetTaskId == pk.timesheetTaskId) &&
				(timesheetId == pk.timesheetId) &&
				(projectTaskId == pk.projectTaskId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, timesheetTaskId);
		hashCode = HashUtil.hash(hashCode, timesheetId);
		hashCode = HashUtil.hash(hashCode, projectTaskId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("timesheetTaskId");
		sb.append(StringPool.EQUAL);
		sb.append(timesheetTaskId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("timesheetId");
		sb.append(StringPool.EQUAL);
		sb.append(timesheetId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("projectTaskId");
		sb.append(StringPool.EQUAL);
		sb.append(projectTaskId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}