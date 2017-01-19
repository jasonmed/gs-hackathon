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

package com.liferay.gs.hack.timesheets.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.timesheets.model.TimesheetTask;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the timesheet task service. This utility wraps {@link com.liferay.gs.hack.timesheets.service.persistence.impl.TimesheetTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskPersistence
 * @see com.liferay.gs.hack.timesheets.service.persistence.impl.TimesheetTaskPersistenceImpl
 * @generated
 */
@ProviderType
public class TimesheetTaskUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TimesheetTask timesheetTask) {
		getPersistence().clearCache(timesheetTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TimesheetTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimesheetTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimesheetTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimesheetTask update(TimesheetTask timesheetTask) {
		return getPersistence().update(timesheetTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimesheetTask update(TimesheetTask timesheetTask,
		ServiceContext serviceContext) {
		return getPersistence().update(timesheetTask, serviceContext);
	}

	/**
	* Returns all the timesheet tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the timesheet tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByUuid_First(java.lang.String uuid,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByUuid_Last(java.lang.String uuid,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where uuid = &#63;.
	*
	* @param timesheetTaskId the primary key of the current timesheet task
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask[] findByUuid_PrevAndNext(long timesheetTaskId,
		java.lang.String uuid,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByUuid_PrevAndNext(timesheetTaskId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the timesheet tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of timesheet tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching timesheet tasks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the timesheet task where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the timesheet task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the timesheet task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the timesheet task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the timesheet task that was removed
	*/
	public static TimesheetTask removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of timesheet tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching timesheet tasks
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param timesheetTaskId the primary key of the current timesheet task
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask[] findByUuid_C_PrevAndNext(
		long timesheetTaskId, java.lang.String uuid, long companyId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(timesheetTaskId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the timesheet tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching timesheet tasks
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the timesheet tasks where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the matching timesheet tasks
	*/
	public static List<TimesheetTask> findByTimesheetId(long timesheetId) {
		return getPersistence().findByTimesheetId(timesheetId);
	}

	/**
	* Returns a range of all the timesheet tasks where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByTimesheetId(long timesheetId,
		int start, int end) {
		return getPersistence().findByTimesheetId(timesheetId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByTimesheetId(long timesheetId,
		int start, int end, OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .findByTimesheetId(timesheetId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByTimesheetId(long timesheetId,
		int start, int end, OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTimesheetId(timesheetId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByTimesheetId_First(long timesheetId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByTimesheetId_First(timesheetId, orderByComparator);
	}

	/**
	* Returns the first timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByTimesheetId_First(long timesheetId,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheetId_First(timesheetId, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByTimesheetId_Last(long timesheetId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByTimesheetId_Last(timesheetId, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByTimesheetId_Last(long timesheetId,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheetId_Last(timesheetId, orderByComparator);
	}

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetTaskId the primary key of the current timesheet task
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask[] findByTimesheetId_PrevAndNext(
		long timesheetTaskId, long timesheetId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByTimesheetId_PrevAndNext(timesheetTaskId, timesheetId,
			orderByComparator);
	}

	/**
	* Removes all the timesheet tasks where timesheetId = &#63; from the database.
	*
	* @param timesheetId the timesheet ID
	*/
	public static void removeByTimesheetId(long timesheetId) {
		getPersistence().removeByTimesheetId(timesheetId);
	}

	/**
	* Returns the number of timesheet tasks where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the number of matching timesheet tasks
	*/
	public static int countByTimesheetId(long timesheetId) {
		return getPersistence().countByTimesheetId(timesheetId);
	}

	/**
	* Returns all the timesheet tasks where projectTaskId = &#63;.
	*
	* @param projectTaskId the project task ID
	* @return the matching timesheet tasks
	*/
	public static List<TimesheetTask> findByProjectTaskId(long projectTaskId) {
		return getPersistence().findByProjectTaskId(projectTaskId);
	}

	/**
	* Returns a range of all the timesheet tasks where projectTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectTaskId the project task ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByProjectTaskId(long projectTaskId,
		int start, int end) {
		return getPersistence().findByProjectTaskId(projectTaskId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where projectTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectTaskId the project task ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByProjectTaskId(long projectTaskId,
		int start, int end, OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .findByProjectTaskId(projectTaskId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet tasks where projectTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectTaskId the project task ID
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet tasks
	*/
	public static List<TimesheetTask> findByProjectTaskId(long projectTaskId,
		int start, int end, OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByProjectTaskId(projectTaskId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet task in the ordered set where projectTaskId = &#63;.
	*
	* @param projectTaskId the project task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByProjectTaskId_First(long projectTaskId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByProjectTaskId_First(projectTaskId, orderByComparator);
	}

	/**
	* Returns the first timesheet task in the ordered set where projectTaskId = &#63;.
	*
	* @param projectTaskId the project task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByProjectTaskId_First(long projectTaskId,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .fetchByProjectTaskId_First(projectTaskId, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where projectTaskId = &#63;.
	*
	* @param projectTaskId the project task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public static TimesheetTask findByProjectTaskId_Last(long projectTaskId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByProjectTaskId_Last(projectTaskId, orderByComparator);
	}

	/**
	* Returns the last timesheet task in the ordered set where projectTaskId = &#63;.
	*
	* @param projectTaskId the project task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public static TimesheetTask fetchByProjectTaskId_Last(long projectTaskId,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence()
				   .fetchByProjectTaskId_Last(projectTaskId, orderByComparator);
	}

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where projectTaskId = &#63;.
	*
	* @param timesheetTaskId the primary key of the current timesheet task
	* @param projectTaskId the project task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask[] findByProjectTaskId_PrevAndNext(
		long timesheetTaskId, long projectTaskId,
		OrderByComparator<TimesheetTask> orderByComparator)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence()
				   .findByProjectTaskId_PrevAndNext(timesheetTaskId,
			projectTaskId, orderByComparator);
	}

	/**
	* Removes all the timesheet tasks where projectTaskId = &#63; from the database.
	*
	* @param projectTaskId the project task ID
	*/
	public static void removeByProjectTaskId(long projectTaskId) {
		getPersistence().removeByProjectTaskId(projectTaskId);
	}

	/**
	* Returns the number of timesheet tasks where projectTaskId = &#63;.
	*
	* @param projectTaskId the project task ID
	* @return the number of matching timesheet tasks
	*/
	public static int countByProjectTaskId(long projectTaskId) {
		return getPersistence().countByProjectTaskId(projectTaskId);
	}

	/**
	* Caches the timesheet task in the entity cache if it is enabled.
	*
	* @param timesheetTask the timesheet task
	*/
	public static void cacheResult(TimesheetTask timesheetTask) {
		getPersistence().cacheResult(timesheetTask);
	}

	/**
	* Caches the timesheet tasks in the entity cache if it is enabled.
	*
	* @param timesheetTasks the timesheet tasks
	*/
	public static void cacheResult(List<TimesheetTask> timesheetTasks) {
		getPersistence().cacheResult(timesheetTasks);
	}

	/**
	* Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	*
	* @param timesheetTaskId the primary key for the new timesheet task
	* @return the new timesheet task
	*/
	public static TimesheetTask create(long timesheetTaskId) {
		return getPersistence().create(timesheetTaskId);
	}

	/**
	* Removes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskId the primary key of the timesheet task
	* @return the timesheet task that was removed
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask remove(long timesheetTaskId)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence().remove(timesheetTaskId);
	}

	public static TimesheetTask updateImpl(TimesheetTask timesheetTask) {
		return getPersistence().updateImpl(timesheetTask);
	}

	/**
	* Returns the timesheet task with the primary key or throws a {@link NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param timesheetTaskId the primary key of the timesheet task
	* @return the timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask findByPrimaryKey(long timesheetTaskId)
		throws com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException {
		return getPersistence().findByPrimaryKey(timesheetTaskId);
	}

	/**
	* Returns the timesheet task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetTaskId the primary key of the timesheet task
	* @return the timesheet task, or <code>null</code> if a timesheet task with the primary key could not be found
	*/
	public static TimesheetTask fetchByPrimaryKey(long timesheetTaskId) {
		return getPersistence().fetchByPrimaryKey(timesheetTaskId);
	}

	public static java.util.Map<java.io.Serializable, TimesheetTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the timesheet tasks.
	*
	* @return the timesheet tasks
	*/
	public static List<TimesheetTask> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the timesheet tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @return the range of timesheet tasks
	*/
	public static List<TimesheetTask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the timesheet tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timesheet tasks
	*/
	public static List<TimesheetTask> findAll(int start, int end,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet tasks
	* @param end the upper bound of the range of timesheet tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of timesheet tasks
	*/
	public static List<TimesheetTask> findAll(int start, int end,
		OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the timesheet tasks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timesheet tasks.
	*
	* @return the number of timesheet tasks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TimesheetTaskPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimesheetTaskPersistence, TimesheetTaskPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TimesheetTaskPersistence.class);
}