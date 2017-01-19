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
 * This class is a wrapper for {@link Timesheet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Timesheet
 * @generated
 */
@ProviderType
public class TimesheetWrapper implements Timesheet, ModelWrapper<Timesheet> {
	public TimesheetWrapper(Timesheet timesheet) {
		_timesheet = timesheet;
	}

	@Override
	public Class<?> getModelClass() {
		return Timesheet.class;
	}

	@Override
	public String getModelClassName() {
		return Timesheet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("timesheetId", getTimesheetId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Timesheet toEscapedModel() {
		return new TimesheetWrapper(_timesheet.toEscapedModel());
	}

	@Override
	public Timesheet toUnescapedModel() {
		return new TimesheetWrapper(_timesheet.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _timesheet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timesheet.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timesheet.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timesheet.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Timesheet> toCacheModel() {
		return _timesheet.toCacheModel();
	}

	@Override
	public int compareTo(Timesheet timesheet) {
		return _timesheet.compareTo(timesheet);
	}

	@Override
	public int hashCode() {
		return _timesheet.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timesheet.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetWrapper((Timesheet)_timesheet.clone());
	}

	/**
	* Returns the status of this timesheet.
	*
	* @return the status of this timesheet
	*/
	@Override
	public java.lang.String getStatus() {
		return _timesheet.getStatus();
	}

	/**
	* Returns the user name of this timesheet.
	*
	* @return the user name of this timesheet
	*/
	@Override
	public java.lang.String getUserName() {
		return _timesheet.getUserName();
	}

	/**
	* Returns the user uuid of this timesheet.
	*
	* @return the user uuid of this timesheet
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timesheet.getUserUuid();
	}

	/**
	* Returns the uuid of this timesheet.
	*
	* @return the uuid of this timesheet
	*/
	@Override
	public java.lang.String getUuid() {
		return _timesheet.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timesheet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timesheet.toXmlString();
	}

	/**
	* Returns the create date of this timesheet.
	*
	* @return the create date of this timesheet
	*/
	@Override
	public Date getCreateDate() {
		return _timesheet.getCreateDate();
	}

	/**
	* Returns the end date of this timesheet.
	*
	* @return the end date of this timesheet
	*/
	@Override
	public Date getEndDate() {
		return _timesheet.getEndDate();
	}

	/**
	* Returns the modified date of this timesheet.
	*
	* @return the modified date of this timesheet
	*/
	@Override
	public Date getModifiedDate() {
		return _timesheet.getModifiedDate();
	}

	/**
	* Returns the start date of this timesheet.
	*
	* @return the start date of this timesheet
	*/
	@Override
	public Date getStartDate() {
		return _timesheet.getStartDate();
	}

	/**
	* Returns the company ID of this timesheet.
	*
	* @return the company ID of this timesheet
	*/
	@Override
	public long getCompanyId() {
		return _timesheet.getCompanyId();
	}

	/**
	* Returns the group ID of this timesheet.
	*
	* @return the group ID of this timesheet
	*/
	@Override
	public long getGroupId() {
		return _timesheet.getGroupId();
	}

	/**
	* Returns the primary key of this timesheet.
	*
	* @return the primary key of this timesheet
	*/
	@Override
	public long getPrimaryKey() {
		return _timesheet.getPrimaryKey();
	}

	/**
	* Returns the timesheet ID of this timesheet.
	*
	* @return the timesheet ID of this timesheet
	*/
	@Override
	public long getTimesheetId() {
		return _timesheet.getTimesheetId();
	}

	/**
	* Returns the user ID of this timesheet.
	*
	* @return the user ID of this timesheet
	*/
	@Override
	public long getUserId() {
		return _timesheet.getUserId();
	}

	@Override
	public void persist() {
		_timesheet.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timesheet.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this timesheet.
	*
	* @param companyId the company ID of this timesheet
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timesheet.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this timesheet.
	*
	* @param createDate the create date of this timesheet
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timesheet.setCreateDate(createDate);
	}

	/**
	* Sets the end date of this timesheet.
	*
	* @param endDate the end date of this timesheet
	*/
	@Override
	public void setEndDate(Date endDate) {
		_timesheet.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timesheet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timesheet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timesheet.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this timesheet.
	*
	* @param groupId the group ID of this timesheet
	*/
	@Override
	public void setGroupId(long groupId) {
		_timesheet.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this timesheet.
	*
	* @param modifiedDate the modified date of this timesheet
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timesheet.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timesheet.setNew(n);
	}

	/**
	* Sets the primary key of this timesheet.
	*
	* @param primaryKey the primary key of this timesheet
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timesheet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timesheet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this timesheet.
	*
	* @param startDate the start date of this timesheet
	*/
	@Override
	public void setStartDate(Date startDate) {
		_timesheet.setStartDate(startDate);
	}

	/**
	* Sets the status of this timesheet.
	*
	* @param status the status of this timesheet
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_timesheet.setStatus(status);
	}

	/**
	* Sets the timesheet ID of this timesheet.
	*
	* @param timesheetId the timesheet ID of this timesheet
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timesheet.setTimesheetId(timesheetId);
	}

	/**
	* Sets the user ID of this timesheet.
	*
	* @param userId the user ID of this timesheet
	*/
	@Override
	public void setUserId(long userId) {
		_timesheet.setUserId(userId);
	}

	/**
	* Sets the user name of this timesheet.
	*
	* @param userName the user name of this timesheet
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timesheet.setUserName(userName);
	}

	/**
	* Sets the user uuid of this timesheet.
	*
	* @param userUuid the user uuid of this timesheet
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timesheet.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this timesheet.
	*
	* @param uuid the uuid of this timesheet
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_timesheet.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetWrapper)) {
			return false;
		}

		TimesheetWrapper timesheetWrapper = (TimesheetWrapper)obj;

		if (Objects.equals(_timesheet, timesheetWrapper._timesheet)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _timesheet.getStagedModelType();
	}

	@Override
	public Timesheet getWrappedModel() {
		return _timesheet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timesheet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timesheet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timesheet.resetOriginalValues();
	}

	private final Timesheet _timesheet;
}