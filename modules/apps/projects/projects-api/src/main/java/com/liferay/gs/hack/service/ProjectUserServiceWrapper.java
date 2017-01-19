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

package com.liferay.gs.hack.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUserService
 * @generated
 */
@ProviderType
public class ProjectUserServiceWrapper implements ProjectUserService,
	ServiceWrapper<ProjectUserService> {
	public ProjectUserServiceWrapper(ProjectUserService projectUserService) {
		_projectUserService = projectUserService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _projectUserService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectUserService getWrappedService() {
		return _projectUserService;
	}

	@Override
	public void setWrappedService(ProjectUserService projectUserService) {
		_projectUserService = projectUserService;
	}

	private ProjectUserService _projectUserService;
}