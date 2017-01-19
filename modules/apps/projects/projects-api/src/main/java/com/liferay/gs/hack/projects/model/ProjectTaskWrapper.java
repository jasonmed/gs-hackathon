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

package com.liferay.gs.hack.projects.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ProjectTask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTask
 * @generated
 */
@ProviderType
public class ProjectTaskWrapper implements ProjectTask,
	ModelWrapper<ProjectTask> {
	public ProjectTaskWrapper(ProjectTask projectTask) {
		_projectTask = projectTask;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectTask.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectTaskId", getProjectTaskId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectTaskId = (Long)attributes.get("projectTaskId");

		if (projectTaskId != null) {
			setProjectTaskId(projectTaskId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public ProjectTask toEscapedModel() {
		return new ProjectTaskWrapper(_projectTask.toEscapedModel());
	}

	@Override
	public ProjectTask toUnescapedModel() {
		return new ProjectTaskWrapper(_projectTask.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _projectTask.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectTask.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectTask.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectTask.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectTask> toCacheModel() {
		return _projectTask.toCacheModel();
	}

	@Override
	public int compareTo(ProjectTask projectTask) {
		return _projectTask.compareTo(projectTask);
	}

	@Override
	public int hashCode() {
		return _projectTask.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectTask.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectTaskWrapper((ProjectTask)_projectTask.clone());
	}

	/**
	* Returns the description of this project task.
	*
	* @return the description of this project task
	*/
	@Override
	public java.lang.String getDescription() {
		return _projectTask.getDescription();
	}

	/**
	* Returns the name of this project task.
	*
	* @return the name of this project task
	*/
	@Override
	public java.lang.String getName() {
		return _projectTask.getName();
	}

	/**
	* Returns the user name of this project task.
	*
	* @return the user name of this project task
	*/
	@Override
	public java.lang.String getUserName() {
		return _projectTask.getUserName();
	}

	/**
	* Returns the user uuid of this project task.
	*
	* @return the user uuid of this project task
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _projectTask.getUserUuid();
	}

	/**
	* Returns the uuid of this project task.
	*
	* @return the uuid of this project task
	*/
	@Override
	public java.lang.String getUuid() {
		return _projectTask.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _projectTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectTask.toXmlString();
	}

	/**
	* Returns the create date of this project task.
	*
	* @return the create date of this project task
	*/
	@Override
	public Date getCreateDate() {
		return _projectTask.getCreateDate();
	}

	/**
	* Returns the modified date of this project task.
	*
	* @return the modified date of this project task
	*/
	@Override
	public Date getModifiedDate() {
		return _projectTask.getModifiedDate();
	}

	/**
	* Returns the company ID of this project task.
	*
	* @return the company ID of this project task
	*/
	@Override
	public long getCompanyId() {
		return _projectTask.getCompanyId();
	}

	/**
	* Returns the organization ID of this project task.
	*
	* @return the organization ID of this project task
	*/
	@Override
	public long getOrganizationId() {
		return _projectTask.getOrganizationId();
	}

	/**
	* Returns the primary key of this project task.
	*
	* @return the primary key of this project task
	*/
	@Override
	public long getPrimaryKey() {
		return _projectTask.getPrimaryKey();
	}

	/**
	* Returns the project task ID of this project task.
	*
	* @return the project task ID of this project task
	*/
	@Override
	public long getProjectTaskId() {
		return _projectTask.getProjectTaskId();
	}

	/**
	* Returns the user ID of this project task.
	*
	* @return the user ID of this project task
	*/
	@Override
	public long getUserId() {
		return _projectTask.getUserId();
	}

	@Override
	public void persist() {
		_projectTask.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectTask.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this project task.
	*
	* @param companyId the company ID of this project task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectTask.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this project task.
	*
	* @param createDate the create date of this project task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_projectTask.setCreateDate(createDate);
	}

	/**
	* Sets the description of this project task.
	*
	* @param description the description of this project task
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_projectTask.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectTask.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this project task.
	*
	* @param modifiedDate the modified date of this project task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_projectTask.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this project task.
	*
	* @param name the name of this project task
	*/
	@Override
	public void setName(java.lang.String name) {
		_projectTask.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_projectTask.setNew(n);
	}

	/**
	* Sets the organization ID of this project task.
	*
	* @param organizationId the organization ID of this project task
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_projectTask.setOrganizationId(organizationId);
	}

	/**
	* Sets the primary key of this project task.
	*
	* @param primaryKey the primary key of this project task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectTask.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectTask.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project task ID of this project task.
	*
	* @param projectTaskId the project task ID of this project task
	*/
	@Override
	public void setProjectTaskId(long projectTaskId) {
		_projectTask.setProjectTaskId(projectTaskId);
	}

	/**
	* Sets the user ID of this project task.
	*
	* @param userId the user ID of this project task
	*/
	@Override
	public void setUserId(long userId) {
		_projectTask.setUserId(userId);
	}

	/**
	* Sets the user name of this project task.
	*
	* @param userName the user name of this project task
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_projectTask.setUserName(userName);
	}

	/**
	* Sets the user uuid of this project task.
	*
	* @param userUuid the user uuid of this project task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectTask.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this project task.
	*
	* @param uuid the uuid of this project task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_projectTask.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectTaskWrapper)) {
			return false;
		}

		ProjectTaskWrapper projectTaskWrapper = (ProjectTaskWrapper)obj;

		if (Objects.equals(_projectTask, projectTaskWrapper._projectTask)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _projectTask.getStagedModelType();
	}

	@Override
	public ProjectTask getWrappedModel() {
		return _projectTask;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectTask.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectTask.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectTask.resetOriginalValues();
	}

	private final ProjectTask _projectTask;
}