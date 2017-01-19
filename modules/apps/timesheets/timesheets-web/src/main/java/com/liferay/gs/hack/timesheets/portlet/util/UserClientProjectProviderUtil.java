package com.liferay.gs.hack.timesheets.portlet.util;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Prathima Shreenath
 */
public class UserClientProjectProviderUtil {

	public List<Organization> getAllUserClients(long userId) {

		List<Organization> clients =  new ArrayList<Organization>();

		List<Organization> organizations =
			OrganizationLocalServiceUtil.getUserOrganizations(userId);

		for (Organization organization : organizations) {
			long parentId = organization.getParentOrganizationId();

			if (parentId == 0) {
				clients.add(organization);
			}
		}

		return clients;
	}

	public List<Organization> getAllUserProjects(long userId) {

		List<Organization> projects =  new ArrayList<Organization>();

		List<Organization> organizations =
			OrganizationLocalServiceUtil.getUserOrganizations(userId);

		for (Organization organization : organizations) {
			long parentId = organization.getParentOrganizationId();

			if (parentId != 0) {
				projects.add(organization);
			}
		}

		return projects;
	}
}
