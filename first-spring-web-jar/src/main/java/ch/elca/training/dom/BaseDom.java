/*
 * BaseDom.java
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

import java.io.Serializable;

public class BaseDom implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}