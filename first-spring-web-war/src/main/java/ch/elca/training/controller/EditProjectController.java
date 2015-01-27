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

package ch.elca.training.controller;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import ch.elca.training.dom.Employee;
import ch.elca.training.dom.EmployeeQuery;
import ch.elca.training.dom.Project;
import ch.elca.training.model.CustomBaseDomEditor;
import ch.elca.training.model.UrlConstants;
import ch.elca.training.service.ProjectService;

@Controller
@RequestMapping(UrlConstants.EDIT_PROJECT_URL)
public class EditProjectController {
    
    private static final String REQUEST_PARAM_CANCEL = "_cancel";
    public static final String COMMAND_OBJECT_NAME = "project";
    
    @Autowired
    private ProjectService projectService;
    
    private List<Employee> allEmployees;
    
    @InitBinder
    public void initBinderEmployees(WebDataBinder binder) {
    	binder.registerCustomEditor(Employee.class, 
    			new CustomBaseDomEditor<Employee>(getAllEmployees()));
    }
    
    @InitBinder
    protected void initBinderDate(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }
    
    public List<Employee> getAllEmployees() {
        if (allEmployees == null) {
            allEmployees = projectService.findEmployeeByQuery(new EmployeeQuery());
        }
        
        return allEmployees;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected String showForm(
    		@RequestParam(value = REQUEST_PARAM_CANCEL, required = false) String cancel,
    		@RequestParam("pid") long pid, Model model) {
    	if (cancel != null) {
    		return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    	}
    	
        Project project = projectService.findById(pid);
        if (project == null) {
            project = new Project();
        }
        
        model.addAttribute(COMMAND_OBJECT_NAME, project);
        model.addAttribute("allEmployees", getAllEmployees());
        
        return UrlConstants.EDIT_VIEW;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmit(
    		@ModelAttribute(COMMAND_OBJECT_NAME) @Valid Project command, 
    		BindingResult bindingResult, 
    		SessionStatus status, Model model,
    		WebRequest request, SessionStatus sessionStatus) {
    	
    	model.addAttribute("allEmployees", getAllEmployees());
    	
    	if (bindingResult.hasErrors()) {
    		return UrlConstants.EDIT_VIEW;
    	} else {
    		projectService.save(command);
    		sessionStatus.setComplete();
    		request.removeAttribute("projects", WebRequest.SCOPE_SESSION);
    		request.removeAttribute("query", WebRequest.SCOPE_SESSION);
    		
    		return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    	}
    }
    
}