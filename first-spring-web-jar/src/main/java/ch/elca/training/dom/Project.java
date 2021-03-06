/*
 * Project.java
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

package ch.elca.training.dom;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Project extends BaseDom {
	private static final long serialVersionUID = 1L;
	
	private String name;
    private int number;
    private Group group;
    private Date finishDate;
    private Employee leader;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj instanceof Project) {
            Project project = (Project) obj;
            return this.getNumber() == project.getNumber();
        }

        return false;
    }
    
    @Override
    public int hashCode() {
        return this.getNumber();
    }
    
    public void copy(Project project) {
    	if (project.getGroup() != null) {
    		this.setGroup(project.getGroup());
    	}
        this.setLeader(project.getLeader());
        this.setName(project.getName());
        this.setNumber(project.getNumber());
        this.setFinishingDate(project.getFinishingDate());
    }
    
    @NotBlank(message = "A name is madatory")
    @Length(max = 50, message = "Maximum length is 50 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Range(min = 1, message = "Min value is 1")
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    @NotNull(message = "Must set a group")
    public Group getGroup() {
        return group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    
    @NotNull(message = "Must set a date")
    public Date getFinishingDate() {
        return finishDate;
    }
    
    public void setFinishingDate(Date finishingDate) {
        this.finishDate = finishingDate;
    }
    
    @NotNull(message = "Must have a leader")
    public Employee getLeader() {
        return leader;
    }
    
    public void setLeader(Employee leader) {
        this.leader = leader;
    }
}