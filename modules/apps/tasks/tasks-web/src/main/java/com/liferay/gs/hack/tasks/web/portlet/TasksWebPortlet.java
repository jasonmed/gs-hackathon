package com.liferay.gs.hack.tasks.web.portlet;

import com.liferay.gs.hack.tasks.web.portlet.constants.TaskWebConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=GS HACK",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=tasks-web Portlet",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TaskWebConstants.TASK_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TasksWebPortlet extends MVCPortlet {
}