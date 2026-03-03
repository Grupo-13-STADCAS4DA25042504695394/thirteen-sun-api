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

}
