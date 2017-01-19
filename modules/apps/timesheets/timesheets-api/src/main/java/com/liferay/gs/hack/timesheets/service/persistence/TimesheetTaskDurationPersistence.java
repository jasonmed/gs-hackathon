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

import com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskDurationException;
import com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the timesheet task duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.timesheets.service.persistence.impl.TimesheetTaskDurationPersistenceImpl
 * @see TimesheetTaskDurationUtil
 * @generated
 */
@ProviderType
public interface TimesheetTaskDurationPersistence extends BasePersistence<TimesheetTaskDuration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimesheetTaskDurationUtil} to access the timesheet task duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the timesheet task durations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching timesheet task durations
	*/
	public java.util.List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

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
	public java.util.List<TimesheetTaskDuration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where uuid = &#63;.
	*
	* @param timesheetTaskDurationId the primary key of the current timesheet task duration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration[] findByUuid_PrevAndNext(
		long timesheetTaskDurationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Removes all the timesheet task durations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of timesheet task durations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching timesheet task durations
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the timesheet task duration where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTimesheetTaskDurationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the timesheet task duration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByUUID_G(java.lang.String uuid,
		long groupId);

	/**
	* Returns the timesheet task duration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache);

	/**
	* Removes the timesheet task duration where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the timesheet task duration that was removed
	*/
	public TimesheetTaskDuration removeByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the number of timesheet task durations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching timesheet task durations
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching timesheet task durations
	*/
	public java.util.List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId);

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
	public java.util.List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

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
	public java.util.List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

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
	public java.util.List<TimesheetTaskDuration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the first timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the last timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param timesheetTaskDurationId the primary key of the current timesheet task duration
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration[] findByUuid_C_PrevAndNext(
		long timesheetTaskDurationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Removes all the timesheet task durations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of timesheet task durations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching timesheet task durations
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the timesheet task durations where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the matching timesheet task durations
	*/
	public java.util.List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId);

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
	public java.util.List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId, int start, int end);

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
	public java.util.List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

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
	public java.util.List<TimesheetTaskDuration> findByTimesheetId(
		long timesheetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByTimesheetId_First(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByTimesheetId_First(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByTimesheetId_Last(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByTimesheetId_Last(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetTaskDurationId the primary key of the current timesheet task duration
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration[] findByTimesheetId_PrevAndNext(
		long timesheetTaskDurationId, long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Removes all the timesheet task durations where timesheetId = &#63; from the database.
	*
	* @param timesheetId the timesheet ID
	*/
	public void removeByTimesheetId(long timesheetId);

	/**
	* Returns the number of timesheet task durations where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the number of matching timesheet task durations
	*/
	public int countByTimesheetId(long timesheetId);

	/**
	* Returns all the timesheet task durations where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @return the matching timesheet task durations
	*/
	public java.util.List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId);

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
	public java.util.List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId, int start, int end);

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
	public java.util.List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

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
	public java.util.List<TimesheetTaskDuration> findByTimesheetTaskId(
		long timesheetTaskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByTimesheetTaskId_First(
		long timesheetTaskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the first timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByTimesheetTaskId_First(
		long timesheetTaskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration findByTimesheetTaskId_Last(
		long timesheetTaskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the last timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task duration, or <code>null</code> if a matching timesheet task duration could not be found
	*/
	public TimesheetTaskDuration fetchByTimesheetTaskId_Last(
		long timesheetTaskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

	/**
	* Returns the timesheet task durations before and after the current timesheet task duration in the ordered set where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskDurationId the primary key of the current timesheet task duration
	* @param timesheetTaskId the timesheet task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration[] findByTimesheetTaskId_PrevAndNext(
		long timesheetTaskDurationId, long timesheetTaskId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Removes all the timesheet task durations where timesheetTaskId = &#63; from the database.
	*
	* @param timesheetTaskId the timesheet task ID
	*/
	public void removeByTimesheetTaskId(long timesheetTaskId);

	/**
	* Returns the number of timesheet task durations where timesheetTaskId = &#63;.
	*
	* @param timesheetTaskId the timesheet task ID
	* @return the number of matching timesheet task durations
	*/
	public int countByTimesheetTaskId(long timesheetTaskId);

	/**
	* Caches the timesheet task duration in the entity cache if it is enabled.
	*
	* @param timesheetTaskDuration the timesheet task duration
	*/
	public void cacheResult(TimesheetTaskDuration timesheetTaskDuration);

	/**
	* Caches the timesheet task durations in the entity cache if it is enabled.
	*
	* @param timesheetTaskDurations the timesheet task durations
	*/
	public void cacheResult(
		java.util.List<TimesheetTaskDuration> timesheetTaskDurations);

	/**
	* Creates a new timesheet task duration with the primary key. Does not add the timesheet task duration to the database.
	*
	* @param timesheetTaskDurationId the primary key for the new timesheet task duration
	* @return the new timesheet task duration
	*/
	public TimesheetTaskDuration create(long timesheetTaskDurationId);

	/**
	* Removes the timesheet task duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskDurationId the primary key of the timesheet task duration
	* @return the timesheet task duration that was removed
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration remove(long timesheetTaskDurationId)
		throws NoSuchTimesheetTaskDurationException;

	public TimesheetTaskDuration updateImpl(
		TimesheetTaskDuration timesheetTaskDuration);

	/**
	* Returns the timesheet task duration with the primary key or throws a {@link NoSuchTimesheetTaskDurationException} if it could not be found.
	*
	* @param timesheetTaskDurationId the primary key of the timesheet task duration
	* @return the timesheet task duration
	* @throws NoSuchTimesheetTaskDurationException if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration findByPrimaryKey(long timesheetTaskDurationId)
		throws NoSuchTimesheetTaskDurationException;

	/**
	* Returns the timesheet task duration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetTaskDurationId the primary key of the timesheet task duration
	* @return the timesheet task duration, or <code>null</code> if a timesheet task duration with the primary key could not be found
	*/
	public TimesheetTaskDuration fetchByPrimaryKey(long timesheetTaskDurationId);

	@Override
	public java.util.Map<java.io.Serializable, TimesheetTaskDuration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the timesheet task durations.
	*
	* @return the timesheet task durations
	*/
	public java.util.List<TimesheetTaskDuration> findAll();

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
	public java.util.List<TimesheetTaskDuration> findAll(int start, int end);

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
	public java.util.List<TimesheetTaskDuration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator);

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
	public java.util.List<TimesheetTaskDuration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTaskDuration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the timesheet task durations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of timesheet task durations.
	*
	* @return the number of timesheet task durations
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}