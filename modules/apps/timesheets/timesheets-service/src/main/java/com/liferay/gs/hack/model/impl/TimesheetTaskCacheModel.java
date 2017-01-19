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

package com.liferay.gs.hack.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.model.TimesheetTask;
import com.liferay.gs.hack.service.persistence.TimesheetTaskPK;

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
 * The cache model class for representing TimesheetTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTask
 * @generated
 */
@ProviderType
public class TimesheetTaskCacheModel implements CacheModel<TimesheetTask>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetTaskCacheModel)) {
			return false;
		}

		TimesheetTaskCacheModel timesheetTaskCacheModel = (TimesheetTaskCacheModel)obj;

		if (timesheetTaskPK.equals(timesheetTaskCacheModel.timesheetTaskPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetTaskPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", timesheetTaskId=");
		sb.append(timesheetTaskId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", timesheetId=");
		sb.append(timesheetId);
		sb.append(", projectTaskId=");
		sb.append(projectTaskId);
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
		sb.append(", billable=");
		sb.append(billable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimesheetTask toEntityModel() {
		TimesheetTaskImpl timesheetTaskImpl = new TimesheetTaskImpl();

		if (uuid == null) {
			timesheetTaskImpl.setUuid(StringPool.BLANK);
		}
		else {
			timesheetTaskImpl.setUuid(uuid);
		}

		timesheetTaskImpl.setTimesheetTaskId(timesheetTaskId);
		timesheetTaskImpl.setGroupId(groupId);
		timesheetTaskImpl.setTimesheetId(timesheetId);
		timesheetTaskImpl.setProjectTaskId(projectTaskId);
		timesheetTaskImpl.setCompanyId(companyId);
		timesheetTaskImpl.setUserId(userId);

		if (userName == null) {
			timesheetTaskImpl.setUserName(StringPool.BLANK);
		}
		else {
			timesheetTaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timesheetTaskImpl.setCreateDate(null);
		}
		else {
			timesheetTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timesheetTaskImpl.setModifiedDate(null);
		}
		else {
			timesheetTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		timesheetTaskImpl.setBillable(billable);

		timesheetTaskImpl.resetOriginalValues();

		return timesheetTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		timesheetTaskId = objectInput.readLong();

		groupId = objectInput.readLong();

		timesheetId = objectInput.readLong();

		projectTaskId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		billable = objectInput.readBoolean();

		timesheetTaskPK = new TimesheetTaskPK(timesheetTaskId, timesheetId,
				projectTaskId);
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

		objectOutput.writeLong(timesheetTaskId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(timesheetId);

		objectOutput.writeLong(projectTaskId);

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

		objectOutput.writeBoolean(billable);
	}

	public String uuid;
	public long timesheetTaskId;
	public long groupId;
	public long timesheetId;
	public long projectTaskId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean billable;
	public transient TimesheetTaskPK timesheetTaskPK;
}