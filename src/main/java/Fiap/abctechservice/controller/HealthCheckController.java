package Fiap.abctechservice.controller;

import Fiap.abctechservice.application.PropertiesComponent;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HealthCheckController {

    private PropertiesComponent propertiesComponent;
    public HealthCheckController(@Autowired PropertiesComponent propertiesComponent){
        this.propertiesComponent = propertiesComponent;
    }
    @GetMapping()
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Sucesso!");
    }
    @GetMapping("version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok(this.propertiesComponent.getName() + " - " + this.propertiesComponent.getVersion());
    }
}
