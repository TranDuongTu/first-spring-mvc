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

public class Employee extends BaseDom {
	private static final long serialVersionUID = 1L;

	private String visa;
	private RankEnum rank;

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public RankEnum getRank() {
		return rank;
	}

	public void setRank(RankEnum rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return String.format("{Employee ID: %s; visa: %s; rank: %s}", 
				getId(), getVisa(), getRank());
	}
}