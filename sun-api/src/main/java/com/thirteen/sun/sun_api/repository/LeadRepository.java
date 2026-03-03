package com.thirteen.sun.sun_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thirteen.sun.sun_api.models.Lead;

import java.util.List;
import java.util.Optional;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    Optional<Lead> findByEmail(String email);

    List<Lead> findByPerfilDeConsumo(Integer perfilDeConsumo);
}
