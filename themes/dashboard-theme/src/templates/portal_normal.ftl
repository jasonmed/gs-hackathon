<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div id="wrapper">
	<div class="flex-container">
		<div class="w20 navigation-container">
			<header id="banner" role="banner">
				<div class="page-title-container">
					<@liferay_ui["icon"]
						cssClass="site-logo"
						icon="time"
						markupView="lexicon"
					/>

					<h1 class="site-name h4" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						Tracker
					</h1>
				</div>

				<#if has_navigation && is_setup_complete>
					<#include "${full_templates_path}/navigation.ftl" />
				</#if>
				
				<div class="user-bar">
					<@liferay.user_personal_bar />
				</div>	
			</header>
		</div>
		
		<div class="w80 content-container">
			<section id="content">
				<h1 class="hide-accessible">${the_title}</h1>

				<nav id="breadcrumbs">
					<@liferay.breadcrumbs />
				</nav>

				<#if selectable>
					<@liferay_util["include"] page=content_include />
				<#else>
					${portletDisplay.recycle()}

					${portletDisplay.setTitle(the_title)}

					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>
				</#if>
			</section>

		</div>
	</div>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
<!-- endinject -->

</body>

</html>
