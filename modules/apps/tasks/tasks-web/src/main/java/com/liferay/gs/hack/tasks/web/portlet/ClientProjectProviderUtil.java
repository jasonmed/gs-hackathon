package com.liferay.gs.hack.tasks.web.portlet;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Prathima Shreenath
 */
public class ClientProjectProviderUtil {

	public static List<Organization> getAllClients() {

		List<Organization> clients = new ArrayList<Organization>();

		List<Organization> organizations =
			OrganizationLocalServiceUtil.getOrganizations(-1, -1);

		for (Organization organization : organizations) {
			if (organization.getParentOrganizationId() == 0) {

				clients.add(organization);
			}
		}

		return clients;
	}

	public static List<Organization> getAllProjects(
		long companyId, long clientId) {

		return OrganizationLocalServiceUtil.getSuborganizations(
			companyId, clientId);
	}
}
