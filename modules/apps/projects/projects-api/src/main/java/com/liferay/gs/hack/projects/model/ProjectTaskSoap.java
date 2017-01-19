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

package com.liferay.gs.hack.projects.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.gs.hack.projects.service.http.ProjectTaskServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.projects.service.http.ProjectTaskServiceSoap
 * @generated
 */
@ProviderType
public class ProjectTaskSoap implements Serializable {
	public static ProjectTaskSoap toSoapModel(ProjectTask model) {
		ProjectTaskSoap soapModel = new ProjectTaskSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProjectTaskId(model.getProjectTaskId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProjectTaskSoap[] toSoapModels(ProjectTask[] models) {
		ProjectTaskSoap[] soapModels = new ProjectTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectTaskSoap[][] toSoapModels(ProjectTask[][] models) {
		ProjectTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectTaskSoap[] toSoapModels(List<ProjectTask> models) {
		List<ProjectTaskSoap> soapModels = new ArrayList<ProjectTaskSoap>(models.size());

		for (ProjectTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectTaskSoap[soapModels.size()]);
	}

	public ProjectTaskSoap() {
	}

	public long getPrimaryKey() {
		return _projectTaskId;
	}

	public void setPrimaryKey(long pk) {
		setProjectTaskId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProjectTaskId() {
		return _projectTaskId;
	}

	public void setProjectTaskId(long projectTaskId) {
		_projectTaskId = projectTaskId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _projectTaskId;
	private long _organizationId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
}