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
 * Provides a wrapper for {@link TimesheetApprovalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetApprovalLocalService
 * @generated
 */
@ProviderType
public class TimesheetApprovalLocalServiceWrapper
	implements TimesheetApprovalLocalService,
		ServiceWrapper<TimesheetApprovalLocalService> {
	public TimesheetApprovalLocalServiceWrapper(
		TimesheetApprovalLocalService timesheetApprovalLocalService) {
		_timesheetApprovalLocalService = timesheetApprovalLocalService;
	}

	/**
	* Adds the timesheet approval to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetApproval the timesheet approval
	* @return the timesheet approval that was added
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval addTimesheetApproval(
		com.liferay.gs.hack.timesheets.model.TimesheetApproval timesheetApproval) {
		return _timesheetApprovalLocalService.addTimesheetApproval(timesheetApproval);
	}

	/**
	* Creates a new timesheet approval with the primary key. Does not add the timesheet approval to the database.
	*
	* @param timesheetApprovalId the primary key for the new timesheet approval
	* @return the new timesheet approval
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval createTimesheetApproval(
		long timesheetApprovalId) {
		return _timesheetApprovalLocalService.createTimesheetApproval(timesheetApprovalId);
	}

	/**
	* Deletes the timesheet approval from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetApproval the timesheet approval
	* @return the timesheet approval that was removed
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval deleteTimesheetApproval(
		com.liferay.gs.hack.timesheets.model.TimesheetApproval timesheetApproval) {
		return _timesheetApprovalLocalService.deleteTimesheetApproval(timesheetApproval);
	}

	/**
	* Deletes the timesheet approval with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetApprovalId the primary key of the timesheet approval
	* @return the timesheet approval that was removed
	* @throws PortalException if a timesheet approval with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval deleteTimesheetApproval(
		long timesheetApprovalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetApprovalLocalService.deleteTimesheetApproval(timesheetApprovalId);
	}

	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval fetchTimesheetApproval(
		long timesheetApprovalId) {
		return _timesheetApprovalLocalService.fetchTimesheetApproval(timesheetApprovalId);
	}

	/**
	* Returns the timesheet approval matching the UUID and group.
	*
	* @param uuid the timesheet approval's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet approval, or <code>null</code> if a matching timesheet approval could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval fetchTimesheetApprovalByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _timesheetApprovalLocalService.fetchTimesheetApprovalByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the timesheet approval with the primary key.
	*
	* @param timesheetApprovalId the primary key of the timesheet approval
	* @return the timesheet approval
	* @throws PortalException if a timesheet approval with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval getTimesheetApproval(
		long timesheetApprovalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetApprovalLocalService.getTimesheetApproval(timesheetApprovalId);
	}

	/**
	* Returns the timesheet approval matching the UUID and group.
	*
	* @param uuid the timesheet approval's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet approval
	* @throws PortalException if a matching timesheet approval could not be found
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval getTimesheetApprovalByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetApprovalLocalService.getTimesheetApprovalByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the timesheet approval in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheetApproval the timesheet approval
	* @return the timesheet approval that was updated
	*/
	@Override
	public com.liferay.gs.hack.timesheets.model.TimesheetApproval updateTimesheetApproval(
		com.liferay.gs.hack.timesheets.model.TimesheetApproval timesheetApproval) {
		return _timesheetApprovalLocalService.updateTimesheetApproval(timesheetApproval);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timesheetApprovalLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timesheetApprovalLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _timesheetApprovalLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timesheetApprovalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetApprovalLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetApprovalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of timesheet approvals.
	*
	* @return the number of timesheet approvals
	*/
	@Override
	public int getTimesheetApprovalsCount() {
		return _timesheetApprovalLocalService.getTimesheetApprovalsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timesheetApprovalLocalService.getOSGiServiceIdentifier();
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
		return _timesheetApprovalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetApprovalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timesheetApprovalLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetApprovalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timesheetApprovalLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the timesheet approvals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.timesheets.model.impl.TimesheetApprovalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet approvals
	* @param end the upper bound of the range of timesheet approvals (not inclusive)
	* @return the range of timesheet approvals
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetApproval> getTimesheetApprovals(
		int start, int end) {
		return _timesheetApprovalLocalService.getTimesheetApprovals(start, end);
	}

	/**
	* Returns all the timesheet approvals matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet approvals
	* @param companyId the primary key of the company
	* @return the matching timesheet approvals, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetApproval> getTimesheetApprovalsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _timesheetApprovalLocalService.getTimesheetApprovalsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of timesheet approvals matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet approvals
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of timesheet approvals
	* @param end the upper bound of the range of timesheet approvals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching timesheet approvals, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.timesheets.model.TimesheetApproval> getTimesheetApprovalsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.timesheets.model.TimesheetApproval> orderByComparator) {
		return _timesheetApprovalLocalService.getTimesheetApprovalsByUuidAndCompanyId(uuid,
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
		return _timesheetApprovalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _timesheetApprovalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TimesheetApprovalLocalService getWrappedService() {
		return _timesheetApprovalLocalService;
	}

	@Override
	public void setWrappedService(
		TimesheetApprovalLocalService timesheetApprovalLocalService) {
		_timesheetApprovalLocalService = timesheetApprovalLocalService;
	}

	private TimesheetApprovalLocalService _timesheetApprovalLocalService;
}