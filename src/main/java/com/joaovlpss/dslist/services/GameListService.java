package com.joaovlpss.dslist.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.joaovlpss.dslist.dto.GameListDTO;
import com.joaovlpss.dslist.entities.GameList;
import com.joaovlpss.dslist.repositories.GameListRepository;


@Service
public class GameListService {
    
    /**
     * This annotation allows Spring to automatically inject an instance of GameRepository into this class.
     */
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        // Spring automatically does the queries and returns the results
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }


}