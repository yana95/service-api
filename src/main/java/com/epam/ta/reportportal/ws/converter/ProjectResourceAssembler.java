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

package com.epam.ta.reportportal.ws.converter;

import com.epam.ta.reportportal.database.entity.ExternalSystem;
import com.epam.ta.reportportal.database.entity.Project;
import com.epam.ta.reportportal.ws.converter.builders.ProjectResourceBuilder;
import com.epam.ta.reportportal.ws.model.project.ProjectResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.ArrayList;

/**
 * Resource Assembler for the {@link Project} DB entity
 *
 * @author Andrei_Ramanchuk
 */
@Service
public class ProjectResourceAssembler extends PagedResourcesAssembler<Project, ProjectResource> {

    @Autowired
    private Provider<ProjectResourceBuilder> builder;

    public ProjectResource toResource(Project project, Iterable<ExternalSystem> systems) {
        ProjectResourceBuilder resourceBuilder = builder.get();
        resourceBuilder.addProject(project, systems);
        return resourceBuilder.build();
    }

    @Override
    public ProjectResource toResource(Project entity) {
        ProjectResourceBuilder resourceBuilder = builder.get();
        resourceBuilder.addProject(entity, new ArrayList<>());
        return resourceBuilder.build();
    }
}
