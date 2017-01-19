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

import com.liferay.gs.hack.timesheets.model.Timesheet;

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
 * The cache model class for representing Timesheet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Timesheet
 * @generated
 */
@ProviderType
public class TimesheetCacheModel implements CacheModel<Timesheet>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetCacheModel)) {
			return false;
		}

		TimesheetCacheModel timesheetCacheModel = (TimesheetCacheModel)obj;

		if (timesheetId == timesheetCacheModel.timesheetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", timesheetId=");
		sb.append(timesheetId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Timesheet toEntityModel() {
		TimesheetImpl timesheetImpl = new TimesheetImpl();

		if (uuid == null) {
			timesheetImpl.setUuid(StringPool.BLANK);
		}
		else {
			timesheetImpl.setUuid(uuid);
		}

		timesheetImpl.setTimesheetId(timesheetId);
		timesheetImpl.setGroupId(groupId);
		timesheetImpl.setUserId(userId);
		timesheetImpl.setCompanyId(companyId);

		if (userName == null) {
			timesheetImpl.setUserName(StringPool.BLANK);
		}
		else {
			timesheetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timesheetImpl.setCreateDate(null);
		}
		else {
			timesheetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timesheetImpl.setModifiedDate(null);
		}
		else {
			timesheetImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startDate == Long.MIN_VALUE) {
			timesheetImpl.setStartDate(null);
		}
		else {
			timesheetImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			timesheetImpl.setEndDate(null);
		}
		else {
			timesheetImpl.setEndDate(new Date(endDate));
		}

		if (status == null) {
			timesheetImpl.setStatus(StringPool.BLANK);
		}
		else {
			timesheetImpl.setStatus(status);
		}

		timesheetImpl.resetOriginalValues();

		return timesheetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		timesheetId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		status = objectInput.readUTF();
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

		objectOutput.writeLong(timesheetId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long timesheetId;
	public long groupId;
	public long userId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long startDate;
	public long endDate;
	public String status;
}