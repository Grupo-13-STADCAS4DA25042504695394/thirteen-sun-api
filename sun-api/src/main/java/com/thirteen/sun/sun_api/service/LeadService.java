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

    public List<Lead> findByPerfilDeConsumo(Integer perfil) {
        return leadRepository.findByPerfilDeConsumo(perfil);
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

    public Lead update(Long id, Lead updatedLead) {

        Lead existing = leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead não encontrado"));

        existing.setNome(updatedLead.getNome());
        existing.setPerfilDeConsumo(updatedLead.getPerfilDeConsumo());
        existing.setCep(updatedLead.getCep());
        existing.setEmail(updatedLead.getEmail());
        existing.setTelefone(updatedLead.getTelefone());

        return leadRepository.save(existing);
    }
}
