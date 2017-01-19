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

package com.liferay.gs.hack.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.gs.hack.model.TimesheetTask;
import com.liferay.gs.hack.service.TimesheetTaskLocalService;
import com.liferay.gs.hack.service.persistence.TimesheetApprovalPersistence;
import com.liferay.gs.hack.service.persistence.TimesheetPersistence;
import com.liferay.gs.hack.service.persistence.TimesheetTaskDurationPersistence;
import com.liferay.gs.hack.service.persistence.TimesheetTaskPK;
import com.liferay.gs.hack.service.persistence.TimesheetTaskPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the timesheet task local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.gs.hack.service.impl.TimesheetTaskLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.impl.TimesheetTaskLocalServiceImpl
 * @see com.liferay.gs.hack.service.TimesheetTaskLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class TimesheetTaskLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TimesheetTaskLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.gs.hack.service.TimesheetTaskLocalServiceUtil} to access the timesheet task local service.
	 */

	/**
	 * Adds the timesheet task to the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTask the timesheet task
	 * @return the timesheet task that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TimesheetTask addTimesheetTask(TimesheetTask timesheetTask) {
		timesheetTask.setNew(true);

		return timesheetTaskPersistence.update(timesheetTask);
	}

	/**
	 * Creates a new timesheet task with the primary key. Does not add the timesheet task to the database.
	 *
	 * @param timesheetTaskPK the primary key for the new timesheet task
	 * @return the new timesheet task
	 */
	@Override
	public TimesheetTask createTimesheetTask(TimesheetTaskPK timesheetTaskPK) {
		return timesheetTaskPersistence.create(timesheetTaskPK);
	}

	/**
	 * Deletes the timesheet task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTaskPK the primary key of the timesheet task
	 * @return the timesheet task that was removed
	 * @throws PortalException if a timesheet task with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TimesheetTask deleteTimesheetTask(TimesheetTaskPK timesheetTaskPK)
		throws PortalException {
		return timesheetTaskPersistence.remove(timesheetTaskPK);
	}

	/**
	 * Deletes the timesheet task from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTask the timesheet task
	 * @return the timesheet task that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TimesheetTask deleteTimesheetTask(TimesheetTask timesheetTask) {
		return timesheetTaskPersistence.remove(timesheetTask);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TimesheetTask.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return timesheetTaskPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return timesheetTaskPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return timesheetTaskPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return timesheetTaskPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return timesheetTaskPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public TimesheetTask fetchTimesheetTask(TimesheetTaskPK timesheetTaskPK) {
		return timesheetTaskPersistence.fetchByPrimaryKey(timesheetTaskPK);
	}

	/**
	 * Returns the timesheet task matching the UUID and group.
	 *
	 * @param uuid the timesheet task's UUID
	 * @param groupId the primary key of the group
	 * @return the matching timesheet task, or <code>null</code> if a matching timesheet task could not be found
	 */
	@Override
	public TimesheetTask fetchTimesheetTaskByUuidAndGroupId(String uuid,
		long groupId) {
		return timesheetTaskPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the timesheet task with the primary key.
	 *
	 * @param timesheetTaskPK the primary key of the timesheet task
	 * @return the timesheet task
	 * @throws PortalException if a timesheet task with the primary key could not be found
	 */
	@Override
	public TimesheetTask getTimesheetTask(TimesheetTaskPK timesheetTaskPK)
		throws PortalException {
		return timesheetTaskPersistence.findByPrimaryKey(timesheetTaskPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(timesheetTaskLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TimesheetTask.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.timesheetTaskId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(timesheetTaskLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TimesheetTask.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.timesheetTaskId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(timesheetTaskLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TimesheetTask.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.timesheetTaskId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<TimesheetTask>() {
				@Override
				public void performAction(TimesheetTask timesheetTask)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						timesheetTask);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(TimesheetTask.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return timesheetTaskLocalService.deleteTimesheetTask((TimesheetTask)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return timesheetTaskPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the timesheet tasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the timesheet tasks
	 * @param companyId the primary key of the company
	 * @return the matching timesheet tasks, or an empty list if no matches were found
	 */
	@Override
	public List<TimesheetTask> getTimesheetTasksByUuidAndCompanyId(
		String uuid, long companyId) {
		return timesheetTaskPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of timesheet tasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the timesheet tasks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of timesheet tasks
	 * @param end the upper bound of the range of timesheet tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching timesheet tasks, or an empty list if no matches were found
	 */
	@Override
	public List<TimesheetTask> getTimesheetTasksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TimesheetTask> orderByComparator) {
		return timesheetTaskPersistence.findByUuid_C(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the timesheet task matching the UUID and group.
	 *
	 * @param uuid the timesheet task's UUID
	 * @param groupId the primary key of the group
	 * @return the matching timesheet task
	 * @throws PortalException if a matching timesheet task could not be found
	 */
	@Override
	public TimesheetTask getTimesheetTaskByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return timesheetTaskPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the timesheet tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.gs.hack.model.impl.TimesheetTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheet tasks
	 * @param end the upper bound of the range of timesheet tasks (not inclusive)
	 * @return the range of timesheet tasks
	 */
	@Override
	public List<TimesheetTask> getTimesheetTasks(int start, int end) {
		return timesheetTaskPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of timesheet tasks.
	 *
	 * @return the number of timesheet tasks
	 */
	@Override
	public int getTimesheetTasksCount() {
		return timesheetTaskPersistence.countAll();
	}

	/**
	 * Updates the timesheet task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetTask the timesheet task
	 * @return the timesheet task that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TimesheetTask updateTimesheetTask(TimesheetTask timesheetTask) {
		return timesheetTaskPersistence.update(timesheetTask);
	}

	/**
	 * Returns the timesheet local service.
	 *
	 * @return the timesheet local service
	 */
	public com.liferay.gs.hack.service.TimesheetLocalService getTimesheetLocalService() {
		return timesheetLocalService;
	}

	/**
	 * Sets the timesheet local service.
	 *
	 * @param timesheetLocalService the timesheet local service
	 */
	public void setTimesheetLocalService(
		com.liferay.gs.hack.service.TimesheetLocalService timesheetLocalService) {
		this.timesheetLocalService = timesheetLocalService;
	}

	/**
	 * Returns the timesheet persistence.
	 *
	 * @return the timesheet persistence
	 */
	public TimesheetPersistence getTimesheetPersistence() {
		return timesheetPersistence;
	}

	/**
	 * Sets the timesheet persistence.
	 *
	 * @param timesheetPersistence the timesheet persistence
	 */
	public void setTimesheetPersistence(
		TimesheetPersistence timesheetPersistence) {
		this.timesheetPersistence = timesheetPersistence;
	}

	/**
	 * Returns the timesheet approval local service.
	 *
	 * @return the timesheet approval local service
	 */
	public com.liferay.gs.hack.service.TimesheetApprovalLocalService getTimesheetApprovalLocalService() {
		return timesheetApprovalLocalService;
	}

	/**
	 * Sets the timesheet approval local service.
	 *
	 * @param timesheetApprovalLocalService the timesheet approval local service
	 */
	public void setTimesheetApprovalLocalService(
		com.liferay.gs.hack.service.TimesheetApprovalLocalService timesheetApprovalLocalService) {
		this.timesheetApprovalLocalService = timesheetApprovalLocalService;
	}

	/**
	 * Returns the timesheet approval persistence.
	 *
	 * @return the timesheet approval persistence
	 */
	public TimesheetApprovalPersistence getTimesheetApprovalPersistence() {
		return timesheetApprovalPersistence;
	}

	/**
	 * Sets the timesheet approval persistence.
	 *
	 * @param timesheetApprovalPersistence the timesheet approval persistence
	 */
	public void setTimesheetApprovalPersistence(
		TimesheetApprovalPersistence timesheetApprovalPersistence) {
		this.timesheetApprovalPersistence = timesheetApprovalPersistence;
	}

	/**
	 * Returns the timesheet task local service.
	 *
	 * @return the timesheet task local service
	 */
	public TimesheetTaskLocalService getTimesheetTaskLocalService() {
		return timesheetTaskLocalService;
	}

	/**
	 * Sets the timesheet task local service.
	 *
	 * @param timesheetTaskLocalService the timesheet task local service
	 */
	public void setTimesheetTaskLocalService(
		TimesheetTaskLocalService timesheetTaskLocalService) {
		this.timesheetTaskLocalService = timesheetTaskLocalService;
	}

	/**
	 * Returns the timesheet task persistence.
	 *
	 * @return the timesheet task persistence
	 */
	public TimesheetTaskPersistence getTimesheetTaskPersistence() {
		return timesheetTaskPersistence;
	}

	/**
	 * Sets the timesheet task persistence.
	 *
	 * @param timesheetTaskPersistence the timesheet task persistence
	 */
	public void setTimesheetTaskPersistence(
		TimesheetTaskPersistence timesheetTaskPersistence) {
		this.timesheetTaskPersistence = timesheetTaskPersistence;
	}

	/**
	 * Returns the timesheet task duration local service.
	 *
	 * @return the timesheet task duration local service
	 */
	public com.liferay.gs.hack.service.TimesheetTaskDurationLocalService getTimesheetTaskDurationLocalService() {
		return timesheetTaskDurationLocalService;
	}

	/**
	 * Sets the timesheet task duration local service.
	 *
	 * @param timesheetTaskDurationLocalService the timesheet task duration local service
	 */
	public void setTimesheetTaskDurationLocalService(
		com.liferay.gs.hack.service.TimesheetTaskDurationLocalService timesheetTaskDurationLocalService) {
		this.timesheetTaskDurationLocalService = timesheetTaskDurationLocalService;
	}

	/**
	 * Returns the timesheet task duration persistence.
	 *
	 * @return the timesheet task duration persistence
	 */
	public TimesheetTaskDurationPersistence getTimesheetTaskDurationPersistence() {
		return timesheetTaskDurationPersistence;
	}

	/**
	 * Sets the timesheet task duration persistence.
	 *
	 * @param timesheetTaskDurationPersistence the timesheet task duration persistence
	 */
	public void setTimesheetTaskDurationPersistence(
		TimesheetTaskDurationPersistence timesheetTaskDurationPersistence) {
		this.timesheetTaskDurationPersistence = timesheetTaskDurationPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.gs.hack.model.TimesheetTask",
			timesheetTaskLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.gs.hack.model.TimesheetTask");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TimesheetTaskLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TimesheetTask.class;
	}

	protected String getModelClassName() {
		return TimesheetTask.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = timesheetTaskPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.gs.hack.service.TimesheetLocalService.class)
	protected com.liferay.gs.hack.service.TimesheetLocalService timesheetLocalService;
	@BeanReference(type = TimesheetPersistence.class)
	protected TimesheetPersistence timesheetPersistence;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetApprovalLocalService.class)
	protected com.liferay.gs.hack.service.TimesheetApprovalLocalService timesheetApprovalLocalService;
	@BeanReference(type = TimesheetApprovalPersistence.class)
	protected TimesheetApprovalPersistence timesheetApprovalPersistence;
	@BeanReference(type = TimesheetTaskLocalService.class)
	protected TimesheetTaskLocalService timesheetTaskLocalService;
	@BeanReference(type = TimesheetTaskPersistence.class)
	protected TimesheetTaskPersistence timesheetTaskPersistence;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetTaskDurationLocalService.class)
	protected com.liferay.gs.hack.service.TimesheetTaskDurationLocalService timesheetTaskDurationLocalService;
	@BeanReference(type = TimesheetTaskDurationPersistence.class)
	protected TimesheetTaskDurationPersistence timesheetTaskDurationPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}