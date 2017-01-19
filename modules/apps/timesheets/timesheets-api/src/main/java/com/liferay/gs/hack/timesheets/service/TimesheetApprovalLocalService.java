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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.gs.hack.timesheets.model.TimesheetApproval;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for TimesheetApproval. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetApprovalLocalServiceUtil
 * @see com.liferay.gs.hack.timesheets.service.base.TimesheetApprovalLocalServiceBaseImpl
 * @see com.liferay.gs.hack.timesheets.service.impl.TimesheetApprovalLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TimesheetApprovalLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimesheetApprovalLocalServiceUtil} to access the timesheet approval local service. Add custom service methods to {@link com.liferay.gs.hack.timesheets.service.impl.TimesheetApprovalLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the timesheet approval to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetApproval the timesheet approval
	* @return the timesheet approval that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TimesheetApproval addTimesheetApproval(
		TimesheetApproval timesheetApproval);

	/**
	* Creates a new timesheet approval with the primary key. Does not add the timesheet approval to the database.
	*
	* @param timesheetApprovalId the primary key for the new timesheet approval
	* @return the new timesheet approval
	*/
	public TimesheetApproval createTimesheetApproval(long timesheetApprovalId);

	/**
	* Deletes the timesheet approval from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetApproval the timesheet approval
	* @return the timesheet approval that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TimesheetApproval deleteTimesheetApproval(
		TimesheetApproval timesheetApproval);

	/**
	* Deletes the timesheet approval with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetApprovalId the primary key of the timesheet approval
	* @return the timesheet approval that was removed
	* @throws PortalException if a timesheet approval with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TimesheetApproval deleteTimesheetApproval(long timesheetApprovalId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimesheetApproval fetchTimesheetApproval(long timesheetApprovalId);

	/**
	* Returns the timesheet approval matching the UUID and group.
	*
	* @param uuid the timesheet approval's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet approval, or <code>null</code> if a matching timesheet approval could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimesheetApproval fetchTimesheetApprovalByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the timesheet approval with the primary key.
	*
	* @param timesheetApprovalId the primary key of the timesheet approval
	* @return the timesheet approval
	* @throws PortalException if a timesheet approval with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimesheetApproval getTimesheetApproval(long timesheetApprovalId)
		throws PortalException;

	/**
	* Returns the timesheet approval matching the UUID and group.
	*
	* @param uuid the timesheet approval's UUID
	* @param groupId the primary key of the group
	* @return the matching timesheet approval
	* @throws PortalException if a matching timesheet approval could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimesheetApproval getTimesheetApprovalByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the timesheet approval in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheetApproval the timesheet approval
	* @return the timesheet approval that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TimesheetApproval updateTimesheetApproval(
		TimesheetApproval timesheetApproval);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of timesheet approvals.
	*
	* @return the number of timesheet approvals
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimesheetApprovalsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimesheetApproval> getTimesheetApprovals(int start, int end);

	/**
	* Returns all the timesheet approvals matching the UUID and company.
	*
	* @param uuid the UUID of the timesheet approvals
	* @param companyId the primary key of the company
	* @return the matching timesheet approvals, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimesheetApproval> getTimesheetApprovalsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimesheetApproval> getTimesheetApprovalsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TimesheetApproval> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}