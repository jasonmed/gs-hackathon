package com.liferay.gs.hack.report.web.portlet.action;

import com.liferay.gs.hack.report.web.constants.ReportsPortletKeys;
import com.liferay.gs.hack.reports.service.ReportsServiceLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Map;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ReportsPortletKeys.REPORTS,
		"mvc.command.name=/generate/report"
	},
	service = MVCActionCommand.class
)
public class SubmitReportMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		generateReport(actionRequest, actionResponse);
	}

	private void generateReport(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();

		boolean isClient = ParamUtil.getBoolean(actionRequest, "isClient");

		long organizationId = ParamUtil.getLong(
			actionRequest, "organizationId");


		Map<User, Double> generatedReport;
		if (isClient)
			generatedReport =
				_reportsServiceLocalService.generateClientReport(organizationId);
		else {
			generatedReport =
				_reportsServiceLocalService.generateClientReport(organizationId);
		}

		actionRequest.setAttribute("generatedReport", generatedReport);
	}

	@Reference
	private ReportsServiceLocalService _reportsServiceLocalService;


}
