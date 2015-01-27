/*
 * SearchProjectsController.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.elca.training.dom.Project;
import ch.elca.training.dom.ProjectQuery;
import ch.elca.training.model.UrlConstants;
import ch.elca.training.service.ProjectService;

@Controller
@RequestMapping("/search")
@SessionAttributes(value = {"query", "projects"})
public class SearchProjectsController {
    
    public static final String COMMAND_OBJECT_NAME = "query";
    
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    protected String showForm(Model model) {
    	if (!model.containsAttribute(COMMAND_OBJECT_NAME)) {
    		model.addAttribute(COMMAND_OBJECT_NAME, new ProjectQuery());
    	}
        return UrlConstants.SEARCH_PROJECTS_URL;
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String onSubmit(@ModelAttribute(COMMAND_OBJECT_NAME) ProjectQuery query, 
    		BindingResult errors, Model model) {
        List<Project> projects = projectService.findByQuery(query);
        model.addAttribute("projects", projects);

        model.addAttribute(COMMAND_OBJECT_NAME, query);
        return UrlConstants.REDIRECT_PREFIX + UrlConstants.SEARCH_PROJECTS_URL;
    }
    
}