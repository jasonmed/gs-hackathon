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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Timesheet. This utility wraps
 * {@link com.liferay.gs.hack.timesheets.service.impl.TimesheetLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetLocalService
 * @see com.liferay.gs.hack.timesheets.service.base.TimesheetLocalServiceBaseImpl
 * @see com.liferay.gs.hack.timesheets.service.impl.TimesheetLocalServiceImpl
 * @generated
 */
@ProviderType
public class TimesheetLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.gs.hack.timesheets.service.impl.TimesheetLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the timesheet to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheet the timesheet
	* @return the timesheet that was added
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet addTimesheet(
		com.liferay.gs.hack.timesheets.model.Timesheet timesheet) {
		return getService().addTimesheet(timesheet);
	}

	/**
	* Creates a new timesheet with the primary key. Does not add the timesheet to the database.
	*
	* @param timesheetId the primary key for the new timesheet
	* @return the new timesheet
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet createTimesheet(
		long timesheetId) {
		return getService().createTimesheet(timesheetId);
	}

	/**
	* Deletes the timesheet from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheet the timesheet
	* @return the timesheet that was removed
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet deleteTimesheet(
		com.liferay.gs.hack.timesheets.model.Timesheet timesheet) {
		return getService().deleteTimesheet(timesheet);
	}

	/**
	* Deletes the timesheet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet that was removed
	* @throws PortalException if a timesheet with the primary key could not be found
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet deleteTimesheet(
		long timesheetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTimesheet(timesheetId);
	}

	public static com.liferay.gs.hack.timesheets.model.Timesheet fetchTimesheet(
		long timesheetId) {
		return getService().fetchTimesheet(timesheetId);
	}

	/**
	* Returns the timesheet matching the UUID and group.
	*
	* @param uuid the timesheet's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet fetchTimesheetByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchTimesheetByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the timesheet with the primary key.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet
	* @throws PortalException if a timesheet with the primary key could not be found
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet getTimesheet(
		long timesheetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTimesheet(timesheetId);
	}

	/**
	* Returns the timesheet matching the UUID and group.
	*
	* @param uuid the timesheet's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet
	* @throws PortalException if a matching timesheet could not be found
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet getTimesheetByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTimesheetByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the timesheet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheet the timesheet
	* @return the timesheet that was updated
	*/
	public static com.liferay.gs.hack.timesheets.model.Timesheet updateTimesheet(
		com.liferay.gs.hack.timesheets.model.Timesheet timesheet) {
		return getService().updateTimesheet(timesheet);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of timesheets.
	*
	* @return the number of timesheets
	*/
	public static int getTimesheetsCount() {
		return getService().getTimesheetsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of timesheets
	*/
	public static java.util.List<com.liferay.gs.hack.timesheets.model.Timesheet> getTimesheets(
		int start, int end) {
		return getService().getTimesheets(start, end);
	}

	/**
	* Returns all the timesheets matching the UUID and company.
	*
	* @param uuid the UUID of the timesheets
	* @param companyId the primary key of the company
	* @return the matching timesheets, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.gs.hack.timesheets.model.Timesheet> getTimesheetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getTimesheetsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of timesheets matching the UUID and company.
	*
	* @param uuid the UUID of the timesheets
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching timesheets, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.gs.hack.timesheets.model.Timesheet> getTimesheetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.timesheets.model.Timesheet> orderByComparator) {
		return getService()
				   .getTimesheetsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TimesheetLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimesheetLocalService, TimesheetLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TimesheetLocalService.class);
}