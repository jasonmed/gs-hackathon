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
 * This class is a wrapper for {@link ProjectUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUser
 * @generated
 */
@ProviderType
public class ProjectUserWrapper implements ProjectUser,
	ModelWrapper<ProjectUser> {
	public ProjectUserWrapper(ProjectUser projectUser) {
		_projectUser = projectUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectUser.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectUserId", getProjectUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("projectId", getProjectId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("roleId", getRoleId());
		attributes.put("billRate", getBillRate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectUserId = (Long)attributes.get("projectUserId");

		if (projectUserId != null) {
			setProjectUserId(projectUserId);
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

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Double billRate = (Double)attributes.get("billRate");

		if (billRate != null) {
			setBillRate(billRate);
		}
	}

	@Override
	public ProjectUser toEscapedModel() {
		return new ProjectUserWrapper(_projectUser.toEscapedModel());
	}

	@Override
	public ProjectUser toUnescapedModel() {
		return new ProjectUserWrapper(_projectUser.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _projectUser.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectUser.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectUser.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectUser.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectUser> toCacheModel() {
		return _projectUser.toCacheModel();
	}

	/**
	* Returns the bill rate of this project user.
	*
	* @return the bill rate of this project user
	*/
	@Override
	public double getBillRate() {
		return _projectUser.getBillRate();
	}

	@Override
	public int compareTo(ProjectUser projectUser) {
		return _projectUser.compareTo(projectUser);
	}

	@Override
	public int hashCode() {
		return _projectUser.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectUser.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectUserWrapper((ProjectUser)_projectUser.clone());
	}

	/**
	* Returns the project user uuid of this project user.
	*
	* @return the project user uuid of this project user
	*/
	@Override
	public java.lang.String getProjectUserUuid() {
		return _projectUser.getProjectUserUuid();
	}

	/**
	* Returns the user name of this project user.
	*
	* @return the user name of this project user
	*/
	@Override
	public java.lang.String getUserName() {
		return _projectUser.getUserName();
	}

	/**
	* Returns the user uuid of this project user.
	*
	* @return the user uuid of this project user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _projectUser.getUserUuid();
	}

	/**
	* Returns the uuid of this project user.
	*
	* @return the uuid of this project user
	*/
	@Override
	public java.lang.String getUuid() {
		return _projectUser.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _projectUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectUser.toXmlString();
	}

	/**
	* Returns the create date of this project user.
	*
	* @return the create date of this project user
	*/
	@Override
	public Date getCreateDate() {
		return _projectUser.getCreateDate();
	}

	/**
	* Returns the modified date of this project user.
	*
	* @return the modified date of this project user
	*/
	@Override
	public Date getModifiedDate() {
		return _projectUser.getModifiedDate();
	}

	/**
	* Returns the company ID of this project user.
	*
	* @return the company ID of this project user
	*/
	@Override
	public long getCompanyId() {
		return _projectUser.getCompanyId();
	}

	/**
	* Returns the employee ID of this project user.
	*
	* @return the employee ID of this project user
	*/
	@Override
	public long getEmployeeId() {
		return _projectUser.getEmployeeId();
	}

	/**
	* Returns the group ID of this project user.
	*
	* @return the group ID of this project user
	*/
	@Override
	public long getGroupId() {
		return _projectUser.getGroupId();
	}

	/**
	* Returns the primary key of this project user.
	*
	* @return the primary key of this project user
	*/
	@Override
	public long getPrimaryKey() {
		return _projectUser.getPrimaryKey();
	}

	/**
	* Returns the project ID of this project user.
	*
	* @return the project ID of this project user
	*/
	@Override
	public long getProjectId() {
		return _projectUser.getProjectId();
	}

	/**
	* Returns the project user ID of this project user.
	*
	* @return the project user ID of this project user
	*/
	@Override
	public long getProjectUserId() {
		return _projectUser.getProjectUserId();
	}

	/**
	* Returns the role ID of this project user.
	*
	* @return the role ID of this project user
	*/
	@Override
	public long getRoleId() {
		return _projectUser.getRoleId();
	}

	/**
	* Returns the user ID of this project user.
	*
	* @return the user ID of this project user
	*/
	@Override
	public long getUserId() {
		return _projectUser.getUserId();
	}

	@Override
	public void persist() {
		_projectUser.persist();
	}

	/**
	* Sets the bill rate of this project user.
	*
	* @param billRate the bill rate of this project user
	*/
	@Override
	public void setBillRate(double billRate) {
		_projectUser.setBillRate(billRate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectUser.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this project user.
	*
	* @param companyId the company ID of this project user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_projectUser.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this project user.
	*
	* @param createDate the create date of this project user
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_projectUser.setCreateDate(createDate);
	}

	/**
	* Sets the employee ID of this project user.
	*
	* @param employeeId the employee ID of this project user
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_projectUser.setEmployeeId(employeeId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this project user.
	*
	* @param groupId the group ID of this project user
	*/
	@Override
	public void setGroupId(long groupId) {
		_projectUser.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this project user.
	*
	* @param modifiedDate the modified date of this project user
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_projectUser.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_projectUser.setNew(n);
	}

	/**
	* Sets the primary key of this project user.
	*
	* @param primaryKey the primary key of this project user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this project user.
	*
	* @param projectId the project ID of this project user
	*/
	@Override
	public void setProjectId(long projectId) {
		_projectUser.setProjectId(projectId);
	}

	/**
	* Sets the project user ID of this project user.
	*
	* @param projectUserId the project user ID of this project user
	*/
	@Override
	public void setProjectUserId(long projectUserId) {
		_projectUser.setProjectUserId(projectUserId);
	}

	/**
	* Sets the project user uuid of this project user.
	*
	* @param projectUserUuid the project user uuid of this project user
	*/
	@Override
	public void setProjectUserUuid(java.lang.String projectUserUuid) {
		_projectUser.setProjectUserUuid(projectUserUuid);
	}

	/**
	* Sets the role ID of this project user.
	*
	* @param roleId the role ID of this project user
	*/
	@Override
	public void setRoleId(long roleId) {
		_projectUser.setRoleId(roleId);
	}

	/**
	* Sets the user ID of this project user.
	*
	* @param userId the user ID of this project user
	*/
	@Override
	public void setUserId(long userId) {
		_projectUser.setUserId(userId);
	}

	/**
	* Sets the user name of this project user.
	*
	* @param userName the user name of this project user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_projectUser.setUserName(userName);
	}

	/**
	* Sets the user uuid of this project user.
	*
	* @param userUuid the user uuid of this project user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_projectUser.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this project user.
	*
	* @param uuid the uuid of this project user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_projectUser.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectUserWrapper)) {
			return false;
		}

		ProjectUserWrapper projectUserWrapper = (ProjectUserWrapper)obj;

		if (Objects.equals(_projectUser, projectUserWrapper._projectUser)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _projectUser.getStagedModelType();
	}

	@Override
	public ProjectUser getWrappedModel() {
		return _projectUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectUser.resetOriginalValues();
	}

	private final ProjectUser _projectUser;
}