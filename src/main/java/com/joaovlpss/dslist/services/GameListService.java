package com.joaovlpss.dslist.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.joaovlpss.dslist.dto.GameListDTO;
import com.joaovlpss.dslist.entities.GameList;
import com.joaovlpss.dslist.projections.GameMinProjection;
import com.joaovlpss.dslist.repositories.GameListRepository;
import com.joaovlpss.dslist.repositories.GameRepository;


@Service
public class GameListService {
    
    /**
     * This annotation allows Spring to automatically inject an instance of GameRepository into this class.
     */
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        // Spring automatically does the queries and returns the results
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {

		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}