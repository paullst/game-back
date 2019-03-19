package fr.paul.game.repository;

import fr.paul.game.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Game Repository
 */
public interface GameRepository extends CrudRepository<GameEntity, Integer> {

}
