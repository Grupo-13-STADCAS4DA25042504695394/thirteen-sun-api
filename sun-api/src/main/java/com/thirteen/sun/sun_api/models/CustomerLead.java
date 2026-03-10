package com.thirteen.sun.sun_api.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_lead")
public class CustomerLead {

    @EmbeddedId
    private CustomerLeadId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    @JsonBackReference(value = "customer-lead")
    private Customer customer;

    @ManyToOne
    @MapsId("leadId")
    @JoinColumn(name = "lead_id")
    @JsonBackReference(value = "lead-customer")
    private Lead lead;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    public CustomerLead() {
    }

    public CustomerLead(Customer customer, Lead lead) {
        this.customer = customer;
        this.lead = lead;
        this.id = new CustomerLeadId(customer.getId(), lead.getId());
    }

    public CustomerLeadId getId() {
        return id;
    }

    public void setId(CustomerLeadId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Lead getLead() {
        return lead;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}