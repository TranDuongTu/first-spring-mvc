/*
 * CustomBaseDomEditor.java
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

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import ch.elca.training.dom.BaseDom;
import ch.elca.training.dom.Group;

/**
 * Custom property for {@link Group}.
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
public class CustomBaseDomEditor<T extends BaseDom> extends PropertyEditorSupport {
    private List<T> entities = new ArrayList<T>();
     
    /**
     * @param entities
     */
    public CustomBaseDomEditor(List<T> entities) {
        super();
        this.entities = entities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public String getAsText() {
        T value = (T) getValue();
        return (value != null ? "" + value.getId() : "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        for (T entity : entities) {
            if (entity.getId() == id) {
                setValue(entity);
                return;
            }
        }
        
        setValue(null);
    }
}
