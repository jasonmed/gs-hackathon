package com.liferay.gs.hack.tasks.web.portlet;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

/**
 * @author Prathima Shreenath
 */
@Component(
	immediate = true,
	service = ClientProjectProvider.class
)
public class ClientProjectProvider {

	public List<Organization> getAllClients() {

		List<Organization> clients = null;

		List<Organization> organizations =
			_organizationLocalService.getOrganizations(-1, -1);

		for (Organization organization : organizations) {
			if (!organization.isParentable()) {

				clients.add(organization);
			}
		}

		return clients;
	}

	@Reference
	private OrganizationLocalService _organizationLocalService;
}
