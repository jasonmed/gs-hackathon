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
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
@ProviderType
public class ProjectWrapper implements Project, ModelWrapper<Project> {
	public ProjectWrapper(Project project) {
		_project = project;
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("clientId", getClientId());
		attributes.put("name", getName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public Project toEscapedModel() {
		return new ProjectWrapper(_project.toEscapedModel());
	}

	@Override
	public Project toUnescapedModel() {
		return new ProjectWrapper(_project.toUnescapedModel());
	}

	/**
	* Returns the active of this project.
	*
	* @return the active of this project
	*/
	@Override
	public boolean getActive() {
		return _project.getActive();
	}

	/**
	* Returns <code>true</code> if this project is active.
	*
	* @return <code>true</code> if this project is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _project.isActive();
	}

	@Override
	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _project.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Project> toCacheModel() {
		return _project.toCacheModel();
	}

	@Override
	public int compareTo(Project project) {
		return _project.compareTo(project);
	}

	@Override
	public int hashCode() {
		return _project.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectWrapper((Project)_project.clone());
	}

	/**
	* Returns the name of this project.
	*
	* @return the name of this project
	*/
	@Override
	public java.lang.String getName() {
		return _project.getName();
	}

	/**
	* Returns the user name of this project.
	*
	* @return the user name of this project
	*/
	@Override
	public java.lang.String getUserName() {
		return _project.getUserName();
	}

	/**
	* Returns the user uuid of this project.
	*
	* @return the user uuid of this project
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _project.getUserUuid();
	}

	/**
	* Returns the uuid of this project.
	*
	* @return the uuid of this project
	*/
	@Override
	public java.lang.String getUuid() {
		return _project.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _project.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	/**
	* Returns the create date of this project.
	*
	* @return the create date of this project
	*/
	@Override
	public Date getCreateDate() {
		return _project.getCreateDate();
	}

	/**
	* Returns the end date of this project.
	*
	* @return the end date of this project
	*/
	@Override
	public Date getEndDate() {
		return _project.getEndDate();
	}

	/**
	* Returns the modified date of this project.
	*
	* @return the modified date of this project
	*/
	@Override
	public Date getModifiedDate() {
		return _project.getModifiedDate();
	}

	/**
	* Returns the start date of this project.
	*
	* @return the start date of this project
	*/
	@Override
	public Date getStartDate() {
		return _project.getStartDate();
	}

	/**
	* Returns the client ID of this project.
	*
	* @return the client ID of this project
	*/
	@Override
	public long getClientId() {
		return _project.getClientId();
	}

	/**
	* Returns the company ID of this project.
	*
	* @return the company ID of this project
	*/
	@Override
	public long getCompanyId() {
		return _project.getCompanyId();
	}

	/**
	* Returns the group ID of this project.
	*
	* @return the group ID of this project
	*/
	@Override
	public long getGroupId() {
		return _project.getGroupId();
	}

	/**
	* Returns the primary key of this project.
	*
	* @return the primary key of this project
	*/
	@Override
	public long getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	/**
	* Returns the project ID of this project.
	*
	* @return the project ID of this project
	*/
	@Override
	public long getProjectId() {
		return _project.getProjectId();
	}

	/**
	* Returns the user ID of this project.
	*
	* @return the user ID of this project
	*/
	@Override
	public long getUserId() {
		return _project.getUserId();
	}

	@Override
	public void persist() {
		_project.persist();
	}

	/**
	* Sets whether this project is active.
	*
	* @param active the active of this project
	*/
	@Override
	public void setActive(boolean active) {
		_project.setActive(active);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	/**
	* Sets the client ID of this project.
	*
	* @param clientId the client ID of this project
	*/
	@Override
	public void setClientId(long clientId) {
		_project.setClientId(clientId);
	}

	/**
	* Sets the company ID of this project.
	*
	* @param companyId the company ID of this project
	*/
	@Override
	public void setCompanyId(long companyId) {
		_project.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this project.
	*
	* @param createDate the create date of this project
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_project.setCreateDate(createDate);
	}

	/**
	* Sets the end date of this project.
	*
	* @param endDate the end date of this project
	*/
	@Override
	public void setEndDate(Date endDate) {
		_project.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_project.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_project.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this project.
	*
	* @param groupId the group ID of this project
	*/
	@Override
	public void setGroupId(long groupId) {
		_project.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this project.
	*
	* @param modifiedDate the modified date of this project
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_project.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this project.
	*
	* @param name the name of this project
	*/
	@Override
	public void setName(java.lang.String name) {
		_project.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_project.setNew(n);
	}

	/**
	* Sets the primary key of this project.
	*
	* @param primaryKey the primary key of this project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_project.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_project.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project.
	*
	* @param projectId the project ID of this project
	*/
	@Override
	public void setProjectId(long projectId) {
		_project.setProjectId(projectId);
	}

	/**
	* Sets the start date of this project.
	*
	* @param startDate the start date of this project
	*/
	@Override
	public void setStartDate(Date startDate) {
		_project.setStartDate(startDate);
	}

	/**
	* Sets the user ID of this project.
	*
	* @param userId the user ID of this project
	*/
	@Override
	public void setUserId(long userId) {
		_project.setUserId(userId);
	}

	/**
	* Sets the user name of this project.
	*
	* @param userName the user name of this project
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_project.setUserName(userName);
	}

	/**
	* Sets the user uuid of this project.
	*
	* @param userUuid the user uuid of this project
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_project.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this project.
	*
	* @param uuid the uuid of this project
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_project.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectWrapper)) {
			return false;
		}

		ProjectWrapper projectWrapper = (ProjectWrapper)obj;

		if (Objects.equals(_project, projectWrapper._project)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _project.getStagedModelType();
	}

	@Override
	public Project getWrappedModel() {
		return _project;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _project.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _project.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_project.resetOriginalValues();
	}

	private final Project _project;
}