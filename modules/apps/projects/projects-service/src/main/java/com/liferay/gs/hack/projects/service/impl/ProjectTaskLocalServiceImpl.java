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

package com.liferay.gs.hack.projects.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.projects.model.ProjectTask;
import com.liferay.gs.hack.projects.service.base.ProjectTaskLocalServiceBaseImpl;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the project task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.projects.service.ProjectTaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskLocalServiceBaseImpl
 * @see com.liferay.gs.hack.projects.service.ProjectTaskLocalServiceUtil
 */
@ProviderType
public class ProjectTaskLocalServiceImpl extends ProjectTaskLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.projects.service.ProjectTaskLocalServiceUtil} to access the project task local service.
	 */

	public List<ProjectTask> findByOrganizationId(long organizationId) {
		return projectTaskPersistence.findByOrganizationId(organizationId);
	}

	public ProjectTask updateProjectTask(
		long companyId, long userId, long organizationId, String name,
		String description) {

		ProjectTask projectTask =
			projectTaskPersistence.fetchByOrganization_Name(
				organizationId, name);

		if (projectTask == null) {

			projectTask = projectTaskPersistence.create(
				counterLocalService.increment(ProjectTask.class.getName()));

			projectTask.setCreateDate(new Date());
		}

		User user = userLocalService.fetchUser(userId);

		projectTask.setCompanyId(companyId);
		projectTask.setUserId(userId);
		projectTask.setUserName(user.getScreenName());

		projectTask.setOrganizationId(organizationId);
		projectTask.setName(name);
		projectTask.setDescription(description);

		projectTask.setModifiedDate(new Date());

		return projectTaskLocalService.updateProjectTask(projectTask);
	}
}