package com.berkay22demirel.kuponrobotu.model;

import com.berkay22demirel.kuponrobotu.enums.Status;

public class PlayedValue {

    private Integer selectedValue;
    private Status statusOfSelectedValue;

    public Integer getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(Integer selectedValue) {
        this.selectedValue = selectedValue;
    }

    public Status getStatusOfSelectedValue() {
        return statusOfSelectedValue;
    }

    public void setStatusOfSelectedValue(Status statusOfSelectedValue) {
        this.statusOfSelectedValue = statusOfSelectedValue;
    }
}
