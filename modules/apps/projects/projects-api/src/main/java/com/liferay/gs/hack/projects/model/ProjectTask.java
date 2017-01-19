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

package com.liferay.gs.hack.projects.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ProjectTask service. Represents a row in the &quot;PS_ProjectTask&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectTaskModel
 * @see com.liferay.gs.hack.projects.model.impl.ProjectTaskImpl
 * @see com.liferay.gs.hack.projects.model.impl.ProjectTaskModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.gs.hack.projects.model.impl.ProjectTaskImpl")
@ProviderType
public interface ProjectTask extends ProjectTaskModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.gs.hack.projects.model.impl.ProjectTaskImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectTask, Long> PROJECT_TASK_ID_ACCESSOR = new Accessor<ProjectTask, Long>() {
			@Override
			public Long get(ProjectTask projectTask) {
				return projectTask.getProjectTaskId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProjectTask> getTypeClass() {
				return ProjectTask.class;
			}
		};
}