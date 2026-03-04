package com.thirteen.sun.sun_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirteen.sun.sun_api.models.Customer;
import com.thirteen.sun.sun_api.models.CustomerLead;
import com.thirteen.sun.sun_api.models.CustomerLeadId;
import com.thirteen.sun.sun_api.models.Lead;
import com.thirteen.sun.sun_api.repository.CustomerLeadRepository;
import com.thirteen.sun.sun_api.repository.CustomerRepository;
import com.thirteen.sun.sun_api.repository.LeadRepository;

import java.time.LocalDateTime;

@Service
public class CustomerLeadService {

    private final CustomerRepository customerRepository;
    private final LeadRepository leadRepository;
    private final CustomerLeadRepository customerLeadRepository;

    public CustomerLeadService(CustomerRepository customerRepository,
                               LeadRepository leadRepository,
                               CustomerLeadRepository customerLeadRepository) {
        this.customerRepository = customerRepository;
        this.leadRepository = leadRepository;
        this.customerLeadRepository = customerLeadRepository;
    }

    @Transactional
    public CustomerLead vincularLeadAoCustomer(Long customerId, Long leadId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer não encontrado"));

        Lead lead = leadRepository.findById(leadId)
                .orElseThrow(() -> new RuntimeException("Lead não encontrado"));

        CustomerLeadId id = new CustomerLeadId(customerId, leadId);

        if (customerLeadRepository.existsById(id)) {
            throw new RuntimeException("Esse lead já foi enviado para esse customer");
        }

        CustomerLead customerLead = new CustomerLead();
        customerLead.setId(id);
        customerLead.setCustomer(customer);
        customerLead.setLead(lead);
        customerLead.setDataEnvio(LocalDateTime.now());

        return customerLeadRepository.save(customerLead);
    }

    public void removerVinculo(Long customerId, Long leadId) {

        CustomerLeadId id = new CustomerLeadId(customerId, leadId);

        if (!customerLeadRepository.existsById(id)) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        customerLeadRepository.deleteById(id);
    }
}
