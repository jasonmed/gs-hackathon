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

package com.liferay.gs.hack.projects.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.projects.model.ProjectTask;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project task service. This utility wraps {@link com.liferay.gs.hack.projects.service.persistence.impl.ProjectTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskPersistence
 * @see com.liferay.gs.hack.projects.service.persistence.impl.ProjectTaskPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectTaskUtil {
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
	public static void clearCache(ProjectTask projectTask) {
		getPersistence().clearCache(projectTask);
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
	public static List<ProjectTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectTask update(ProjectTask projectTask) {
		return getPersistence().update(projectTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectTask update(ProjectTask projectTask,
		ServiceContext serviceContext) {
		return getPersistence().update(projectTask, serviceContext);
	}

	/**
	* Returns all the project tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project tasks
	*/
	public static List<ProjectTask> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of matching project tasks
	*/
	public static List<ProjectTask> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project tasks
	*/
	public static List<ProjectTask> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project tasks where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project tasks
	*/
	public static List<ProjectTask> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByUuid_First(java.lang.String uuid,
		OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project tasks before and after the current project task in the ordered set where uuid = &#63;.
	*
	* @param projectTaskId the primary key of the current project task
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project task
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask[] findByUuid_PrevAndNext(long projectTaskId,
		java.lang.String uuid, OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByUuid_PrevAndNext(projectTaskId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project tasks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project task where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProjectTaskException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the project task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the project task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the project task where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the project task that was removed
	*/
	public static ProjectTask removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of project tasks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching project tasks
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the project tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching project tasks
	*/
	public static List<ProjectTask> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the project tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of matching project tasks
	*/
	public static List<ProjectTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the project tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project tasks
	*/
	public static List<ProjectTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project tasks where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project tasks
	*/
	public static List<ProjectTask> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first project task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last project task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last project task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the project tasks before and after the current project task in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param projectTaskId the primary key of the current project task
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project task
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask[] findByUuid_C_PrevAndNext(long projectTaskId,
		java.lang.String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(projectTaskId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the project tasks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of project tasks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching project tasks
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the project tasks where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching project tasks
	*/
	public static List<ProjectTask> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	* Returns a range of all the project tasks where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of matching project tasks
	*/
	public static List<ProjectTask> findByProjectId(long projectId, int start,
		int end) {
		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	* Returns an ordered range of all the project tasks where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project tasks
	*/
	public static List<ProjectTask> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .findByProjectId(projectId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project tasks where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project tasks
	*/
	public static List<ProjectTask> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByProjectId(projectId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project task in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByProjectId_First(long projectId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByProjectId_First(projectId, orderByComparator);
	}

	/**
	* Returns the first project task in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByProjectId_First(long projectId,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .fetchByProjectId_First(projectId, orderByComparator);
	}

	/**
	* Returns the last project task in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project task
	* @throws NoSuchProjectTaskException if a matching project task could not be found
	*/
	public static ProjectTask findByProjectId_Last(long projectId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByProjectId_Last(projectId, orderByComparator);
	}

	/**
	* Returns the last project task in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static ProjectTask fetchByProjectId_Last(long projectId,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence()
				   .fetchByProjectId_Last(projectId, orderByComparator);
	}

	/**
	* Returns the project tasks before and after the current project task in the ordered set where projectId = &#63;.
	*
	* @param projectTaskId the primary key of the current project task
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project task
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask[] findByProjectId_PrevAndNext(
		long projectTaskId, long projectId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence()
				   .findByProjectId_PrevAndNext(projectTaskId, projectId,
			orderByComparator);
	}

	/**
	* Removes all the project tasks where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	* Returns the number of project tasks where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching project tasks
	*/
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	* Caches the project task in the entity cache if it is enabled.
	*
	* @param projectTask the project task
	*/
	public static void cacheResult(ProjectTask projectTask) {
		getPersistence().cacheResult(projectTask);
	}

	/**
	* Caches the project tasks in the entity cache if it is enabled.
	*
	* @param projectTasks the project tasks
	*/
	public static void cacheResult(List<ProjectTask> projectTasks) {
		getPersistence().cacheResult(projectTasks);
	}

	/**
	* Creates a new project task with the primary key. Does not add the project task to the database.
	*
	* @param projectTaskId the primary key for the new project task
	* @return the new project task
	*/
	public static ProjectTask create(long projectTaskId) {
		return getPersistence().create(projectTaskId);
	}

	/**
	* Removes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task that was removed
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask remove(long projectTaskId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence().remove(projectTaskId);
	}

	public static ProjectTask updateImpl(ProjectTask projectTask) {
		return getPersistence().updateImpl(projectTask);
	}

	/**
	* Returns the project task with the primary key or throws a {@link NoSuchProjectTaskException} if it could not be found.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task
	* @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	*/
	public static ProjectTask findByPrimaryKey(long projectTaskId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException {
		return getPersistence().findByPrimaryKey(projectTaskId);
	}

	/**
	* Returns the project task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task, or <code>null</code> if a project task with the primary key could not be found
	*/
	public static ProjectTask fetchByPrimaryKey(long projectTaskId) {
		return getPersistence().fetchByPrimaryKey(projectTaskId);
	}

	public static java.util.Map<java.io.Serializable, ProjectTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project tasks.
	*
	* @return the project tasks
	*/
	public static List<ProjectTask> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of project tasks
	*/
	public static List<ProjectTask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project tasks
	*/
	public static List<ProjectTask> findAll(int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project tasks
	*/
	public static List<ProjectTask> findAll(int start, int end,
		OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project tasks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project tasks.
	*
	* @return the number of project tasks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectTaskPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectTaskPersistence, ProjectTaskPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ProjectTaskPersistence.class);
}