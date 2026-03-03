package com.thirteen.sun.sun_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thirteen.sun.sun_api.models.CustomerLead;
import com.thirteen.sun.sun_api.service.CustomerLeadService;

@RestController
@RequestMapping("/customer-leads")
public class CustomerLeadController {

    private final CustomerLeadService customerLeadService;

    public CustomerLeadController(CustomerLeadService customerLeadService) {
        this.customerLeadService = customerLeadService;
    }

    @PostMapping("/vincular")
    public ResponseEntity<CustomerLead> vincular(
            @RequestParam Long customerId,
            @RequestParam Long leadId) {

        CustomerLead customerLead =
                customerLeadService.vincularLeadAoCustomer(customerId, leadId);

        return ResponseEntity.ok(customerLead);
    }
}
