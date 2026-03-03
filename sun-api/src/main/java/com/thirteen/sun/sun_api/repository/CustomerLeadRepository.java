package com.thirteen.sun.sun_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thirteen.sun.sun_api.models.CustomerLead;
import com.thirteen.sun.sun_api.models.CustomerLeadId;

public interface CustomerLeadRepository extends JpaRepository<CustomerLead, CustomerLeadId> {
}
