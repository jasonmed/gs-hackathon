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

package com.liferay.gs.hack.projects.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.projects.model.ProjectUser;

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
 * The cache model class for representing ProjectUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUser
 * @generated
 */
@ProviderType
public class ProjectUserCacheModel implements CacheModel<ProjectUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectUserCacheModel)) {
			return false;
		}

		ProjectUserCacheModel projectUserCacheModel = (ProjectUserCacheModel)obj;

		if (projectUserId == projectUserCacheModel.projectUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectUserId=");
		sb.append(projectUserId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", billRate=");
		sb.append(billRate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectUser toEntityModel() {
		ProjectUserImpl projectUserImpl = new ProjectUserImpl();

		if (uuid == null) {
			projectUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			projectUserImpl.setUuid(uuid);
		}

		projectUserImpl.setProjectUserId(projectUserId);
		projectUserImpl.setGroupId(groupId);
		projectUserImpl.setCompanyId(companyId);
		projectUserImpl.setUserId(userId);

		if (userName == null) {
			projectUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectUserImpl.setCreateDate(null);
		}
		else {
			projectUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectUserImpl.setModifiedDate(null);
		}
		else {
			projectUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectUserImpl.setProjectId(projectId);
		projectUserImpl.setEmployeeId(employeeId);
		projectUserImpl.setRoleId(roleId);
		projectUserImpl.setBillRate(billRate);

		projectUserImpl.resetOriginalValues();

		return projectUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		projectId = objectInput.readLong();

		employeeId = objectInput.readLong();

		roleId = objectInput.readLong();

		billRate = objectInput.readDouble();
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

		objectOutput.writeLong(projectUserId);

		objectOutput.writeLong(groupId);

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

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(roleId);

		objectOutput.writeDouble(billRate);
	}

	public String uuid;
	public long projectUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long projectId;
	public long employeeId;
	public long roleId;
	public double billRate;
}