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
}
