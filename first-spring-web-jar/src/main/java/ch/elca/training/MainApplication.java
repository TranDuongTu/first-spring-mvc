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


/**
 * The entry point for launching the application.
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
public class MainApplication {
	
    private static final Log s_logger = LogFactory.getLog(MainApplication.class);

    private static ApplicationContext s_applicationContext = null;
    
    /**
     * Initiate the application context with Spring.
     */
    private static void startup() {
         s_applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    }
 
    /**
     * Just simply print all the members of the group whose id is given into the console.
     * 
     * @param groupService {@link GroupService}
     */
    private static void printAllMembers(GroupService groupService) {
        long groupId = 1;
        List<Employee> members = groupService.getAllMembersInGroup(groupId);
        for (Employee member : members) {
            s_logger.info(member.toString());
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        startup();
        
        GroupService groupService = s_applicationContext.getBean(GroupService.class);
        printAllMembers(groupService);
    }
}