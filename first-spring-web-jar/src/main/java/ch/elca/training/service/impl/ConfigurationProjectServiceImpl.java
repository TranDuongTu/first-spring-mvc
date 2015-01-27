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

@Service("projectService")
public class ConfigurationProjectServiceImpl implements ProjectService, BeanFactoryAware {

    private ListableBeanFactory beanFactory;
    
    @Autowired
    private SequenceProvider sequenceProvider;

    private List<Project> allProjects;
    
    private List<Group> allGroups;
    
    private List<Employee> allEmployees;

    private List<Project> getAllProjects() {
        if (allProjects == null) {
            Map<String, Project> projectsMap = beanFactory.getBeansOfType(Project.class);
            allProjects = new ArrayList<Project>(projectsMap.values());
        }
        
        return allProjects;
    }

    private List<Group> getAllGroups() {
        if (allGroups == null) {
            Map<String, Group> employeesMap = beanFactory.getBeansOfType(Group.class);
            allGroups = new ArrayList<Group>(employeesMap.values());
        }
        
        return allGroups;
    }

    private List<Employee> getAllEmployees() {
        if (allEmployees == null) {
            Map<String, Employee> employeesMap = beanFactory.getBeansOfType(Employee.class);
            allEmployees = new ArrayList<Employee>(employeesMap.values());
        }
        
        return allEmployees;
    }

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
    
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        assert (beanFactory instanceof ListableBeanFactory) 
                : "The bean factory must be a ListableBeanFactory";
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }

    public Project findById(long pid) {
        for (Project project : getAllProjects()) {
            if (project.getId() == pid) {
                return project;
            }
        }
        
        return null;
    }

    public List<Employee> findEmployeeByQuery(EmployeeQuery employeeQuery) {
        return getAllEmployees();
    }

    public List<Group> findGroupByQuery(GroupQuery groupQuery) {
        return getAllGroups();
    }

    public Project save(Project savedProject) {
        for (Project project : getAllProjects()) {
            if (project.equals(savedProject)) {
                project.copy(savedProject);
                return project;
            }
        }
        
        // create it
        savedProject.setId(sequenceProvider.getNext());
        getAllProjects().add(savedProject);
        
        return savedProject;
    }
}
