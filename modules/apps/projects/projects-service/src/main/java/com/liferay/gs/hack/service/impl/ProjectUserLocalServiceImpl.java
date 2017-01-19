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

package com.liferay.gs.hack.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.model.ProjectUser;
import com.liferay.gs.hack.service.base.ProjectUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the projectUser user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.service.ProjectUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUserLocalServiceBaseImpl
 * @see com.liferay.gs.hack.service.ProjectUserLocalServiceUtil
 */
@ProviderType
public class ProjectUserLocalServiceImpl
	extends ProjectUserLocalServiceBaseImpl {

	public List<ProjectUser> getProjectUserInfoByProjectId_RoleId(
		long projectId, long roleId) {

		return projectUserPersistence.findByProject_Role(projectId, roleId);
	}

	public List<ProjectUser> getProjectUserInfoByEmployeeId(long employeeId) {
		return projectUserPersistence.findByEmployeeId(employeeId);
	}

	public List<ProjectUser> getProjectUserInfoByProjectId(long projectId) {
		return projectUserPersistence.findByProjectId(projectId);
	}

	public ProjectUser getProjectUserInfoByProjectId_EmployeeId(
		long projectId, long employeeId) {

		return projectUserPersistence.fetchByProject_Employee(
			projectId, employeeId);
	}

	public ProjectUser getProjectUserInfoByProjectId_EmployeeId_RoleId(
		long projectId, long employeeId, long roleId) {

		return projectUserPersistence.fetchByProject_Employee_Role(
			projectId, employeeId, roleId);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.service.ProjectUserLocalServiceUtil} to access the projectUser user local service.
	 */

	public ProjectUser updateProjectUser(
		long companyId, long groupId, long userId, long projectId,
		long employeeId, long roleId, double billRate) {

		User user = userLocalService.fetchUser(userId);

		ProjectUser projectUser =
			projectUserPersistence.fetchByProject_Employee_Role(
				projectId, employeeId, roleId);

		if (projectUser == null) {
			projectUser = projectUserPersistence.create(
				counterLocalService.increment(ProjectUser.class.getName()));

			projectUser.setCreateDate(new Date());

			if (_log.isInfoEnabled()) {
				_log.info(
					">>> Creating new Project User Association for" +
						"projectId : " + projectId + "UserId : " + employeeId);
			}
		}

		//set audit fields

		projectUser.setCompanyId(companyId);
		projectUser.setGroupId(groupId);
		projectUser.setUserId(user.getUserId());
		projectUser.setUserName(user.getScreenName());

		projectUser.setProjectId(projectId);
		projectUser.setEmployeeId(employeeId);
		projectUser.setRoleId(roleId);
		projectUser.setBillRate(billRate);

		projectUser.setModifiedDate(new Date());

		return projectUserLocalService.updateProjectUser(projectUser);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectUserLocalServiceImpl.class);

}