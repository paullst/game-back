package fr.paul.game.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.paul.game.entity.GameEntity;
import fr.paul.game.entity.StateEntity;
import fr.paul.game.model.Country;
import fr.paul.game.model.Game;
import fr.paul.game.model.State;
import org.apache.tomcat.util.digester.ArrayStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * State Mapper
 */
@Component
public class StateMapper extends AbstractMapper<StateEntity, State> {

    Logger logger = LoggerFactory.getLogger(StateMapper.class);

    @Autowired
    GameMapper gameMapper;

    @Override
    public State mapToModel(StateEntity entity) {
        if (Objects.nonNull(entity)) {
            State model = new State();
            model.setId(entity.getId());
            model.setNextPlayer(entity.getNextPlayer());
            model.setMoveNo(entity.getMoveNo());

            // Remove state entities from game entity to avoid recursive issues
            GameEntity gameEntity = entity.getGame();
            if (Objects.nonNull(gameEntity)) {
                gameEntity.setStates(new ArrayList<>());
                model.setGame(gameMapper.mapToModel(gameEntity));
            }

            // Country map
            if (Objects.nonNull(entity.getMap())) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    TypeReference<HashMap<String, Country>> typeRef = new TypeReference<HashMap<String, Country>>() {};
                    model.setMap(mapper.readValue(entity.getMap(), typeRef));
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }

            return model;

        }

        return null;
    }

    @Override
    public StateEntity mapFromModel(State model) {

        if (Objects.nonNull(model)) {
            StateEntity entity = new StateEntity();
            entity.setId(model.getId());
            entity.setNextPlayer(model.getNextPlayer());
            entity.setMoveNo(model.getMoveNo());

            // Remove states from game to avoid recursive issues
            Game gameModel = model.getGame();
            if(Objects.nonNull(gameModel)) {
                gameModel.setStates(new ArrayList<>());
                entity.setGame(gameMapper.mapFromModel(gameModel));
            }

            // Country map
            if (Objects.nonNull(model.getGame())) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    entity.setMap(mapper.writeValueAsString(model.getMap()));

                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }

            return entity;
        }

        return null;
    }
}
