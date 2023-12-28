package com.loja.loja.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jogos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    private String title;
    private String link;
    private String description;
    private List<String> tags;
    
}
