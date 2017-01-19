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

package com.liferay.gs.hack.projects.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.projects.exception.NoSuchProjectTaskException;
import com.liferay.gs.hack.projects.model.ProjectTask;
import com.liferay.gs.hack.projects.model.impl.ProjectTaskImpl;
import com.liferay.gs.hack.projects.model.impl.ProjectTaskModelImpl;
import com.liferay.gs.hack.projects.service.persistence.ProjectTaskPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the project task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskPersistence
 * @see com.liferay.gs.hack.projects.service.persistence.ProjectTaskUtil
 * @generated
 */
@ProviderType
public class ProjectTaskPersistenceImpl extends BasePersistenceImpl<ProjectTask>
	implements ProjectTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectTaskUtil} to access the project task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectTaskModelImpl.UUID_COLUMN_BITMASK |
			ProjectTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the project tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project tasks
	 */
	@Override
	public List<ProjectTask> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectTask> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ProjectTask> findByUuid(String uuid, int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectTask> findByUuid(String uuid, int start, int end,
		OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ProjectTask> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectTask projectTask : list) {
					if (!Objects.equals(uuid, projectTask.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROJECTTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first project task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project task
	 * @throws NoSuchProjectTaskException if a matching project task could not be found
	 */
	@Override
	public ProjectTask findByUuid_First(String uuid,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByUuid_First(uuid, orderByComparator);

		if (projectTask != null) {
			return projectTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectTaskException(msg.toString());
	}

	/**
	 * Returns the first project task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByUuid_First(String uuid,
		OrderByComparator<ProjectTask> orderByComparator) {
		List<ProjectTask> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project task
	 * @throws NoSuchProjectTaskException if a matching project task could not be found
	 */
	@Override
	public ProjectTask findByUuid_Last(String uuid,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByUuid_Last(uuid, orderByComparator);

		if (projectTask != null) {
			return projectTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectTaskException(msg.toString());
	}

	/**
	 * Returns the last project task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectTask> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectTask> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectTask[] findByUuid_PrevAndNext(long projectTaskId,
		String uuid, OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = findByPrimaryKey(projectTaskId);

		Session session = null;

		try {
			session = openSession();

			ProjectTask[] array = new ProjectTaskImpl[3];

			array[0] = getByUuid_PrevAndNext(session, projectTask, uuid,
					orderByComparator, true);

			array[1] = projectTask;

			array[2] = getByUuid_PrevAndNext(session, projectTask, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectTask getByUuid_PrevAndNext(Session session,
		ProjectTask projectTask, String uuid,
		OrderByComparator<ProjectTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTTASK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProjectTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project tasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectTask projectTask : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(projectTask);
		}
	}

	/**
	 * Returns the number of project tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project tasks
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectTask.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectTask.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectTask.uuid IS NULL OR projectTask.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ProjectTaskModelImpl.UUID_COLUMN_BITMASK |
			ProjectTaskModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the project task where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProjectTaskException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project task
	 * @throws NoSuchProjectTaskException if a matching project task could not be found
	 */
	@Override
	public ProjectTask findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByUUID_G(uuid, groupId);

		if (projectTask == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectTaskException(msg.toString());
		}

		return projectTask;
	}

	/**
	 * Returns the project task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ProjectTask) {
			ProjectTask projectTask = (ProjectTask)result;

			if (!Objects.equals(uuid, projectTask.getUuid()) ||
					(groupId != projectTask.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJECTTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ProjectTask> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ProjectTask projectTask = list.get(0);

					result = projectTask;

					cacheResult(projectTask);

					if ((projectTask.getUuid() == null) ||
							!projectTask.getUuid().equals(uuid) ||
							(projectTask.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, projectTask);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ProjectTask)result;
		}
	}

	/**
	 * Removes the project task where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project task that was removed
	 */
	@Override
	public ProjectTask removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = findByUUID_G(uuid, groupId);

		return remove(projectTask);
	}

	/**
	 * Returns the number of project tasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project tasks
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "projectTask.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "projectTask.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(projectTask.uuid IS NULL OR projectTask.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "projectTask.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ProjectTaskModelImpl.UUID_COLUMN_BITMASK |
			ProjectTaskModelImpl.COMPANYID_COLUMN_BITMASK |
			ProjectTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the project tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project tasks
	 */
	@Override
	public List<ProjectTask> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectTask> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ProjectTask> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ProjectTask> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectTask> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ProjectTask> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectTask projectTask : list) {
					if (!Objects.equals(uuid, projectTask.getUuid()) ||
							(companyId != projectTask.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PROJECTTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ProjectTask findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (projectTask != null) {
			return projectTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectTaskException(msg.toString());
	}

	/**
	 * Returns the first project task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator) {
		List<ProjectTask> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectTask findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (projectTask != null) {
			return projectTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectTaskException(msg.toString());
	}

	/**
	 * Returns the last project task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectTask> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectTask[] findByUuid_C_PrevAndNext(long projectTaskId,
		String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = findByPrimaryKey(projectTaskId);

		Session session = null;

		try {
			session = openSession();

			ProjectTask[] array = new ProjectTaskImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, projectTask, uuid,
					companyId, orderByComparator, true);

			array[1] = projectTask;

			array[2] = getByUuid_C_PrevAndNext(session, projectTask, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectTask getByUuid_C_PrevAndNext(Session session,
		ProjectTask projectTask, String uuid, long companyId,
		OrderByComparator<ProjectTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECTTASK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProjectTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project tasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProjectTask projectTask : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectTask);
		}
	}

	/**
	 * Returns the number of project tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project tasks
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "projectTask.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "projectTask.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(projectTask.uuid IS NULL OR projectTask.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "projectTask.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, ProjectTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] { Long.class.getName() },
			ProjectTaskModelImpl.PROJECTID_COLUMN_BITMASK |
			ProjectTaskModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project tasks where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project tasks
	 */
	@Override
	public List<ProjectTask> findByProjectId(long projectId) {
		return findByProjectId(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<ProjectTask> findByProjectId(long projectId, int start, int end) {
		return findByProjectId(projectId, start, end, null);
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
	@Override
	public List<ProjectTask> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectTask> orderByComparator) {
		return findByProjectId(projectId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectTask> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { projectId, start, end, orderByComparator };
		}

		List<ProjectTask> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectTask projectTask : list) {
					if ((projectId != projectTask.getProjectId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROJECTTASK_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first project task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project task
	 * @throws NoSuchProjectTaskException if a matching project task could not be found
	 */
	@Override
	public ProjectTask findByProjectId_First(long projectId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByProjectId_First(projectId,
				orderByComparator);

		if (projectTask != null) {
			return projectTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectTaskException(msg.toString());
	}

	/**
	 * Returns the first project task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByProjectId_First(long projectId,
		OrderByComparator<ProjectTask> orderByComparator) {
		List<ProjectTask> list = findByProjectId(projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project task
	 * @throws NoSuchProjectTaskException if a matching project task could not be found
	 */
	@Override
	public ProjectTask findByProjectId_Last(long projectId,
		OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByProjectId_Last(projectId,
				orderByComparator);

		if (projectTask != null) {
			return projectTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectTaskException(msg.toString());
	}

	/**
	 * Returns the last project task in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project task, or <code>null</code> if a matching project task could not be found
	 */
	@Override
	public ProjectTask fetchByProjectId_Last(long projectId,
		OrderByComparator<ProjectTask> orderByComparator) {
		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<ProjectTask> list = findByProjectId(projectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectTask[] findByProjectId_PrevAndNext(long projectTaskId,
		long projectId, OrderByComparator<ProjectTask> orderByComparator)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = findByPrimaryKey(projectTaskId);

		Session session = null;

		try {
			session = openSession();

			ProjectTask[] array = new ProjectTaskImpl[3];

			array[0] = getByProjectId_PrevAndNext(session, projectTask,
					projectId, orderByComparator, true);

			array[1] = projectTask;

			array[2] = getByProjectId_PrevAndNext(session, projectTask,
					projectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectTask getByProjectId_PrevAndNext(Session session,
		ProjectTask projectTask, long projectId,
		OrderByComparator<ProjectTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTTASK_WHERE);

		query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProjectTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project tasks where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (ProjectTask projectTask : findByProjectId(projectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectTask);
		}
	}

	/**
	 * Returns the number of project tasks where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project tasks
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTID;

		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTTASK_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "projectTask.projectId = ?";

	public ProjectTaskPersistenceImpl() {
		setModelClass(ProjectTask.class);
	}

	/**
	 * Caches the project task in the entity cache if it is enabled.
	 *
	 * @param projectTask the project task
	 */
	@Override
	public void cacheResult(ProjectTask projectTask) {
		entityCache.putResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskImpl.class, projectTask.getPrimaryKey(), projectTask);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { projectTask.getUuid(), projectTask.getGroupId() },
			projectTask);

		projectTask.resetOriginalValues();
	}

	/**
	 * Caches the project tasks in the entity cache if it is enabled.
	 *
	 * @param projectTasks the project tasks
	 */
	@Override
	public void cacheResult(List<ProjectTask> projectTasks) {
		for (ProjectTask projectTask : projectTasks) {
			if (entityCache.getResult(
						ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
						ProjectTaskImpl.class, projectTask.getPrimaryKey()) == null) {
				cacheResult(projectTask);
			}
			else {
				projectTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project tasks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectTaskImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project task.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectTask projectTask) {
		entityCache.removeResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskImpl.class, projectTask.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectTaskModelImpl)projectTask);
	}

	@Override
	public void clearCache(List<ProjectTask> projectTasks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectTask projectTask : projectTasks) {
			entityCache.removeResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
				ProjectTaskImpl.class, projectTask.getPrimaryKey());

			clearUniqueFindersCache((ProjectTaskModelImpl)projectTask);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectTaskModelImpl projectTaskModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					projectTaskModelImpl.getUuid(),
					projectTaskModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				projectTaskModelImpl);
		}
		else {
			if ((projectTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectTaskModelImpl.getUuid(),
						projectTaskModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					projectTaskModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ProjectTaskModelImpl projectTaskModelImpl) {
		Object[] args = new Object[] {
				projectTaskModelImpl.getUuid(),
				projectTaskModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((projectTaskModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					projectTaskModelImpl.getOriginalUuid(),
					projectTaskModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new project task with the primary key. Does not add the project task to the database.
	 *
	 * @param projectTaskId the primary key for the new project task
	 * @return the new project task
	 */
	@Override
	public ProjectTask create(long projectTaskId) {
		ProjectTask projectTask = new ProjectTaskImpl();

		projectTask.setNew(true);
		projectTask.setPrimaryKey(projectTaskId);

		String uuid = PortalUUIDUtil.generate();

		projectTask.setUuid(uuid);

		projectTask.setCompanyId(companyProvider.getCompanyId());

		return projectTask;
	}

	/**
	 * Removes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectTaskId the primary key of the project task
	 * @return the project task that was removed
	 * @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	 */
	@Override
	public ProjectTask remove(long projectTaskId)
		throws NoSuchProjectTaskException {
		return remove((Serializable)projectTaskId);
	}

	/**
	 * Removes the project task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project task
	 * @return the project task that was removed
	 * @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	 */
	@Override
	public ProjectTask remove(Serializable primaryKey)
		throws NoSuchProjectTaskException {
		Session session = null;

		try {
			session = openSession();

			ProjectTask projectTask = (ProjectTask)session.get(ProjectTaskImpl.class,
					primaryKey);

			if (projectTask == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectTask);
		}
		catch (NoSuchProjectTaskException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProjectTask removeImpl(ProjectTask projectTask) {
		projectTask = toUnwrappedModel(projectTask);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectTask)) {
				projectTask = (ProjectTask)session.get(ProjectTaskImpl.class,
						projectTask.getPrimaryKeyObj());
			}

			if (projectTask != null) {
				session.delete(projectTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectTask != null) {
			clearCache(projectTask);
		}

		return projectTask;
	}

	@Override
	public ProjectTask updateImpl(ProjectTask projectTask) {
		projectTask = toUnwrappedModel(projectTask);

		boolean isNew = projectTask.isNew();

		ProjectTaskModelImpl projectTaskModelImpl = (ProjectTaskModelImpl)projectTask;

		if (Validator.isNull(projectTask.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectTask.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (projectTask.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectTask.setCreateDate(now);
			}
			else {
				projectTask.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!projectTaskModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectTask.setModifiedDate(now);
			}
			else {
				projectTask.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (projectTask.isNew()) {
				session.save(projectTask);

				projectTask.setNew(false);
			}
			else {
				projectTask = (ProjectTask)session.merge(projectTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProjectTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((projectTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectTaskModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { projectTaskModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectTaskModelImpl.getOriginalUuid(),
						projectTaskModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						projectTaskModelImpl.getUuid(),
						projectTaskModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((projectTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectTaskModelImpl.getOriginalProjectId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] { projectTaskModelImpl.getProjectId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}
		}

		entityCache.putResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
			ProjectTaskImpl.class, projectTask.getPrimaryKey(), projectTask,
			false);

		clearUniqueFindersCache(projectTaskModelImpl);
		cacheUniqueFindersCache(projectTaskModelImpl, isNew);

		projectTask.resetOriginalValues();

		return projectTask;
	}

	protected ProjectTask toUnwrappedModel(ProjectTask projectTask) {
		if (projectTask instanceof ProjectTaskImpl) {
			return projectTask;
		}

		ProjectTaskImpl projectTaskImpl = new ProjectTaskImpl();

		projectTaskImpl.setNew(projectTask.isNew());
		projectTaskImpl.setPrimaryKey(projectTask.getPrimaryKey());

		projectTaskImpl.setUuid(projectTask.getUuid());
		projectTaskImpl.setProjectTaskId(projectTask.getProjectTaskId());
		projectTaskImpl.setGroupId(projectTask.getGroupId());
		projectTaskImpl.setCompanyId(projectTask.getCompanyId());
		projectTaskImpl.setUserId(projectTask.getUserId());
		projectTaskImpl.setUserName(projectTask.getUserName());
		projectTaskImpl.setCreateDate(projectTask.getCreateDate());
		projectTaskImpl.setModifiedDate(projectTask.getModifiedDate());
		projectTaskImpl.setProjectId(projectTask.getProjectId());
		projectTaskImpl.setName(projectTask.getName());

		return projectTaskImpl;
	}

	/**
	 * Returns the project task with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project task
	 * @return the project task
	 * @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	 */
	@Override
	public ProjectTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectTaskException {
		ProjectTask projectTask = fetchByPrimaryKey(primaryKey);

		if (projectTask == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectTask;
	}

	/**
	 * Returns the project task with the primary key or throws a {@link NoSuchProjectTaskException} if it could not be found.
	 *
	 * @param projectTaskId the primary key of the project task
	 * @return the project task
	 * @throws NoSuchProjectTaskException if a project task with the primary key could not be found
	 */
	@Override
	public ProjectTask findByPrimaryKey(long projectTaskId)
		throws NoSuchProjectTaskException {
		return findByPrimaryKey((Serializable)projectTaskId);
	}

	/**
	 * Returns the project task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project task
	 * @return the project task, or <code>null</code> if a project task with the primary key could not be found
	 */
	@Override
	public ProjectTask fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
				ProjectTaskImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectTask projectTask = (ProjectTask)serializable;

		if (projectTask == null) {
			Session session = null;

			try {
				session = openSession();

				projectTask = (ProjectTask)session.get(ProjectTaskImpl.class,
						primaryKey);

				if (projectTask != null) {
					cacheResult(projectTask);
				}
				else {
					entityCache.putResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
						ProjectTaskImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
					ProjectTaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectTask;
	}

	/**
	 * Returns the project task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectTaskId the primary key of the project task
	 * @return the project task, or <code>null</code> if a project task with the primary key could not be found
	 */
	@Override
	public ProjectTask fetchByPrimaryKey(long projectTaskId) {
		return fetchByPrimaryKey((Serializable)projectTaskId);
	}

	@Override
	public Map<Serializable, ProjectTask> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectTask> map = new HashMap<Serializable, ProjectTask>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectTask projectTask = fetchByPrimaryKey(primaryKey);

			if (projectTask != null) {
				map.put(primaryKey, projectTask);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
					ProjectTaskImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectTask)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTTASK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ProjectTask projectTask : (List<ProjectTask>)q.list()) {
				map.put(projectTask.getPrimaryKeyObj(), projectTask);

				cacheResult(projectTask);

				uncachedPrimaryKeys.remove(projectTask.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectTaskModelImpl.ENTITY_CACHE_ENABLED,
					ProjectTaskImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the project tasks.
	 *
	 * @return the project tasks
	 */
	@Override
	public List<ProjectTask> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectTask> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ProjectTask> findAll(int start, int end,
		OrderByComparator<ProjectTask> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ProjectTask> findAll(int start, int end,
		OrderByComparator<ProjectTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ProjectTask> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectTask>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTTASK;

				if (pagination) {
					sql = sql.concat(ProjectTaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectTask>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the project tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectTask projectTask : findAll()) {
			remove(projectTask);
		}
	}

	/**
	 * Returns the number of project tasks.
	 *
	 * @return the number of project tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTTASK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectTaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project task persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectTaskImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTTASK = "SELECT projectTask FROM ProjectTask projectTask";
	private static final String _SQL_SELECT_PROJECTTASK_WHERE_PKS_IN = "SELECT projectTask FROM ProjectTask projectTask WHERE projectTaskId IN (";
	private static final String _SQL_SELECT_PROJECTTASK_WHERE = "SELECT projectTask FROM ProjectTask projectTask WHERE ";
	private static final String _SQL_COUNT_PROJECTTASK = "SELECT COUNT(projectTask) FROM ProjectTask projectTask";
	private static final String _SQL_COUNT_PROJECTTASK_WHERE = "SELECT COUNT(projectTask) FROM ProjectTask projectTask WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectTask exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectTaskPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}