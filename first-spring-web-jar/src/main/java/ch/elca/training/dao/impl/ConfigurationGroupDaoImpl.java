/*
 * ConfigurationGroupDaoImpl.java
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

package ch.elca.training.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ch.elca.training.dao.GroupDao;
import ch.elca.training.dom.Group;

public class ConfigurationGroupDaoImpl implements GroupDao {
    
    private Map<Long, Group> groups = new HashMap<Long, Group>();
    
    public Map<Long, Group> getGroups() {
		return groups;
	}

    public Group findById(long groupId) {
        return groups.get(groupId);
    }
}
