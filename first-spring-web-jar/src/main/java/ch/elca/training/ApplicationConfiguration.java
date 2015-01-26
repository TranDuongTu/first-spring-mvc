/*
 * ApplicationConfiguration.java
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

package ch.elca.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import ch.elca.training.dao.GroupDao;
import ch.elca.training.dao.impl.ConfigurationGroupDaoImpl;
import ch.elca.training.dom.Group;

/**
 * This class holds all Spring beans configuration for the application.
 * 
 * @author mmn
 *
 */
@Configuration
@ImportResource({ "classpath*:mandatory/core-config.xml",
    "classpath*:scenarios/dummy/dummy-database.xml" })
public class ApplicationConfiguration {

	@Autowired
	@Qualifier("group-qmv")
	private Group qmvGroup;  // wire in the XML-configured bean
	
	@Autowired
	@Qualifier("group-hnh")
	private Group hnhGroup;  // wire in the XML-configured bean
	
	@Bean
	public GroupDao configurationGroupDao() {
		ConfigurationGroupDaoImpl groupDao = new ConfigurationGroupDaoImpl();
		groupDao.getGroups().put(1l, qmvGroup);
		groupDao.getGroups().put(2l, hnhGroup);
		return groupDao;
	}
}
