package com.thirteen.sun.sun_api.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "customer",
       uniqueConstraints = @UniqueConstraint(name = "unique_customer_email", columnNames = "email"))

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(length = 20)
    private String telefone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerLead> customerLeads;

    public Customer() {
    }

    public Customer(String name, String email, String telefone) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
    }

    public Customer(Long id, String name, String email, String telefone, Set<CustomerLead> customerLeads) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.customerLeads = customerLeads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<CustomerLead> getCustomerLeads() {
        return customerLeads;
    }

    public void setCustomerLeads(Set<CustomerLead> customerLeads) {
        this.customerLeads = customerLeads;
    }


    
}
