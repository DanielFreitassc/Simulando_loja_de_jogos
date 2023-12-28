package com.loja.loja.dtos;

import java.util.List;

import com.loja.loja.models.Jogos;

public record JogosDto(String title, String link, String description , List<String> tags){
    public Jogos toModel(){
        return new Jogos(null, title,link,description,tags);
    }
}
