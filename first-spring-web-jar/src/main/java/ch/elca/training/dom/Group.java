/*
 * Group.java
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

package ch.elca.training.dom;

import java.util.ArrayList;
import java.util.List;


/**
 * ELCA's Group. In ELCA, a group consists of several projects. Each project has some engineers
 * working on it under the leadership of a project leader.
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
public class Group extends BaseDom {
	
	private static final long serialVersionUID = 1L;
	
	private Employee m_leader;
	private List<Project> m_projects = new ArrayList<Project>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Group {LEADER: " + getLeader() + "}";
    }
    
    /**
     * @return the leader
     */
    public Employee getLeader() {
        return m_leader;
    }
    
    /**
     * @param leader the leader to set
     */
    public void setLeader(Employee leader) {
        m_leader = leader;
    }
    
    /**
     * @return the projects
     */
    public List<Project> getProjects() {
        return m_projects;
    }
    
    /**
     * @param projects the projects to set
     */
    public void setProjects(List<Project> projects) {
        m_projects = projects;
    }
}