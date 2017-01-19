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

package com.liferay.gs.hack.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.model.TimesheetTaskDuration;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the timesheet task duration service. This utility wraps {@link com.liferay.gs.hack.service.persistence.impl.TimesheetTaskDurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetTaskDurationPersistence
 * @see com.liferay.gs.hack.service.persistence.impl.TimesheetTaskDurationPersistenceImpl
 * @generated
 */
@ProviderType
public class TimesheetTaskDurationUtil {
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
	public static void clearCache(TimesheetTaskDuration timesheetTaskDuration) {
		getPersistence().clearCache(timesheetTaskDuration);
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
	public static List<TimesheetTaskDuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimesheetTaskDuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimesheetTaskDuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimesheetTaskDuration update(
		TimesheetTaskDuration timesheetTaskDuration) {
		return getPersistence().update(timesheetTaskDuration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimesheetTaskDuration update(
		TimesheetTaskDuration timesheetTaskDuration,
		ServiceContext serviceContext) {
		return getPersistence().update(timesheetTaskDuration, serviceContext);
	}

	/**
	* Returns all the timesheet task durations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the timesheet task durations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @return the range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByUuid_Last(java.lang.String uuid,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param timesheetTaskDurationPK the primary key of the current timesheet task duration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration[] findByUuid_PrevAndNext(
		TimesheetTaskDurationPK timesheetTaskDurationPK, java.lang.String uuid,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(timesheetTaskDurationPK, uuid,
			orderByComparator);
	}

	/**
	* Removes all the timesheet task durations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of timesheet task durations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching timesheet task durations
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the timesheet task duration where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTimesheetTaskDurationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the timesheet task duration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the timesheet task duration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the timesheet task duration where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the timesheet task duration that was removed
	*/
	public static TimesheetTaskDuration removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of timesheet task durations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching timesheet task durations
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @return the range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param timesheetTaskDurationPK the primary key of the current timesheet task duration
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration[] findByUuid_C_PrevAndNext(
		TimesheetTaskDurationPK timesheetTaskDurationPK, java.lang.String uuid,
		long companyId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(timesheetTaskDurationPK, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the timesheet task durations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching timesheet task durations
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the timesheet task durations where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId) {
		return getPersistence().findByTimesheetId(timesheetId);
	}

	/**
	* Returns a range of all the timesheet task durations where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @return the range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId, int start, int end) {
		return getPersistence().findByTimesheetId(timesheetId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .findByTimesheetId(timesheetId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTimesheetId(timesheetId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByTimesheetId_First(
		long timesheetId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByTimesheetId_First(timesheetId, orderByComparator);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByTimesheetId_First(
		long timesheetId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheetId_First(timesheetId, orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByTimesheetId_Last(
		long timesheetId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByTimesheetId_Last(timesheetId, orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByTimesheetId_Last(
		long timesheetId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheetId_Last(timesheetId, orderByComparator);
	}

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetTaskDurationPK the primary key of the current timesheet task duration
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration[] findByTimesheetId_PrevAndNext(
		TimesheetTaskDurationPK timesheetTaskDurationPK, long timesheetId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByTimesheetId_PrevAndNext(timesheetTaskDurationPK,
			timesheetId, orderByComparator);
	}

	/**
	* Removes all the timesheet task durations where timesheetId = &#63; from the database.
	*
	* @param timesheetId the timesheet ID
	*/
	public static void removeByTimesheetId(long timesheetId) {
		getPersistence().removeByTimesheetId(timesheetId);
	}

	/**
	* Returns the number of timesheet task durations where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the number of matching timesheet task durations
	*/
	public static int countByTimesheetId(long timesheetId) {
		return getPersistence().countByTimesheetId(timesheetId);
	}

	/**
	* Returns all the timesheet task durations where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @return the matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId) {
		return getPersistence().findByTimesheetTaskId(timesheetTaskId);
	}

	/**
	* Returns a range of all the timesheet task durations where timesheetTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetTaskId the timesheet task ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @return the range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId, int start, int end) {
		return getPersistence()
				   .findByTimesheetTaskId(timesheetTaskId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where timesheetTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetTaskId the timesheet task ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .findByTimesheetTaskId(timesheetTaskId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet task durations where timesheetTaskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetTaskId the timesheet task ID
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId, int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTimesheetTaskId(timesheetTaskId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByTimesheetTaskId_First(
		long timesheetTaskId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByTimesheetTaskId_First(timesheetTaskId,
			orderByComparator);
	}

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByTimesheetTaskId_First(
		long timesheetTaskId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheetTaskId_First(timesheetTaskId,
			orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration findByTimesheetTaskId_Last(
		long timesheetTaskId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByTimesheetTaskId_Last(timesheetTaskId,
			orderByComparator);
	}

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public static TimesheetTaskDuration fetchByTimesheetTaskId_Last(
		long timesheetTaskId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheetTaskId_Last(timesheetTaskId,
			orderByComparator);
	}

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskDurationPK the primary key of the current timesheet task duration
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration[] findByTimesheetTaskId_PrevAndNext(
		TimesheetTaskDurationPK timesheetTaskDurationPK, long timesheetTaskId,
		OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence()
				   .findByTimesheetTaskId_PrevAndNext(timesheetTaskDurationPK,
			timesheetTaskId, orderByComparator);
	}

	/**
	* Removes all the timesheet task durations where timesheetTaskId = &#63; from the database.
	*
	* @param timesheetTaskId the timesheet task ID
	*/
	public static void removeByTimesheetTaskId(long timesheetTaskId) {
		getPersistence().removeByTimesheetTaskId(timesheetTaskId);
	}

	/**
	* Returns the number of timesheet task durations where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @return the number of matching timesheet task durations
	*/
	public static int countByTimesheetTaskId(long timesheetTaskId) {
		return getPersistence().countByTimesheetTaskId(timesheetTaskId);
	}

	/**
	* Caches the timesheet task duration in the entity cache if it is enabled.
	*
	* @param timesheetTaskDuration the timesheet task duration
	*/
	public static void cacheResult(TimesheetTaskDuration timesheetTaskDuration) {
		getPersistence().cacheResult(timesheetTaskDuration);
	}

	/**
	* Caches the timesheet task durations in the entity cache if it is enabled.
	*
	* @param timesheetTaskDurations the timesheet task durations
	*/
	public static void cacheResult(
		List<TimesheetTaskDuration> timesheetTaskDurations) {
		getPersistence().cacheResult(timesheetTaskDurations);
	}

	/**
	* Creates a new timesheet task duration with the primary key. Does not add the timesheet task duration to the database.
	*
	* @param timesheetTaskDurationPK the primary key for the new timesheet task duration
	* @return the new timesheet task duration
	*/
	public static TimesheetTaskDuration create(
		TimesheetTaskDurationPK timesheetTaskDurationPK) {
		return getPersistence().create(timesheetTaskDurationPK);
	}

	/**
	* Removes the timesheet task duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskDurationPK the primary key of the timesheet task duration
	* @return the timesheet task duration that was removed
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration remove(
		TimesheetTaskDurationPK timesheetTaskDurationPK)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence().remove(timesheetTaskDurationPK);
	}

	public static TimesheetTaskDuration updateImpl(
		TimesheetTaskDuration timesheetTaskDuration) {
		return getPersistence().updateImpl(timesheetTaskDuration);
	}

	/**
	* Returns the timesheet task duration with the primary key or throws a {@link NoSuchTimesheetTaskDurationException} if it could not be found.
	*
	* @param timesheetTaskDurationPK the primary key of the timesheet task duration
	* @return the timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration findByPrimaryKey(
		TimesheetTaskDurationPK timesheetTaskDurationPK)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetTaskDurationException {
		return getPersistence().findByPrimaryKey(timesheetTaskDurationPK);
	}

	/**
	* Returns the timesheet task duration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetTaskDurationPK the primary key of the timesheet task duration
	* @return the timesheet task duration, or <code>null</code> if a timesheet task duration with the primary key could not be found
	*/
	public static TimesheetTaskDuration fetchByPrimaryKey(
		TimesheetTaskDurationPK timesheetTaskDurationPK) {
		return getPersistence().fetchByPrimaryKey(timesheetTaskDurationPK);
	}

	public static java.util.Map<java.io.Serializable, TimesheetTaskDuration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the timesheet task durations.
	*
	* @return the timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the timesheet task durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @return the range of timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the timesheet task durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findAll(int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheet task durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetTaskDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheet task durations
	* @param end the upper bound of the range of timesheet task durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of timesheet task durations
	*/
	public static List<TimesheetTaskDuration> findAll(int start, int end,
		OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the timesheet task durations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timesheet task durations.
	*
	* @return the number of timesheet task durations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TimesheetTaskDurationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimesheetTaskDurationPersistence, TimesheetTaskDurationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TimesheetTaskDurationPersistence.class);
}