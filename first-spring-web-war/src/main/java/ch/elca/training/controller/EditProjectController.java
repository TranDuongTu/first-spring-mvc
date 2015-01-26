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

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ch.elca.training.dom.Employee;
import ch.elca.training.dom.EmployeeQuery;
import ch.elca.training.dom.Project;
import ch.elca.training.model.CustomBaseDomEditor;
import ch.elca.training.model.UrlConstants;
import ch.elca.training.service.ProjectService;

/**
 * The controller show project's detail.
 *
 * <script type="text/javascript">printFileStatus
 *   ("$URL: https://cvs.elca.ch/subversion/cxnet-portal/trunk/etc/eclipse/preferences_2008_03_03.epf $",
 *    "$Revision: 334 $",
 *    "$Date: 2008-03-03 16:07:32 +0700 (Mon, 03 Mar 2008) $",
 *    "$Author: qkp@ELCA.CH $"
 *    "$Id:$"
 * );</script>
 *
 * @author mmn
 */
@Controller
@RequestMapping(UrlConstants.EDIT_PROJECT_URL)
public class EditProjectController {
    
    private static final String REQUEST_PARAM_CANCEL = "_cancel";
    public static final String COMMAND_OBJECT_NAME = "project";
    
    @Autowired
    private ProjectService m_projectService;
    
    private List<Employee> m_allEmployees;
    
    /**
     * Register validator.
     * 
     * @param binder binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	binder.registerCustomEditor(Employee.class, new CustomBaseDomEditor<Employee>(getAllEmployees()));
    }
    
    /**
     * @return all the available employees in the system.
     */
    public List<Employee> getAllEmployees() {
        if (m_allEmployees == null) {
            m_allEmployees = m_projectService.findEmployeeByQuery(new EmployeeQuery());
        }
        
        return m_allEmployees;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected String showForm(@RequestParam(value = REQUEST_PARAM_CANCEL, required = false) String cancel,
    		@RequestParam("pid") long pid, Model model) {
    	if (cancel != null) {
    		return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    	}
    	
    	// load the current project
        Project project = m_projectService.findById(pid);
        if (project == null) {
            project = new Project();
        }
        
        model.addAttribute(COMMAND_OBJECT_NAME, project);
        model.addAttribute("allEmployees", getAllEmployees());
        
        return UrlConstants.EDIT_PROJECT_URL;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmit(@ModelAttribute(COMMAND_OBJECT_NAME) @Valid Project command, BindingResult bindingResult, 
    		SessionStatus status, Model model) {
    	
    	model.addAttribute("allEmployees", getAllEmployees());
    	
    	if (bindingResult.hasErrors()) {
    		return UrlConstants.EDIT_PROJECT_URL;
    	} else {
    		m_projectService.save(command);
    		status.setComplete();
    		
    		return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    	}
    }
    
}