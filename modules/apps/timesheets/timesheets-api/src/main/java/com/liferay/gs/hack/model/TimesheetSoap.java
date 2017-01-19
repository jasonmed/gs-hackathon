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
 * This class is used by SOAP remote services, specifically {@link com.liferay.gs.hack.service.http.TimesheetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.http.TimesheetServiceSoap
 * @generated
 */
@ProviderType
public class TimesheetSoap implements Serializable {
	public static TimesheetSoap toSoapModel(Timesheet model) {
		TimesheetSoap soapModel = new TimesheetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TimesheetSoap[] toSoapModels(Timesheet[] models) {
		TimesheetSoap[] soapModels = new TimesheetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimesheetSoap[][] toSoapModels(Timesheet[][] models) {
		TimesheetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimesheetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimesheetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimesheetSoap[] toSoapModels(List<Timesheet> models) {
		List<TimesheetSoap> soapModels = new ArrayList<TimesheetSoap>(models.size());

		for (Timesheet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimesheetSoap[soapModels.size()]);
	}

	public TimesheetSoap() {
	}

	public long getPrimaryKey() {
		return _timesheetId;
	}

	public void setPrimaryKey(long pk) {
		setTimesheetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTimesheetId() {
		return _timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private String _uuid;
	private long _timesheetId;
	private long _groupId;
	private long _userId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _startDate;
	private Date _endDate;
	private String _status;
}