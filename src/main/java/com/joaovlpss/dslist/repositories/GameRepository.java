/**
 * A repository is a Spring component that provides an interface between the application and the data source. 
 * In this case, GameRepository is a repository for Game entity, extending JpaRepository interface.
 */
package com.joaovlpss.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joaovlpss.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
