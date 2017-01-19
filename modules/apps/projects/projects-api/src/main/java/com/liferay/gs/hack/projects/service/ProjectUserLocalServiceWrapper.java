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

package com.liferay.gs.hack.projects.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUserLocalService
 * @generated
 */
@ProviderType
public class ProjectUserLocalServiceWrapper implements ProjectUserLocalService,
	ServiceWrapper<ProjectUserLocalService> {
	public ProjectUserLocalServiceWrapper(
		ProjectUserLocalService projectUserLocalService) {
		_projectUserLocalService = projectUserLocalService;
	}

	/**
	* Adds the project user to the database. Also notifies the appropriate model listeners.
	*
	* @param projectUser the project user
	* @return the project user that was added
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser addProjectUser(
		com.liferay.gs.hack.projects.model.ProjectUser projectUser) {
		return _projectUserLocalService.addProjectUser(projectUser);
	}

	/**
	* Creates a new project user with the primary key. Does not add the project user to the database.
	*
	* @param projectUserId the primary key for the new project user
	* @return the new project user
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser createProjectUser(
		long projectUserId) {
		return _projectUserLocalService.createProjectUser(projectUserId);
	}

	/**
	* Deletes the project user from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUser the project user
	* @return the project user that was removed
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser deleteProjectUser(
		com.liferay.gs.hack.projects.model.ProjectUser projectUser) {
		return _projectUserLocalService.deleteProjectUser(projectUser);
	}

	/**
	* Deletes the project user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user that was removed
	* @throws PortalException if a project user with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser deleteProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUserLocalService.deleteProjectUser(projectUserId);
	}

	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser fetchProjectUser(
		long projectUserId) {
		return _projectUserLocalService.fetchProjectUser(projectUserId);
	}

	/**
	* Returns the project user matching the UUID and group.
	*
	* @param uuid the project user's UUID
	* @param groupId the primary key of the group
	* @return the matching project user, or <code>null</code> if a matching project user could not be found
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser fetchProjectUserByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _projectUserLocalService.fetchProjectUserByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the project user with the primary key.
	*
	* @param projectUserId the primary key of the project user
	* @return the project user
	* @throws PortalException if a project user with the primary key could not be found
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser getProjectUser(
		long projectUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUserLocalService.getProjectUser(projectUserId);
	}

	/**
	* Returns the project user matching the UUID and group.
	*
	* @param uuid the project user's UUID
	* @param groupId the primary key of the group
	* @return the matching project user
	* @throws PortalException if a matching project user could not be found
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser getProjectUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUserLocalService.getProjectUserByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the project user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectUser the project user
	* @return the project user that was updated
	*/
	@Override
	public com.liferay.gs.hack.projects.model.ProjectUser updateProjectUser(
		com.liferay.gs.hack.projects.model.ProjectUser projectUser) {
		return _projectUserLocalService.updateProjectUser(projectUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectUserLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _projectUserLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of project users.
	*
	* @return the number of project users
	*/
	@Override
	public int getProjectUsersCount() {
		return _projectUserLocalService.getProjectUsersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _projectUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _projectUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.projects.model.impl.ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _projectUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.projects.model.impl.ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _projectUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the project users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.projects.model.impl.ProjectUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project users
	* @param end the upper bound of the range of project users (not inclusive)
	* @return the range of project users
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.projects.model.ProjectUser> getProjectUsers(
		int start, int end) {
		return _projectUserLocalService.getProjectUsers(start, end);
	}

	/**
	* Returns all the project users matching the UUID and company.
	*
	* @param uuid the UUID of the project users
	* @param companyId the primary key of the company
	* @return the matching project users, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.gs.hack.projects.model.ProjectUser> getProjectUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _projectUserLocalService.getProjectUsersByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.liferay.gs.hack.projects.model.ProjectUser> getProjectUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.projects.model.ProjectUser> orderByComparator) {
		return _projectUserLocalService.getProjectUsersByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _projectUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _projectUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ProjectUserLocalService getWrappedService() {
		return _projectUserLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectUserLocalService projectUserLocalService) {
		_projectUserLocalService = projectUserLocalService;
	}

	private ProjectUserLocalService _projectUserLocalService;
}