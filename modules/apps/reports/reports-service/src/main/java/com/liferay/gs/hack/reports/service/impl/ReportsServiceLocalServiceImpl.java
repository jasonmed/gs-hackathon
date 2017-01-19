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

package com.liferay.gs.hack.reports.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.projects.model.ProjectTask;
import com.liferay.gs.hack.projects.service.ProjectTaskLocalService;
import com.liferay.gs.hack.reports.service.base.ReportsServiceLocalServiceBaseImpl;
import com.liferay.gs.hack.timesheets.model.Timesheet;
import com.liferay.gs.hack.timesheets.model.TimesheetTask;
import com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration;
import com.liferay.gs.hack.timesheets.service.TimesheetLocalService;
import com.liferay.gs.hack.timesheets.service.TimesheetTaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the reports service local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.gs.hack.reports.service.ReportsServiceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Abdullah Bushnaq
 * @see ReportsServiceLocalServiceBaseImpl
 * @see com.liferay.gs.hack.reports.service.ReportsServiceLocalServiceUtil
 */
@ProviderType
public class ReportsServiceLocalServiceImpl
	extends ReportsServiceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.gs.hack.reports.service.ReportsServiceLocalServiceUtil} to access the reports service local service.
	 */

	public Double generateUserTaskTime(long userId, long projectTaskId) throws PortalException {
		double total = 0;

		List<Timesheet> timesheets = _timesheetLocalService.findByUserId(userId);

		for (Timesheet timesheet : timesheets) {
			List<TimesheetTask> timesheetTasks =
				_timesheetTaskLocalService.findByTimesheetId(
					timesheet.getTimesheetId());

			for (TimesheetTask timesheetTask : timesheetTasks) {
				if (timesheetTask.getProjectTaskId() == projectTaskId) {
					List<TimesheetTaskDuration> durations =
						timesheetTask.getTimesheetTaskDurations();

					for (TimesheetTaskDuration duration : durations) {
						total += duration.getDuration();
					}
				}
			}
		}

		return total;
	}

	public Map<User, Double> generateTaskReport(
			long projectTaskId)
		throws PortalException {

		Map<User, Double> projectReport = new HashMap<User, Double>();

		List<TimesheetTask> timesheetTasks =
			_timesheetTaskLocalService.findByProjectTaskId(projectTaskId);

		for (TimesheetTask timesheetTask : timesheetTasks) {
			User user = userLocalService.getUser(timesheetTask.getUserId());

			double total = generateUserTaskTime(
				timesheetTask.getUserId(), projectTaskId);

			projectReport.put(user, total);
		}

		return projectReport;
	}

	public Map<User, Double> generateProjectReport(
			long projectOrganizationId)
		throws PortalException{

		Map<User, Double> projectReport = new HashMap<User, Double>();

		List<ProjectTask> projectTasks =
			_projectTaskLocalService.findByOrganizationId(
				projectOrganizationId);

		for (ProjectTask projectTask : projectTasks) {
			Map<User, Double> projectTaskReport =
				generateTaskReport(projectTask.getProjectTaskId());

			projectReport = mergeReport(projectReport, projectTaskReport);
		}

		return projectReport;

	}

	public Map<User, Double> generateClientReport(
			long clientOrganizationId)
		throws PortalException {

		Organization client =
			OrganizationLocalServiceUtil.getOrganization(
				clientOrganizationId);

		Map<User, Double> clientReport = new HashMap<User, Double>();

		List<Organization> projects = client.getSuborganizations();

		for (Organization project : projects) {
			Map<User, Double> projectReport =
				generateProjectReport(project.getOrganizationId());

			clientReport = mergeReport(clientReport, projectReport);
		}

		return clientReport;
	}

	public Map<User, Double> mergeReport(Map<User, Double> totalReport, Map<User, Double> report) {
		for (Map.Entry<User, Double> reportEntry : report.entrySet()) {
			if (!totalReport.containsKey(reportEntry.getKey())) {
				totalReport.put(reportEntry.getKey(), 0d);
			}

			double totalTime =
				totalReport.get(reportEntry.getValue()) +
					reportEntry.getValue();

			totalReport.put(reportEntry.getKey(), totalTime);
		}

		return totalReport;
	}

	@ServiceReference
	private TimesheetLocalService _timesheetLocalService;
	@ServiceReference
	private TimesheetTaskLocalService _timesheetTaskLocalService;

	@ServiceReference
	private ProjectTaskLocalService _projectTaskLocalService;
}