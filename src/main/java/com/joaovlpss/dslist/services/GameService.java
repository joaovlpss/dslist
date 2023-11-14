/**
 * Service class for handling game-related operations.
 * In Spring, a Service is a class that contains business logic and acts as an intermediary between a Controller and a Repository.
 */
package com.joaovlpss.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovlpss.dslist.repositories.GameRepository;
import com.joaovlpss.dslist.dto.GameMinDTO;
import com.joaovlpss.dslist.entities.Game;

@Service
public class GameService {
    
    /**
     * This annotation allows Spring to automatically inject an instance of GameRepository into this class.
     */
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
    // Spring automatically does the queries and returns the results
    List<Game> result = gameRepository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
    }
}