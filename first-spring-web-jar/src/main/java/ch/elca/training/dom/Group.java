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

public class Group extends BaseDom {
	private static final long serialVersionUID = 1L;
	
	private Employee leader;
	private List<Project> projects = new ArrayList<Project>(); 
    
    public Employee getLeader() {
        return leader;
    }
    
    public void setLeader(Employee leader) {
        this.leader = leader;
    }
    
    public List<Project> getProjects() {
        return projects;
    }
    
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}