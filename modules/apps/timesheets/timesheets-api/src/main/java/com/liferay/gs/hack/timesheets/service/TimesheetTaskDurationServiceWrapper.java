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

package com.liferay.gs.hack.timesheets.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TimesheetTaskDurationService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDurationService
 * @generated
 */
@ProviderType
public class TimesheetTaskDurationServiceWrapper
	implements TimesheetTaskDurationService,
		ServiceWrapper<TimesheetTaskDurationService> {
	public TimesheetTaskDurationServiceWrapper(
		TimesheetTaskDurationService timesheetTaskDurationService) {
		_timesheetTaskDurationService = timesheetTaskDurationService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timesheetTaskDurationService.getOSGiServiceIdentifier();
	}

	@Override
	public TimesheetTaskDurationService getWrappedService() {
		return _timesheetTaskDurationService;
	}

	@Override
	public void setWrappedService(
		TimesheetTaskDurationService timesheetTaskDurationService) {
		_timesheetTaskDurationService = timesheetTaskDurationService;
	}

	private TimesheetTaskDurationService _timesheetTaskDurationService;
}