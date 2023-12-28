package com.loja.loja.dtos;

import java.util.List;

public record JogosResponse(Long id,String title, String link, String description, List<String> tags) {
    
}
