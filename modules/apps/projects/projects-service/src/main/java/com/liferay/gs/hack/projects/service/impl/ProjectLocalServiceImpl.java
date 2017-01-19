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

import com.liferay.gs.hack.projects.model.Project;
import com.liferay.gs.hack.projects.service.base.ProjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.projects.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectLocalServiceBaseImpl
 * @see com.liferay.gs.hack.projects.service.ProjectLocalServiceUtil
 */
@ProviderType
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.projects.service.ProjectLocalServiceUtil} to access the project local service.
	 */
    public Project fetchProjectByName(String name) {
        return projectPersistence.fetchByName(name);
    }

    public List<Project> getActiveProjectsByClientId(long clientId) {
        return projectPersistence.findByclientId_active(clientId, true);
    }

    public List<Project> getAllActiveProjects(int start, int end) {
        return projectPersistence.findByactive(true, start, end);
    }

    public List<Project> getAllProjectsByClientId(long clientId) {
        return projectPersistence.findByClientId(clientId);
    }

    public List<Project> getProjectsByStatus(
            boolean active, int start, int end) {

        return projectPersistence.findByactive(active, start, end);
    }

    /**
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link com.liferay.gs.hack.projects.service.ProjectLocalServiceUtil} to access the project local service.
     */

    public Project updateProject(
            long companyId, long groupId, long userId, long clientId, String name,
            Date startDate, Date endDate, boolean active) {

        User user = userLocalService.fetchUser(userId);

        Project project = projectPersistence.fetchByName(name);

        if (project == null) {
            project = projectPersistence.create(
                    counterLocalService.increment(Project.class.getName()));

            project.setCreateDate(new Date());

            if (_log.isInfoEnabled()) {
                _log.info(">>> Creating new project : " + name);
            }
        }

        //set audit fields

        project.setCompanyId(companyId);
        project.setGroupId(groupId);
        project.setUserId(user.getUserId());
        project.setUserName(user.getScreenName());

        project.setClientId(clientId);
        project.setActive(active);
        project.setStartDate(startDate);
        project.setEndDate(endDate);

        project.setModifiedDate(new Date());

        return projectLocalService.updateProject(project);
    }

    private static final Log _log = LogFactoryUtil.getLog(
            ProjectLocalServiceImpl.class);
}