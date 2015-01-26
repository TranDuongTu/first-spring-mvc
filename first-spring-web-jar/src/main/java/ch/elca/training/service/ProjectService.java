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

/**
 * Service provides access on ELCA's project.
 *
 * <script type="text/javascript">printFileStatus
 *   ("$URL: https://cvs.elca.ch/subversion/cxnet-portal/trunk/etc/eclipse/preferences_2008_03_03.epf $",
 *    "$Revision: 334 $",
 *    "$Date: 2008-03-03 16:07:32 +0700 (Mon, 03 Mar 2008) $",
 *    "$Author: qkp@ELCA.CH $"
 *    "$Id:$"
 * );</script>
 *
 * @author qkp
 */
public interface ProjectService {
    /**
     * Query all projects matching the criteria.
     * @param query {@link ProjectQuery}. This parameter is nullable. In this case, the
     * service will return all projects available in the system.
     * 
     * @return list of {@link Project}
     */
    List<Project> findByQuery(ProjectQuery query);

    /**
     * @param pid id of the project. This parameter must be not null.
     * @return {@link Project} whose id matches with the <code>pid</code>. Null value could be 
     * returned.
     */
    Project findById(long pid);

    /**
     * @param groupQuery {@link GroupQuery}. This parameter is nullable. In this case, the
     * service will return all groups available in the system.
     * @return list of {@link Group}
     */
    List<Group> findGroupByQuery(GroupQuery groupQuery);

    /**
     * @param employeeQuery {@link EmployeeQuery}. This parameter is nullable. In this case, the
     * service will return all employees available in the system.
     * @return list of {@link Employee}
     */
    List<Employee> findEmployeeByQuery(EmployeeQuery employeeQuery);

    /**
     * If the project exists, update the content of the <code>project</code> into system. Otherwise,
     * just create and return an up-to-date version. 
     * 
     * @param project {@link Project}. This parameter must be not null. 
     * @return updated version which may includes new concurrent id.
     */
    Project save(Project project);
}