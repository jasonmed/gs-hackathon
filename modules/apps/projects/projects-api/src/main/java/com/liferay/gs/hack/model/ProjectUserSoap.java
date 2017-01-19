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
 * This class is used by SOAP remote services, specifically {@link com.liferay.gs.hack.service.http.ProjectUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.http.ProjectUserServiceSoap
 * @generated
 */
@ProviderType
public class ProjectUserSoap implements Serializable {
	public static ProjectUserSoap toSoapModel(ProjectUser model) {
		ProjectUserSoap soapModel = new ProjectUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProjectUserId(model.getProjectUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setBillRate(model.getBillRate());

		return soapModel;
	}

	public static ProjectUserSoap[] toSoapModels(ProjectUser[] models) {
		ProjectUserSoap[] soapModels = new ProjectUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectUserSoap[][] toSoapModels(ProjectUser[][] models) {
		ProjectUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectUserSoap[] toSoapModels(List<ProjectUser> models) {
		List<ProjectUserSoap> soapModels = new ArrayList<ProjectUserSoap>(models.size());

		for (ProjectUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectUserSoap[soapModels.size()]);
	}

	public ProjectUserSoap() {
	}

	public long getPrimaryKey() {
		return _projectUserId;
	}

	public void setPrimaryKey(long pk) {
		setProjectUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProjectUserId() {
		return _projectUserId;
	}

	public void setProjectUserId(long projectUserId) {
		_projectUserId = projectUserId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public double getBillRate() {
		return _billRate;
	}

	public void setBillRate(double billRate) {
		_billRate = billRate;
	}

	private String _uuid;
	private long _projectUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _projectId;
	private long _employeeId;
	private long _roleId;
	private double _billRate;
}