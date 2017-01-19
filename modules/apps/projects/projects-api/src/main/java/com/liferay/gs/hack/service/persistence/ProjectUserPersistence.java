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

import com.liferay.gs.hack.exception.NoSuchProjectUserException;
import com.liferay.gs.hack.model.ProjectUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.persistence.impl.ProjectUserPersistenceImpl
 * @see ProjectUserUtil
 * @generated
 */
@ProviderType
public interface ProjectUserPersistence extends BasePersistence<ProjectUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectUserUtil} to access the project user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project users
	*/
	public java.util.List<ProjectUser> findByUuid(java.lang.String uuid);

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
	public java.util.List<ProjectUser> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<ProjectUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the first project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the last project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the last project user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the project users before and after the current project user in the ordered set where uuid = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public ProjectUser[] findByUuid_PrevAndNext(long projectUserId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Removes all the project users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of project users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project users
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the project user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchProjectUserException;

	/**
	* Returns the project user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the project user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the project user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the project user that was removed
	*/
	public ProjectUser removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchProjectUserException;

	/**
	* Returns the number of project users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching project users
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the project users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching project users
	*/
	public java.util.List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the first project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the last project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the last project user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public ProjectUser[] findByUuid_C_PrevAndNext(long projectUserId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Removes all the project users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of project users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching project users
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching project users
	*/
	public java.util.List<ProjectUser> findByProjectId(long projectId);

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
	public java.util.List<ProjectUser> findByProjectId(long projectId,
		int start, int end);

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
	public java.util.List<ProjectUser> findByProjectId(long projectId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findByProjectId(long projectId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByProjectId_First(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the first project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProjectId_First(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the last project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByProjectId_Last(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the last project user in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProjectId_Last(long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the project users before and after the current project user in the ordered set where projectId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public ProjectUser[] findByProjectId_PrevAndNext(long projectUserId,
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Removes all the project users where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	*/
	public void removeByProjectId(long projectId);

	/**
	* Returns the number of project users where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching project users
	*/
	public int countByProjectId(long projectId);

	/**
	* Returns all the project users where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching project users
	*/
	public java.util.List<ProjectUser> findByEmployeeId(long employeeId);

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
	public java.util.List<ProjectUser> findByEmployeeId(long employeeId,
		int start, int end);

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
	public java.util.List<ProjectUser> findByEmployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findByEmployeeId(long employeeId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByEmployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the first project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByEmployeeId_First(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the last project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByEmployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the last project user in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByEmployeeId_Last(long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the project users before and after the current project user in the ordered set where employeeId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public ProjectUser[] findByEmployeeId_PrevAndNext(long projectUserId,
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Removes all the project users where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	*/
	public void removeByEmployeeId(long employeeId);

	/**
	* Returns the number of project users where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching project users
	*/
	public int countByEmployeeId(long employeeId);

	/**
	* Returns all the project users where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the matching project users
	*/
	public java.util.List<ProjectUser> findByRoleId(long roleId);

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
	public java.util.List<ProjectUser> findByRoleId(long roleId, int start,
		int end);

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
	public java.util.List<ProjectUser> findByRoleId(long roleId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findByRoleId(long roleId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByRoleId_First(long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the first project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByRoleId_First(long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the last project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByRoleId_Last(long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the last project user in the ordered set where roleId = &#63;.
	*
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByRoleId_Last(long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the project users before and after the current project user in the ordered set where roleId = &#63;.
	*
	* @param projectUserId the primary key of the current project user
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public ProjectUser[] findByRoleId_PrevAndNext(long projectUserId,
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Removes all the project users where roleId = &#63; from the database.
	*
	* @param roleId the role ID
	*/
	public void removeByRoleId(long roleId);

	/**
	* Returns the number of project users where roleId = &#63;.
	*
	* @param roleId the role ID
	* @return the number of matching project users
	*/
	public int countByRoleId(long roleId);

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByProject_Employee(long projectId, long employeeId)
		throws NoSuchProjectUserException;

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProject_Employee(long projectId, long employeeId);

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProject_Employee(long projectId, long employeeId,
		boolean retrieveFromCache);

	/**
	* Removes the project user where projectId = &#63; and employeeId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the project user that was removed
	*/
	public ProjectUser removeByProject_Employee(long projectId, long employeeId)
		throws NoSuchProjectUserException;

	/**
	* Returns the number of project users where projectId = &#63; and employeeId = &#63;.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @return the number of matching project users
	*/
	public int countByProject_Employee(long projectId, long employeeId);

	/**
	* Returns all the project users where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @return the matching project users
	*/
	public java.util.List<ProjectUser> findByProject_Role(long projectId,
		long roleId);

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
	public java.util.List<ProjectUser> findByProject_Role(long projectId,
		long roleId, int start, int end);

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
	public java.util.List<ProjectUser> findByProject_Role(long projectId,
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findByProject_Role(long projectId,
		long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByProject_Role_First(long projectId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the first project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProject_Role_First(long projectId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

	/**
	* Returns the last project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByProject_Role_Last(long projectId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Returns the last project user in the ordered set where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProject_Role_Last(long projectId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public ProjectUser[] findByProject_Role_PrevAndNext(long projectUserId,
		long projectId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException;

	/**
	* Removes all the project users where projectId = &#63; and roleId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	*/
	public void removeByProject_Role(long projectId, long roleId);

	/**
	* Returns the number of project users where projectId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param roleId the role ID
	* @return the number of matching project users
	*/
	public int countByProject_Role(long projectId, long roleId);

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the matching project user
	* @throws NoSuchProjectUserException if a matching project user could not be found
	*/
	public ProjectUser findByProject_Employee_Role(long projectId,
		long employeeId, long roleId) throws NoSuchProjectUserException;

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProject_Employee_Role(long projectId,
		long employeeId, long roleId);

	/**
	* Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public ProjectUser fetchByProject_Employee_Role(long projectId,
		long employeeId, long roleId, boolean retrieveFromCache);

	/**
	* Removes the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; from the database.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the project user that was removed
	*/
	public ProjectUser removeByProject_Employee_Role(long projectId,
		long employeeId, long roleId) throws NoSuchProjectUserException;

	/**
	* Returns the number of project users where projectId = &#63; and employeeId = &#63; and roleId = &#63;.
	*
	* @param projectId the project ID
	* @param employeeId the employee ID
	* @param roleId the role ID
	* @return the number of matching project users
	*/
	public int countByProject_Employee_Role(long projectId, long employeeId,
		long roleId);

	/**
	* Caches the project user in the entity cache if it is enabled.
	*
	* @param projectUser the project user
	*/
	public void cacheResult(ProjectUser projectUser);

	/**
	* Caches the project users in the entity cache if it is enabled.
	*
	* @param projectUsers the project users
	*/
	public void cacheResult(java.util.List<ProjectUser> projectUsers);

	/**
	* Creates a new project user with the primary key. Does not add the project user to the database.
	*
	* @param projectUserId the primary key for the new project user
	* @return the new project user
	*/
	public ProjectUser create(long projectUserId);

	/**
	* Removes the project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user that was removed
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public ProjectUser remove(long projectUserId)
		throws NoSuchProjectUserException;

	public ProjectUser updateImpl(ProjectUser projectUser);

	/**
	* Returns the project user with the primary key or throws a {@link NoSuchProjectUserException} if it could not be found.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user
	* @throws NoSuchProjectUserException if a project user with the primary key could not be found
	*/
	public ProjectUser findByPrimaryKey(long projectUserId)
		throws NoSuchProjectUserException;

	/**
	* Returns the project user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user, or <code>null</code> if a project user with the primary key could not be found
	*/
	public ProjectUser fetchByPrimaryKey(long projectUserId);

	@Override
	public java.util.Map<java.io.Serializable, ProjectUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project users.
	*
	* @return the project users
	*/
	public java.util.List<ProjectUser> findAll();

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
	public java.util.List<ProjectUser> findAll(int start, int end);

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
	public java.util.List<ProjectUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator);

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
	public java.util.List<ProjectUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project users.
	*
	* @return the number of project users
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}