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

import com.liferay.gs.hack.timesheets.exception.NoSuchTimesheetTaskException;
import com.liferay.gs.hack.timesheets.model.TimesheetTask;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the timesheet task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.timesheets.service.persistence.impl.TimesheetTaskPersistenceImpl
 * @see TimesheetTaskUtil
 * @generated
 */
@ProviderType
public interface TimesheetTaskPersistence extends BasePersistence<TimesheetTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimesheetTaskUtil} to access the timesheet task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the timesheet tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching timesheet tasks
	*/
	public java.util.List<TimesheetTask> findByUuid(java.lang.String uuid);

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
	public java.util.List<TimesheetTask> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<TimesheetTask> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

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
	public java.util.List<TimesheetTask> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where uuid = &#63;.
	*
	* @param timesheetTaskPK the primary key of the current timesheet task
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public TimesheetTask[] findByUuid_PrevAndNext(
		TimesheetTaskPK timesheetTaskPK, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Removes all the timesheet tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of timesheet tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching timesheet tasks
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the timesheet task where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the timesheet task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the timesheet task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the timesheet task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the timesheet task that was removed
	*/
	public TimesheetTask removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the number of timesheet tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching timesheet tasks
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching timesheet tasks
	*/
	public java.util.List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

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
	public java.util.List<TimesheetTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the first timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the last timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param timesheetTaskPK the primary key of the current timesheet task
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public TimesheetTask[] findByUuid_C_PrevAndNext(
		TimesheetTaskPK timesheetTaskPK, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Removes all the timesheet tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of timesheet tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching timesheet tasks
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the timesheet tasks where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the matching timesheet tasks
	*/
	public java.util.List<TimesheetTask> findByTimesheetId(long timesheetId);

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
	public java.util.List<TimesheetTask> findByTimesheetId(long timesheetId,
		int start, int end);

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
	public java.util.List<TimesheetTask> findByTimesheetId(long timesheetId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

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
	public java.util.List<TimesheetTask> findByTimesheetId(long timesheetId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByTimesheetId_First(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the first timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByTimesheetId_First(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

	/**
	* Returns the last timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task
	* @throws NoSuchTimesheetTaskException if a matching timesheet task could not be found
	*/
	public TimesheetTask findByTimesheetId_Last(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the last timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	*/
	public TimesheetTask fetchByTimesheetId_Last(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

	/**
	* Returns the timesheet tasks before and after the current timesheet task in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetTaskPK the primary key of the current timesheet task
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public TimesheetTask[] findByTimesheetId_PrevAndNext(
		TimesheetTaskPK timesheetTaskPK, long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator)
		throws NoSuchTimesheetTaskException;

	/**
	* Removes all the timesheet tasks where timesheetId = &#63; from the database.
	*
	* @param timesheetId the timesheet ID
	*/
	public void removeByTimesheetId(long timesheetId);

	/**
	* Returns the number of timesheet tasks where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the number of matching timesheet tasks
	*/
	public int countByTimesheetId(long timesheetId);

	/**
	* Caches the timesheet task in the entity cache if it is enabled.
	*
	* @param timesheetTask the timesheet task
	*/
	public void cacheResult(TimesheetTask timesheetTask);

	/**
	* Caches the timesheet tasks in the entity cache if it is enabled.
	*
	* @param timesheetTasks the timesheet tasks
	*/
	public void cacheResult(java.util.List<TimesheetTask> timesheetTasks);

	/**
	* Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	*
	* @param timesheetTaskPK the primary key for the new timesheet task
	* @return the new timesheet task
	*/
	public TimesheetTask create(TimesheetTaskPK timesheetTaskPK);

	/**
	* Removes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetTaskPK the primary key of the timesheet task
	* @return the timesheet task that was removed
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public TimesheetTask remove(TimesheetTaskPK timesheetTaskPK)
		throws NoSuchTimesheetTaskException;

	public TimesheetTask updateImpl(TimesheetTask timesheetTask);

	/**
	* Returns the timesheet task with the primary key or throws a {@link NoSuchTimesheetTaskException} if it could not be found.
	*
	* @param timesheetTaskPK the primary key of the timesheet task
	* @return the timesheet task
	* @throws NoSuchTimesheetTaskException if a timesheet task with the primary key could not be found
	*/
	public TimesheetTask findByPrimaryKey(TimesheetTaskPK timesheetTaskPK)
		throws NoSuchTimesheetTaskException;

	/**
	* Returns the timesheet task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetTaskPK the primary key of the timesheet task
	* @return the timesheet task, or <code>null</code> if a timesheet task with the primary key could not be found
	*/
	public TimesheetTask fetchByPrimaryKey(TimesheetTaskPK timesheetTaskPK);

	@Override
	public java.util.Map<java.io.Serializable, TimesheetTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the timesheet tasks.
	*
	* @return the timesheet tasks
	*/
	public java.util.List<TimesheetTask> findAll();

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
	public java.util.List<TimesheetTask> findAll(int start, int end);

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
	public java.util.List<TimesheetTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator);

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
	public java.util.List<TimesheetTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimesheetTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the timesheet tasks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of timesheet tasks.
	*
	* @return the number of timesheet tasks
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}