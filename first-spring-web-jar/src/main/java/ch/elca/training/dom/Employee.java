/*
 * Employee.java
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


/**
 * ELCA's employee. An employee could be a group leader, a project leader or an engineeer.
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
public class Employee extends BaseDom {
	
	private static final long serialVersionUID = 1L;
	
	private String m_visa;
    private RankEnum m_rank;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Employee {ID: " + getId() + ", VISA: " + getVisa() + ", RANK: " + getRank() + "}";
    }
    
    /**
     * @return the visa
     */
    public String getVisa() {
        return m_visa;
    }
    
    /**
     * @param visa the visa to set
     */
    public void setVisa(String visa) {
        m_visa = visa;
    }
    
    /**
     * @return the rank
     */
    public RankEnum getRank() {
        return m_rank;
    }
    
    /**
     * @param rank the rank to set
     */
    public void setRank(RankEnum rank) {
        m_rank = rank;
    }
}