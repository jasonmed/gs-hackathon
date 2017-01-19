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

package com.liferay.gs.hack.timesheets.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration;
import com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskDurationPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimesheetTaskDuration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDuration
 * @generated
 */
@ProviderType
public class TimesheetTaskDurationCacheModel implements CacheModel<TimesheetTaskDuration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetTaskDurationCacheModel)) {
			return false;
		}

		TimesheetTaskDurationCacheModel timesheetTaskDurationCacheModel = (TimesheetTaskDurationCacheModel)obj;

		if (timesheetTaskDurationPK.equals(
					timesheetTaskDurationCacheModel.timesheetTaskDurationPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetTaskDurationPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", timesheetTaskDurationId=");
		sb.append(timesheetTaskDurationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", timesheetId=");
		sb.append(timesheetId);
		sb.append(", timesheetTaskId=");
		sb.append(timesheetTaskId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", taskDate=");
		sb.append(taskDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimesheetTaskDuration toEntityModel() {
		TimesheetTaskDurationImpl timesheetTaskDurationImpl = new TimesheetTaskDurationImpl();

		if (uuid == null) {
			timesheetTaskDurationImpl.setUuid(StringPool.BLANK);
		}
		else {
			timesheetTaskDurationImpl.setUuid(uuid);
		}

		timesheetTaskDurationImpl.setTimesheetTaskDurationId(timesheetTaskDurationId);
		timesheetTaskDurationImpl.setGroupId(groupId);
		timesheetTaskDurationImpl.setTimesheetId(timesheetId);
		timesheetTaskDurationImpl.setTimesheetTaskId(timesheetTaskId);
		timesheetTaskDurationImpl.setCompanyId(companyId);
		timesheetTaskDurationImpl.setUserId(userId);

		if (userName == null) {
			timesheetTaskDurationImpl.setUserName(StringPool.BLANK);
		}
		else {
			timesheetTaskDurationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timesheetTaskDurationImpl.setCreateDate(null);
		}
		else {
			timesheetTaskDurationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timesheetTaskDurationImpl.setModifiedDate(null);
		}
		else {
			timesheetTaskDurationImpl.setModifiedDate(new Date(modifiedDate));
		}

		timesheetTaskDurationImpl.setDuration(duration);

		if (comment == null) {
			timesheetTaskDurationImpl.setComment(StringPool.BLANK);
		}
		else {
			timesheetTaskDurationImpl.setComment(comment);
		}

		if (taskDate == Long.MIN_VALUE) {
			timesheetTaskDurationImpl.setTaskDate(null);
		}
		else {
			timesheetTaskDurationImpl.setTaskDate(new Date(taskDate));
		}

		timesheetTaskDurationImpl.resetOriginalValues();

		return timesheetTaskDurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		timesheetTaskDurationId = objectInput.readLong();

		groupId = objectInput.readLong();

		timesheetId = objectInput.readLong();

		timesheetTaskId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		duration = objectInput.readDouble();
		comment = objectInput.readUTF();
		taskDate = objectInput.readLong();

		timesheetTaskDurationPK = new TimesheetTaskDurationPK(timesheetTaskDurationId,
				timesheetId, timesheetTaskId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(timesheetTaskDurationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(timesheetId);

		objectOutput.writeLong(timesheetTaskId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeDouble(duration);

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeLong(taskDate);
	}

	public String uuid;
	public long timesheetTaskDurationId;
	public long groupId;
	public long timesheetId;
	public long timesheetTaskId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public double duration;
	public String comment;
	public long taskDate;
	public transient TimesheetTaskDurationPK timesheetTaskDurationPK;
}