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
 * Provides a wrapper for {@link TimesheetTaskDurationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDurationLocalService
 * @generated
 */
@ProviderType
public class TimesheetTaskDurationLocalServiceWrapper
	implements TimesheetTaskDurationLocalService,
		ServiceWrapper<TimesheetTaskDurationLocalService> {
	public TimesheetTaskDurationLocalServiceWrapper(
		TimesheetTaskDurationLocalService timesheetTaskDurationLocalService) {
		_timesheetTaskDurationLocalService = timesheetTaskDurationLocalService;
	}

	/**
	* Adds the timesheet task duration to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskDuration the timesheet task duration
	* @return the timesheet task duration that was added
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration addTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration timesheetTaskDuration) {
		return _timesheetTaskDurationLocalService.addTimesheetTaskDuration(timesheetTaskDuration);
	}

	/**
	* Creates a new timesheet task duration with the primary key. Does not add the timesheet task duration to the database.
	*
	* @param timesheetTaskDurationPK the primary key for the new timesheet task duration
	* @return the new timesheet task duration
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration createTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskDurationPK timesheetTaskDurationPK) {
		return _timesheetTaskDurationLocalService.createTimesheetTaskDuration(timesheetTaskDurationPK);
	}

	/**
	* Deletes the timesheet task duration from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskDuration the timesheet task duration
	* @return the timesheet task duration that was removed
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration deleteTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration timesheetTaskDuration) {
		return _timesheetTaskDurationLocalService.deleteTimesheetTaskDuration(timesheetTaskDuration);
	}

	/**
	* Deletes the timesheet task duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskDurationPK the primary key of the timesheet task duration
	* @return the timesheet task duration that was removed
	* @throws PortalException if a timesheet task duration with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration deleteTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskDurationPK timesheetTaskDurationPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskDurationLocalService.deleteTimesheetTaskDuration(timesheetTaskDurationPK);
	}

	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration fetchTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskDurationPK timesheetTaskDurationPK) {
		return _timesheetTaskDurationLocalService.fetchTimesheetTaskDuration(timesheetTaskDurationPK);
	}

	/**
	* Returns the timesheet task duration matching the UUID and group.
	*
	* @param uuid the timesheet task duration's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration fetchTimesheetTaskDurationByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _timesheetTaskDurationLocalService.fetchTimesheetTaskDurationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the timesheet task duration with the primary key.
	*
	* @param timesheetTaskDurationPK the primary key of the timesheet task duration
	* @return the timesheet task duration
	* @throws PortalException if a timesheet task duration with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration getTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskDurationPK timesheetTaskDurationPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskDurationLocalService.getTimesheetTaskDuration(timesheetTaskDurationPK);
	}

	/**
	* Returns the timesheet task duration matching the UUID and group.
	*
	* @param uuid the timesheet task duration's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet task duration
	* @throws PortalException if a matching timesheet task duration could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration getTimesheetTaskDurationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskDurationLocalService.getTimesheetTaskDurationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the timesheet task duration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskDuration the timesheet task duration
	* @return the timesheet task duration that was updated
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration updateTimesheetTaskDuration(
		com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration timesheetTaskDuration) {
		return _timesheetTaskDurationLocalService.updateTimesheetTaskDuration(timesheetTaskDuration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timesheetTaskDurationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timesheetTaskDurationLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _timesheetTaskDurationLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timesheetTaskDurationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskDurationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskDurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of timesheet task durations.
	*
	* @return the number of timesheet task durations
	*/
	@Override
	public int getTimesheetTaskDurationsCount() {
		return _timesheetTaskDurationLocalService.getTimesheetTaskDurationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timesheetTaskDurationLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _timesheetTaskDurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _timesheetTaskDurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _timesheetTaskDurationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration> findByTimesheetId(
		long timesheetId) {
		return _timesheetTaskDurationLocalService.findByTimesheetId(timesheetId);
	}

	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId) {
		return _timesheetTaskDurationLocalService.findByTimesheetTaskId(timesheetTaskId);
	}

	/**
	* Returns a range of all the timesheet task durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @return the range of timesheet task durations
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration> getTimesheetTaskDurations(
		int start, int end) {
		return _timesheetTaskDurationLocalService.getTimesheetTaskDurations(start,
			end);
	}

	/**
	* Returns all the timesheet task durations matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet task durations
	* @param companyId the primary key of the company
	* @return the matching timesheet task durations, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration> getTimesheetTaskDurationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _timesheetTaskDurationLocalService.getTimesheetTaskDurationsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of timesheet task durations matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet task durations
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching timesheet task durations, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration> getTimesheetTaskDurationsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration> orderByComparator) {
		return _timesheetTaskDurationLocalService.getTimesheetTaskDurationsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _timesheetTaskDurationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _timesheetTaskDurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TimesheetTaskDurationLocalService getWrappedService() {
		return _timesheetTaskDurationLocalService;
	}

	@Override
	public void setWrappedService(
		TimesheetTaskDurationLocalService timesheetTaskDurationLocalService) {
		_timesheetTaskDurationLocalService = timesheetTaskDurationLocalService;
	}

	private TimesheetTaskDurationLocalService _timesheetTaskDurationLocalService;
}