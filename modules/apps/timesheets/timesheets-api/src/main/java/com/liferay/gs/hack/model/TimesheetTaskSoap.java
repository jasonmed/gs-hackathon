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

import com.liferay.gs.hack.service.persistence.TimesheetTaskPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.gs.hack.service.http.TimesheetTaskServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.http.TimesheetTaskServiceSoap
 * @generated
 */
@ProviderType
public class TimesheetTaskSoap implements Serializable {
	public static TimesheetTaskSoap toSoapModel(TimesheetTask model) {
		TimesheetTaskSoap soapModel = new TimesheetTaskSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTimesheetTaskId(model.getTimesheetTaskId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setProjectTaskId(model.getProjectTaskId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBillable(model.getBillable());

		return soapModel;
	}

	public static TimesheetTaskSoap[] toSoapModels(TimesheetTask[] models) {
		TimesheetTaskSoap[] soapModels = new TimesheetTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimesheetTaskSoap[][] toSoapModels(TimesheetTask[][] models) {
		TimesheetTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimesheetTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimesheetTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimesheetTaskSoap[] toSoapModels(List<TimesheetTask> models) {
		List<TimesheetTaskSoap> soapModels = new ArrayList<TimesheetTaskSoap>(models.size());

		for (TimesheetTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimesheetTaskSoap[soapModels.size()]);
	}

	public TimesheetTaskSoap() {
	}

	public TimesheetTaskPK getPrimaryKey() {
		return new TimesheetTaskPK(_timesheetTaskId, _timesheetId,
			_projectTaskId);
	}

	public void setPrimaryKey(TimesheetTaskPK pk) {
		setTimesheetTaskId(pk.timesheetTaskId);
		setTimesheetId(pk.timesheetId);
		setProjectTaskId(pk.projectTaskId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTimesheetTaskId() {
		return _timesheetTaskId;
	}

	public void setTimesheetTaskId(long timesheetTaskId) {
		_timesheetTaskId = timesheetTaskId;
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

	public long getProjectTaskId() {
		return _projectTaskId;
	}

	public void setProjectTaskId(long projectTaskId) {
		_projectTaskId = projectTaskId;
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

	public boolean getBillable() {
		return _billable;
	}

	public boolean isBillable() {
		return _billable;
	}

	public void setBillable(boolean billable) {
		_billable = billable;
	}

	private String _uuid;
	private long _timesheetTaskId;
	private long _groupId;
	private long _timesheetId;
	private long _projectTaskId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _billable;
}