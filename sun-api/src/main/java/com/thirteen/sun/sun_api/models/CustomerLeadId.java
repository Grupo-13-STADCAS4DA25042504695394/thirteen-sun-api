package com.thirteen.sun.sun_api.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
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

    public Long getLeadId() {
        return leadId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerLeadId)) return false;
        CustomerLeadId that = (CustomerLeadId) o;
        return Objects.equals(customerId, that.customerId) &&
               Objects.equals(leadId, that.leadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, leadId);
    }
}