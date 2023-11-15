/**
 * Service class for handling game-related operations.
 * In Spring, a Service is a class that contains business logic and acts as an intermediary between a Controller and a Repository.
 */
package com.joaovlpss.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaovlpss.dslist.repositories.GameRepository;
import com.joaovlpss.dslist.dto.GameDTO;
import com.joaovlpss.dslist.dto.GameMinDTO;
import com.joaovlpss.dslist.entities.Game;
import com.joaovlpss.dslist.projections.GameMinProjection;

@Service
public class GameService {
    
    /**
     * This annotation allows Spring to automatically inject an instance of GameRepository into this class.
     */
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
    List<Game> result = gameRepository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
    }

    
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> optionalGame = gameRepository.findById(id);            
        if (optionalGame.isPresent()) {
            Game entity = optionalGame.get();
            return new GameDTO(entity);
        }
            return null;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
    List<GameMinProjection> result = gameRepository.searchByList(listId);
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
    }
}
