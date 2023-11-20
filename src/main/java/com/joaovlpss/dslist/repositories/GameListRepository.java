/**
 * A repository is a Spring component that provides an interface between the application and the data source. 
 * In this case, GameRepository is a repository for Game entity, extending JpaRepository interface.
 */
package com.joaovlpss.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.joaovlpss.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
