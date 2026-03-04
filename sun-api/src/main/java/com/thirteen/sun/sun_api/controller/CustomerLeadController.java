package com.thirteen.sun.sun_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thirteen.sun.sun_api.service.CustomerLeadService;

@RestController
@RequestMapping("/customer-leads")
public class CustomerLeadController {

    private final CustomerLeadService customerLeadService;

    public CustomerLeadController(CustomerLeadService customerLeadService) {
        this.customerLeadService = customerLeadService;
    }

    @PostMapping("/vincular")
    public ResponseEntity<String> vincular(
            @RequestParam Long customerId,
            @RequestParam Long leadId) {

        customerLeadService.vincularLeadAoCustomer(customerId, leadId);

        return ResponseEntity.ok("Vinculado com sucesso");
    }

    @DeleteMapping
    public ResponseEntity<Void> removerRelacionamento(
            @RequestParam Long customerId,
            @RequestParam Long leadId) {

        customerLeadService.removerVinculo(customerId, leadId);
        return ResponseEntity.noContent().build();
    }

}
