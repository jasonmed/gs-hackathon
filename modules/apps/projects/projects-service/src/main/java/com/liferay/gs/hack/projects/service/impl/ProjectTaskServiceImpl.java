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

import com.liferay.gs.hack.projects.service.base.ProjectTaskServiceBaseImpl;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;
import java.util.List;

/**
 * The implementation of the project task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.projects.service.ProjectTaskService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskServiceBaseImpl
 * @see com.liferay.gs.hack.projects.service.ProjectTaskServiceUtil
 */
@ProviderType
public class ProjectTaskServiceImpl extends ProjectTaskServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.projects.service.ProjectTaskServiceUtil} to access the project task remote service.
	 */

	public List<Organization> getAllClients() {

		List<Organization> clients = Collections.emptyList();

		List<Organization> organizations =
			_organizationLocalService.getOrganizations(-1, -1);

		for (Organization organization : organizations) {
			if (!organization.isParentable()) {

				clients.add(organization);
			}
		}

		return clients;
	}

	public List<Organization> getAllProjects(
		long companyId, long clientId) {

		return _organizationLocalService.getSuborganizations(
			companyId, clientId);
	}


	@ServiceReference (type = OrganizationLocalService.class)
	private OrganizationLocalService _organizationLocalService;
}