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

/**
 * Implementation of interface {@link GroupDao} in Hibernate.
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
public class ConfigurationGroupDaoImpl implements GroupDao {
    
    private Map<Long, Group> groups = new HashMap<Long, Group>();
    
    public Map<Long, Group> getGroups() {
		return groups;
	}

	/**
     * {@inheritDoc}
     */
    public Group findById(long groupId) {
        return groups.get(groupId);
    }

}
