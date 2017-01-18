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

import com.liferay.gs.hack.exception.NoSuchClientException;
import com.liferay.gs.hack.model.Client;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.gs.hack.service.persistence.impl.ClientPersistenceImpl
 * @see ClientUtil
 * @generated
 */
@ProviderType
public interface ClientPersistence extends BasePersistence<Client> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClientUtil} to access the client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the clients where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching clients
	*/
	public java.util.List<Client> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the clients where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @return the range of matching clients
	*/
	public java.util.List<Client> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the clients where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clients
	*/
	public java.util.List<Client> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns an ordered range of all the clients where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching clients
	*/
	public java.util.List<Client> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first client in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public Client findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException;

	/**
	* Returns the first client in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching client, or <code>null</code> if a matching client could not be found
	*/
	public Client fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns the last client in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public Client findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException;

	/**
	* Returns the last client in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching client, or <code>null</code> if a matching client could not be found
	*/
	public Client fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns the clients before and after the current client in the ordered set where uuid = &#63;.
	*
	* @param clientId the primary key of the current client
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next client
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public Client[] findByUuid_PrevAndNext(long clientId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException;

	/**
	* Removes all the clients where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of clients where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching clients
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the client where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchClientException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public Client findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchClientException;

	/**
	* Returns the client where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching client, or <code>null</code> if a matching client could not be found
	*/
	public Client fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the client where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching client, or <code>null</code> if a matching client could not be found
	*/
	public Client fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the client where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the client that was removed
	*/
	public Client removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchClientException;

	/**
	* Returns the number of clients where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching clients
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the clients where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching clients
	*/
	public java.util.List<Client> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the clients where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @return the range of matching clients
	*/
	public java.util.List<Client> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the clients where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clients
	*/
	public java.util.List<Client> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns an ordered range of all the clients where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching clients
	*/
	public java.util.List<Client> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first client in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public Client findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException;

	/**
	* Returns the first client in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching client, or <code>null</code> if a matching client could not be found
	*/
	public Client fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns the last client in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public Client findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException;

	/**
	* Returns the last client in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching client, or <code>null</code> if a matching client could not be found
	*/
	public Client fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns the clients before and after the current client in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param clientId the primary key of the current client
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next client
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public Client[] findByUuid_C_PrevAndNext(long clientId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator)
		throws NoSuchClientException;

	/**
	* Removes all the clients where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of clients where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching clients
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the client in the entity cache if it is enabled.
	*
	* @param client the client
	*/
	public void cacheResult(Client client);

	/**
	* Caches the clients in the entity cache if it is enabled.
	*
	* @param clients the clients
	*/
	public void cacheResult(java.util.List<Client> clients);

	/**
	* Creates a new client with the primary key. Does not add the client to the database.
	*
	* @param clientId the primary key for the new client
	* @return the new client
	*/
	public Client create(long clientId);

	/**
	* Removes the client with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the client
	* @return the client that was removed
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public Client remove(long clientId) throws NoSuchClientException;

	public Client updateImpl(Client client);

	/**
	* Returns the client with the primary key or throws a {@link NoSuchClientException} if it could not be found.
	*
	* @param clientId the primary key of the client
	* @return the client
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public Client findByPrimaryKey(long clientId) throws NoSuchClientException;

	/**
	* Returns the client with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientId the primary key of the client
	* @return the client, or <code>null</code> if a client with the primary key could not be found
	*/
	public Client fetchByPrimaryKey(long clientId);

	@Override
	public java.util.Map<java.io.Serializable, Client> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the clients.
	*
	* @return the clients
	*/
	public java.util.List<Client> findAll();

	/**
	* Returns a range of all the clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @return the range of clients
	*/
	public java.util.List<Client> findAll(int start, int end);

	/**
	* Returns an ordered range of all the clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clients
	*/
	public java.util.List<Client> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator);

	/**
	* Returns an ordered range of all the clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of clients
	*/
	public java.util.List<Client> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Client> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the clients from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of clients.
	*
	* @return the number of clients
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}