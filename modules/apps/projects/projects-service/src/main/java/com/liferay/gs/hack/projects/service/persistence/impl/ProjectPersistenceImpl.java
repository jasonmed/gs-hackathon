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

import com.liferay.gs.hack.projects.exception.NoSuchProjectException;
import com.liferay.gs.hack.projects.model.Project;
import com.liferay.gs.hack.projects.model.impl.ProjectImpl;
import com.liferay.gs.hack.projects.model.impl.ProjectModelImpl;
import com.liferay.gs.hack.projects.service.persistence.ProjectPersistence;

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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPersistence
 * @see com.liferay.gs.hack.projects.service.persistence.ProjectUtil
 * @generated
 */
@ProviderType
public class ProjectPersistenceImpl extends BasePersistenceImpl<Project>
	implements ProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectModelImpl.UUID_COLUMN_BITMASK |
			ProjectModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the projects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projects
	 */
	@Override
	public List<Project> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	@Override
	public List<Project> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByUuid(String uuid, int start, int end,
		OrderByComparator<Project> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projects where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByUuid(String uuid, int start, int end,
		OrderByComparator<Project> orderByComparator, boolean retrieveFromCache) {
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

		List<Project> list = null;

		if (retrieveFromCache) {
			list = (List<Project>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Project project : list) {
					if (!Objects.equals(uuid, project.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECT_WHERE);

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
				query.append(ProjectModelImpl.ORDER_BY_JPQL);
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
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByUuid_First(String uuid,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByUuid_First(uuid, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByUuid_First(String uuid,
		OrderByComparator<Project> orderByComparator) {
		List<Project> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByUuid_Last(String uuid,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByUuid_Last(uuid, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last project in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByUuid_Last(String uuid,
		OrderByComparator<Project> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Project> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the projects before and after the current project in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project[] findByUuid_PrevAndNext(long projectId, String uuid,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			Project[] array = new ProjectImpl[3];

			array[0] = getByUuid_PrevAndNext(session, project, uuid,
					orderByComparator, true);

			array[1] = project;

			array[2] = getByUuid_PrevAndNext(session, project, uuid,
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

	protected Project getByUuid_PrevAndNext(Session session, Project project,
		String uuid, OrderByComparator<Project> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_WHERE);

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
			query.append(ProjectModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(project);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the projects where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Project project : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projects
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "project.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "project.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(project.uuid IS NULL OR project.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ProjectModelImpl.UUID_COLUMN_BITMASK |
			ProjectModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the project where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProjectException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectException {
		Project project = fetchByUUID_G(uuid, groupId);

		if (project == null) {
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

			throw new NoSuchProjectException(msg.toString());
		}

		return project;
	}

	/**
	 * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Project) {
			Project project = (Project)result;

			if (!Objects.equals(uuid, project.getUuid()) ||
					(groupId != project.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJECT_WHERE);

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

				List<Project> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Project project = list.get(0);

					result = project;

					cacheResult(project);

					if ((project.getUuid() == null) ||
							!project.getUuid().equals(uuid) ||
							(project.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, project);
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
			return (Project)result;
		}
	}

	/**
	 * Removes the project where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project that was removed
	 */
	@Override
	public Project removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectException {
		Project project = findByUUID_G(uuid, groupId);

		return remove(project);
	}

	/**
	 * Returns the number of projects where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projects
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "project.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "project.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(project.uuid IS NULL OR project.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "project.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ProjectModelImpl.UUID_COLUMN_BITMASK |
			ProjectModelImpl.COMPANYID_COLUMN_BITMASK |
			ProjectModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching projects
	 */
	@Override
	public List<Project> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	@Override
	public List<Project> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Project> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projects where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Project> orderByComparator,
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

		List<Project> list = null;

		if (retrieveFromCache) {
			list = (List<Project>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Project project : list) {
					if (!Objects.equals(uuid, project.getUuid()) ||
							(companyId != project.getCompanyId())) {
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

			query.append(_SQL_SELECT_PROJECT_WHERE);

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
				query.append(ProjectModelImpl.ORDER_BY_JPQL);
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
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Project> orderByComparator) {
		List<Project> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Project> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Project> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the projects before and after the current project in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project[] findByUuid_C_PrevAndNext(long projectId, String uuid,
		long companyId, OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			Project[] array = new ProjectImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, project, uuid,
					companyId, orderByComparator, true);

			array[1] = project;

			array[2] = getByUuid_C_PrevAndNext(session, project, uuid,
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

	protected Project getByUuid_C_PrevAndNext(Session session, Project project,
		String uuid, long companyId,
		OrderByComparator<Project> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECT_WHERE);

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
			query.append(ProjectModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(project);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the projects where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Project project : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching projects
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "project.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "project.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(project.uuid IS NULL OR project.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "project.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClientId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID =
		new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClientId",
			new String[] { Long.class.getName() },
			ProjectModelImpl.CLIENTID_COLUMN_BITMASK |
			ProjectModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the projects where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching projects
	 */
	@Override
	public List<Project> findByClientId(long clientId) {
		return findByClientId(clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the projects where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	@Override
	public List<Project> findByClientId(long clientId, int start, int end) {
		return findByClientId(clientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByClientId(long clientId, int start, int end,
		OrderByComparator<Project> orderByComparator) {
		return findByClientId(clientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projects where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByClientId(long clientId, int start, int end,
		OrderByComparator<Project> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId, start, end, orderByComparator };
		}

		List<Project> list = null;

		if (retrieveFromCache) {
			list = (List<Project>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Project project : list) {
					if ((clientId != project.getClientId())) {
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

			query.append(_SQL_SELECT_PROJECT_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				if (!pagination) {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByClientId_First(long clientId,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByClientId_First(clientId, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first project in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByClientId_First(long clientId,
		OrderByComparator<Project> orderByComparator) {
		List<Project> list = findByClientId(clientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByClientId_Last(long clientId,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByClientId_Last(clientId, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last project in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByClientId_Last(long clientId,
		OrderByComparator<Project> orderByComparator) {
		int count = countByClientId(clientId);

		if (count == 0) {
			return null;
		}

		List<Project> list = findByClientId(clientId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the projects before and after the current project in the ordered set where clientId = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project[] findByClientId_PrevAndNext(long projectId, long clientId,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			Project[] array = new ProjectImpl[3];

			array[0] = getByClientId_PrevAndNext(session, project, clientId,
					orderByComparator, true);

			array[1] = project;

			array[2] = getByClientId_PrevAndNext(session, project, clientId,
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

	protected Project getByClientId_PrevAndNext(Session session,
		Project project, long clientId,
		OrderByComparator<Project> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_WHERE);

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

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
			query.append(ProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clientId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the projects where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	@Override
	public void removeByClientId(long clientId) {
		for (Project project : findByClientId(clientId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching projects
	 */
	@Override
	public int countByClientId(long clientId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTID;

		Object[] finderArgs = new Object[] { clientId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECT_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

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

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_2 = "project.clientId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			ProjectModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the project where name = &#63; or throws a {@link NoSuchProjectException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByName(String name) throws NoSuchProjectException {
		Project project = fetchByName(name);

		if (project == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectException(msg.toString());
		}

		return project;
	}

	/**
	 * Returns the project where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the project where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByName(String name, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Project) {
			Project project = (Project)result;

			if (!Objects.equals(name, project.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Project> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectPersistenceImpl.fetchByName(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Project project = list.get(0);

					result = project;

					cacheResult(project);

					if ((project.getName() == null) ||
							!project.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, project);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, finderArgs);

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
			return (Project)result;
		}
	}

	/**
	 * Removes the project where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the project that was removed
	 */
	@Override
	public Project removeByName(String name) throws NoSuchProjectException {
		Project project = findByName(name);

		return remove(project);
	}

	/**
	 * Returns the number of projects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching projects
	 */
	@Override
	public int countByName(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "project.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "project.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(project.name IS NULL OR project.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactive",
			new String[] { Boolean.class.getName() },
			ProjectModelImpl.ACTIVE_COLUMN_BITMASK |
			ProjectModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the projects where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching projects
	 */
	@Override
	public List<Project> findByactive(boolean active) {
		return findByactive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projects where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	@Override
	public List<Project> findByactive(boolean active, int start, int end) {
		return findByactive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByactive(boolean active, int start, int end,
		OrderByComparator<Project> orderByComparator) {
		return findByactive(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projects where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByactive(boolean active, int start, int end,
		OrderByComparator<Project> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<Project> list = null;

		if (retrieveFromCache) {
			list = (List<Project>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Project project : list) {
					if ((active != project.getActive())) {
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

			query.append(_SQL_SELECT_PROJECT_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByactive_First(boolean active,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByactive_First(active, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first project in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByactive_First(boolean active,
		OrderByComparator<Project> orderByComparator) {
		List<Project> list = findByactive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByactive_Last(boolean active,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByactive_Last(active, orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last project in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByactive_Last(boolean active,
		OrderByComparator<Project> orderByComparator) {
		int count = countByactive(active);

		if (count == 0) {
			return null;
		}

		List<Project> list = findByactive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the projects before and after the current project in the ordered set where active = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project[] findByactive_PrevAndNext(long projectId, boolean active,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			Project[] array = new ProjectImpl[3];

			array[0] = getByactive_PrevAndNext(session, project, active,
					orderByComparator, true);

			array[1] = project;

			array[2] = getByactive_PrevAndNext(session, project, active,
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

	protected Project getByactive_PrevAndNext(Session session, Project project,
		boolean active, OrderByComparator<Project> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			query.append(ProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the projects where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByactive(boolean active) {
		for (Project project : findByactive(active, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching projects
	 */
	@Override
	public int countByactive(boolean active) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVE;

		Object[] finderArgs = new Object[] { active };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECT_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "project.active = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID_ACTIVE =
		new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByclientId_active",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID_ACTIVE =
		new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByclientId_active",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ProjectModelImpl.CLIENTID_COLUMN_BITMASK |
			ProjectModelImpl.ACTIVE_COLUMN_BITMASK |
			ProjectModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTID_ACTIVE = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByclientId_active",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the projects where clientId = &#63; and active = &#63;.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @return the matching projects
	 */
	@Override
	public List<Project> findByclientId_active(long clientId, boolean active) {
		return findByclientId_active(clientId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projects where clientId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of matching projects
	 */
	@Override
	public List<Project> findByclientId_active(long clientId, boolean active,
		int start, int end) {
		return findByclientId_active(clientId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects where clientId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByclientId_active(long clientId, boolean active,
		int start, int end, OrderByComparator<Project> orderByComparator) {
		return findByclientId_active(clientId, active, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projects where clientId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching projects
	 */
	@Override
	public List<Project> findByclientId_active(long clientId, boolean active,
		int start, int end, OrderByComparator<Project> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID_ACTIVE;
			finderArgs = new Object[] { clientId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID_ACTIVE;
			finderArgs = new Object[] {
					clientId, active,
					
					start, end, orderByComparator
				};
		}

		List<Project> list = null;

		if (retrieveFromCache) {
			list = (List<Project>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Project project : list) {
					if ((clientId != project.getClientId()) ||
							(active != project.getActive())) {
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

			query.append(_SQL_SELECT_PROJECT_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_ACTIVE_CLIENTID_2);

			query.append(_FINDER_COLUMN_CLIENTID_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				qPos.add(active);

				if (!pagination) {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project in the ordered set where clientId = &#63; and active = &#63;.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByclientId_active_First(long clientId, boolean active,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByclientId_active_First(clientId, active,
				orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the first project in the ordered set where clientId = &#63; and active = &#63;.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByclientId_active_First(long clientId, boolean active,
		OrderByComparator<Project> orderByComparator) {
		List<Project> list = findByclientId_active(clientId, active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project in the ordered set where clientId = &#63; and active = &#63;.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project
	 * @throws NoSuchProjectException if a matching project could not be found
	 */
	@Override
	public Project findByclientId_active_Last(long clientId, boolean active,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = fetchByclientId_active_Last(clientId, active,
				orderByComparator);

		if (project != null) {
			return project;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectException(msg.toString());
	}

	/**
	 * Returns the last project in the ordered set where clientId = &#63; and active = &#63;.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public Project fetchByclientId_active_Last(long clientId, boolean active,
		OrderByComparator<Project> orderByComparator) {
		int count = countByclientId_active(clientId, active);

		if (count == 0) {
			return null;
		}

		List<Project> list = findByclientId_active(clientId, active, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the projects before and after the current project in the ordered set where clientId = &#63; and active = &#63;.
	 *
	 * @param projectId the primary key of the current project
	 * @param clientId the client ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project[] findByclientId_active_PrevAndNext(long projectId,
		long clientId, boolean active,
		OrderByComparator<Project> orderByComparator)
		throws NoSuchProjectException {
		Project project = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			Project[] array = new ProjectImpl[3];

			array[0] = getByclientId_active_PrevAndNext(session, project,
					clientId, active, orderByComparator, true);

			array[1] = project;

			array[2] = getByclientId_active_PrevAndNext(session, project,
					clientId, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Project getByclientId_active_PrevAndNext(Session session,
		Project project, long clientId, boolean active,
		OrderByComparator<Project> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECT_WHERE);

		query.append(_FINDER_COLUMN_CLIENTID_ACTIVE_CLIENTID_2);

		query.append(_FINDER_COLUMN_CLIENTID_ACTIVE_ACTIVE_2);

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
			query.append(ProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clientId);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the projects where clientId = &#63; and active = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 */
	@Override
	public void removeByclientId_active(long clientId, boolean active) {
		for (Project project : findByclientId_active(clientId, active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects where clientId = &#63; and active = &#63;.
	 *
	 * @param clientId the client ID
	 * @param active the active
	 * @return the number of matching projects
	 */
	@Override
	public int countByclientId_active(long clientId, boolean active) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTID_ACTIVE;

		Object[] finderArgs = new Object[] { clientId, active };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECT_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_ACTIVE_CLIENTID_2);

			query.append(_FINDER_COLUMN_CLIENTID_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_CLIENTID_ACTIVE_CLIENTID_2 = "project.clientId = ? AND ";
	private static final String _FINDER_COLUMN_CLIENTID_ACTIVE_ACTIVE_2 = "project.active = ?";

	public ProjectPersistenceImpl() {
		setModelClass(Project.class);
	}

	/**
	 * Caches the project in the entity cache if it is enabled.
	 *
	 * @param project the project
	 */
	@Override
	public void cacheResult(Project project) {
		entityCache.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectImpl.class, project.getPrimaryKey(), project);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { project.getUuid(), project.getGroupId() }, project);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { project.getName() }, project);

		project.resetOriginalValues();
	}

	/**
	 * Caches the projects in the entity cache if it is enabled.
	 *
	 * @param projects the projects
	 */
	@Override
	public void cacheResult(List<Project> projects) {
		for (Project project : projects) {
			if (entityCache.getResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
						ProjectImpl.class, project.getPrimaryKey()) == null) {
				cacheResult(project);
			}
			else {
				project.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all projects.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Project project) {
		entityCache.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectImpl.class, project.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectModelImpl)project);
	}

	@Override
	public void clearCache(List<Project> projects) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Project project : projects) {
			entityCache.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
				ProjectImpl.class, project.getPrimaryKey());

			clearUniqueFindersCache((ProjectModelImpl)project);
		}
	}

	protected void cacheUniqueFindersCache(ProjectModelImpl projectModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					projectModelImpl.getUuid(), projectModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				projectModelImpl);

			args = new Object[] { projectModelImpl.getName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				projectModelImpl);
		}
		else {
			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectModelImpl.getUuid(),
						projectModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					projectModelImpl);
			}

			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { projectModelImpl.getName() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					projectModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(ProjectModelImpl projectModelImpl) {
		Object[] args = new Object[] {
				projectModelImpl.getUuid(), projectModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((projectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					projectModelImpl.getOriginalUuid(),
					projectModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { projectModelImpl.getName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((projectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { projectModelImpl.getOriginalName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param projectId the primary key for the new project
	 * @return the new project
	 */
	@Override
	public Project create(long projectId) {
		Project project = new ProjectImpl();

		project.setNew(true);
		project.setPrimaryKey(projectId);

		String uuid = PortalUUIDUtil.generate();

		project.setUuid(uuid);

		project.setCompanyId(companyProvider.getCompanyId());

		return project;
	}

	/**
	 * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the project
	 * @return the project that was removed
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project remove(long projectId) throws NoSuchProjectException {
		return remove((Serializable)projectId);
	}

	/**
	 * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project
	 * @return the project that was removed
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project remove(Serializable primaryKey)
		throws NoSuchProjectException {
		Session session = null;

		try {
			session = openSession();

			Project project = (Project)session.get(ProjectImpl.class, primaryKey);

			if (project == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(project);
		}
		catch (NoSuchProjectException nsee) {
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
	protected Project removeImpl(Project project) {
		project = toUnwrappedModel(project);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(project)) {
				project = (Project)session.get(ProjectImpl.class,
						project.getPrimaryKeyObj());
			}

			if (project != null) {
				session.delete(project);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (project != null) {
			clearCache(project);
		}

		return project;
	}

	@Override
	public Project updateImpl(Project project) {
		project = toUnwrappedModel(project);

		boolean isNew = project.isNew();

		ProjectModelImpl projectModelImpl = (ProjectModelImpl)project;

		if (Validator.isNull(project.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			project.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (project.getCreateDate() == null)) {
			if (serviceContext == null) {
				project.setCreateDate(now);
			}
			else {
				project.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!projectModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				project.setModifiedDate(now);
			}
			else {
				project.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (project.isNew()) {
				session.save(project);

				project.setNew(false);
			}
			else {
				project = (Project)session.merge(project);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { projectModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { projectModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectModelImpl.getOriginalUuid(),
						projectModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						projectModelImpl.getUuid(),
						projectModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectModelImpl.getOriginalClientId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);

				args = new Object[] { projectModelImpl.getClientId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);
			}

			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectModelImpl.getOriginalActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { projectModelImpl.getActive() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}

			if ((projectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectModelImpl.getOriginalClientId(),
						projectModelImpl.getOriginalActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID_ACTIVE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID_ACTIVE,
					args);

				args = new Object[] {
						projectModelImpl.getClientId(),
						projectModelImpl.getActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID_ACTIVE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID_ACTIVE,
					args);
			}
		}

		entityCache.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
			ProjectImpl.class, project.getPrimaryKey(), project, false);

		clearUniqueFindersCache(projectModelImpl);
		cacheUniqueFindersCache(projectModelImpl, isNew);

		project.resetOriginalValues();

		return project;
	}

	protected Project toUnwrappedModel(Project project) {
		if (project instanceof ProjectImpl) {
			return project;
		}

		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setNew(project.isNew());
		projectImpl.setPrimaryKey(project.getPrimaryKey());

		projectImpl.setUuid(project.getUuid());
		projectImpl.setProjectId(project.getProjectId());
		projectImpl.setGroupId(project.getGroupId());
		projectImpl.setCompanyId(project.getCompanyId());
		projectImpl.setUserId(project.getUserId());
		projectImpl.setUserName(project.getUserName());
		projectImpl.setCreateDate(project.getCreateDate());
		projectImpl.setModifiedDate(project.getModifiedDate());
		projectImpl.setClientId(project.getClientId());
		projectImpl.setName(project.getName());
		projectImpl.setStartDate(project.getStartDate());
		projectImpl.setEndDate(project.getEndDate());
		projectImpl.setActive(project.isActive());

		return projectImpl;
	}

	/**
	 * Returns the project with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project
	 * @return the project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectException {
		Project project = fetchByPrimaryKey(primaryKey);

		if (project == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return project;
	}

	/**
	 * Returns the project with the primary key or throws a {@link NoSuchProjectException} if it could not be found.
	 *
	 * @param projectId the primary key of the project
	 * @return the project
	 * @throws NoSuchProjectException if a project with the primary key could not be found
	 */
	@Override
	public Project findByPrimaryKey(long projectId)
		throws NoSuchProjectException {
		return findByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns the project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project
	 * @return the project, or <code>null</code> if a project with the primary key could not be found
	 */
	@Override
	public Project fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
				ProjectImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Project project = (Project)serializable;

		if (project == null) {
			Session session = null;

			try {
				session = openSession();

				project = (Project)session.get(ProjectImpl.class, primaryKey);

				if (project != null) {
					cacheResult(project);
				}
				else {
					entityCache.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
						ProjectImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
					ProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return project;
	}

	/**
	 * Returns the project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the project
	 * @return the project, or <code>null</code> if a project with the primary key could not be found
	 */
	@Override
	public Project fetchByPrimaryKey(long projectId) {
		return fetchByPrimaryKey((Serializable)projectId);
	}

	@Override
	public Map<Serializable, Project> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Project> map = new HashMap<Serializable, Project>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Project project = fetchByPrimaryKey(primaryKey);

			if (project != null) {
				map.put(primaryKey, project);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
					ProjectImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Project)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECT_WHERE_PKS_IN);

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

			for (Project project : (List<Project>)q.list()) {
				map.put(project.getPrimaryKeyObj(), project);

				cacheResult(project);

				uncachedPrimaryKeys.remove(project.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
					ProjectImpl.class, primaryKey, nullModel);
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
	 * Returns all the projects.
	 *
	 * @return the projects
	 */
	@Override
	public List<Project> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of projects
	 */
	@Override
	public List<Project> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of projects
	 */
	@Override
	public List<Project> findAll(int start, int end,
		OrderByComparator<Project> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of projects
	 */
	@Override
	public List<Project> findAll(int start, int end,
		OrderByComparator<Project> orderByComparator, boolean retrieveFromCache) {
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

		List<Project> list = null;

		if (retrieveFromCache) {
			list = (List<Project>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECT;

				if (pagination) {
					sql = sql.concat(ProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Project>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the projects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Project project : findAll()) {
			remove(project);
		}
	}

	/**
	 * Returns the number of projects.
	 *
	 * @return the number of projects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECT);

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
		return ProjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectImpl.class.getName());
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
	private static final String _SQL_SELECT_PROJECT = "SELECT project FROM Project project";
	private static final String _SQL_SELECT_PROJECT_WHERE_PKS_IN = "SELECT project FROM Project project WHERE projectId IN (";
	private static final String _SQL_SELECT_PROJECT_WHERE = "SELECT project FROM Project project WHERE ";
	private static final String _SQL_COUNT_PROJECT = "SELECT COUNT(project) FROM Project project";
	private static final String _SQL_COUNT_PROJECT_WHERE = "SELECT COUNT(project) FROM Project project WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "project.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Project exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "active"
			});
}