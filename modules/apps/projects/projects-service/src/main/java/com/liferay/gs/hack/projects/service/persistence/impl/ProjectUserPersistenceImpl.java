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

import com.liferay.gs.hack.projects.exception.NoSuchProjectUserException;
import com.liferay.gs.hack.projects.model.ProjectUser;
import com.liferay.gs.hack.projects.model.impl.ProjectUserImpl;
import com.liferay.gs.hack.projects.model.impl.ProjectUserModelImpl;
import com.liferay.gs.hack.projects.service.persistence.ProjectUserPersistence;

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
 * The persistence implementation for the project user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUserPersistence
 * @see com.liferay.gs.hack.projects.service.persistence.ProjectUserUtil
 * @generated
 */
@ProviderType
public class ProjectUserPersistenceImpl extends BasePersistenceImpl<ProjectUser>
	implements ProjectUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectUserUtil} to access the project user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectUserModelImpl.UUID_COLUMN_BITMASK |
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the project users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project users
	 */
	@Override
	public List<ProjectUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ProjectUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator,
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

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUser projectUser : list) {
					if (!Objects.equals(uuid, projectUser.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

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
				query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByUuid_First(String uuid,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByUuid_First(uuid, orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first project user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByUuid_First(String uuid,
		OrderByComparator<ProjectUser> orderByComparator) {
		List<ProjectUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByUuid_Last(String uuid,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByUuid_Last(uuid, orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last project user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectUser> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser[] findByUuid_PrevAndNext(long projectUserId,
		String uuid, OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			ProjectUser[] array = new ProjectUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, projectUser, uuid,
					orderByComparator, true);

			array[1] = projectUser;

			array[2] = getByUuid_PrevAndNext(session, projectUser, uuid,
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

	protected ProjectUser getByUuid_PrevAndNext(Session session,
		ProjectUser projectUser, String uuid,
		OrderByComparator<ProjectUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTUSER_WHERE);

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
			query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectUser projectUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project users
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectUser.uuid IS NULL OR projectUser.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ProjectUserModelImpl.UUID_COLUMN_BITMASK |
			ProjectUserModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the project user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByUUID_G(uuid, groupId);

		if (projectUser == null) {
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

			throw new NoSuchProjectUserException(msg.toString());
		}

		return projectUser;
	}

	/**
	 * Returns the project user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ProjectUser) {
			ProjectUser projectUser = (ProjectUser)result;

			if (!Objects.equals(uuid, projectUser.getUuid()) ||
					(groupId != projectUser.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

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

				List<ProjectUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ProjectUser projectUser = list.get(0);

					result = projectUser;

					cacheResult(projectUser);

					if ((projectUser.getUuid() == null) ||
							!projectUser.getUuid().equals(uuid) ||
							(projectUser.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, projectUser);
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
			return (ProjectUser)result;
		}
	}

	/**
	 * Removes the project user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project user that was removed
	 */
	@Override
	public ProjectUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByUUID_G(uuid, groupId);

		return remove(projectUser);
	}

	/**
	 * Returns the number of project users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "projectUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "projectUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(projectUser.uuid IS NULL OR projectUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "projectUser.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ProjectUserModelImpl.UUID_COLUMN_BITMASK |
			ProjectUserModelImpl.COMPANYID_COLUMN_BITMASK |
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the project users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project users
	 */
	@Override
	public List<ProjectUser> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectUser> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ProjectUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator,
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

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUser projectUser : list) {
					if (!Objects.equals(uuid, projectUser.getUuid()) ||
							(companyId != projectUser.getCompanyId())) {
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

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

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
				query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first project user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator) {
		List<ProjectUser> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last project user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectUser> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser[] findByUuid_C_PrevAndNext(long projectUserId,
		String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			ProjectUser[] array = new ProjectUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, projectUser, uuid,
					companyId, orderByComparator, true);

			array[1] = projectUser;

			array[2] = getByUuid_C_PrevAndNext(session, projectUser, uuid,
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

	protected ProjectUser getByUuid_C_PrevAndNext(Session session,
		ProjectUser projectUser, String uuid, long companyId,
		OrderByComparator<ProjectUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECTUSER_WHERE);

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
			query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProjectUser projectUser : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "projectUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "projectUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(projectUser.uuid IS NULL OR projectUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "projectUser.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] { Long.class.getName() },
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project users where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project users
	 */
	@Override
	public List<ProjectUser> findByProjectId(long projectId) {
		return findByProjectId(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<ProjectUser> findByProjectId(long projectId, int start, int end) {
		return findByProjectId(projectId, start, end, null);
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
	@Override
	public List<ProjectUser> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator) {
		return findByProjectId(projectId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectUser> findByProjectId(long projectId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator,
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

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUser projectUser : list) {
					if ((projectId != projectUser.getProjectId())) {
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

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByProjectId_First(long projectId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByProjectId_First(projectId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProjectId_First(long projectId,
		OrderByComparator<ProjectUser> orderByComparator) {
		List<ProjectUser> list = findByProjectId(projectId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByProjectId_Last(long projectId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByProjectId_Last(projectId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last project user in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProjectId_Last(long projectId,
		OrderByComparator<ProjectUser> orderByComparator) {
		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<ProjectUser> list = findByProjectId(projectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser[] findByProjectId_PrevAndNext(long projectUserId,
		long projectId, OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			ProjectUser[] array = new ProjectUserImpl[3];

			array[0] = getByProjectId_PrevAndNext(session, projectUser,
					projectId, orderByComparator, true);

			array[1] = projectUser;

			array[2] = getByProjectId_PrevAndNext(session, projectUser,
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

	protected ProjectUser getByProjectId_PrevAndNext(Session session,
		ProjectUser projectUser, long projectId,
		OrderByComparator<ProjectUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTUSER_WHERE);

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
			query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project users where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (ProjectUser projectUser : findByProjectId(projectId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTID;

		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "projectUser.projectId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] { Long.class.getName() },
			ProjectUserModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project users where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching project users
	 */
	@Override
	public List<ProjectUser> findByEmployeeId(long employeeId) {
		return findByEmployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectUser> findByEmployeeId(long employeeId, int start,
		int end) {
		return findByEmployeeId(employeeId, start, end, null);
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
	@Override
	public List<ProjectUser> findByEmployeeId(long employeeId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator) {
		return findByEmployeeId(employeeId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectUser> findByEmployeeId(long employeeId, int start,
		int end, OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUser projectUser : list) {
					if ((employeeId != projectUser.getEmployeeId())) {
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

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project user in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByEmployeeId_First(employeeId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first project user in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByEmployeeId_First(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator) {
		List<ProjectUser> list = findByEmployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project user in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByEmployeeId_Last(employeeId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last project user in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByEmployeeId_Last(long employeeId,
		OrderByComparator<ProjectUser> orderByComparator) {
		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ProjectUser> list = findByEmployeeId(employeeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser[] findByEmployeeId_PrevAndNext(long projectUserId,
		long employeeId, OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			ProjectUser[] array = new ProjectUserImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(session, projectUser,
					employeeId, orderByComparator, true);

			array[1] = projectUser;

			array[2] = getByEmployeeId_PrevAndNext(session, projectUser,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectUser getByEmployeeId_PrevAndNext(Session session,
		ProjectUser projectUser, long employeeId,
		OrderByComparator<ProjectUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project users where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (ProjectUser projectUser : findByEmployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "projectUser.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleId",
			new String[] { Long.class.getName() },
			ProjectUserModelImpl.ROLEID_COLUMN_BITMASK |
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project users where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching project users
	 */
	@Override
	public List<ProjectUser> findByRoleId(long roleId) {
		return findByRoleId(roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectUser> findByRoleId(long roleId, int start, int end) {
		return findByRoleId(roleId, start, end, null);
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
	@Override
	public List<ProjectUser> findByRoleId(long roleId, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return findByRoleId(roleId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectUser> findByRoleId(long roleId, int start, int end,
		OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { roleId, start, end, orderByComparator };
		}

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUser projectUser : list) {
					if ((roleId != projectUser.getRoleId())) {
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

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project user in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByRoleId_First(long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByRoleId_First(roleId, orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first project user in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByRoleId_First(long roleId,
		OrderByComparator<ProjectUser> orderByComparator) {
		List<ProjectUser> list = findByRoleId(roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project user in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByRoleId_Last(long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByRoleId_Last(roleId, orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last project user in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByRoleId_Last(long roleId,
		OrderByComparator<ProjectUser> orderByComparator) {
		int count = countByRoleId(roleId);

		if (count == 0) {
			return null;
		}

		List<ProjectUser> list = findByRoleId(roleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser[] findByRoleId_PrevAndNext(long projectUserId,
		long roleId, OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			ProjectUser[] array = new ProjectUserImpl[3];

			array[0] = getByRoleId_PrevAndNext(session, projectUser, roleId,
					orderByComparator, true);

			array[1] = projectUser;

			array[2] = getByRoleId_PrevAndNext(session, projectUser, roleId,
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

	protected ProjectUser getByRoleId_PrevAndNext(Session session,
		ProjectUser projectUser, long roleId,
		OrderByComparator<ProjectUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

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
			query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project users where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	@Override
	public void removeByRoleId(long roleId) {
		for (ProjectUser projectUser : findByRoleId(roleId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByRoleId(long roleId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEID;

		Object[] finderArgs = new Object[] { roleId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_ROLEID_ROLEID_2 = "projectUser.roleId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByProject_Employee",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK |
			ProjectUserModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProject_Employee",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the project user where projectId = &#63; and employeeId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByProject_Employee(long projectId, long employeeId)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByProject_Employee(projectId, employeeId);

		if (projectUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("projectId=");
			msg.append(projectId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectUserException(msg.toString());
		}

		return projectUser;
	}

	/**
	 * Returns the project user where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProject_Employee(long projectId, long employeeId) {
		return fetchByProject_Employee(projectId, employeeId, true);
	}

	/**
	 * Returns the project user where projectId = &#63; and employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProject_Employee(long projectId, long employeeId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { projectId, employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE,
					finderArgs, this);
		}

		if (result instanceof ProjectUser) {
			ProjectUser projectUser = (ProjectUser)result;

			if ((projectId != projectUser.getProjectId()) ||
					(employeeId != projectUser.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(employeeId);

				List<ProjectUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectUserPersistenceImpl.fetchByProject_Employee(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectUser projectUser = list.get(0);

					result = projectUser;

					cacheResult(projectUser);

					if ((projectUser.getProjectId() != projectId) ||
							(projectUser.getEmployeeId() != employeeId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE,
							finderArgs, projectUser);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE,
					finderArgs);

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
			return (ProjectUser)result;
		}
	}

	/**
	 * Removes the project user where projectId = &#63; and employeeId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the project user that was removed
	 */
	@Override
	public ProjectUser removeByProject_Employee(long projectId, long employeeId)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByProject_Employee(projectId, employeeId);

		return remove(projectUser);
	}

	/**
	 * Returns the number of project users where projectId = &#63; and employeeId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByProject_Employee(long projectId, long employeeId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE;

		Object[] finderArgs = new Object[] { projectId, employeeId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_PROJECT_EMPLOYEE_PROJECTID_2 = "projectUser.projectId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_EMPLOYEE_EMPLOYEEID_2 = "projectUser.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ROLE =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProject_Role",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ROLE =
		new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProject_Role",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK |
			ProjectUserModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ROLE = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProject_Role",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the project users where projectId = &#63; and roleId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param roleId the role ID
	 * @return the matching project users
	 */
	@Override
	public List<ProjectUser> findByProject_Role(long projectId, long roleId) {
		return findByProject_Role(projectId, roleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectUser> findByProject_Role(long projectId, long roleId,
		int start, int end) {
		return findByProject_Role(projectId, roleId, start, end, null);
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
	@Override
	public List<ProjectUser> findByProject_Role(long projectId, long roleId,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator) {
		return findByProject_Role(projectId, roleId, start, end,
			orderByComparator, true);
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
	@Override
	public List<ProjectUser> findByProject_Role(long projectId, long roleId,
		int start, int end, OrderByComparator<ProjectUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ROLE;
			finderArgs = new Object[] { projectId, roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ROLE;
			finderArgs = new Object[] {
					projectId, roleId,
					
					start, end, orderByComparator
				};
		}

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUser projectUser : list) {
					if ((projectId != projectUser.getProjectId()) ||
							(roleId != projectUser.getRoleId())) {
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

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ROLE_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECT_ROLE_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project user in the ordered set where projectId = &#63; and roleId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByProject_Role_First(long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByProject_Role_First(projectId, roleId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the first project user in the ordered set where projectId = &#63; and roleId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProject_Role_First(long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator) {
		List<ProjectUser> list = findByProject_Role(projectId, roleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser findByProject_Role_Last(long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByProject_Role_Last(projectId, roleId,
				orderByComparator);

		if (projectUser != null) {
			return projectUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProjectUserException(msg.toString());
	}

	/**
	 * Returns the last project user in the ordered set where projectId = &#63; and roleId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProject_Role_Last(long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator) {
		int count = countByProject_Role(projectId, roleId);

		if (count == 0) {
			return null;
		}

		List<ProjectUser> list = findByProject_Role(projectId, roleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectUser[] findByProject_Role_PrevAndNext(long projectUserId,
		long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = findByPrimaryKey(projectUserId);

		Session session = null;

		try {
			session = openSession();

			ProjectUser[] array = new ProjectUserImpl[3];

			array[0] = getByProject_Role_PrevAndNext(session, projectUser,
					projectId, roleId, orderByComparator, true);

			array[1] = projectUser;

			array[2] = getByProject_Role_PrevAndNext(session, projectUser,
					projectId, roleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectUser getByProject_Role_PrevAndNext(Session session,
		ProjectUser projectUser, long projectId, long roleId,
		OrderByComparator<ProjectUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECTUSER_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_ROLE_PROJECTID_2);

		query.append(_FINDER_COLUMN_PROJECT_ROLE_ROLEID_2);

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
			query.append(ProjectUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project users where projectId = &#63; and roleId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param roleId the role ID
	 */
	@Override
	public void removeByProject_Role(long projectId, long roleId) {
		for (ProjectUser projectUser : findByProject_Role(projectId, roleId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users where projectId = &#63; and roleId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param roleId the role ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByProject_Role(long projectId, long roleId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ROLE;

		Object[] finderArgs = new Object[] { projectId, roleId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ROLE_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECT_ROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_PROJECT_ROLE_PROJECTID_2 = "projectUser.projectId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_ROLE_ROLEID_2 = "projectUser.roleId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, ProjectUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByProject_Employee_Role",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ProjectUserModelImpl.PROJECTID_COLUMN_BITMASK |
			ProjectUserModelImpl.EMPLOYEEID_COLUMN_BITMASK |
			ProjectUserModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE_ROLE = new FinderPath(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProject_Employee_Role",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or throws a {@link NoSuchProjectUserException} if it could not be found.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param roleId the role ID
	 * @return the matching project user
	 * @throws NoSuchProjectUserException if a matching project user could not be found
	 */
	@Override
	public ProjectUser findByProject_Employee_Role(long projectId,
		long employeeId, long roleId) throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByProject_Employee_Role(projectId,
				employeeId, roleId);

		if (projectUser == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("projectId=");
			msg.append(projectId);

			msg.append(", employeeId=");
			msg.append(employeeId);

			msg.append(", roleId=");
			msg.append(roleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectUserException(msg.toString());
		}

		return projectUser;
	}

	/**
	 * Returns the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param roleId the role ID
	 * @return the matching project user, or <code>null</code> if a matching project user could not be found
	 */
	@Override
	public ProjectUser fetchByProject_Employee_Role(long projectId,
		long employeeId, long roleId) {
		return fetchByProject_Employee_Role(projectId, employeeId, roleId, true);
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
	@Override
	public ProjectUser fetchByProject_Employee_Role(long projectId,
		long employeeId, long roleId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { projectId, employeeId, roleId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
					finderArgs, this);
		}

		if (result instanceof ProjectUser) {
			ProjectUser projectUser = (ProjectUser)result;

			if ((projectId != projectUser.getProjectId()) ||
					(employeeId != projectUser.getEmployeeId()) ||
					(roleId != projectUser.getRoleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(employeeId);

				qPos.add(roleId);

				List<ProjectUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectUserPersistenceImpl.fetchByProject_Employee_Role(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectUser projectUser = list.get(0);

					result = projectUser;

					cacheResult(projectUser);

					if ((projectUser.getProjectId() != projectId) ||
							(projectUser.getEmployeeId() != employeeId) ||
							(projectUser.getRoleId() != roleId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
							finderArgs, projectUser);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
					finderArgs);

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
			return (ProjectUser)result;
		}
	}

	/**
	 * Removes the project user where projectId = &#63; and employeeId = &#63; and roleId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param roleId the role ID
	 * @return the project user that was removed
	 */
	@Override
	public ProjectUser removeByProject_Employee_Role(long projectId,
		long employeeId, long roleId) throws NoSuchProjectUserException {
		ProjectUser projectUser = findByProject_Employee_Role(projectId,
				employeeId, roleId);

		return remove(projectUser);
	}

	/**
	 * Returns the number of project users where projectId = &#63; and employeeId = &#63; and roleId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param employeeId the employee ID
	 * @param roleId the role ID
	 * @return the number of matching project users
	 */
	@Override
	public int countByProject_Employee_Role(long projectId, long employeeId,
		long roleId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE_ROLE;

		Object[] finderArgs = new Object[] { projectId, employeeId, roleId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROJECTUSER_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_PROJECTID_2);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_EMPLOYEEID_2);

			query.append(_FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				qPos.add(employeeId);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_PROJECTID_2 =
		"projectUser.projectId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_EMPLOYEEID_2 =
		"projectUser.employeeId = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_EMPLOYEE_ROLE_ROLEID_2 = "projectUser.roleId = ?";

	public ProjectUserPersistenceImpl() {
		setModelClass(ProjectUser.class);
	}

	/**
	 * Caches the project user in the entity cache if it is enabled.
	 *
	 * @param projectUser the project user
	 */
	@Override
	public void cacheResult(ProjectUser projectUser) {
		entityCache.putResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserImpl.class, projectUser.getPrimaryKey(), projectUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { projectUser.getUuid(), projectUser.getGroupId() },
			projectUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE,
			new Object[] { projectUser.getProjectId(), projectUser.getEmployeeId() },
			projectUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
			new Object[] {
				projectUser.getProjectId(), projectUser.getEmployeeId(),
				projectUser.getRoleId()
			}, projectUser);

		projectUser.resetOriginalValues();
	}

	/**
	 * Caches the project users in the entity cache if it is enabled.
	 *
	 * @param projectUsers the project users
	 */
	@Override
	public void cacheResult(List<ProjectUser> projectUsers) {
		for (ProjectUser projectUser : projectUsers) {
			if (entityCache.getResult(
						ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
						ProjectUserImpl.class, projectUser.getPrimaryKey()) == null) {
				cacheResult(projectUser);
			}
			else {
				projectUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectUser projectUser) {
		entityCache.removeResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserImpl.class, projectUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectUserModelImpl)projectUser);
	}

	@Override
	public void clearCache(List<ProjectUser> projectUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectUser projectUser : projectUsers) {
			entityCache.removeResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
				ProjectUserImpl.class, projectUser.getPrimaryKey());

			clearUniqueFindersCache((ProjectUserModelImpl)projectUser);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectUserModelImpl projectUserModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					projectUserModelImpl.getUuid(),
					projectUserModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				projectUserModelImpl);

			args = new Object[] {
					projectUserModelImpl.getProjectId(),
					projectUserModelImpl.getEmployeeId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE, args,
				projectUserModelImpl);

			args = new Object[] {
					projectUserModelImpl.getProjectId(),
					projectUserModelImpl.getEmployeeId(),
					projectUserModelImpl.getRoleId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE_ROLE,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
				args, projectUserModelImpl);
		}
		else {
			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getUuid(),
						projectUserModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					projectUserModelImpl);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getProjectId(),
						projectUserModelImpl.getEmployeeId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE,
					args, projectUserModelImpl);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getProjectId(),
						projectUserModelImpl.getEmployeeId(),
						projectUserModelImpl.getRoleId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE_ROLE,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
					args, projectUserModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ProjectUserModelImpl projectUserModelImpl) {
		Object[] args = new Object[] {
				projectUserModelImpl.getUuid(),
				projectUserModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((projectUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					projectUserModelImpl.getOriginalUuid(),
					projectUserModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				projectUserModelImpl.getProjectId(),
				projectUserModelImpl.getEmployeeId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE, args);

		if ((projectUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE.getColumnBitmask()) != 0) {
			args = new Object[] {
					projectUserModelImpl.getOriginalProjectId(),
					projectUserModelImpl.getOriginalEmployeeId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE, args);
		}

		args = new Object[] {
				projectUserModelImpl.getProjectId(),
				projectUserModelImpl.getEmployeeId(),
				projectUserModelImpl.getRoleId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE_ROLE,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
			args);

		if ((projectUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE.getColumnBitmask()) != 0) {
			args = new Object[] {
					projectUserModelImpl.getOriginalProjectId(),
					projectUserModelImpl.getOriginalEmployeeId(),
					projectUserModelImpl.getOriginalRoleId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_EMPLOYEE_ROLE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_EMPLOYEE_ROLE,
				args);
		}
	}

	/**
	 * Creates a new project user with the primary key. Does not add the project user to the database.
	 *
	 * @param projectUserId the primary key for the new project user
	 * @return the new project user
	 */
	@Override
	public ProjectUser create(long projectUserId) {
		ProjectUser projectUser = new ProjectUserImpl();

		projectUser.setNew(true);
		projectUser.setPrimaryKey(projectUserId);

		String uuid = PortalUUIDUtil.generate();

		projectUser.setUuid(uuid);

		projectUser.setCompanyId(companyProvider.getCompanyId());

		return projectUser;
	}

	/**
	 * Removes the project user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectUserId the primary key of the project user
	 * @return the project user that was removed
	 * @throws NoSuchProjectUserException if a project user with the primary key could not be found
	 */
	@Override
	public ProjectUser remove(long projectUserId)
		throws NoSuchProjectUserException {
		return remove((Serializable)projectUserId);
	}

	/**
	 * Removes the project user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project user
	 * @return the project user that was removed
	 * @throws NoSuchProjectUserException if a project user with the primary key could not be found
	 */
	@Override
	public ProjectUser remove(Serializable primaryKey)
		throws NoSuchProjectUserException {
		Session session = null;

		try {
			session = openSession();

			ProjectUser projectUser = (ProjectUser)session.get(ProjectUserImpl.class,
					primaryKey);

			if (projectUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectUser);
		}
		catch (NoSuchProjectUserException nsee) {
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
	protected ProjectUser removeImpl(ProjectUser projectUser) {
		projectUser = toUnwrappedModel(projectUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectUser)) {
				projectUser = (ProjectUser)session.get(ProjectUserImpl.class,
						projectUser.getPrimaryKeyObj());
			}

			if (projectUser != null) {
				session.delete(projectUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectUser != null) {
			clearCache(projectUser);
		}

		return projectUser;
	}

	@Override
	public ProjectUser updateImpl(ProjectUser projectUser) {
		projectUser = toUnwrappedModel(projectUser);

		boolean isNew = projectUser.isNew();

		ProjectUserModelImpl projectUserModelImpl = (ProjectUserModelImpl)projectUser;

		if (Validator.isNull(projectUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectUser.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (projectUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectUser.setCreateDate(now);
			}
			else {
				projectUser.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!projectUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectUser.setModifiedDate(now);
			}
			else {
				projectUser.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (projectUser.isNew()) {
				session.save(projectUser);

				projectUser.setNew(false);
			}
			else {
				projectUser = (ProjectUser)session.merge(projectUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProjectUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { projectUserModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getOriginalUuid(),
						projectUserModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						projectUserModelImpl.getUuid(),
						projectUserModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getOriginalProjectId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] { projectUserModelImpl.getProjectId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getOriginalEmployeeId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { projectUserModelImpl.getEmployeeId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getOriginalRoleId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);

				args = new Object[] { projectUserModelImpl.getRoleId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);
			}

			if ((projectUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUserModelImpl.getOriginalProjectId(),
						projectUserModelImpl.getOriginalRoleId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ROLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ROLE,
					args);

				args = new Object[] {
						projectUserModelImpl.getProjectId(),
						projectUserModelImpl.getRoleId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ROLE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ROLE,
					args);
			}
		}

		entityCache.putResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUserImpl.class, projectUser.getPrimaryKey(), projectUser,
			false);

		clearUniqueFindersCache(projectUserModelImpl);
		cacheUniqueFindersCache(projectUserModelImpl, isNew);

		projectUser.resetOriginalValues();

		return projectUser;
	}

	protected ProjectUser toUnwrappedModel(ProjectUser projectUser) {
		if (projectUser instanceof ProjectUserImpl) {
			return projectUser;
		}

		ProjectUserImpl projectUserImpl = new ProjectUserImpl();

		projectUserImpl.setNew(projectUser.isNew());
		projectUserImpl.setPrimaryKey(projectUser.getPrimaryKey());

		projectUserImpl.setUuid(projectUser.getUuid());
		projectUserImpl.setProjectUserId(projectUser.getProjectUserId());
		projectUserImpl.setGroupId(projectUser.getGroupId());
		projectUserImpl.setCompanyId(projectUser.getCompanyId());
		projectUserImpl.setUserId(projectUser.getUserId());
		projectUserImpl.setUserName(projectUser.getUserName());
		projectUserImpl.setCreateDate(projectUser.getCreateDate());
		projectUserImpl.setModifiedDate(projectUser.getModifiedDate());
		projectUserImpl.setProjectId(projectUser.getProjectId());
		projectUserImpl.setEmployeeId(projectUser.getEmployeeId());
		projectUserImpl.setRoleId(projectUser.getRoleId());
		projectUserImpl.setBillRate(projectUser.getBillRate());

		return projectUserImpl;
	}

	/**
	 * Returns the project user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project user
	 * @return the project user
	 * @throws NoSuchProjectUserException if a project user with the primary key could not be found
	 */
	@Override
	public ProjectUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectUserException {
		ProjectUser projectUser = fetchByPrimaryKey(primaryKey);

		if (projectUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectUser;
	}

	/**
	 * Returns the project user with the primary key or throws a {@link NoSuchProjectUserException} if it could not be found.
	 *
	 * @param projectUserId the primary key of the project user
	 * @return the project user
	 * @throws NoSuchProjectUserException if a project user with the primary key could not be found
	 */
	@Override
	public ProjectUser findByPrimaryKey(long projectUserId)
		throws NoSuchProjectUserException {
		return findByPrimaryKey((Serializable)projectUserId);
	}

	/**
	 * Returns the project user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project user
	 * @return the project user, or <code>null</code> if a project user with the primary key could not be found
	 */
	@Override
	public ProjectUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
				ProjectUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectUser projectUser = (ProjectUser)serializable;

		if (projectUser == null) {
			Session session = null;

			try {
				session = openSession();

				projectUser = (ProjectUser)session.get(ProjectUserImpl.class,
						primaryKey);

				if (projectUser != null) {
					cacheResult(projectUser);
				}
				else {
					entityCache.putResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
						ProjectUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
					ProjectUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectUser;
	}

	/**
	 * Returns the project user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectUserId the primary key of the project user
	 * @return the project user, or <code>null</code> if a project user with the primary key could not be found
	 */
	@Override
	public ProjectUser fetchByPrimaryKey(long projectUserId) {
		return fetchByPrimaryKey((Serializable)projectUserId);
	}

	@Override
	public Map<Serializable, ProjectUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectUser> map = new HashMap<Serializable, ProjectUser>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectUser projectUser = fetchByPrimaryKey(primaryKey);

			if (projectUser != null) {
				map.put(primaryKey, projectUser);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
					ProjectUserImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectUser)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTUSER_WHERE_PKS_IN);

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

			for (ProjectUser projectUser : (List<ProjectUser>)q.list()) {
				map.put(projectUser.getPrimaryKeyObj(), projectUser);

				cacheResult(projectUser);

				uncachedPrimaryKeys.remove(projectUser.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectUserModelImpl.ENTITY_CACHE_ENABLED,
					ProjectUserImpl.class, primaryKey, nullModel);
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
	 * Returns all the project users.
	 *
	 * @return the project users
	 */
	@Override
	public List<ProjectUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ProjectUser> findAll(int start, int end,
		OrderByComparator<ProjectUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ProjectUser> findAll(int start, int end,
		OrderByComparator<ProjectUser> orderByComparator,
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

		List<ProjectUser> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTUSER;

				if (pagination) {
					sql = sql.concat(ProjectUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the project users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectUser projectUser : findAll()) {
			remove(projectUser);
		}
	}

	/**
	 * Returns the number of project users.
	 *
	 * @return the number of project users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTUSER);

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
		return ProjectUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectUserImpl.class.getName());
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
	private static final String _SQL_SELECT_PROJECTUSER = "SELECT projectUser FROM ProjectUser projectUser";
	private static final String _SQL_SELECT_PROJECTUSER_WHERE_PKS_IN = "SELECT projectUser FROM ProjectUser projectUser WHERE projectUserId IN (";
	private static final String _SQL_SELECT_PROJECTUSER_WHERE = "SELECT projectUser FROM ProjectUser projectUser WHERE ";
	private static final String _SQL_COUNT_PROJECTUSER = "SELECT COUNT(projectUser) FROM ProjectUser projectUser";
	private static final String _SQL_COUNT_PROJECTUSER_WHERE = "SELECT COUNT(projectUser) FROM ProjectUser projectUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}