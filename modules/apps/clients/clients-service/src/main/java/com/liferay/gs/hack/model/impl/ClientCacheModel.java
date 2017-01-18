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

import com.liferay.gs.hack.model.Client;

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
 * The cache model class for representing Client in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Client
 * @generated
 */
@ProviderType
public class ClientCacheModel implements CacheModel<Client>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientCacheModel)) {
			return false;
		}

		ClientCacheModel clientCacheModel = (ClientCacheModel)obj;

		if (clientId == clientCacheModel.clientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clientId=");
		sb.append(clientId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Client toEntityModel() {
		ClientImpl clientImpl = new ClientImpl();

		if (uuid == null) {
			clientImpl.setUuid(StringPool.BLANK);
		}
		else {
			clientImpl.setUuid(uuid);
		}

		clientImpl.setClientId(clientId);
		clientImpl.setGroupId(groupId);
		clientImpl.setCompanyId(companyId);
		clientImpl.setUserId(userId);

		if (userName == null) {
			clientImpl.setUserName(StringPool.BLANK);
		}
		else {
			clientImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			clientImpl.setCreateDate(null);
		}
		else {
			clientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			clientImpl.setModifiedDate(null);
		}
		else {
			clientImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			clientImpl.setName(StringPool.BLANK);
		}
		else {
			clientImpl.setName(name);
		}

		if (description == null) {
			clientImpl.setDescription(StringPool.BLANK);
		}
		else {
			clientImpl.setDescription(description);
		}

		clientImpl.resetOriginalValues();

		return clientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		clientId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
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

		objectOutput.writeLong(clientId);

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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long clientId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
}