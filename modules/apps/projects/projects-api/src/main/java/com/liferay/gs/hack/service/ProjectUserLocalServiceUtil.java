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

package com.liferay.gs.hack.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ProjectUser. This utility wraps
 * {@link com.liferay.gs.hack.service.impl.ProjectUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUserLocalService
 * @see com.liferay.gs.hack.service.base.ProjectUserLocalServiceBaseImpl
 * @see com.liferay.gs.hack.service.impl.ProjectUserLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProjectUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.gs.hack.service.impl.ProjectUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project user to the database. Also notifies the appropriate model listeners.
	*
	* @param projectUser the project user
	* @return the project user that was added
	*/
	public static com.liferay.gs.hack.model.ProjectUser addProjectUser(
		com.liferay.gs.hack.model.ProjectUser projectUser) {
		return getService().addProjectUser(projectUser);
	}

	/**
	* Creates a new project user with the primary key. Does not add the project user to the database.
	*
	* @param projectUserId the primary key for the new project user
	* @return the new project user
	*/
	public static com.liferay.gs.hack.model.ProjectUser createProjectUser(
		long projectUserId) {
		return getService().createProjectUser(projectUserId);
	}

	/**
	* Deletes the project user from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUser the project user
	* @return the project user that was removed
	*/
	public static com.liferay.gs.hack.model.ProjectUser deleteProjectUser(
		com.liferay.gs.hack.model.ProjectUser projectUser) {
		return getService().deleteProjectUser(projectUser);
	}

	/**
	* Deletes the project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user that was removed
	* @throws PortalException if a project user with the primary key could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectUser deleteProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProjectUser(projectUserId);
	}

	public static com.liferay.gs.hack.model.ProjectUser fetchProjectUser(
		long projectUserId) {
		return getService().fetchProjectUser(projectUserId);
	}

	/**
	* Returns the project user matching the UUID and group.
	*
	* @param uuid the project user's UUID
	* @param groupId the primary key of the group
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectUser fetchProjectUserByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchProjectUserByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the project user with the primary key.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user
	* @throws PortalException if a project user with the primary key could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectUser getProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectUser(projectUserId);
	}

	/**
	* Returns the project user matching the UUID and group.
	*
	* @param uuid the project user's UUID
	* @param groupId the primary key of the group
	* @return the matching project user
	* @throws PortalException if a matching project user could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectUser getProjectUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectUserByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.gs.hack.model.ProjectUser getProjectUserInfoByProjectId_EmployeeId(
		long projectId, long employeeId) {
		return getService()
				   .getProjectUserInfoByProjectId_EmployeeId(projectId,
			employeeId);
	}

	public static com.liferay.gs.hack.model.ProjectUser getProjectUserInfoByProjectId_EmployeeId_RoleId(
		long projectId, long employeeId, long roleId) {
		return getService()
				   .getProjectUserInfoByProjectId_EmployeeId_RoleId(projectId,
			employeeId, roleId);
	}

	/**
	* Updates the project user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectUser the project user
	* @return the project user that was updated
	*/
	public static com.liferay.gs.hack.model.ProjectUser updateProjectUser(
		com.liferay.gs.hack.model.ProjectUser projectUser) {
		return getService().updateProjectUser(projectUser);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this class directly. Always use {@link ProjectUserLocalServiceUtil} to access the projectUser user local service.
	*/
	public static com.liferay.gs.hack.model.ProjectUser updateProjectUser(
		long companyId, long groupId, long userId, long projectId,
		long employeeId, long roleId, double billRate) {
		return getService()
				   .updateProjectUser(companyId, groupId, userId, projectId,
			employeeId, roleId, billRate);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of project users.
	*
	* @return the number of project users
	*/
	public static int getProjectUsersCount() {
		return getService().getProjectUsersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<java.lang.Long> getEmployeeByProjectId_RoleId(
		long projectId, long roleId) {
		return getService().getEmployeeByProjectId_RoleId(projectId, roleId);
	}

	public static java.util.List<com.liferay.gs.hack.model.ProjectUser> getProjectUserInfoByEmployeeId(
		long employeeId) {
		return getService().getProjectUserInfoByEmployeeId(employeeId);
	}

	public static java.util.List<com.liferay.gs.hack.model.ProjectUser> getProjectUserInfoByProjectId(
		long projectId) {
		return getService().getProjectUserInfoByProjectId(projectId);
	}

	/**
	* Returns a range of all the project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of project users
	*/
	public static java.util.List<com.liferay.gs.hack.model.ProjectUser> getProjectUsers(
		int start, int end) {
		return getService().getProjectUsers(start, end);
	}

	/**
	* Returns all the project users matching the UUID and company.
	*
	* @param uuid the UUID of the project users
	* @param companyId the primary key of the company
	* @return the matching project users, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.gs.hack.model.ProjectUser> getProjectUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getProjectUsersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of project users matching the UUID and company.
	*
	* @param uuid the UUID of the project users
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching project users, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.gs.hack.model.ProjectUser> getProjectUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.model.ProjectUser> orderByComparator) {
		return getService()
				   .getProjectUsersByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProjectUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectUserLocalService, ProjectUserLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ProjectUserLocalService.class);
}