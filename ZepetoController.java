package com.planner.godsaeng.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planner.godsaeng.entity.Zepeto;
import com.planner.godsaeng.service.ZepetoService;

@RestController
@RequestMapping("/api")
public class ZepetoController {

    @Autowired
    ZepetoService zepetoService;

    @PostMapping("/zepeto")
    public ResponseEntity<String> receiveZepetoData(@RequestBody Map<String, Object> data) {
        String name = (String) data.get("name");
        String challenge = (String) data.get("challenge");
        
        // Create a new Zepeto object with the received data
        Zepeto zepeto = new Zepeto();
        zepeto.setName(name);
        zepeto.setChallenge(challenge);
        
        // Save the Zepeto to the database
        zepetoService.saveZepeto(zepeto);

        return ResponseEntity.ok("Received Zepeto data and saved to database");
    }
}