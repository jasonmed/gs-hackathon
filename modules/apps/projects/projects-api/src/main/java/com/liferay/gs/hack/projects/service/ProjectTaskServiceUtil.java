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

package com.liferay.gs.hack.projects.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ProjectTask. This utility wraps
 * {@link com.liferay.gs.hack.projects.service.impl.ProjectTaskServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskService
 * @see com.liferay.gs.hack.projects.service.base.ProjectTaskServiceBaseImpl
 * @see com.liferay.gs.hack.projects.service.impl.ProjectTaskServiceImpl
 * @generated
 */
@ProviderType
public class ProjectTaskServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.gs.hack.projects.service.impl.ProjectTaskServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization> getAllClients() {
		return getService().getAllClients();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization> getAllProjects(
		long companyId, long clientId) {
		return getService().getAllProjects(companyId, clientId);
	}

	public static ProjectTaskService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectTaskService, ProjectTaskService> _serviceTracker =
		ServiceTrackerFactory.open(ProjectTaskService.class);
}