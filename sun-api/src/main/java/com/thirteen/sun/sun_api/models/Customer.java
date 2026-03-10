package com.thirteen.sun.sun_api.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(
    name = "customer",
    uniqueConstraints = @UniqueConstraint(
        name = "unique_customer_email",
        columnNames = "email"
    )
)
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
    @JsonIgnore
    private Set<CustomerLead> customerLeads;

    public Customer() {}

    public Customer(String name, String email, String telefone) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Set<CustomerLead> getCustomerLeads() {
        return customerLeads;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCustomerLeads(Set<CustomerLead> customerLeads) {
        this.customerLeads = customerLeads;
    }
}