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
 * This class is a wrapper for {@link TimesheetTaskDuration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDuration
 * @generated
 */
@ProviderType
public class TimesheetTaskDurationWrapper implements TimesheetTaskDuration,
	ModelWrapper<TimesheetTaskDuration> {
	public TimesheetTaskDurationWrapper(
		TimesheetTaskDuration timesheetTaskDuration) {
		_timesheetTaskDuration = timesheetTaskDuration;
	}

	@Override
	public Class<?> getModelClass() {
		return TimesheetTaskDuration.class;
	}

	@Override
	public String getModelClassName() {
		return TimesheetTaskDuration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("timesheetTaskDurationId", getTimesheetTaskDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("timesheetId", getTimesheetId());
		attributes.put("timesheetTaskId", getTimesheetTaskId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("duration", getDuration());
		attributes.put("comment", getComment());
		attributes.put("day", getDay());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long timesheetTaskDurationId = (Long)attributes.get(
				"timesheetTaskDurationId");

		if (timesheetTaskDurationId != null) {
			setTimesheetTaskDurationId(timesheetTaskDurationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Long timesheetTaskId = (Long)attributes.get("timesheetTaskId");

		if (timesheetTaskId != null) {
			setTimesheetTaskId(timesheetTaskId);
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

		Double duration = (Double)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}
	}

	@Override
	public TimesheetTaskDuration toEscapedModel() {
		return new TimesheetTaskDurationWrapper(_timesheetTaskDuration.toEscapedModel());
	}

	@Override
	public TimesheetTaskDuration toUnescapedModel() {
		return new TimesheetTaskDurationWrapper(_timesheetTaskDuration.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _timesheetTaskDuration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timesheetTaskDuration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timesheetTaskDuration.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timesheetTaskDuration.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TimesheetTaskDuration> toCacheModel() {
		return _timesheetTaskDuration.toCacheModel();
	}

	/**
	* Returns the duration of this timesheet task duration.
	*
	* @return the duration of this timesheet task duration
	*/
	@Override
	public double getDuration() {
		return _timesheetTaskDuration.getDuration();
	}

	@Override
	public int compareTo(TimesheetTaskDuration timesheetTaskDuration) {
		return _timesheetTaskDuration.compareTo(timesheetTaskDuration);
	}

	/**
	* Returns the day of this timesheet task duration.
	*
	* @return the day of this timesheet task duration
	*/
	@Override
	public int getDay() {
		return _timesheetTaskDuration.getDay();
	}

	@Override
	public int hashCode() {
		return _timesheetTaskDuration.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timesheetTaskDuration.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetTaskDurationWrapper((TimesheetTaskDuration)_timesheetTaskDuration.clone());
	}

	/**
	* Returns the comment of this timesheet task duration.
	*
	* @return the comment of this timesheet task duration
	*/
	@Override
	public java.lang.String getComment() {
		return _timesheetTaskDuration.getComment();
	}

	/**
	* Returns the user name of this timesheet task duration.
	*
	* @return the user name of this timesheet task duration
	*/
	@Override
	public java.lang.String getUserName() {
		return _timesheetTaskDuration.getUserName();
	}

	/**
	* Returns the user uuid of this timesheet task duration.
	*
	* @return the user uuid of this timesheet task duration
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timesheetTaskDuration.getUserUuid();
	}

	/**
	* Returns the uuid of this timesheet task duration.
	*
	* @return the uuid of this timesheet task duration
	*/
	@Override
	public java.lang.String getUuid() {
		return _timesheetTaskDuration.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timesheetTaskDuration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timesheetTaskDuration.toXmlString();
	}

	/**
	* Returns the create date of this timesheet task duration.
	*
	* @return the create date of this timesheet task duration
	*/
	@Override
	public Date getCreateDate() {
		return _timesheetTaskDuration.getCreateDate();
	}

	/**
	* Returns the modified date of this timesheet task duration.
	*
	* @return the modified date of this timesheet task duration
	*/
	@Override
	public Date getModifiedDate() {
		return _timesheetTaskDuration.getModifiedDate();
	}

	/**
	* Returns the company ID of this timesheet task duration.
	*
	* @return the company ID of this timesheet task duration
	*/
	@Override
	public long getCompanyId() {
		return _timesheetTaskDuration.getCompanyId();
	}

	/**
	* Returns the group ID of this timesheet task duration.
	*
	* @return the group ID of this timesheet task duration
	*/
	@Override
	public long getGroupId() {
		return _timesheetTaskDuration.getGroupId();
	}

	/**
	* Returns the primary key of this timesheet task duration.
	*
	* @return the primary key of this timesheet task duration
	*/
	@Override
	public long getPrimaryKey() {
		return _timesheetTaskDuration.getPrimaryKey();
	}

	/**
	* Returns the timesheet ID of this timesheet task duration.
	*
	* @return the timesheet ID of this timesheet task duration
	*/
	@Override
	public long getTimesheetId() {
		return _timesheetTaskDuration.getTimesheetId();
	}

	/**
	* Returns the timesheet task duration ID of this timesheet task duration.
	*
	* @return the timesheet task duration ID of this timesheet task duration
	*/
	@Override
	public long getTimesheetTaskDurationId() {
		return _timesheetTaskDuration.getTimesheetTaskDurationId();
	}

	/**
	* Returns the timesheet task ID of this timesheet task duration.
	*
	* @return the timesheet task ID of this timesheet task duration
	*/
	@Override
	public long getTimesheetTaskId() {
		return _timesheetTaskDuration.getTimesheetTaskId();
	}

	/**
	* Returns the user ID of this timesheet task duration.
	*
	* @return the user ID of this timesheet task duration
	*/
	@Override
	public long getUserId() {
		return _timesheetTaskDuration.getUserId();
	}

	@Override
	public void persist() {
		_timesheetTaskDuration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timesheetTaskDuration.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this timesheet task duration.
	*
	* @param comment the comment of this timesheet task duration
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_timesheetTaskDuration.setComment(comment);
	}

	/**
	* Sets the company ID of this timesheet task duration.
	*
	* @param companyId the company ID of this timesheet task duration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timesheetTaskDuration.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this timesheet task duration.
	*
	* @param createDate the create date of this timesheet task duration
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timesheetTaskDuration.setCreateDate(createDate);
	}

	/**
	* Sets the day of this timesheet task duration.
	*
	* @param day the day of this timesheet task duration
	*/
	@Override
	public void setDay(int day) {
		_timesheetTaskDuration.setDay(day);
	}

	/**
	* Sets the duration of this timesheet task duration.
	*
	* @param duration the duration of this timesheet task duration
	*/
	@Override
	public void setDuration(double duration) {
		_timesheetTaskDuration.setDuration(duration);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timesheetTaskDuration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timesheetTaskDuration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timesheetTaskDuration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this timesheet task duration.
	*
	* @param groupId the group ID of this timesheet task duration
	*/
	@Override
	public void setGroupId(long groupId) {
		_timesheetTaskDuration.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this timesheet task duration.
	*
	* @param modifiedDate the modified date of this timesheet task duration
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timesheetTaskDuration.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timesheetTaskDuration.setNew(n);
	}

	/**
	* Sets the primary key of this timesheet task duration.
	*
	* @param primaryKey the primary key of this timesheet task duration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timesheetTaskDuration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timesheetTaskDuration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the timesheet ID of this timesheet task duration.
	*
	* @param timesheetId the timesheet ID of this timesheet task duration
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timesheetTaskDuration.setTimesheetId(timesheetId);
	}

	/**
	* Sets the timesheet task duration ID of this timesheet task duration.
	*
	* @param timesheetTaskDurationId the timesheet task duration ID of this timesheet task duration
	*/
	@Override
	public void setTimesheetTaskDurationId(long timesheetTaskDurationId) {
		_timesheetTaskDuration.setTimesheetTaskDurationId(timesheetTaskDurationId);
	}

	/**
	* Sets the timesheet task ID of this timesheet task duration.
	*
	* @param timesheetTaskId the timesheet task ID of this timesheet task duration
	*/
	@Override
	public void setTimesheetTaskId(long timesheetTaskId) {
		_timesheetTaskDuration.setTimesheetTaskId(timesheetTaskId);
	}

	/**
	* Sets the user ID of this timesheet task duration.
	*
	* @param userId the user ID of this timesheet task duration
	*/
	@Override
	public void setUserId(long userId) {
		_timesheetTaskDuration.setUserId(userId);
	}

	/**
	* Sets the user name of this timesheet task duration.
	*
	* @param userName the user name of this timesheet task duration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timesheetTaskDuration.setUserName(userName);
	}

	/**
	* Sets the user uuid of this timesheet task duration.
	*
	* @param userUuid the user uuid of this timesheet task duration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timesheetTaskDuration.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this timesheet task duration.
	*
	* @param uuid the uuid of this timesheet task duration
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_timesheetTaskDuration.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetTaskDurationWrapper)) {
			return false;
		}

		TimesheetTaskDurationWrapper timesheetTaskDurationWrapper = (TimesheetTaskDurationWrapper)obj;

		if (Objects.equals(_timesheetTaskDuration,
					timesheetTaskDurationWrapper._timesheetTaskDuration)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _timesheetTaskDuration.getStagedModelType();
	}

	@Override
	public TimesheetTaskDuration getWrappedModel() {
		return _timesheetTaskDuration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timesheetTaskDuration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timesheetTaskDuration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timesheetTaskDuration.resetOriginalValues();
	}

	private final TimesheetTaskDuration _timesheetTaskDuration;
}