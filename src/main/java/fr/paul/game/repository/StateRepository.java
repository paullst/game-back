package fr.paul.game.repository;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.entity.StateEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * State Repository
 */
public interface StateRepository extends CrudRepository<StateEntity, Integer> {

}
