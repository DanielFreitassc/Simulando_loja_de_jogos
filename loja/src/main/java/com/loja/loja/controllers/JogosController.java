package com.loja.loja.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.loja.loja.dtos.JogosDto;
import com.loja.loja.dtos.JogosResponse;
import com.loja.loja.models.Jogos;
import com.loja.loja.services.JogosService;

@RestController
@RequestMapping("/jogos")
public class JogosController {
    @Autowired
    private JogosService jogosService;
    
    @GetMapping
    public ResponseEntity findAll(){
        List<Jogos> allJogos = jogosService.getAllJogos();
        return ResponseEntity.ok().body(allJogos);

    }
    
    @GetMapping("/findByTag")
    public ResponseEntity findJogosByTag(@RequestParam List<String> tags){
        List<Jogos> jogosList =jogosService.findJogosByTag(tags);
        return ResponseEntity.ok().body(jogosList);
    }

    @PostMapping
    public ResponseEntity saveJogos(@RequestBody JogosDto jogosDto){
    Jogos jogosToBeSaved = jogosDto.toModel();
    JogosResponse jogosResponse = jogosService.saveJogos(jogosToBeSaved);
    
    URI headerLocation = ServletUriComponentsBuilder   // Corrigido o nome da classe
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(jogosResponse.id())
            .toUri();
    return ResponseEntity.created(headerLocation).body(jogosResponse);
    }

    @DeleteMapping
    public ResponseEntity deleteJogos(@RequestParam Long id){
        jogosService.deleteJogosById(id);
        return ResponseEntity.ok().body("Jogos deletados");
    }

}
