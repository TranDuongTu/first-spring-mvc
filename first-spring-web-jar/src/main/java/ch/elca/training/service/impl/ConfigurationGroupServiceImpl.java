/*
 * ConfigurationGroupServiceImpl.java
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

package ch.elca.training.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.elca.training.dao.GroupDao;
import ch.elca.training.dom.Employee;
import ch.elca.training.dom.Group;
import ch.elca.training.dom.Project;
import ch.elca.training.service.GroupService;

@Service("configurationGroupService")
public class ConfigurationGroupServiceImpl implements GroupService {

    private GroupDao m_groupDao;
    
    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        m_groupDao = groupDao;
    }

    public List<Employee> getAllMembersInGroup(long groupId) {
        List<Employee> allMembers = new ArrayList<Employee>();
        
        Group group = m_groupDao.findById(groupId);
        if (group != null) {
            allMembers.add(group.getLeader());
            for (Project project : group.getProjects()) {
                allMembers.add(project.getLeader());
            }
        }
        
        return allMembers;
    }
}
