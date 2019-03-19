package fr.paul.game.mapper;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.entity.StateEntity;
import fr.paul.game.model.Game;
import fr.paul.game.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Game Mapper
 */
@Component
public class GameMapper extends AbstractMapper<GameEntity, Game>{

    @Autowired
    private StateMapper stateMapper;

    @Override
    public Game mapToModel(GameEntity entity) {

        if (Objects.nonNull(entity)) {
            Game model = new Game();
            model.setId(entity.getId());
            model.setPlayer1(entity.getPlayer1());
            model.setPlayer2(entity.getPlayer2());
            model.setWinner(entity.getWinner());

            // Remove game from states to avoid recursive issues
            List<StateEntity> stateEntities = entity.getStates();
            if (!CollectionUtils.isEmpty(stateEntities)) {
                stateEntities.stream()
                        .forEach(s -> s.setGame(null));
            }

            return model;
        }

        return null;
    }

    @Override
    public GameEntity mapFromModel(Game model) {

        if (Objects.nonNull(model)) {
            GameEntity entity = new GameEntity();
            entity.setId(model.getId());
            entity.setPlayer1(model.getPlayer1());
            entity.setPlayer2(model.getPlayer2());
            entity.setWinner(model.getWinner());

            // Remove game from states to avoid recursive issues
            List<State> stateModels = model.getStates();
            if (!CollectionUtils.isEmpty(stateModels)) {
                stateModels.stream()
                        .forEach(s -> s.setGame(null));
            }

            return entity;
        }

        return null;
    }
}
