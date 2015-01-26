/*
 * GroupService.java
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

/**
 * Service provides access on ELCA's groups.
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
public interface GroupService {
    /**
     * A group in ELCA has several projects in which there are some engineers are working under
     * the leadership of a project leader. This method is to query the list of all members of the
     * given group which includes:
     * <ul>
     *  <li>Group Leader</li>
     *  <li>All projects' members - leader and engineers</li>
     * </ul>
     * 
     * @param groupId id of the group whose memebers to be queried.
     * @return list of {@link Employee}
     */
    List<Employee> getAllMembersInGroup(long groupId);
}
