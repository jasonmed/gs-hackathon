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

import com.liferay.gs.hack.model.Timesheet;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the timesheet service. This utility wraps {@link com.liferay.gs.hack.service.persistence.impl.TimesheetPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetPersistence
 * @see com.liferay.gs.hack.service.persistence.impl.TimesheetPersistenceImpl
 * @generated
 */
@ProviderType
public class TimesheetUtil {
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
	public static void clearCache(Timesheet timesheet) {
		getPersistence().clearCache(timesheet);
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
	public static List<Timesheet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Timesheet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Timesheet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Timesheet update(Timesheet timesheet) {
		return getPersistence().update(timesheet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Timesheet update(Timesheet timesheet,
		ServiceContext serviceContext) {
		return getPersistence().update(timesheet, serviceContext);
	}

	/**
	* Returns all the timesheets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching timesheets
	*/
	public static List<Timesheet> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the timesheets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public static List<Timesheet> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the timesheets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUuid_First(java.lang.String uuid,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first timesheet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where uuid = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet[] findByUuid_PrevAndNext(long timesheetId,
		java.lang.String uuid, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByUuid_PrevAndNext(timesheetId, uuid, orderByComparator);
	}

	/**
	* Removes all the timesheets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of timesheets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching timesheets
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the timesheet where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTimesheetException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the timesheet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the timesheet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the timesheet where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the timesheet that was removed
	*/
	public static Timesheet removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of timesheets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching timesheets
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the timesheets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching timesheets
	*/
	public static List<Timesheet> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the timesheets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public static List<Timesheet> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet[] findByUuid_C_PrevAndNext(long timesheetId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(timesheetId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the timesheets where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of timesheets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching timesheets
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the timesheets where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching timesheets
	*/
	public static List<Timesheet> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the timesheets where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public static List<Timesheet> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the timesheets where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByUserId(long userId, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByUserId(long userId, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUserId_First(long userId,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUserId_First(long userId,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUserId_Last(long userId,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUserId_Last(long userId,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where userId = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet[] findByUserId_PrevAndNext(long timesheetId,
		long userId, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByUserId_PrevAndNext(timesheetId, userId,
			orderByComparator);
	}

	/**
	* Removes all the timesheets where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of timesheets where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching timesheets
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the timesheets where startDate = &#63;.
	*
	* @param startDate the start date
	* @return the matching timesheets
	*/
	public static List<Timesheet> findByStartDate(Date startDate) {
		return getPersistence().findByStartDate(startDate);
	}

	/**
	* Returns a range of all the timesheets where startDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public static List<Timesheet> findByStartDate(Date startDate, int start,
		int end) {
		return getPersistence().findByStartDate(startDate, start, end);
	}

	/**
	* Returns an ordered range of all the timesheets where startDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByStartDate(Date startDate, int start,
		int end, OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .findByStartDate(startDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets where startDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startDate the start date
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByStartDate(Date startDate, int start,
		int end, OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStartDate(startDate, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet in the ordered set where startDate = &#63;.
	*
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByStartDate_First(Date startDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByStartDate_First(startDate, orderByComparator);
	}

	/**
	* Returns the first timesheet in the ordered set where startDate = &#63;.
	*
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByStartDate_First(Date startDate,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .fetchByStartDate_First(startDate, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where startDate = &#63;.
	*
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByStartDate_Last(Date startDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByStartDate_Last(startDate, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where startDate = &#63;.
	*
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByStartDate_Last(Date startDate,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .fetchByStartDate_Last(startDate, orderByComparator);
	}

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where startDate = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param startDate the start date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet[] findByStartDate_PrevAndNext(long timesheetId,
		Date startDate, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByStartDate_PrevAndNext(timesheetId, startDate,
			orderByComparator);
	}

	/**
	* Removes all the timesheets where startDate = &#63; from the database.
	*
	* @param startDate the start date
	*/
	public static void removeByStartDate(Date startDate) {
		getPersistence().removeByStartDate(startDate);
	}

	/**
	* Returns the number of timesheets where startDate = &#63;.
	*
	* @param startDate the start date
	* @return the number of matching timesheets
	*/
	public static int countByStartDate(Date startDate) {
		return getPersistence().countByStartDate(startDate);
	}

	/**
	* Returns all the timesheets where endDate = &#63;.
	*
	* @param endDate the end date
	* @return the matching timesheets
	*/
	public static List<Timesheet> findByEndDate(Date endDate) {
		return getPersistence().findByEndDate(endDate);
	}

	/**
	* Returns a range of all the timesheets where endDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public static List<Timesheet> findByEndDate(Date endDate, int start, int end) {
		return getPersistence().findByEndDate(endDate, start, end);
	}

	/**
	* Returns an ordered range of all the timesheets where endDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByEndDate(Date endDate, int start,
		int end, OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .findByEndDate(endDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets where endDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param endDate the end date
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByEndDate(Date endDate, int start,
		int end, OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEndDate(endDate, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet in the ordered set where endDate = &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByEndDate_First(Date endDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByEndDate_First(endDate, orderByComparator);
	}

	/**
	* Returns the first timesheet in the ordered set where endDate = &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByEndDate_First(Date endDate,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByEndDate_First(endDate, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where endDate = &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByEndDate_Last(Date endDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByEndDate_Last(endDate, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where endDate = &#63;.
	*
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByEndDate_Last(Date endDate,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByEndDate_Last(endDate, orderByComparator);
	}

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where endDate = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet[] findByEndDate_PrevAndNext(long timesheetId,
		Date endDate, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByEndDate_PrevAndNext(timesheetId, endDate,
			orderByComparator);
	}

	/**
	* Removes all the timesheets where endDate = &#63; from the database.
	*
	* @param endDate the end date
	*/
	public static void removeByEndDate(Date endDate) {
		getPersistence().removeByEndDate(endDate);
	}

	/**
	* Returns the number of timesheets where endDate = &#63;.
	*
	* @param endDate the end date
	* @return the number of matching timesheets
	*/
	public static int countByEndDate(Date endDate) {
		return getPersistence().countByEndDate(endDate);
	}

	/**
	* Returns all the timesheets where status = &#63;.
	*
	* @param status the status
	* @return the matching timesheets
	*/
	public static List<Timesheet> findByStatus(java.lang.String status) {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the timesheets where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public static List<Timesheet> findByStatus(java.lang.String status,
		int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the timesheets where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByStatus(java.lang.String status,
		int start, int end, OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public static List<Timesheet> findByStatus(java.lang.String status,
		int start, int end, OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timesheet in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByStatus_First(java.lang.String status,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first timesheet in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByStatus_First(java.lang.String status,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByStatus_Last(java.lang.String status,
		OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last timesheet in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByStatus_Last(java.lang.String status,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where status = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet[] findByStatus_PrevAndNext(long timesheetId,
		java.lang.String status, OrderByComparator<Timesheet> orderByComparator)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence()
				   .findByStatus_PrevAndNext(timesheetId, status,
			orderByComparator);
	}

	/**
	* Removes all the timesheets where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeByStatus(java.lang.String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of timesheets where status = &#63;.
	*
	* @param status the status
	* @return the number of matching timesheets
	*/
	public static int countByStatus(java.lang.String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the timesheet where userId = &#63; and startDate = &#63; or throws a {@link NoSuchTimesheetException} if it could not be found.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @return the matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public static Timesheet findByUserId_StartDate(long userId, Date startDate)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByUserId_StartDate(userId, startDate);
	}

	/**
	* Returns the timesheet where userId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUserId_StartDate(long userId, Date startDate) {
		return getPersistence().fetchByUserId_StartDate(userId, startDate);
	}

	/**
	* Returns the timesheet where userId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public static Timesheet fetchByUserId_StartDate(long userId,
		Date startDate, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByUserId_StartDate(userId, startDate, retrieveFromCache);
	}

	/**
	* Removes the timesheet where userId = &#63; and startDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @return the timesheet that was removed
	*/
	public static Timesheet removeByUserId_StartDate(long userId, Date startDate)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().removeByUserId_StartDate(userId, startDate);
	}

	/**
	* Returns the number of timesheets where userId = &#63; and startDate = &#63;.
	*
	* @param userId the user ID
	* @param startDate the start date
	* @return the number of matching timesheets
	*/
	public static int countByUserId_StartDate(long userId, Date startDate) {
		return getPersistence().countByUserId_StartDate(userId, startDate);
	}

	/**
	* Caches the timesheet in the entity cache if it is enabled.
	*
	* @param timesheet the timesheet
	*/
	public static void cacheResult(Timesheet timesheet) {
		getPersistence().cacheResult(timesheet);
	}

	/**
	* Caches the timesheets in the entity cache if it is enabled.
	*
	* @param timesheets the timesheets
	*/
	public static void cacheResult(List<Timesheet> timesheets) {
		getPersistence().cacheResult(timesheets);
	}

	/**
	* Creates a new timesheet with the primary key. Does not add the timesheet to the database.
	*
	* @param timesheetId the primary key for the new timesheet
	* @return the new timesheet
	*/
	public static Timesheet create(long timesheetId) {
		return getPersistence().create(timesheetId);
	}

	/**
	* Removes the timesheet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet that was removed
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet remove(long timesheetId)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().remove(timesheetId);
	}

	public static Timesheet updateImpl(Timesheet timesheet) {
		return getPersistence().updateImpl(timesheet);
	}

	/**
	* Returns the timesheet with the primary key or throws a {@link NoSuchTimesheetException} if it could not be found.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public static Timesheet findByPrimaryKey(long timesheetId)
		throws com.liferay.gs.hack.exception.NoSuchTimesheetException {
		return getPersistence().findByPrimaryKey(timesheetId);
	}

	/**
	* Returns the timesheet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet, or <code>null</code> if a timesheet with the primary key could not be found
	*/
	public static Timesheet fetchByPrimaryKey(long timesheetId) {
		return getPersistence().fetchByPrimaryKey(timesheetId);
	}

	public static java.util.Map<java.io.Serializable, Timesheet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the timesheets.
	*
	* @return the timesheets
	*/
	public static List<Timesheet> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of timesheets
	*/
	public static List<Timesheet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timesheets
	*/
	public static List<Timesheet> findAll(int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of timesheets
	*/
	public static List<Timesheet> findAll(int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the timesheets from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timesheets.
	*
	* @return the number of timesheets
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TimesheetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimesheetPersistence, TimesheetPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TimesheetPersistence.class);
}