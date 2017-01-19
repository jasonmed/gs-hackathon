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

import com.liferay.gs.hack.projects.model.ProjectUser;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project user service. This utility wraps {@link com.liferay.gs.hack.projects.service.persistence.impl.ProjectUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUserPersistence
 * @see com.liferay.gs.hack.projects.service.persistence.impl.ProjectUserPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectUserUtil {
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
	public static void clearCache(ProjectUser projectUser) {
		getPersistence().clearCache(projectUser);
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
	public static List<ProjectUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectUser update(ProjectUser projectUser) {
		return getPersistence().update(projectUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectUser update(ProjectUser projectUser,
		ServiceContext serviceContext) {
		return getPersistence().update(projectUser, serviceContext);
	}

	/**
	* Returns all the project users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project users
	*/
	public static List<ProjectUser> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of matching project users
	*/
	public static List<ProjectUser> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByUuid_First(java.lang.String uuid,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project users before and after the current project user in the ordered set where uuid = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser[] findByUuid_PrevAndNext(long projectUserId,
		java.lang.String uuid, OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(projectUserId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project users
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the project user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the project user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the project user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the project user that was removed
	*/
	public static ProjectUser removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of project users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching project users
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the project users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching project users
	*/
	public static List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the project users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of matching project users
	*/
	public static List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the project users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the project users before and after the current project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser[] findByUuid_C_PrevAndNext(long projectUserId,
		java.lang.String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(projectUserId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the project users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of project users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching project users
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching project users
	*/
	public static List<ProjectUser> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	* Returns a range of all the project users where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of matching project users
	*/
	public static List<ProjectUser> findByProjectId(long projectId, int start,
		int end) {
		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	* Returns an ordered range of all the project users where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .findByProjectId(projectId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByProjectId(projectId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByProjectId_First(long projectId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProjectId_First(projectId, orderByComparator);
	}

	/**
	* Returns the first project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProjectId_First(long projectId,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByProjectId_First(projectId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByProjectId_Last(long projectId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProjectId_Last(projectId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProjectId_Last(long projectId,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByProjectId_Last(projectId, orderByComparator);
	}

	/**
	* Returns the project users before and after the current project user in the ordered set where projectId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser[] findByProjectId_PrevAndNext(
		long projectUserId, long projectId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProjectId_PrevAndNext(projectUserId, projectId,
			orderByComparator);
	}

	/**
	* Removes all the project users where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	* Returns the number of project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching project users
	*/
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	* Returns all the project users where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching project users
	*/
	public static List<ProjectUser> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	* Returns a range of all the project users where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of matching project users
	*/
	public static List<ProjectUser> findByEmployeeId(long employeeId,
		int start, int end) {
		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the project users where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByEmployeeId(long employeeId,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .findByEmployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByEmployeeId(long employeeId,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEmployeeId(employeeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByEmployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByEmployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByEmployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByEmployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the project users before and after the current project user in the ordered set where employeeId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser[] findByEmployeeId_PrevAndNext(
		long projectUserId, long employeeId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByEmployeeId_PrevAndNext(projectUserId, employeeId,
			orderByComparator);
	}

	/**
	* Removes all the project users where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	* Returns the number of project users where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching project users
	*/
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	* Returns all the project users where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the matching project users
	*/
	public static List<ProjectUser> findByRoleId(long roleId) {
		return getPersistence().findByRoleId(roleId);
	}

	/**
	* Returns a range of all the project users where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of matching project users
	*/
	public static List<ProjectUser> findByRoleId(long roleId, int start, int end) {
		return getPersistence().findByRoleId(roleId, start, end);
	}

	/**
	* Returns an ordered range of all the project users where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByRoleId(long roleId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .findByRoleId(roleId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users where roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param roleId the role ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByRoleId(long roleId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRoleId(roleId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByRoleId_First(long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByRoleId_First(roleId, orderByComparator);
	}

	/**
	* Returns the first project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByRoleId_First(long roleId,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence().fetchByRoleId_First(roleId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByRoleId_Last(long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByRoleId_Last(roleId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByRoleId_Last(long roleId,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence().fetchByRoleId_Last(roleId, orderByComparator);
	}

	/**
	* Returns the project users before and after the current project user in the ordered set where roleId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser[] findByRoleId_PrevAndNext(long projectUserId,
		long roleId, OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByRoleId_PrevAndNext(projectUserId, roleId,
			orderByComparator);
	}

	/**
	* Removes all the project users where roleId = &#63; from the database.
	*
	* @param roleId the role ID
	*/
	public static void removeByRoleId(long roleId) {
		getPersistence().removeByRoleId(roleId);
	}

	/**
	* Returns the number of project users where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the number of matching project users
	*/
	public static int countByRoleId(long roleId) {
		return getPersistence().countByRoleId(roleId);
	}

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByProject_Employee(long projectId,
		long employeeId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByProject_Employee(projectId, employeeId);
	}

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProject_Employee(long projectId,
		long employeeId) {
		return getPersistence().fetchByProject_Employee(projectId, employeeId);
	}

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProject_Employee(long projectId,
		long employeeId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByProject_Employee(projectId, employeeId,
			retrieveFromCache);
	}

	/**
	* Removes the project user where projectId = &#63; and employeeId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the project user that was removed
	*/
	public static ProjectUser removeByProject_Employee(long projectId,
		long employeeId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().removeByProject_Employee(projectId, employeeId);
	}

	/**
	* Returns the number of project users where projectId = &#63; and employeeId = &#63;.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the number of matching project users
	*/
	public static int countByProject_Employee(long projectId, long employeeId) {
		return getPersistence().countByProject_Employee(projectId, employeeId);
	}

	/**
	* Returns all the project users where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @return the matching project users
	*/
	public static List<ProjectUser> findByProject_Role(long projectId,
		long roleId) {
		return getPersistence().findByProject_Role(projectId, roleId);
	}

	/**
	* Returns a range of all the project users where projectId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of matching project users
	*/
	public static List<ProjectUser> findByProject_Role(long projectId,
		long roleId, int start, int end) {
		return getPersistence().findByProject_Role(projectId, roleId, start, end);
	}

	/**
	* Returns an ordered range of all the project users where projectId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByProject_Role(long projectId,
		long roleId, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .findByProject_Role(projectId, roleId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users where projectId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project users
	*/
	public static List<ProjectUser> findByProject_Role(long projectId,
		long roleId, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByProject_Role(projectId, roleId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByProject_Role_First(long projectId,
		long roleId, OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProject_Role_First(projectId, roleId,
			orderByComparator);
	}

	/**
	* Returns the first project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProject_Role_First(long projectId,
		long roleId, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByProject_Role_First(projectId, roleId,
			orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByProject_Role_Last(long projectId,
		long roleId, OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProject_Role_Last(projectId, roleId, orderByComparator);
	}

	/**
	* Returns the last project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProject_Role_Last(long projectId,
		long roleId, OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence()
				   .fetchByProject_Role_Last(projectId, roleId,
			orderByComparator);
	}

	/**
	* Returns the project users before and after the current project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser[] findByProject_Role_PrevAndNext(
		long projectUserId, long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProject_Role_PrevAndNext(projectUserId, projectId,
			roleId, orderByComparator);
	}

	/**
	* Removes all the project users where projectId = &#63; and roleId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	*/
	public static void removeByProject_Role(long projectId, long roleId) {
		getPersistence().removeByProject_Role(projectId, roleId);
	}

	/**
	* Returns the number of project users where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @return the number of matching project users
	*/
	public static int countByProject_Role(long projectId, long roleId) {
		return getPersistence().countByProject_Role(projectId, roleId);
	}

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public static ProjectUser findByProject_Employee_Role(long projectId,
		long employeeId, long roleId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .findByProject_Employee_Role(projectId, employeeId, roleId);
	}

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProject_Employee_Role(long projectId,
		long employeeId, long roleId) {
		return getPersistence()
				   .fetchByProject_Employee_Role(projectId, employeeId, roleId);
	}

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static ProjectUser fetchByProject_Employee_Role(long projectId,
		long employeeId, long roleId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByProject_Employee_Role(projectId, employeeId, roleId,
			retrieveFromCache);
	}

	/**
	* Removes the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the project user that was removed
	*/
	public static ProjectUser removeByProject_Employee_Role(long projectId,
		long employeeId, long roleId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence()
				   .removeByProject_Employee_Role(projectId, employeeId, roleId);
	}

	/**
	* Returns the number of project users where projectId = &#63; and employeeId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the number of matching project users
	*/
	public static int countByProject_Employee_Role(long projectId,
		long employeeId, long roleId) {
		return getPersistence()
				   .countByProject_Employee_Role(projectId, employeeId, roleId);
	}

	/**
	* Caches the project user in the entity cache if it is enabled.
	*
	* @param projectUser the project user
	*/
	public static void cacheResult(ProjectUser projectUser) {
		getPersistence().cacheResult(projectUser);
	}

	/**
	* Caches the project users in the entity cache if it is enabled.
	*
	* @param projectUsers the project users
	*/
	public static void cacheResult(List<ProjectUser> projectUsers) {
		getPersistence().cacheResult(projectUsers);
	}

	/**
	* Creates a new project user with the primary key. Does not add the project user to the database.
	*
	* @param projectUserId the primary key for the new project user
	* @return the new project user
	*/
	public static ProjectUser create(long projectUserId) {
		return getPersistence().create(projectUserId);
	}

	/**
	* Removes the project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user that was removed
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser remove(long projectUserId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().remove(projectUserId);
	}

	public static ProjectUser updateImpl(ProjectUser projectUser) {
		return getPersistence().updateImpl(projectUser);
	}

	/**
	* Returns the project user with the primary key or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public static ProjectUser findByPrimaryKey(long projectUserId)
		throws com.liferay.gs.hack.projects.exception.NoSuchProjectUserException {
		return getPersistence().findByPrimaryKey(projectUserId);
	}

	/**
	* Returns the project user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user, or <code>null</code> if a project user with the primary key could not be found
	*/
	public static ProjectUser fetchByPrimaryKey(long projectUserId) {
		return getPersistence().fetchByPrimaryKey(projectUserId);
	}

	public static java.util.Map<java.io.Serializable, ProjectUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project users.
	*
	* @return the project users
	*/
	public static List<ProjectUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of project users
	*/
	public static List<ProjectUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project users
	*/
	public static List<ProjectUser> findAll(int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project users
	*/
	public static List<ProjectUser> findAll(int start, int end,
		OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project users.
	*
	* @return the number of project users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectUserPersistence, ProjectUserPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ProjectUserPersistence.class);
}