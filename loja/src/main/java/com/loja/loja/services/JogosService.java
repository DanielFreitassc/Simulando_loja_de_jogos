package com.loja.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.loja.dtos.JogosResponse;
import com.loja.loja.models.Jogos;
import com.loja.loja.repositories.JogosRepository;

@Service
public class JogosService {
    @Autowired
    private JogosRepository jogosRepository;
    
    public List<Jogos> getAllJogos(){
       List<Jogos> jogosList =  jogosRepository.findAll();
       return jogosList;
    }
    public List<Jogos> findJogosByTag(List<String >tags){
        List<Jogos> jogosList = jogosRepository.findByTagsIn(tags);
        return jogosList;
    }
    public  JogosResponse saveJogos(Jogos jogos){
        Jogos jogosSaved = jogosRepository.save(jogos);
        JogosResponse jogosResponse = new JogosResponse(jogosSaved.getId(), jogosSaved.getTitle(), jogosSaved.getLink(), jogosSaved.getDescription(), jogosSaved.getTags());

        return jogosResponse;
    }
    public void deleteJogosById(Long id){
        jogosRepository.deleteById(id);
    }

}
