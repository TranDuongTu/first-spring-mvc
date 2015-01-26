/*
 * ProjectMember.java
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
 * The role of each employee in project. Please note that one employee could have more than
 * 1 functionality for example, the project leader normally is a deveoper in the same project.
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
public class ProjectMember {
    private Employee m_employee;
    private FunctionEnum m_functionality;
    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return m_employee;
    }
    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        m_employee = employee;
    }
    /**
     * @return the functionality
     */
    public FunctionEnum getFunctionality() {
        return m_functionality;
    }
    /**
     * @param functionality the functionality to set
     */
    public void setFunctionality(FunctionEnum functionality) {
        m_functionality = functionality;
    }
}