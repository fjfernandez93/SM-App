package com.example.paco.supermarketfinder;

import java.io.Serializable;

/**
 * Created by Paco on 9/10/15.
 */
public class SettingCheckBox implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_DESCRIPTION = "N/A";

    private final String description;

    private boolean checked=true;

    public String getDescription () {
        return description == null ? DEFAULT_DESCRIPTION  : description;
    }

    public void setChecked ( final boolean checked ) {
        this.checked = checked;
    }

    public boolean getChecked () {
        return checked;
    }

    public SettingCheckBox ( final String description ) {
        this.description = description;
    }
}
