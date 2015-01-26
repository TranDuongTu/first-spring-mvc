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

/**
 * ELCA's Project.
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
public class Project extends BaseDom {
	
	private static final long serialVersionUID = 1L;
	
	private String m_name;
    private int m_number;
    private Group m_group;
    private Date m_finishingDate;
    private Employee m_leader;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "\nProject {\n\tID:" + getId() 
            + "\n\tNUMBER: " + getNumber() 
            + "\n\tNAME: " + getName() 
            + "\n\tLEADER: " + getLeader() 
            + "\n\tGROUP: " + getGroup() 
            + "\n}";
    }
    
    /**
     * Copy 1 by 1 from the given project except the technical id. 
     * 
     * @param project {@link Project} to copy. This value must be not null and integrity.
     */
    public void copy(Project project) {
        this.setGroup(project.getGroup());
        this.setLeader(project.getLeader());
        this.setName(project.getName());
        this.setNumber(project.getNumber());
        this.setFinishingDate(project.getFinishingDate());
    }
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.getNumber();
    }
    
    /**
     * @return the name
     */
    @NotBlank
    @Length(max = 50)
    public String getName() {
        return m_name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        m_name = name;
    }
    
    /**
     * @return the number
     */
    @Range(min = 1)
    public int getNumber() {
        return m_number;
    }
    
    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        m_number = number;
    }
    
    /**
     * @return the group
     */
    public Group getGroup() {
        return m_group;
    }
    
    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        m_group = group;
    }
    
    /**
     * @return the finishingDate
     */
    @NotNull
    public Date getFinishingDate() {
        return m_finishingDate;
    }
    
    /**
     * @param finishingDate the finishingDate to set
     */
    public void setFinishingDate(Date finishingDate) {
        m_finishingDate = finishingDate;
    }
    
    /**
     * @return the leader
     */
    @NotNull
    public Employee getLeader() {
        return m_leader;
    }
    
    /**
     * @param leader the leader to set
     */
    public void setLeader(Employee leader) {
        m_leader = leader;
    }

}