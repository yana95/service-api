/*
 * Copyright 2016 EPAM Systems
 *
 *
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/service-api
 *
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.epam.ta.reportportal.events;

import com.epam.ta.reportportal.database.entity.Launch;
import com.epam.ta.reportportal.database.entity.Project;
import com.google.common.base.Preconditions;

/**
 * Lifecycle events.
 *
 * @author Andrei Varabyeu
 */
public class LaunchFinishedEvent {

	private final Launch launch;
	private final Project project;

	public LaunchFinishedEvent(Launch launch, Project project) {

		this.project = Preconditions.checkNotNull(project, "Project should not be null");
		this.launch = Preconditions.checkNotNull(launch, "Should not be null");
	}

	public Launch getLaunch() {
		return launch;
	}

	public Project getProject() {
		return project;
	}
}
