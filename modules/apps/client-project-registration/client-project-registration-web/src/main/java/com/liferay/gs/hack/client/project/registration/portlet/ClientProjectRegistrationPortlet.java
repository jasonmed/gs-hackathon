package com.liferay.gs.hack.client.project.registration.portlet;

import com.liferay.gs.hack.client.project.registration.portlet.constants.ClientProjectRegistrationConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prathima Shreenath
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=GS HACK",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=client-project-registration Portlet",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.mvc-command-names-default-views=/project/view",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + ClientProjectRegistrationConstants.PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ClientProjectRegistrationPortlet extends MVCPortlet {
}