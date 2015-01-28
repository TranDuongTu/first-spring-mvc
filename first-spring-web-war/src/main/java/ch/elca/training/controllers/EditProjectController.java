/*
 * EditProjectController.java
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

package ch.elca.training.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.elca.training.constants.UrlConstants;
import ch.elca.training.dom.Employee;
import ch.elca.training.dom.EmployeeQuery;
import ch.elca.training.dom.Group;
import ch.elca.training.dom.GroupQuery;
import ch.elca.training.dom.Project;
import ch.elca.training.dom.ProjectQuery;
import ch.elca.training.propertyeditors.CustomBaseDomEditor;
import ch.elca.training.service.ProjectService;

@Controller
@RequestMapping(UrlConstants.EDIT_PROJECT_URL)
public class EditProjectController {
    
    @Autowired
    private ProjectService projectService;
    
    private List<Employee> allEmployees;
    private List<Group> allGroups;
    
    @InitBinder
    public void initBinderEmployees(WebDataBinder binder) {
    	// PropertyEditors to convert String to Employee and Group object
    	binder.registerCustomEditor(Employee.class, 
    			new CustomBaseDomEditor<Employee>(getAllEmployees()));
    	binder.registerCustomEditor(Group.class,
    			new CustomBaseDomEditor<Group>(getAllGroups()));
    	
    	// CustomDateEditor for converting date string
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected String showEditProjectForm(
    		@RequestParam(value = UrlConstants.REQUEST_PARAM_CANCEL, required = false) String isCancel,
    		@RequestParam(UrlConstants.REQUEST_PARAM_PID) long pid, Model model) {
    	if (isCancel != null) {
    		return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    	}
    	
        Project project = projectService.findById(pid);
        if (project == null) {
            project = new Project();
        }
        
        // Update projects in session
        model.addAttribute(UrlConstants.MODEL_PROJECT, project);
        
        // Model attributes for rendering this view
        model.addAttribute(UrlConstants.MODEL_EMPLOYEES, getAllEmployees());
        model.addAttribute(UrlConstants.MODEL_GROUPS, getAllGroups());
        
        return UrlConstants.EDIT_VIEW;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmitProject(
    		@ModelAttribute(UrlConstants.COMMAND_OBJECT_PROJECT) @Valid Project command,
    		BindingResult projectBindingResult, 
    		@ModelAttribute(UrlConstants.COMMAND_OBJECT_QUERY) ProjectQuery query,
    		Model model) {
    	
    	model.addAttribute(UrlConstants.MODEL_EMPLOYEES, getAllEmployees());
    	model.addAttribute(UrlConstants.MODEL_GROUPS, getAllGroups());
    	
    	if (projectBindingResult.hasErrors()) {
    		return UrlConstants.EDIT_VIEW;
    	} else {       	
    		projectService.save(command);
    		
    		// Update projects currently in Session
    		model.addAttribute(UrlConstants.SESSION_PROJECTS, projectService.findByQuery(query));
    		
    		return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    	}
    }
    
    // ========================================================================
    // PRIVATE HELPERS
    // ========================================================================
    
    private List<Employee> getAllEmployees() {
        if (allEmployees == null) {
            allEmployees = projectService.findEmployeeByQuery(new EmployeeQuery());
        }
        
        return allEmployees;
    }
    
    private List<Group> getAllGroups() {
    	if (allGroups == null) {
    		allGroups = projectService.findGroupByQuery(new GroupQuery());
    	}
    	return allGroups;
    }
}