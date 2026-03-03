package com.thirteen.sun.sun_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.thirteen.sun.sun_api.models.Lead;
import com.thirteen.sun.sun_api.repository.LeadRepository;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public List<Lead> findAll() {
        return leadRepository.findAll();
    }

    public Lead findById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead não encontrado"));
    }

    public void delete(Long id) {
        leadRepository.deleteById(id);
    }
}
