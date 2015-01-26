/*
 * UrlConstants.java
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

package ch.elca.training.model;

/**
 * All URLs will be defined as constants here.
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
public interface UrlConstants {
	
    /** Constant which is used to redirect page */
    public static final String REDIRECT_PREFIX = "redirect:";
    
    /** The URL which is used to show home page. */
    public static final String HOME_URL = "home";

    /** The URL which is used to search the project list. */
    public static final String SEARCH_PROJECTS_URL = "searchProjects";
    
    /** The URL which is used to show the project detail. */
    public static final String EDIT_PROJECT_URL = "editProject";
}
