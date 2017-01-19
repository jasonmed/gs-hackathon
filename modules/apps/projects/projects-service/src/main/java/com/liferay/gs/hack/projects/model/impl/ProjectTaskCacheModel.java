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

import com.liferay.gs.hack.projects.model.ProjectTask;

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
 * The cache model class for representing ProjectTask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTask
 * @generated
 */
@ProviderType
public class ProjectTaskCacheModel implements CacheModel<ProjectTask>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectTaskCacheModel)) {
			return false;
		}

		ProjectTaskCacheModel projectTaskCacheModel = (ProjectTaskCacheModel)obj;

		if (projectTaskId == projectTaskCacheModel.projectTaskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectTaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectTaskId=");
		sb.append(projectTaskId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectTask toEntityModel() {
		ProjectTaskImpl projectTaskImpl = new ProjectTaskImpl();

		if (uuid == null) {
			projectTaskImpl.setUuid(StringPool.BLANK);
		}
		else {
			projectTaskImpl.setUuid(uuid);
		}

		projectTaskImpl.setProjectTaskId(projectTaskId);
		projectTaskImpl.setGroupId(groupId);
		projectTaskImpl.setCompanyId(companyId);
		projectTaskImpl.setUserId(userId);

		if (userName == null) {
			projectTaskImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectTaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectTaskImpl.setCreateDate(null);
		}
		else {
			projectTaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectTaskImpl.setModifiedDate(null);
		}
		else {
			projectTaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		projectTaskImpl.setProjectId(projectId);

		if (name == null) {
			projectTaskImpl.setName(StringPool.BLANK);
		}
		else {
			projectTaskImpl.setName(name);
		}

		projectTaskImpl.resetOriginalValues();

		return projectTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectTaskId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		projectId = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(projectTaskId);

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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long projectTaskId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long projectId;
	public String name;
}