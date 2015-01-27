/*
 * MainApplication.java
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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.elca.training.dom.Employee;
import ch.elca.training.service.GroupService;


public class MainApplication {
	
    private static final Log logger = LogFactory.getLog(MainApplication.class);

    private static ApplicationContext applicationContext = null;
    
    private static void startup() {
         applicationContext = new AnnotationConfigApplicationContext(
        		 ApplicationConfiguration.class);
    }
 
    private static void printAllMembers(GroupService groupService) {
        long groupId = 1;
        List<Employee> members = groupService.getAllMembersInGroup(groupId);
        for (Employee member : members) {
            logger.info(member.toString());
        }
    }
    
    public static void main(String[] args) {
        startup();
        
        GroupService groupService = applicationContext.getBean(GroupService.class);
        printAllMembers(groupService);
    }
}