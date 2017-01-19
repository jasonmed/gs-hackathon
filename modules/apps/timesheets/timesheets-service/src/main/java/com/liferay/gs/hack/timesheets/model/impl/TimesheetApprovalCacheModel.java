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

import com.liferay.gs.hack.timesheets.model.TimesheetApproval;

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
 * The cache model class for representing TimesheetApproval in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetApproval
 * @generated
 */
@ProviderType
public class TimesheetApprovalCacheModel implements CacheModel<TimesheetApproval>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetApprovalCacheModel)) {
			return false;
		}

		TimesheetApprovalCacheModel timesheetApprovalCacheModel = (TimesheetApprovalCacheModel)obj;

		if (timesheetApprovalId == timesheetApprovalCacheModel.timesheetApprovalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetApprovalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", timesheetApprovalId=");
		sb.append(timesheetApprovalId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", timesheetId=");
		sb.append(timesheetId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimesheetApproval toEntityModel() {
		TimesheetApprovalImpl timesheetApprovalImpl = new TimesheetApprovalImpl();

		if (uuid == null) {
			timesheetApprovalImpl.setUuid(StringPool.BLANK);
		}
		else {
			timesheetApprovalImpl.setUuid(uuid);
		}

		timesheetApprovalImpl.setTimesheetApprovalId(timesheetApprovalId);
		timesheetApprovalImpl.setGroupId(groupId);
		timesheetApprovalImpl.setTimesheetId(timesheetId);
		timesheetApprovalImpl.setCompanyId(companyId);
		timesheetApprovalImpl.setUserId(userId);

		if (userName == null) {
			timesheetApprovalImpl.setUserName(StringPool.BLANK);
		}
		else {
			timesheetApprovalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timesheetApprovalImpl.setCreateDate(null);
		}
		else {
			timesheetApprovalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timesheetApprovalImpl.setModifiedDate(null);
		}
		else {
			timesheetApprovalImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (status == null) {
			timesheetApprovalImpl.setStatus(StringPool.BLANK);
		}
		else {
			timesheetApprovalImpl.setStatus(status);
		}

		if (comment == null) {
			timesheetApprovalImpl.setComment(StringPool.BLANK);
		}
		else {
			timesheetApprovalImpl.setComment(comment);
		}

		timesheetApprovalImpl.resetOriginalValues();

		return timesheetApprovalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		timesheetApprovalId = objectInput.readLong();

		groupId = objectInput.readLong();

		timesheetId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readUTF();
		comment = objectInput.readUTF();
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

		objectOutput.writeLong(timesheetApprovalId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(timesheetId);

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

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public String uuid;
	public long timesheetApprovalId;
	public long groupId;
	public long timesheetId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String status;
	public String comment;
}