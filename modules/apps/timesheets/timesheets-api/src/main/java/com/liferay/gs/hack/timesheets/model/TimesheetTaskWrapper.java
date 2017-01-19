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

package com.liferay.gs.hack.timesheets.model;

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
 * This class is a wrapper for {@link TimesheetTask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTask
 * @generated
 */
@ProviderType
public class TimesheetTaskWrapper implements TimesheetTask,
	ModelWrapper<TimesheetTask> {
	public TimesheetTaskWrapper(TimesheetTask timesheetTask) {
		_timesheetTask = timesheetTask;
	}

	@Override
	public Class<?> getModelClass() {
		return TimesheetTask.class;
	}

	@Override
	public String getModelClassName() {
		return TimesheetTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("timesheetTaskId", getTimesheetTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("timesheetId", getTimesheetId());
		attributes.put("projectTaskId", getProjectTaskId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("billable", getBillable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long timesheetTaskId = (Long)attributes.get("timesheetTaskId");

		if (timesheetTaskId != null) {
			setTimesheetTaskId(timesheetTaskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Long projectTaskId = (Long)attributes.get("projectTaskId");

		if (projectTaskId != null) {
			setProjectTaskId(projectTaskId);
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

		Boolean billable = (Boolean)attributes.get("billable");

		if (billable != null) {
			setBillable(billable);
		}
	}

	@Override
	public TimesheetTask toEscapedModel() {
		return new TimesheetTaskWrapper(_timesheetTask.toEscapedModel());
	}

	@Override
	public TimesheetTask toUnescapedModel() {
		return new TimesheetTaskWrapper(_timesheetTask.toUnescapedModel());
	}

	/**
	* Returns the billable of this timesheet task.
	*
	* @return the billable of this timesheet task
	*/
	@Override
	public boolean getBillable() {
		return _timesheetTask.getBillable();
	}

	/**
	* Returns <code>true</code> if this timesheet task is billable.
	*
	* @return <code>true</code> if this timesheet task is billable; <code>false</code> otherwise
	*/
	@Override
	public boolean isBillable() {
		return _timesheetTask.isBillable();
	}

	@Override
	public boolean isCachedModel() {
		return _timesheetTask.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timesheetTask.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timesheetTask.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timesheetTask.getExpandoBridge();
	}

	/**
	* Returns the primary key of this timesheet task.
	*
	* @return the primary key of this timesheet task
	*/
	@Override
	public com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskPK getPrimaryKey() {
		return _timesheetTask.getPrimaryKey();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TimesheetTask> toCacheModel() {
		return _timesheetTask.toCacheModel();
	}

	@Override
	public int compareTo(TimesheetTask timesheetTask) {
		return _timesheetTask.compareTo(timesheetTask);
	}

	@Override
	public int hashCode() {
		return _timesheetTask.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timesheetTask.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetTaskWrapper((TimesheetTask)_timesheetTask.clone());
	}

	/**
	* Returns the user name of this timesheet task.
	*
	* @return the user name of this timesheet task
	*/
	@Override
	public java.lang.String getUserName() {
		return _timesheetTask.getUserName();
	}

	/**
	* Returns the user uuid of this timesheet task.
	*
	* @return the user uuid of this timesheet task
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timesheetTask.getUserUuid();
	}

	/**
	* Returns the uuid of this timesheet task.
	*
	* @return the uuid of this timesheet task
	*/
	@Override
	public java.lang.String getUuid() {
		return _timesheetTask.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timesheetTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timesheetTask.toXmlString();
	}

	/**
	* Returns the create date of this timesheet task.
	*
	* @return the create date of this timesheet task
	*/
	@Override
	public Date getCreateDate() {
		return _timesheetTask.getCreateDate();
	}

	/**
	* Returns the modified date of this timesheet task.
	*
	* @return the modified date of this timesheet task
	*/
	@Override
	public Date getModifiedDate() {
		return _timesheetTask.getModifiedDate();
	}

	/**
	* Returns the company ID of this timesheet task.
	*
	* @return the company ID of this timesheet task
	*/
	@Override
	public long getCompanyId() {
		return _timesheetTask.getCompanyId();
	}

	/**
	* Returns the group ID of this timesheet task.
	*
	* @return the group ID of this timesheet task
	*/
	@Override
	public long getGroupId() {
		return _timesheetTask.getGroupId();
	}

	/**
	* Returns the project task ID of this timesheet task.
	*
	* @return the project task ID of this timesheet task
	*/
	@Override
	public long getProjectTaskId() {
		return _timesheetTask.getProjectTaskId();
	}

	/**
	* Returns the timesheet ID of this timesheet task.
	*
	* @return the timesheet ID of this timesheet task
	*/
	@Override
	public long getTimesheetId() {
		return _timesheetTask.getTimesheetId();
	}

	/**
	* Returns the timesheet task ID of this timesheet task.
	*
	* @return the timesheet task ID of this timesheet task
	*/
	@Override
	public long getTimesheetTaskId() {
		return _timesheetTask.getTimesheetTaskId();
	}

	/**
	* Returns the user ID of this timesheet task.
	*
	* @return the user ID of this timesheet task
	*/
	@Override
	public long getUserId() {
		return _timesheetTask.getUserId();
	}

	@Override
	public void persist() {
		_timesheetTask.persist();
	}

	/**
	* Sets whether this timesheet task is billable.
	*
	* @param billable the billable of this timesheet task
	*/
	@Override
	public void setBillable(boolean billable) {
		_timesheetTask.setBillable(billable);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timesheetTask.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this timesheet task.
	*
	* @param companyId the company ID of this timesheet task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timesheetTask.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this timesheet task.
	*
	* @param createDate the create date of this timesheet task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timesheetTask.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timesheetTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timesheetTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timesheetTask.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this timesheet task.
	*
	* @param groupId the group ID of this timesheet task
	*/
	@Override
	public void setGroupId(long groupId) {
		_timesheetTask.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this timesheet task.
	*
	* @param modifiedDate the modified date of this timesheet task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timesheetTask.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timesheetTask.setNew(n);
	}

	/**
	* Sets the primary key of this timesheet task.
	*
	* @param primaryKey the primary key of this timesheet task
	*/
	@Override
	public void setPrimaryKey(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskPK primaryKey) {
		_timesheetTask.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timesheetTask.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project task ID of this timesheet task.
	*
	* @param projectTaskId the project task ID of this timesheet task
	*/
	@Override
	public void setProjectTaskId(long projectTaskId) {
		_timesheetTask.setProjectTaskId(projectTaskId);
	}

	/**
	* Sets the timesheet ID of this timesheet task.
	*
	* @param timesheetId the timesheet ID of this timesheet task
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timesheetTask.setTimesheetId(timesheetId);
	}

	/**
	* Sets the timesheet task ID of this timesheet task.
	*
	* @param timesheetTaskId the timesheet task ID of this timesheet task
	*/
	@Override
	public void setTimesheetTaskId(long timesheetTaskId) {
		_timesheetTask.setTimesheetTaskId(timesheetTaskId);
	}

	/**
	* Sets the user ID of this timesheet task.
	*
	* @param userId the user ID of this timesheet task
	*/
	@Override
	public void setUserId(long userId) {
		_timesheetTask.setUserId(userId);
	}

	/**
	* Sets the user name of this timesheet task.
	*
	* @param userName the user name of this timesheet task
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timesheetTask.setUserName(userName);
	}

	/**
	* Sets the user uuid of this timesheet task.
	*
	* @param userUuid the user uuid of this timesheet task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timesheetTask.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this timesheet task.
	*
	* @param uuid the uuid of this timesheet task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_timesheetTask.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetTaskWrapper)) {
			return false;
		}

		TimesheetTaskWrapper timesheetTaskWrapper = (TimesheetTaskWrapper)obj;

		if (Objects.equals(_timesheetTask, timesheetTaskWrapper._timesheetTask)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _timesheetTask.getStagedModelType();
	}

	@Override
	public TimesheetTask getWrappedModel() {
		return _timesheetTask;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timesheetTask.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timesheetTask.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timesheetTask.resetOriginalValues();
	}

	private final TimesheetTask _timesheetTask;
}