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

import com.liferay.gs.hack.model.TimesheetTaskDuration;
import com.liferay.gs.hack.service.TimesheetTaskDurationService;
import com.liferay.gs.hack.service.persistence.TimesheetApprovalPersistence;
import com.liferay.gs.hack.service.persistence.TimesheetPersistence;
import com.liferay.gs.hack.service.persistence.TimesheetTaskDurationPersistence;
import com.liferay.gs.hack.service.persistence.TimesheetTaskPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the timesheet task duration remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.gs.hack.service.impl.TimesheetTaskDurationServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.impl.TimesheetTaskDurationServiceImpl
 * @see com.liferay.gs.hack.service.TimesheetTaskDurationServiceUtil
 * @generated
 */
public abstract class TimesheetTaskDurationServiceBaseImpl
	extends BaseServiceImpl implements TimesheetTaskDurationService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.gs.hack.service.TimesheetTaskDurationServiceUtil} to access the timesheet task duration remote service.
	 */

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
	 * Returns the timesheet remote service.
	 *
	 * @return the timesheet remote service
	 */
	public com.liferay.gs.hack.service.TimesheetService getTimesheetService() {
		return timesheetService;
	}

	/**
	 * Sets the timesheet remote service.
	 *
	 * @param timesheetService the timesheet remote service
	 */
	public void setTimesheetService(
		com.liferay.gs.hack.service.TimesheetService timesheetService) {
		this.timesheetService = timesheetService;
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
	 * Returns the timesheet approval remote service.
	 *
	 * @return the timesheet approval remote service
	 */
	public com.liferay.gs.hack.service.TimesheetApprovalService getTimesheetApprovalService() {
		return timesheetApprovalService;
	}

	/**
	 * Sets the timesheet approval remote service.
	 *
	 * @param timesheetApprovalService the timesheet approval remote service
	 */
	public void setTimesheetApprovalService(
		com.liferay.gs.hack.service.TimesheetApprovalService timesheetApprovalService) {
		this.timesheetApprovalService = timesheetApprovalService;
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
	public com.liferay.gs.hack.service.TimesheetTaskLocalService getTimesheetTaskLocalService() {
		return timesheetTaskLocalService;
	}

	/**
	 * Sets the timesheet task local service.
	 *
	 * @param timesheetTaskLocalService the timesheet task local service
	 */
	public void setTimesheetTaskLocalService(
		com.liferay.gs.hack.service.TimesheetTaskLocalService timesheetTaskLocalService) {
		this.timesheetTaskLocalService = timesheetTaskLocalService;
	}

	/**
	 * Returns the timesheet task remote service.
	 *
	 * @return the timesheet task remote service
	 */
	public com.liferay.gs.hack.service.TimesheetTaskService getTimesheetTaskService() {
		return timesheetTaskService;
	}

	/**
	 * Sets the timesheet task remote service.
	 *
	 * @param timesheetTaskService the timesheet task remote service
	 */
	public void setTimesheetTaskService(
		com.liferay.gs.hack.service.TimesheetTaskService timesheetTaskService) {
		this.timesheetTaskService = timesheetTaskService;
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
	 * Returns the timesheet task duration remote service.
	 *
	 * @return the timesheet task duration remote service
	 */
	public TimesheetTaskDurationService getTimesheetTaskDurationService() {
		return timesheetTaskDurationService;
	}

	/**
	 * Sets the timesheet task duration remote service.
	 *
	 * @param timesheetTaskDurationService the timesheet task duration remote service
	 */
	public void setTimesheetTaskDurationService(
		TimesheetTaskDurationService timesheetTaskDurationService) {
		this.timesheetTaskDurationService = timesheetTaskDurationService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TimesheetTaskDurationService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TimesheetTaskDuration.class;
	}

	protected String getModelClassName() {
		return TimesheetTaskDuration.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = timesheetTaskDurationPersistence.getDataSource();

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
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetService.class)
	protected com.liferay.gs.hack.service.TimesheetService timesheetService;
	@BeanReference(type = TimesheetPersistence.class)
	protected TimesheetPersistence timesheetPersistence;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetApprovalLocalService.class)
	protected com.liferay.gs.hack.service.TimesheetApprovalLocalService timesheetApprovalLocalService;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetApprovalService.class)
	protected com.liferay.gs.hack.service.TimesheetApprovalService timesheetApprovalService;
	@BeanReference(type = TimesheetApprovalPersistence.class)
	protected TimesheetApprovalPersistence timesheetApprovalPersistence;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetTaskLocalService.class)
	protected com.liferay.gs.hack.service.TimesheetTaskLocalService timesheetTaskLocalService;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetTaskService.class)
	protected com.liferay.gs.hack.service.TimesheetTaskService timesheetTaskService;
	@BeanReference(type = TimesheetTaskPersistence.class)
	protected TimesheetTaskPersistence timesheetTaskPersistence;
	@BeanReference(type = com.liferay.gs.hack.service.TimesheetTaskDurationLocalService.class)
	protected com.liferay.gs.hack.service.TimesheetTaskDurationLocalService timesheetTaskDurationLocalService;
	@BeanReference(type = TimesheetTaskDurationService.class)
	protected TimesheetTaskDurationService timesheetTaskDurationService;
	@BeanReference(type = TimesheetTaskDurationPersistence.class)
	protected TimesheetTaskDurationPersistence timesheetTaskDurationPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}