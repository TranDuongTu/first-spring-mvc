/*
 * ProjectService.java
 *
 * Project: TECHWATCH - TESTING TECHNOLOGIES
 *
 * Copyright 2008 by ELCA Informatique SA
 * Av. de la Harpe 22-24, 1000 Lausanne 13
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of ELCA Informatique SA. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license
 * agreement you entered into with ELCA.
 */

package ch.elca.training.service;

import java.util.List;

import ch.elca.training.dom.Employee;
import ch.elca.training.dom.EmployeeQuery;
import ch.elca.training.dom.Group;
import ch.elca.training.dom.GroupQuery;
import ch.elca.training.dom.Project;
import ch.elca.training.dom.ProjectQuery;

public interface ProjectService {
	
    List<Project> findByQuery(ProjectQuery query);

    Project findById(long pid);

    List<Group> findGroupByQuery(GroupQuery groupQuery);

    List<Employee> findEmployeeByQuery(EmployeeQuery employeeQuery);

    Project save(Project project);
}