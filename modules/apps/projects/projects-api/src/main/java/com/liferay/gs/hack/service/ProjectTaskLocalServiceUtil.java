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
 * Provides the local service utility for ProjectTask. This utility wraps
 * {@link com.liferay.gs.hack.service.impl.ProjectTaskLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskLocalService
 * @see com.liferay.gs.hack.service.base.ProjectTaskLocalServiceBaseImpl
 * @see com.liferay.gs.hack.service.impl.ProjectTaskLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProjectTaskLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.gs.hack.service.impl.ProjectTaskLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project task to the database. Also notifies the appropriate model listeners.
	*
	* @param projectTask the project task
	* @return the project task that was added
	*/
	public static com.liferay.gs.hack.model.ProjectTask addProjectTask(
		com.liferay.gs.hack.model.ProjectTask projectTask) {
		return getService().addProjectTask(projectTask);
	}

	/**
	* Creates a new project task with the primary key. Does not add the project task to the database.
	*
	* @param projectTaskId the primary key for the new project task
	* @return the new project task
	*/
	public static com.liferay.gs.hack.model.ProjectTask createProjectTask(
		long projectTaskId) {
		return getService().createProjectTask(projectTaskId);
	}

	/**
	* Deletes the project task from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTask the project task
	* @return the project task that was removed
	*/
	public static com.liferay.gs.hack.model.ProjectTask deleteProjectTask(
		com.liferay.gs.hack.model.ProjectTask projectTask) {
		return getService().deleteProjectTask(projectTask);
	}

	/**
	* Deletes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task that was removed
	* @throws PortalException if a project task with the primary key could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectTask deleteProjectTask(
		long projectTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProjectTask(projectTaskId);
	}

	public static com.liferay.gs.hack.model.ProjectTask fetchProjectTask(
		long projectTaskId) {
		return getService().fetchProjectTask(projectTaskId);
	}

	/**
	* Returns the project task matching the UUID and group.
	*
	* @param uuid the project task's UUID
	* @param groupId the primary key of the group
	* @return the matching project task, or <code>null</code> if a matching project task could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectTask fetchProjectTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchProjectTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the project task with the primary key.
	*
	* @param projectTaskId the primary key of the project task
	* @return the project task
	* @throws PortalException if a project task with the primary key could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectTask getProjectTask(
		long projectTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectTask(projectTaskId);
	}

	/**
	* Returns the project task matching the UUID and group.
	*
	* @param uuid the project task's UUID
	* @param groupId the primary key of the group
	* @return the matching project task
	* @throws PortalException if a matching project task could not be found
	*/
	public static com.liferay.gs.hack.model.ProjectTask getProjectTaskByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the project task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectTask the project task
	* @return the project task that was updated
	*/
	public static com.liferay.gs.hack.model.ProjectTask updateProjectTask(
		com.liferay.gs.hack.model.ProjectTask projectTask) {
		return getService().updateProjectTask(projectTask);
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
	* Returns the number of project tasks.
	*
	* @return the number of project tasks
	*/
	public static int getProjectTasksCount() {
		return getService().getProjectTasksCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.liferay.gs.hack.model.ProjectTask> findByProjectId(
		long projectId) {
		return getService().findByProjectId(projectId);
	}

	/**
	* Returns a range of all the project tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.ProjectTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @return the range of project tasks
	*/
	public static java.util.List<com.liferay.gs.hack.model.ProjectTask> getProjectTasks(
		int start, int end) {
		return getService().getProjectTasks(start, end);
	}

	/**
	* Returns all the project tasks matching the UUID and company.
	*
	* @param uuid the UUID of the project tasks
	* @param companyId the primary key of the company
	* @return the matching project tasks, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.gs.hack.model.ProjectTask> getProjectTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getProjectTasksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of project tasks matching the UUID and company.
	*
	* @param uuid the UUID of the project tasks
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of project tasks
	* @param end the upper bound of the range of project tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching project tasks, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.gs.hack.model.ProjectTask> getProjectTasksByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.gs.hack.model.ProjectTask> orderByComparator) {
		return getService()
				   .getProjectTasksByUuidAndCompanyId(uuid, companyId, start,
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

	public static ProjectTaskLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectTaskLocalService, ProjectTaskLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ProjectTaskLocalService.class);
}