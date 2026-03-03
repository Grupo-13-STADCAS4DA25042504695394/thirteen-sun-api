package com.thirteen.sun.sun_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thirteen.sun.sun_api.models.Lead;
import com.thirteen.sun.sun_api.service.LeadService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public ResponseEntity<Lead> create(@RequestBody Lead lead) {
        Lead savedLead = leadService.createLead(lead);
        return ResponseEntity
                .created(URI.create("/leads/" + savedLead.getId()))
                .body(savedLead);
    }

    @GetMapping
    public ResponseEntity<List<Lead>> findAll() {
        return ResponseEntity.ok(leadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> findById(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        leadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
