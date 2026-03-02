package com.thirteen.sun.sun_api.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "lead",
       uniqueConstraints = @UniqueConstraint(name = "unique_lead_email", columnNames = "email"))
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(name = "perfil_de_consumo", nullable = false)
    private Integer perfilDeConsumo;

    @Column(length = 10)
    private String cep;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(length = 20)
    private String telefone;

    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerLead> customerLeads;

    public Lead() {
    }

    public Lead(Long id, String nome, Integer perfilDeConsumo, String cep, String email, String telefone, Set<CustomerLead> customerLeads) {
        this.id = id;
        this.nome = nome;
        this.perfilDeConsumo = perfilDeConsumo;
        this.cep = cep;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPerfilDeConsumo() {
        return perfilDeConsumo;
    }

    public void setPerfilDeConsumo(Integer perfilDeConsumo) {
        this.perfilDeConsumo = perfilDeConsumo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
