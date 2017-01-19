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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.gs.hack.service.http.TimesheetApprovalServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.http.TimesheetApprovalServiceSoap
 * @generated
 */
@ProviderType
public class TimesheetApprovalSoap implements Serializable {
	public static TimesheetApprovalSoap toSoapModel(TimesheetApproval model) {
		TimesheetApprovalSoap soapModel = new TimesheetApprovalSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTimesheetApprovalId(model.getTimesheetApprovalId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static TimesheetApprovalSoap[] toSoapModels(
		TimesheetApproval[] models) {
		TimesheetApprovalSoap[] soapModels = new TimesheetApprovalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimesheetApprovalSoap[][] toSoapModels(
		TimesheetApproval[][] models) {
		TimesheetApprovalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimesheetApprovalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimesheetApprovalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimesheetApprovalSoap[] toSoapModels(
		List<TimesheetApproval> models) {
		List<TimesheetApprovalSoap> soapModels = new ArrayList<TimesheetApprovalSoap>(models.size());

		for (TimesheetApproval model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimesheetApprovalSoap[soapModels.size()]);
	}

	public TimesheetApprovalSoap() {
	}

	public long getPrimaryKey() {
		return _timesheetApprovalId;
	}

	public void setPrimaryKey(long pk) {
		setTimesheetApprovalId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTimesheetApprovalId() {
		return _timesheetApprovalId;
	}

	public void setTimesheetApprovalId(long timesheetApprovalId) {
		_timesheetApprovalId = timesheetApprovalId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getTimesheetId() {
		return _timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private String _uuid;
	private long _timesheetApprovalId;
	private long _groupId;
	private long _timesheetId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _status;
	private String _comment;
}