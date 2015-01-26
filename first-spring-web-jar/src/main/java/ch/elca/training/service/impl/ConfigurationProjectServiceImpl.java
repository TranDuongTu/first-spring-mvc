/*
 * ConfigurationProjectServiceImpl.java
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
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.elca.training.dom.Employee;
import ch.elca.training.dom.EmployeeQuery;
import ch.elca.training.dom.Group;
import ch.elca.training.dom.GroupQuery;
import ch.elca.training.dom.Project;
import ch.elca.training.dom.ProjectQuery;
import ch.elca.training.helper.SequenceProvider;
import ch.elca.training.service.ProjectService;

/**
 * Implementation of the interface {@link ProjectService} just by configuration in Spring.
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
@Service("projectService")
public class ConfigurationProjectServiceImpl implements ProjectService, BeanFactoryAware {

    private ListableBeanFactory m_beanFactory;
    
    @Autowired
    private SequenceProvider m_sequenceProvider;

    private List<Project> m_allProjects;
    
    private List<Group> m_allGroups;
    
    private List<Employee> m_allEmployees;

    /** Get all projects */
    private List<Project> getAllProjects() {
        if (m_allProjects == null) {
            Map<String, Project> projectsMap = m_beanFactory.getBeansOfType(Project.class);
            m_allProjects = new ArrayList<Project>(projectsMap.values());
        }
        
        return m_allProjects;
    }

    /** Get all groups */
    private List<Group> getAllGroups() {
        if (m_allGroups == null) {
            Map<String, Group> employeesMap = m_beanFactory.getBeansOfType(Group.class);
            m_allGroups = new ArrayList<Group>(employeesMap.values());
        }
        
        return m_allGroups;
    }

    /** Get all employees */
    private List<Employee> getAllEmployees() {
        if (m_allEmployees == null) {
            Map<String, Employee> employeesMap = m_beanFactory.getBeansOfType(Employee.class);
            m_allEmployees = new ArrayList<Employee>(employeesMap.values());
        }
        
        return m_allEmployees;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<Project> findByQuery(ProjectQuery query) {
        List<Project> projects = new ArrayList<Project>();
        for (Project project : getAllProjects()) {
            String criteria = StringUtils.trimToEmpty(query.getMatchingText());
            if (StringUtils.containsIgnoreCase(project.getName(), criteria) 
                    || StringUtils.containsIgnoreCase(project.getLeader().getVisa(), criteria)
                    || StringUtils.containsIgnoreCase(project.getGroup().getLeader().getVisa(), criteria)
                    || StringUtils.containsIgnoreCase("" + project.getNumber(), criteria)) {
                projects.add(project);
            }
        }
        
        return projects;
    }

    /**
     * {@inheritDoc}
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        assert (beanFactory instanceof ListableBeanFactory) 
                : "The bean factory must be a ListableBeanFactory";
        m_beanFactory = (ListableBeanFactory) beanFactory;
    }

    /**
     * {@inheritDoc}
     */
    public Project findById(long pid) {
        for (Project project : getAllProjects()) {
            if (project.getId() == pid) {
                return project;
            }
        }
        
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> findEmployeeByQuery(EmployeeQuery employeeQuery) {
        return getAllEmployees();
    }

    /**
     * {@inheritDoc}
     */
    public List<Group> findGroupByQuery(GroupQuery groupQuery) {
        return getAllGroups();
    }

    /**
     * {@inheritDoc}
     */
    public Project save(Project savedProject) {
        for (Project project : getAllProjects()) {
            if (project.equals(savedProject)) {
                project.copy(savedProject);
                return project;
            }
        }
        
        // create it
        savedProject.setId(m_sequenceProvider.getNext());
        getAllProjects().add(savedProject);
        
        return savedProject;
    }
}
