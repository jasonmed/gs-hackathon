package com.liferay.gs.hack.report.web.portlet;

import com.liferay.gs.hack.report.web.constants.ReportsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Travis Cory
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=reports-web",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Reports Portlet",
		"javax.portlet.init-param.mvc-command-names-default-views=/reports/view",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + ReportsPortletKeys.REPORTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ReportsPortlet extends MVCPortlet {
}
