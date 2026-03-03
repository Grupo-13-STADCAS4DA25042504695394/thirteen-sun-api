package com.thirteen.sun.sun_api.models;

import java.io.Serializable;

public class CustomerLeadId implements Serializable {

    private Long customerId;
    private Long leadId;

    public CustomerLeadId() {
    }

    public CustomerLeadId(Long customerId, Long leadId) {
        this.customerId = customerId;
        this.leadId = leadId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }
}
