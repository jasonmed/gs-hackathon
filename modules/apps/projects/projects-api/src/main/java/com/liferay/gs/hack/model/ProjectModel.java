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

package com.liferay.gs.hack.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Project service. Represents a row in the &quot;GS_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.gs.hack.model.impl.ProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.gs.hack.model.impl.ProjectImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @see com.liferay.gs.hack.model.impl.ProjectImpl
 * @see com.liferay.gs.hack.model.impl.ProjectModelImpl
 * @generated
 */
@ProviderType
public interface ProjectModel extends BaseModel<Project>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project model instance should use the {@link Project} interface instead.
	 */

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this project.
	 *
	 * @return the uuid of this project
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this project.
	 *
	 * @param uuid the uuid of this project
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the group ID of this project.
	 *
	 * @return the group ID of this project
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this project.
	 *
	 * @param groupId the group ID of this project
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this project.
	 *
	 * @return the company ID of this project
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this project.
	 *
	 * @param companyId the company ID of this project
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this project.
	 *
	 * @return the user ID of this project
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this project.
	 *
	 * @param userId the user ID of this project
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this project.
	 *
	 * @return the user uuid of this project
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this project.
	 *
	 * @param userUuid the user uuid of this project
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this project.
	 *
	 * @return the user name of this project
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this project.
	 *
	 * @param userName the user name of this project
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this project.
	 *
	 * @return the create date of this project
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this project.
	 *
	 * @param createDate the create date of this project
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this project.
	 *
	 * @return the modified date of this project
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this project.
	 *
	 * @param modifiedDate the modified date of this project
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the client ID of this project.
	 *
	 * @return the client ID of this project
	 */
	public long getClientId();

	/**
	 * Sets the client ID of this project.
	 *
	 * @param clientId the client ID of this project
	 */
	public void setClientId(long clientId);

	/**
	 * Returns the name of this project.
	 *
	 * @return the name of this project
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this project.
	 *
	 * @param name the name of this project
	 */
	public void setName(String name);

	/**
	 * Returns the start date of this project.
	 *
	 * @return the start date of this project
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this project.
	 *
	 * @param startDate the start date of this project
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this project.
	 *
	 * @return the end date of this project
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this project.
	 *
	 * @param endDate the end date of this project
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the active of this project.
	 *
	 * @return the active of this project
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this project is active.
	 *
	 * @return <code>true</code> if this project is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this project is active.
	 *
	 * @param active the active of this project
	 */
	public void setActive(boolean active);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Project project);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Project> toCacheModel();

	@Override
	public Project toEscapedModel();

	@Override
	public Project toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}