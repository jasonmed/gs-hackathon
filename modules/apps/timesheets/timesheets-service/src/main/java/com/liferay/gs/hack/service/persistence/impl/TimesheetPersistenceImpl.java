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

package com.liferay.gs.hack.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.gs.hack.exception.NoSuchTimesheetException;
import com.liferay.gs.hack.model.Timesheet;
import com.liferay.gs.hack.model.impl.TimesheetImpl;
import com.liferay.gs.hack.model.impl.TimesheetModelImpl;
import com.liferay.gs.hack.service.persistence.TimesheetPersistence;

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

import java.sql.Timestamp;

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
 * The persistence implementation for the timesheet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetPersistence
 * @see com.liferay.gs.hack.service.persistence.TimesheetUtil
 * @generated
 */
@ProviderType
public class TimesheetPersistenceImpl extends BasePersistenceImpl<Timesheet>
	implements TimesheetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimesheetUtil} to access the timesheet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimesheetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TimesheetModelImpl.UUID_COLUMN_BITMASK |
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the timesheets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid(String uuid, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid(String uuid, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
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

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Timesheet timesheet : list) {
					if (!Objects.equals(uuid, timesheet.getUuid())) {
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

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

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
				query.append(TimesheetModelImpl.ORDER_BY_JPQL);
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
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first timesheet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUuid_First(String uuid,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUuid_First(uuid, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the first timesheet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUuid_First(String uuid,
		OrderByComparator<Timesheet> orderByComparator) {
		List<Timesheet> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timesheet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUuid_Last(String uuid,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUuid_Last(uuid, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the last timesheet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUuid_Last(String uuid,
		OrderByComparator<Timesheet> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Timesheet> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timesheets before and after the current timesheet in the ordered set where uuid = &#63;.
	 *
	 * @param timesheetId the primary key of the current timesheet
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet[] findByUuid_PrevAndNext(long timesheetId, String uuid,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			Timesheet[] array = new TimesheetImpl[3];

			array[0] = getByUuid_PrevAndNext(session, timesheet, uuid,
					orderByComparator, true);

			array[1] = timesheet;

			array[2] = getByUuid_PrevAndNext(session, timesheet, uuid,
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

	protected Timesheet getByUuid_PrevAndNext(Session session,
		Timesheet timesheet, String uuid,
		OrderByComparator<Timesheet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMESHEET_WHERE);

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
			query.append(TimesheetModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(timesheet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Timesheet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timesheets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Timesheet timesheet : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "timesheet.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "timesheet.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(timesheet.uuid IS NULL OR timesheet.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TimesheetModelImpl.UUID_COLUMN_BITMASK |
			TimesheetModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the timesheet where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTimesheetException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUUID_G(String uuid, long groupId)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUUID_G(uuid, groupId);

		if (timesheet == null) {
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

			throw new NoSuchTimesheetException(msg.toString());
		}

		return timesheet;
	}

	/**
	 * Returns the timesheet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the timesheet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Timesheet) {
			Timesheet timesheet = (Timesheet)result;

			if (!Objects.equals(uuid, timesheet.getUuid()) ||
					(groupId != timesheet.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

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

				List<Timesheet> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Timesheet timesheet = list.get(0);

					result = timesheet;

					cacheResult(timesheet);

					if ((timesheet.getUuid() == null) ||
							!timesheet.getUuid().equals(uuid) ||
							(timesheet.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, timesheet);
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
			return (Timesheet)result;
		}
	}

	/**
	 * Removes the timesheet where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the timesheet that was removed
	 */
	@Override
	public Timesheet removeByUUID_G(String uuid, long groupId)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByUUID_G(uuid, groupId);

		return remove(timesheet);
	}

	/**
	 * Returns the number of timesheets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "timesheet.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "timesheet.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(timesheet.uuid IS NULL OR timesheet.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "timesheet.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TimesheetModelImpl.UUID_COLUMN_BITMASK |
			TimesheetModelImpl.COMPANYID_COLUMN_BITMASK |
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the timesheets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Timesheet> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Timesheet> orderByComparator,
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

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Timesheet timesheet : list) {
					if (!Objects.equals(uuid, timesheet.getUuid()) ||
							(companyId != timesheet.getCompanyId())) {
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

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

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
				query.append(TimesheetModelImpl.ORDER_BY_JPQL);
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
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the first timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Timesheet> orderByComparator) {
		List<Timesheet> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the last timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Timesheet> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Timesheet> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timesheets before and after the current timesheet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param timesheetId the primary key of the current timesheet
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet[] findByUuid_C_PrevAndNext(long timesheetId, String uuid,
		long companyId, OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			Timesheet[] array = new TimesheetImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, timesheet, uuid,
					companyId, orderByComparator, true);

			array[1] = timesheet;

			array[2] = getByUuid_C_PrevAndNext(session, timesheet, uuid,
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

	protected Timesheet getByUuid_C_PrevAndNext(Session session,
		Timesheet timesheet, String uuid, long companyId,
		OrderByComparator<Timesheet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TIMESHEET_WHERE);

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
			query.append(TimesheetModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(timesheet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Timesheet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timesheets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Timesheet timesheet : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "timesheet.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "timesheet.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(timesheet.uuid IS NULL OR timesheet.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "timesheet.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			TimesheetModelImpl.USERID_COLUMN_BITMASK |
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the timesheets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching timesheets
	 */
	@Override
	public List<Timesheet> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUserId(long userId, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByUserId(long userId, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Timesheet timesheet : list) {
					if ((userId != timesheet.getUserId())) {
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

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimesheetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first timesheet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUserId_First(long userId,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUserId_First(userId, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the first timesheet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUserId_First(long userId,
		OrderByComparator<Timesheet> orderByComparator) {
		List<Timesheet> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timesheet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUserId_Last(long userId,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUserId_Last(userId, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the last timesheet in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUserId_Last(long userId,
		OrderByComparator<Timesheet> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Timesheet> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timesheets before and after the current timesheet in the ordered set where userId = &#63;.
	 *
	 * @param timesheetId the primary key of the current timesheet
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet[] findByUserId_PrevAndNext(long timesheetId, long userId,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			Timesheet[] array = new TimesheetImpl[3];

			array[0] = getByUserId_PrevAndNext(session, timesheet, userId,
					orderByComparator, true);

			array[1] = timesheet;

			array[2] = getByUserId_PrevAndNext(session, timesheet, userId,
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

	protected Timesheet getByUserId_PrevAndNext(Session session,
		Timesheet timesheet, long userId,
		OrderByComparator<Timesheet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMESHEET_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(TimesheetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timesheet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Timesheet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timesheets where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Timesheet timesheet : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "timesheet.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTDATE =
		new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStartDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTDATE =
		new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStartDate",
			new String[] { Date.class.getName() },
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STARTDATE = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStartDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the timesheets where startDate = &#63;.
	 *
	 * @param startDate the start date
	 * @return the matching timesheets
	 */
	@Override
	public List<Timesheet> findByStartDate(Date startDate) {
		return findByStartDate(startDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the timesheets where startDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByStartDate(Date startDate, int start, int end) {
		return findByStartDate(startDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets where startDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByStartDate(Date startDate, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return findByStartDate(startDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets where startDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param startDate the start date
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByStartDate(Date startDate, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTDATE;
			finderArgs = new Object[] { startDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTDATE;
			finderArgs = new Object[] { startDate, start, end, orderByComparator };
		}

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Timesheet timesheet : list) {
					if (!Objects.equals(startDate, timesheet.getStartDate())) {
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

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_STARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_STARTDATE_STARTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimesheetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
				}

				if (!pagination) {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first timesheet in the ordered set where startDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByStartDate_First(Date startDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByStartDate_First(startDate,
				orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startDate=");
		msg.append(startDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the first timesheet in the ordered set where startDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByStartDate_First(Date startDate,
		OrderByComparator<Timesheet> orderByComparator) {
		List<Timesheet> list = findByStartDate(startDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timesheet in the ordered set where startDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByStartDate_Last(Date startDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByStartDate_Last(startDate, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("startDate=");
		msg.append(startDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the last timesheet in the ordered set where startDate = &#63;.
	 *
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByStartDate_Last(Date startDate,
		OrderByComparator<Timesheet> orderByComparator) {
		int count = countByStartDate(startDate);

		if (count == 0) {
			return null;
		}

		List<Timesheet> list = findByStartDate(startDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timesheets before and after the current timesheet in the ordered set where startDate = &#63;.
	 *
	 * @param timesheetId the primary key of the current timesheet
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet[] findByStartDate_PrevAndNext(long timesheetId,
		Date startDate, OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			Timesheet[] array = new TimesheetImpl[3];

			array[0] = getByStartDate_PrevAndNext(session, timesheet,
					startDate, orderByComparator, true);

			array[1] = timesheet;

			array[2] = getByStartDate_PrevAndNext(session, timesheet,
					startDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Timesheet getByStartDate_PrevAndNext(Session session,
		Timesheet timesheet, Date startDate,
		OrderByComparator<Timesheet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMESHEET_WHERE);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_STARTDATE_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_STARTDATE_STARTDATE_2);
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
			query.append(TimesheetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStartDate) {
			qPos.add(new Timestamp(startDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timesheet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Timesheet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timesheets where startDate = &#63; from the database.
	 *
	 * @param startDate the start date
	 */
	@Override
	public void removeByStartDate(Date startDate) {
		for (Timesheet timesheet : findByStartDate(startDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets where startDate = &#63;.
	 *
	 * @param startDate the start date
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByStartDate(Date startDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STARTDATE;

		Object[] finderArgs = new Object[] { startDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_STARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_STARTDATE_STARTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
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

	private static final String _FINDER_COLUMN_STARTDATE_STARTDATE_1 = "timesheet.startDate IS NULL";
	private static final String _FINDER_COLUMN_STARTDATE_STARTDATE_2 = "timesheet.startDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDDATE = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEndDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDDATE =
		new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEndDate",
			new String[] { Date.class.getName() },
			TimesheetModelImpl.ENDDATE_COLUMN_BITMASK |
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENDDATE = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEndDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the timesheets where endDate = &#63;.
	 *
	 * @param endDate the end date
	 * @return the matching timesheets
	 */
	@Override
	public List<Timesheet> findByEndDate(Date endDate) {
		return findByEndDate(endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheets where endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByEndDate(Date endDate, int start, int end) {
		return findByEndDate(endDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets where endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByEndDate(Date endDate, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return findByEndDate(endDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets where endDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByEndDate(Date endDate, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDDATE;
			finderArgs = new Object[] { endDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDDATE;
			finderArgs = new Object[] { endDate, start, end, orderByComparator };
		}

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Timesheet timesheet : list) {
					if (!Objects.equals(endDate, timesheet.getEndDate())) {
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

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimesheetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(new Timestamp(endDate.getTime()));
				}

				if (!pagination) {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first timesheet in the ordered set where endDate = &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByEndDate_First(Date endDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByEndDate_First(endDate, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the first timesheet in the ordered set where endDate = &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByEndDate_First(Date endDate,
		OrderByComparator<Timesheet> orderByComparator) {
		List<Timesheet> list = findByEndDate(endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timesheet in the ordered set where endDate = &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByEndDate_Last(Date endDate,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByEndDate_Last(endDate, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the last timesheet in the ordered set where endDate = &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByEndDate_Last(Date endDate,
		OrderByComparator<Timesheet> orderByComparator) {
		int count = countByEndDate(endDate);

		if (count == 0) {
			return null;
		}

		List<Timesheet> list = findByEndDate(endDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timesheets before and after the current timesheet in the ordered set where endDate = &#63;.
	 *
	 * @param timesheetId the primary key of the current timesheet
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet[] findByEndDate_PrevAndNext(long timesheetId,
		Date endDate, OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			Timesheet[] array = new TimesheetImpl[3];

			array[0] = getByEndDate_PrevAndNext(session, timesheet, endDate,
					orderByComparator, true);

			array[1] = timesheet;

			array[2] = getByEndDate_PrevAndNext(session, timesheet, endDate,
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

	protected Timesheet getByEndDate_PrevAndNext(Session session,
		Timesheet timesheet, Date endDate,
		OrderByComparator<Timesheet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMESHEET_WHERE);

		boolean bindEndDate = false;

		if (endDate == null) {
			query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
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
			query.append(TimesheetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEndDate) {
			qPos.add(new Timestamp(endDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timesheet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Timesheet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timesheets where endDate = &#63; from the database.
	 *
	 * @param endDate the end date
	 */
	@Override
	public void removeByEndDate(Date endDate) {
		for (Timesheet timesheet : findByEndDate(endDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets where endDate = &#63;.
	 *
	 * @param endDate the end date
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByEndDate(Date endDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENDDATE;

		Object[] finderArgs = new Object[] { endDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				query.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEndDate) {
					qPos.add(new Timestamp(endDate.getTime()));
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

	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_1 = "timesheet.endDate IS NULL";
	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_2 = "timesheet.endDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			TimesheetModelImpl.STATUS_COLUMN_BITMASK |
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the timesheets where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching timesheets
	 */
	@Override
	public List<Timesheet> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByStatus(String status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByStatus(String status, int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timesheets
	 */
	@Override
	public List<Timesheet> findByStatus(String status, int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Timesheet timesheet : list) {
					if (!Objects.equals(status, timesheet.getStatus())) {
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

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimesheetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first timesheet in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByStatus_First(String status,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByStatus_First(status, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the first timesheet in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByStatus_First(String status,
		OrderByComparator<Timesheet> orderByComparator) {
		List<Timesheet> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timesheet in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByStatus_Last(String status,
		OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByStatus_Last(status, orderByComparator);

		if (timesheet != null) {
			return timesheet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimesheetException(msg.toString());
	}

	/**
	 * Returns the last timesheet in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByStatus_Last(String status,
		OrderByComparator<Timesheet> orderByComparator) {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Timesheet> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timesheets before and after the current timesheet in the ordered set where status = &#63;.
	 *
	 * @param timesheetId the primary key of the current timesheet
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet[] findByStatus_PrevAndNext(long timesheetId,
		String status, OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByPrimaryKey(timesheetId);

		Session session = null;

		try {
			session = openSession();

			Timesheet[] array = new TimesheetImpl[3];

			array[0] = getByStatus_PrevAndNext(session, timesheet, status,
					orderByComparator, true);

			array[1] = timesheet;

			array[2] = getByStatus_PrevAndNext(session, timesheet, status,
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

	protected Timesheet getByStatus_PrevAndNext(Session session,
		Timesheet timesheet, String status,
		OrderByComparator<Timesheet> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMESHEET_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			query.append(TimesheetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timesheet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Timesheet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timesheets where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (Timesheet timesheet : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByStatus(String status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "timesheet.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "timesheet.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(timesheet.status IS NULL OR timesheet.status = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID_STARTDATE = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, TimesheetImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId_StartDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			TimesheetModelImpl.USERID_COLUMN_BITMASK |
			TimesheetModelImpl.STARTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_STARTDATE = new FinderPath(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_StartDate",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the timesheet where userId = &#63; and startDate = &#63; or throws a {@link NoSuchTimesheetException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @return the matching timesheet
	 * @throws NoSuchTimesheetException if a matching timesheet could not be found
	 */
	@Override
	public Timesheet findByUserId_StartDate(long userId, Date startDate)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByUserId_StartDate(userId, startDate);

		if (timesheet == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", startDate=");
			msg.append(startDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTimesheetException(msg.toString());
		}

		return timesheet;
	}

	/**
	 * Returns the timesheet where userId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUserId_StartDate(long userId, Date startDate) {
		return fetchByUserId_StartDate(userId, startDate, true);
	}

	/**
	 * Returns the timesheet where userId = &#63; and startDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching timesheet, or <code>null</code> if a matching timesheet could not be found
	 */
	@Override
	public Timesheet fetchByUserId_StartDate(long userId, Date startDate,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId, startDate };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE,
					finderArgs, this);
		}

		if (result instanceof Timesheet) {
			Timesheet timesheet = (Timesheet)result;

			if ((userId != timesheet.getUserId()) ||
					!Objects.equals(startDate, timesheet.getStartDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TIMESHEET_WHERE);

			query.append(_FINDER_COLUMN_USERID_STARTDATE_USERID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_USERID_STARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_USERID_STARTDATE_STARTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
				}

				List<Timesheet> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TimesheetPersistenceImpl.fetchByUserId_StartDate(long, Date, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Timesheet timesheet = list.get(0);

					result = timesheet;

					cacheResult(timesheet);

					if ((timesheet.getUserId() != userId) ||
							(timesheet.getStartDate() == null) ||
							!timesheet.getStartDate().equals(startDate)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE,
							finderArgs, timesheet);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE,
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
			return (Timesheet)result;
		}
	}

	/**
	 * Removes the timesheet where userId = &#63; and startDate = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @return the timesheet that was removed
	 */
	@Override
	public Timesheet removeByUserId_StartDate(long userId, Date startDate)
		throws NoSuchTimesheetException {
		Timesheet timesheet = findByUserId_StartDate(userId, startDate);

		return remove(timesheet);
	}

	/**
	 * Returns the number of timesheets where userId = &#63; and startDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param startDate the start date
	 * @return the number of matching timesheets
	 */
	@Override
	public int countByUserId_StartDate(long userId, Date startDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID_STARTDATE;

		Object[] finderArgs = new Object[] { userId, startDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMESHEET_WHERE);

			query.append(_FINDER_COLUMN_USERID_STARTDATE_USERID_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_USERID_STARTDATE_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_USERID_STARTDATE_STARTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
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

	private static final String _FINDER_COLUMN_USERID_STARTDATE_USERID_2 = "timesheet.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_STARTDATE_STARTDATE_1 = "timesheet.startDate IS NULL";
	private static final String _FINDER_COLUMN_USERID_STARTDATE_STARTDATE_2 = "timesheet.startDate = ?";

	public TimesheetPersistenceImpl() {
		setModelClass(Timesheet.class);
	}

	/**
	 * Caches the timesheet in the entity cache if it is enabled.
	 *
	 * @param timesheet the timesheet
	 */
	@Override
	public void cacheResult(Timesheet timesheet) {
		entityCache.putResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetImpl.class, timesheet.getPrimaryKey(), timesheet);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { timesheet.getUuid(), timesheet.getGroupId() },
			timesheet);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE,
			new Object[] { timesheet.getUserId(), timesheet.getStartDate() },
			timesheet);

		timesheet.resetOriginalValues();
	}

	/**
	 * Caches the timesheets in the entity cache if it is enabled.
	 *
	 * @param timesheets the timesheets
	 */
	@Override
	public void cacheResult(List<Timesheet> timesheets) {
		for (Timesheet timesheet : timesheets) {
			if (entityCache.getResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
						TimesheetImpl.class, timesheet.getPrimaryKey()) == null) {
				cacheResult(timesheet);
			}
			else {
				timesheet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all timesheets.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimesheetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the timesheet.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Timesheet timesheet) {
		entityCache.removeResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetImpl.class, timesheet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TimesheetModelImpl)timesheet);
	}

	@Override
	public void clearCache(List<Timesheet> timesheets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Timesheet timesheet : timesheets) {
			entityCache.removeResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
				TimesheetImpl.class, timesheet.getPrimaryKey());

			clearUniqueFindersCache((TimesheetModelImpl)timesheet);
		}
	}

	protected void cacheUniqueFindersCache(
		TimesheetModelImpl timesheetModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					timesheetModelImpl.getUuid(),
					timesheetModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				timesheetModelImpl);

			args = new Object[] {
					timesheetModelImpl.getUserId(),
					timesheetModelImpl.getStartDate()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERID_STARTDATE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE, args,
				timesheetModelImpl);
		}
		else {
			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getUuid(),
						timesheetModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					timesheetModelImpl);
			}

			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID_STARTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getUserId(),
						timesheetModelImpl.getStartDate()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERID_STARTDATE,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE,
					args, timesheetModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TimesheetModelImpl timesheetModelImpl) {
		Object[] args = new Object[] {
				timesheetModelImpl.getUuid(), timesheetModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((timesheetModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					timesheetModelImpl.getOriginalUuid(),
					timesheetModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				timesheetModelImpl.getUserId(),
				timesheetModelImpl.getStartDate()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID_STARTDATE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE, args);

		if ((timesheetModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID_STARTDATE.getColumnBitmask()) != 0) {
			args = new Object[] {
					timesheetModelImpl.getOriginalUserId(),
					timesheetModelImpl.getOriginalStartDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID_STARTDATE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID_STARTDATE, args);
		}
	}

	/**
	 * Creates a new timesheet with the primary key. Does not add the timesheet to the database.
	 *
	 * @param timesheetId the primary key for the new timesheet
	 * @return the new timesheet
	 */
	@Override
	public Timesheet create(long timesheetId) {
		Timesheet timesheet = new TimesheetImpl();

		timesheet.setNew(true);
		timesheet.setPrimaryKey(timesheetId);

		String uuid = PortalUUIDUtil.generate();

		timesheet.setUuid(uuid);

		timesheet.setCompanyId(companyProvider.getCompanyId());

		return timesheet;
	}

	/**
	 * Removes the timesheet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timesheetId the primary key of the timesheet
	 * @return the timesheet that was removed
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet remove(long timesheetId) throws NoSuchTimesheetException {
		return remove((Serializable)timesheetId);
	}

	/**
	 * Removes the timesheet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the timesheet
	 * @return the timesheet that was removed
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet remove(Serializable primaryKey)
		throws NoSuchTimesheetException {
		Session session = null;

		try {
			session = openSession();

			Timesheet timesheet = (Timesheet)session.get(TimesheetImpl.class,
					primaryKey);

			if (timesheet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimesheetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timesheet);
		}
		catch (NoSuchTimesheetException nsee) {
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
	protected Timesheet removeImpl(Timesheet timesheet) {
		timesheet = toUnwrappedModel(timesheet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timesheet)) {
				timesheet = (Timesheet)session.get(TimesheetImpl.class,
						timesheet.getPrimaryKeyObj());
			}

			if (timesheet != null) {
				session.delete(timesheet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (timesheet != null) {
			clearCache(timesheet);
		}

		return timesheet;
	}

	@Override
	public Timesheet updateImpl(Timesheet timesheet) {
		timesheet = toUnwrappedModel(timesheet);

		boolean isNew = timesheet.isNew();

		TimesheetModelImpl timesheetModelImpl = (TimesheetModelImpl)timesheet;

		if (Validator.isNull(timesheet.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			timesheet.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (timesheet.getCreateDate() == null)) {
			if (serviceContext == null) {
				timesheet.setCreateDate(now);
			}
			else {
				timesheet.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!timesheetModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				timesheet.setModifiedDate(now);
			}
			else {
				timesheet.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (timesheet.isNew()) {
				session.save(timesheet);

				timesheet.setNew(false);
			}
			else {
				timesheet = (Timesheet)session.merge(timesheet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TimesheetModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { timesheetModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getOriginalUuid(),
						timesheetModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						timesheetModelImpl.getUuid(),
						timesheetModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { timesheetModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getOriginalStartDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STARTDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTDATE,
					args);

				args = new Object[] { timesheetModelImpl.getStartDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STARTDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTDATE,
					args);
			}

			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getOriginalEndDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ENDDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDDATE,
					args);

				args = new Object[] { timesheetModelImpl.getEndDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ENDDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDDATE,
					args);
			}

			if ((timesheetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timesheetModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { timesheetModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
			TimesheetImpl.class, timesheet.getPrimaryKey(), timesheet, false);

		clearUniqueFindersCache(timesheetModelImpl);
		cacheUniqueFindersCache(timesheetModelImpl, isNew);

		timesheet.resetOriginalValues();

		return timesheet;
	}

	protected Timesheet toUnwrappedModel(Timesheet timesheet) {
		if (timesheet instanceof TimesheetImpl) {
			return timesheet;
		}

		TimesheetImpl timesheetImpl = new TimesheetImpl();

		timesheetImpl.setNew(timesheet.isNew());
		timesheetImpl.setPrimaryKey(timesheet.getPrimaryKey());

		timesheetImpl.setUuid(timesheet.getUuid());
		timesheetImpl.setTimesheetId(timesheet.getTimesheetId());
		timesheetImpl.setGroupId(timesheet.getGroupId());
		timesheetImpl.setUserId(timesheet.getUserId());
		timesheetImpl.setCompanyId(timesheet.getCompanyId());
		timesheetImpl.setUserName(timesheet.getUserName());
		timesheetImpl.setCreateDate(timesheet.getCreateDate());
		timesheetImpl.setModifiedDate(timesheet.getModifiedDate());
		timesheetImpl.setStartDate(timesheet.getStartDate());
		timesheetImpl.setEndDate(timesheet.getEndDate());
		timesheetImpl.setStatus(timesheet.getStatus());

		return timesheetImpl;
	}

	/**
	 * Returns the timesheet with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the timesheet
	 * @return the timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimesheetException {
		Timesheet timesheet = fetchByPrimaryKey(primaryKey);

		if (timesheet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimesheetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timesheet;
	}

	/**
	 * Returns the timesheet with the primary key or throws a {@link NoSuchTimesheetException} if it could not be found.
	 *
	 * @param timesheetId the primary key of the timesheet
	 * @return the timesheet
	 * @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet findByPrimaryKey(long timesheetId)
		throws NoSuchTimesheetException {
		return findByPrimaryKey((Serializable)timesheetId);
	}

	/**
	 * Returns the timesheet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the timesheet
	 * @return the timesheet, or <code>null</code> if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
				TimesheetImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Timesheet timesheet = (Timesheet)serializable;

		if (timesheet == null) {
			Session session = null;

			try {
				session = openSession();

				timesheet = (Timesheet)session.get(TimesheetImpl.class,
						primaryKey);

				if (timesheet != null) {
					cacheResult(timesheet);
				}
				else {
					entityCache.putResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
						TimesheetImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
					TimesheetImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return timesheet;
	}

	/**
	 * Returns the timesheet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timesheetId the primary key of the timesheet
	 * @return the timesheet, or <code>null</code> if a timesheet with the primary key could not be found
	 */
	@Override
	public Timesheet fetchByPrimaryKey(long timesheetId) {
		return fetchByPrimaryKey((Serializable)timesheetId);
	}

	@Override
	public Map<Serializable, Timesheet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Timesheet> map = new HashMap<Serializable, Timesheet>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Timesheet timesheet = fetchByPrimaryKey(primaryKey);

			if (timesheet != null) {
				map.put(primaryKey, timesheet);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
					TimesheetImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Timesheet)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIMESHEET_WHERE_PKS_IN);

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

			for (Timesheet timesheet : (List<Timesheet>)q.list()) {
				map.put(timesheet.getPrimaryKeyObj(), timesheet);

				cacheResult(timesheet);

				uncachedPrimaryKeys.remove(timesheet.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TimesheetModelImpl.ENTITY_CACHE_ENABLED,
					TimesheetImpl.class, primaryKey, nullModel);
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
	 * Returns all the timesheets.
	 *
	 * @return the timesheets
	 */
	@Override
	public List<Timesheet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timesheets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @return the range of timesheets
	 */
	@Override
	public List<Timesheet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the timesheets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timesheets
	 */
	@Override
	public List<Timesheet> findAll(int start, int end,
		OrderByComparator<Timesheet> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timesheets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timesheets
	 * @param end the upper bound of the range of timesheets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of timesheets
	 */
	@Override
	public List<Timesheet> findAll(int start, int end,
		OrderByComparator<Timesheet> orderByComparator,
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

		List<Timesheet> list = null;

		if (retrieveFromCache) {
			list = (List<Timesheet>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIMESHEET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMESHEET;

				if (pagination) {
					sql = sql.concat(TimesheetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Timesheet>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the timesheets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Timesheet timesheet : findAll()) {
			remove(timesheet);
		}
	}

	/**
	 * Returns the number of timesheets.
	 *
	 * @return the number of timesheets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMESHEET);

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
		return TimesheetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the timesheet persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TimesheetImpl.class.getName());
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
	private static final String _SQL_SELECT_TIMESHEET = "SELECT timesheet FROM Timesheet timesheet";
	private static final String _SQL_SELECT_TIMESHEET_WHERE_PKS_IN = "SELECT timesheet FROM Timesheet timesheet WHERE timesheetId IN (";
	private static final String _SQL_SELECT_TIMESHEET_WHERE = "SELECT timesheet FROM Timesheet timesheet WHERE ";
	private static final String _SQL_COUNT_TIMESHEET = "SELECT COUNT(timesheet) FROM Timesheet timesheet";
	private static final String _SQL_COUNT_TIMESHEET_WHERE = "SELECT COUNT(timesheet) FROM Timesheet timesheet WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timesheet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Timesheet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Timesheet exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TimesheetPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}