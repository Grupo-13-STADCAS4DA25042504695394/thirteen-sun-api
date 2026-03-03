package com.thirteen.sun.sun_api.models;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_lead")
public class CustomerLead {

    @EmbeddedId
    private CustomerLeadId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @ManyToOne
    @MapsId("leadId")
    @JoinColumn(name = "lead_id", foreignKey = @ForeignKey(name = "fk_lead"))
    private Lead lead;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;


    public CustomerLead() {
    }


    public CustomerLead(CustomerLeadId id, Customer customer, Lead lead, LocalDateTime dataEnvio) {
        this.id = id;
        this.customer = customer;
        this.lead = lead;
        this.dataEnvio = dataEnvio;
    }


    public CustomerLead(Customer customer, Lead lead, LocalDateTime dataEnvio) {
        this.customer = customer;
        this.lead = lead;
        this.dataEnvio = dataEnvio;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

}