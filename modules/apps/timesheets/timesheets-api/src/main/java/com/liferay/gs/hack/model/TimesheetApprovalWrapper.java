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
 * This class is a wrapper for {@link TimesheetApproval}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetApproval
 * @generated
 */
@ProviderType
public class TimesheetApprovalWrapper implements TimesheetApproval,
	ModelWrapper<TimesheetApproval> {
	public TimesheetApprovalWrapper(TimesheetApproval timesheetApproval) {
		_timesheetApproval = timesheetApproval;
	}

	@Override
	public Class<?> getModelClass() {
		return TimesheetApproval.class;
	}

	@Override
	public String getModelClassName() {
		return TimesheetApproval.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("timesheetApprovalId", getTimesheetApprovalId());
		attributes.put("groupId", getGroupId());
		attributes.put("timesheetId", getTimesheetId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long timesheetApprovalId = (Long)attributes.get("timesheetApprovalId");

		if (timesheetApprovalId != null) {
			setTimesheetApprovalId(timesheetApprovalId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	@Override
	public TimesheetApproval toEscapedModel() {
		return new TimesheetApprovalWrapper(_timesheetApproval.toEscapedModel());
	}

	@Override
	public TimesheetApproval toUnescapedModel() {
		return new TimesheetApprovalWrapper(_timesheetApproval.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _timesheetApproval.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timesheetApproval.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timesheetApproval.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timesheetApproval.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TimesheetApproval> toCacheModel() {
		return _timesheetApproval.toCacheModel();
	}

	@Override
	public int compareTo(TimesheetApproval timesheetApproval) {
		return _timesheetApproval.compareTo(timesheetApproval);
	}

	@Override
	public int hashCode() {
		return _timesheetApproval.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timesheetApproval.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetApprovalWrapper((TimesheetApproval)_timesheetApproval.clone());
	}

	/**
	* Returns the comment of this timesheet approval.
	*
	* @return the comment of this timesheet approval
	*/
	@Override
	public java.lang.String getComment() {
		return _timesheetApproval.getComment();
	}

	/**
	* Returns the status of this timesheet approval.
	*
	* @return the status of this timesheet approval
	*/
	@Override
	public java.lang.String getStatus() {
		return _timesheetApproval.getStatus();
	}

	/**
	* Returns the user name of this timesheet approval.
	*
	* @return the user name of this timesheet approval
	*/
	@Override
	public java.lang.String getUserName() {
		return _timesheetApproval.getUserName();
	}

	/**
	* Returns the user uuid of this timesheet approval.
	*
	* @return the user uuid of this timesheet approval
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timesheetApproval.getUserUuid();
	}

	/**
	* Returns the uuid of this timesheet approval.
	*
	* @return the uuid of this timesheet approval
	*/
	@Override
	public java.lang.String getUuid() {
		return _timesheetApproval.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timesheetApproval.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timesheetApproval.toXmlString();
	}

	/**
	* Returns the create date of this timesheet approval.
	*
	* @return the create date of this timesheet approval
	*/
	@Override
	public Date getCreateDate() {
		return _timesheetApproval.getCreateDate();
	}

	/**
	* Returns the modified date of this timesheet approval.
	*
	* @return the modified date of this timesheet approval
	*/
	@Override
	public Date getModifiedDate() {
		return _timesheetApproval.getModifiedDate();
	}

	/**
	* Returns the company ID of this timesheet approval.
	*
	* @return the company ID of this timesheet approval
	*/
	@Override
	public long getCompanyId() {
		return _timesheetApproval.getCompanyId();
	}

	/**
	* Returns the group ID of this timesheet approval.
	*
	* @return the group ID of this timesheet approval
	*/
	@Override
	public long getGroupId() {
		return _timesheetApproval.getGroupId();
	}

	/**
	* Returns the primary key of this timesheet approval.
	*
	* @return the primary key of this timesheet approval
	*/
	@Override
	public long getPrimaryKey() {
		return _timesheetApproval.getPrimaryKey();
	}

	/**
	* Returns the timesheet approval ID of this timesheet approval.
	*
	* @return the timesheet approval ID of this timesheet approval
	*/
	@Override
	public long getTimesheetApprovalId() {
		return _timesheetApproval.getTimesheetApprovalId();
	}

	/**
	* Returns the timesheet ID of this timesheet approval.
	*
	* @return the timesheet ID of this timesheet approval
	*/
	@Override
	public long getTimesheetId() {
		return _timesheetApproval.getTimesheetId();
	}

	/**
	* Returns the user ID of this timesheet approval.
	*
	* @return the user ID of this timesheet approval
	*/
	@Override
	public long getUserId() {
		return _timesheetApproval.getUserId();
	}

	@Override
	public void persist() {
		_timesheetApproval.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timesheetApproval.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this timesheet approval.
	*
	* @param comment the comment of this timesheet approval
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_timesheetApproval.setComment(comment);
	}

	/**
	* Sets the company ID of this timesheet approval.
	*
	* @param companyId the company ID of this timesheet approval
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timesheetApproval.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this timesheet approval.
	*
	* @param createDate the create date of this timesheet approval
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timesheetApproval.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timesheetApproval.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timesheetApproval.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timesheetApproval.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this timesheet approval.
	*
	* @param groupId the group ID of this timesheet approval
	*/
	@Override
	public void setGroupId(long groupId) {
		_timesheetApproval.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this timesheet approval.
	*
	* @param modifiedDate the modified date of this timesheet approval
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timesheetApproval.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timesheetApproval.setNew(n);
	}

	/**
	* Sets the primary key of this timesheet approval.
	*
	* @param primaryKey the primary key of this timesheet approval
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timesheetApproval.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timesheetApproval.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this timesheet approval.
	*
	* @param status the status of this timesheet approval
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_timesheetApproval.setStatus(status);
	}

	/**
	* Sets the timesheet approval ID of this timesheet approval.
	*
	* @param timesheetApprovalId the timesheet approval ID of this timesheet approval
	*/
	@Override
	public void setTimesheetApprovalId(long timesheetApprovalId) {
		_timesheetApproval.setTimesheetApprovalId(timesheetApprovalId);
	}

	/**
	* Sets the timesheet ID of this timesheet approval.
	*
	* @param timesheetId the timesheet ID of this timesheet approval
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timesheetApproval.setTimesheetId(timesheetId);
	}

	/**
	* Sets the user ID of this timesheet approval.
	*
	* @param userId the user ID of this timesheet approval
	*/
	@Override
	public void setUserId(long userId) {
		_timesheetApproval.setUserId(userId);
	}

	/**
	* Sets the user name of this timesheet approval.
	*
	* @param userName the user name of this timesheet approval
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timesheetApproval.setUserName(userName);
	}

	/**
	* Sets the user uuid of this timesheet approval.
	*
	* @param userUuid the user uuid of this timesheet approval
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timesheetApproval.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this timesheet approval.
	*
	* @param uuid the uuid of this timesheet approval
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_timesheetApproval.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetApprovalWrapper)) {
			return false;
		}

		TimesheetApprovalWrapper timesheetApprovalWrapper = (TimesheetApprovalWrapper)obj;

		if (Objects.equals(_timesheetApproval,
					timesheetApprovalWrapper._timesheetApproval)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _timesheetApproval.getStagedModelType();
	}

	@Override
	public TimesheetApproval getWrappedModel() {
		return _timesheetApproval;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timesheetApproval.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timesheetApproval.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timesheetApproval.resetOriginalValues();
	}

	private final TimesheetApproval _timesheetApproval;
}