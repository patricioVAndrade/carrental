package com.bda.carrental.controllers;

import com.bda.carrental.entidades.ClientCompany;
import com.bda.carrental.entidades.dto.ClientCompanyDto;
import com.bda.carrental.services.ClientCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/company") // http://localhost:8080/api/client/company
public class ClientCompanyController {

    private ClientCompanyService clientCompanyService;

    public ClientCompanyController(ClientCompanyService clientCompanyService) {
        this.clientCompanyService = clientCompanyService;
    }

    @GetMapping
    public ResponseEntity<List<ClientCompanyDto>> getAll() {
        List<ClientCompanyDto> values = this.clientCompanyService.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping
    public ResponseEntity<ClientCompanyDto> add(@RequestBody ClientCompanyDto clientCompany) {
        ClientCompanyDto company =  this.clientCompanyService.add(clientCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        ClientCompanyDto company = clientCompanyService.getById(id);
        if (company != null) {
            clientCompanyService.delete(id);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientCompanyDto> getById(@PathVariable Long id) {
        ClientCompanyDto company = clientCompanyService.getById(id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
