package fr.paul.game.mapper;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            Game model = mapToModelNoDependency(entity);
            model.setStates(stateMapper.mapToModelsNoDependency(entity.getStates()));

            return model;
        }

        return null;
    }

    @Override
    public GameEntity mapFromModel(Game model) {

        if (Objects.nonNull(model)) {
            GameEntity entity = mapFromModelNoDependency(model);
            entity.setStates(stateMapper.mapFromModelsNoDependency(model.getStates()));

            return entity;
        }

        return null;
    }

    @Override
    public Game mapToModelNoDependency(GameEntity entity) {

        if (Objects.nonNull(entity)) {
            Game model = new Game();
            model.setId(entity.getId());
            model.setPlayer1(entity.getPlayer1());
            model.setPlayer2(entity.getPlayer2());
            model.setWinner(entity.getWinner());

            return model;
        }

        return null;
    }

    @Override
    public GameEntity mapFromModelNoDependency(Game model) {

        if (Objects.nonNull(model)) {
            GameEntity entity = new GameEntity();
            entity.setId(model.getId());
            entity.setPlayer1(model.getPlayer1());
            entity.setPlayer2(model.getPlayer2());
            entity.setWinner(model.getWinner());

            return entity;
        }

        return null;
    }
}
