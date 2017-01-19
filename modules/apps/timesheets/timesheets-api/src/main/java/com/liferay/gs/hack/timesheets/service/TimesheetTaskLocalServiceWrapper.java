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
 * Provides a wrapper for {@link TimesheetTaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskLocalService
 * @generated
 */
@ProviderType
public class TimesheetTaskLocalServiceWrapper
	implements TimesheetTaskLocalService,
		ServiceWrapper<TimesheetTaskLocalService> {
	public TimesheetTaskLocalServiceWrapper(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		_timesheetTaskLocalService = timesheetTaskLocalService;
	}

	/**
	* Adds the timesheet task to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @return the timesheet task that was added
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask addTimesheetTask(
		com.liferay.gs.hack.timesheets.model.TimesheetTask timesheetTask) {
		return _timesheetTaskLocalService.addTimesheetTask(timesheetTask);
	}

	/**
	* Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	*
	* @param timesheetTaskPK the primary key for the new timesheet task
	* @return the new timesheet task
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask createTimesheetTask(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskPK timesheetTaskPK) {
		return _timesheetTaskLocalService.createTimesheetTask(timesheetTaskPK);
	}

	/**
	* Deletes the timesheet task from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @return the timesheet task that was removed
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask deleteTimesheetTask(
		com.liferay.gs.hack.timesheets.model.TimesheetTask timesheetTask) {
		return _timesheetTaskLocalService.deleteTimesheetTask(timesheetTask);
	}

	/**
	* Deletes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskPK the primary key of the timesheet task
	* @return the timesheet task that was removed
	* @throws PortalException if a timesheet task with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask deleteTimesheetTask(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskPK timesheetTaskPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskLocalService.deleteTimesheetTask(timesheetTaskPK);
	}

	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask fetchTimesheetTask(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskPK timesheetTaskPK) {
		return _timesheetTaskLocalService.fetchTimesheetTask(timesheetTaskPK);
	}

	/**
	* Returns the timesheet task matching the UUID and group.
	*
	* @param uuid the timesheet task's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask fetchTimesheetTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _timesheetTaskLocalService.fetchTimesheetTaskByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the timesheet task with the primary key.
	*
	* @param timesheetTaskPK the primary key of the timesheet task
	* @return the timesheet task
	* @throws PortalException if a timesheet task with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask getTimesheetTask(
		com.liferay.gs.hack.timesheets.service.persistence.TimesheetTaskPK timesheetTaskPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskLocalService.getTimesheetTask(timesheetTaskPK);
	}

	/**
	* Returns the timesheet task matching the UUID and group.
	*
	* @param uuid the timesheet task's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet task
	* @throws PortalException if a matching timesheet task could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask getTimesheetTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskLocalService.getTimesheetTaskByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the timesheet task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheetTask the timesheet task
	* @return the timesheet task that was updated
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetTask updateTimesheetTask(
		com.liferay.gs.hack.timesheets.model.TimesheetTask timesheetTask) {
		return _timesheetTaskLocalService.updateTimesheetTask(timesheetTask);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timesheetTaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timesheetTaskLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _timesheetTaskLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timesheetTaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of timesheet tasks.
	*
	* @return the number of timesheet tasks
	*/
	@Override
	public int getTimesheetTasksCount() {
		return _timesheetTaskLocalService.getTimesheetTasksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timesheetTaskLocalService.getOSGiServiceIdentifier();
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
		return _timesheetTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timesheetTaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timesheetTaskLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTask> findByProjectTaskId(
		long projectTaskId) {
		return _timesheetTaskLocalService.findByProjectTaskId(projectTaskId);
	}

	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTask> findByTimesheetId(
		long timesheetId) {
		return _timesheetTaskLocalService.findByTimesheetId(timesheetId);
	}

	/**
	* Returns a range of all the timesheet tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of timesheet tasks
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTask> getTimesheetTasks(
		int start, int end) {
		return _timesheetTaskLocalService.getTimesheetTasks(start, end);
	}

	/**
	* Returns all the timesheet tasks matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet tasks
	* @param companyId the primary key of the company
	* @return the matching timesheet tasks, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTask> getTimesheetTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _timesheetTaskLocalService.getTimesheetTasksByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of timesheet tasks matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet tasks
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching timesheet tasks, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetTask> getTimesheetTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.timesheets.model.TimesheetTask> orderByComparator) {
		return _timesheetTaskLocalService.getTimesheetTasksByUuidAndCompanyId(uuid,
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
		return _timesheetTaskLocalService.dynamicQueryCount(dynamicQuery);
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
		return _timesheetTaskLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TimesheetTaskLocalService getWrappedService() {
		return _timesheetTaskLocalService;
	}

	@Override
	public void setWrappedService(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		_timesheetTaskLocalService = timesheetTaskLocalService;
	}

	private TimesheetTaskLocalService _timesheetTaskLocalService;
}