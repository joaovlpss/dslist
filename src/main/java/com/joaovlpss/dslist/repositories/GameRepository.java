/**
 * A repository is a Spring component that provides an interface between the application and the data source. 
 * In this case, GameRepository is a repository for Game entity, extending JpaRepository interface.
 */
package com.joaovlpss.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.joaovlpss.dslist.projections.GameMinProjection;

import com.joaovlpss.dslist.entities.Game;

    public interface GameRepository extends JpaRepository<Game, Long> {

        @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
                """)
    List<GameMinProjection> searchByList(Long listId);
}
