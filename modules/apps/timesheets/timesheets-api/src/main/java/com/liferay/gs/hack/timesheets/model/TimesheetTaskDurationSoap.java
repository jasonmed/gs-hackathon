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

import com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskDurationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.gs.hack.timesheets.service.http.TimesheetTaskDurationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.timesheets.service.http.TimesheetTaskDurationServiceSoap
 * @generated
 */
@ProviderType
public class TimesheetTaskDurationSoap implements Serializable {
	public static TimesheetTaskDurationSoap toSoapModel(
		TimesheetTaskDuration model) {
		TimesheetTaskDurationSoap soapModel = new TimesheetTaskDurationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTimesheetTaskDurationId(model.getTimesheetTaskDurationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setTimesheetTaskId(model.getTimesheetTaskId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDuration(model.getDuration());
		soapModel.setComment(model.getComment());
		soapModel.setDay(model.getDay());

		return soapModel;
	}

	public static TimesheetTaskDurationSoap[] toSoapModels(
		TimesheetTaskDuration[] models) {
		TimesheetTaskDurationSoap[] soapModels = new TimesheetTaskDurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimesheetTaskDurationSoap[][] toSoapModels(
		TimesheetTaskDuration[][] models) {
		TimesheetTaskDurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimesheetTaskDurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimesheetTaskDurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimesheetTaskDurationSoap[] toSoapModels(
		List<TimesheetTaskDuration> models) {
		List<TimesheetTaskDurationSoap> soapModels = new ArrayList<TimesheetTaskDurationSoap>(models.size());

		for (TimesheetTaskDuration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimesheetTaskDurationSoap[soapModels.size()]);
	}

	public TimesheetTaskDurationSoap() {
	}

	public TimesheetTaskDurationPK getPrimaryKey() {
		return new TimesheetTaskDurationPK(_timesheetTaskDurationId,
			_timesheetId, _timesheetTaskId);
	}

	public void setPrimaryKey(TimesheetTaskDurationPK pk) {
		setTimesheetTaskDurationId(pk.timesheetTaskDurationId);
		setTimesheetId(pk.timesheetId);
		setTimesheetTaskId(pk.timesheetTaskId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTimesheetTaskDurationId() {
		return _timesheetTaskDurationId;
	}

	public void setTimesheetTaskDurationId(long timesheetTaskDurationId) {
		_timesheetTaskDurationId = timesheetTaskDurationId;
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

	public long getTimesheetTaskId() {
		return _timesheetTaskId;
	}

	public void setTimesheetTaskId(long timesheetTaskId) {
		_timesheetTaskId = timesheetTaskId;
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

	public double getDuration() {
		return _duration;
	}

	public void setDuration(double duration) {
		_duration = duration;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public int getDay() {
		return _day;
	}

	public void setDay(int day) {
		_day = day;
	}

	private String _uuid;
	private long _timesheetTaskDurationId;
	private long _groupId;
	private long _timesheetId;
	private long _timesheetTaskId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private double _duration;
	private String _comment;
	private int _day;
}