package fr.paul.game.service.impl;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.mapper.GameMapper;
import fr.paul.game.model.Game;
import fr.paul.game.model.State;
import fr.paul.game.repository.GameRepository;
import fr.paul.game.service.GameService;
import fr.paul.game.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Game Service Implementation
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private StateService stateService;


    @Override
    public Game createNewGame(String player1, String player2) {
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);


        // Set initial state
        State state = stateService.makeInitialState(player1, player2);
        List<State> stateList = new ArrayList<>();
        stateList.add(state);

        game.setStates(stateList);

        return saveGame(game);
    }

    @Override
    public Game getGameById(Integer id) {

        Optional<GameEntity> entity = gameRepository.findById(id);

        if (entity.isPresent()) {
            return gameMapper.mapToModel(entity.get());
        } else {
            return null;
        }

    }

    /**
     * Persist game
     * @param game
     * @return game
     */
    private Game saveGame(Game game) {

        GameEntity entity = gameMapper.mapFromModel(game);
        GameEntity savedEntity = gameRepository.save(entity);

        return gameMapper.mapToModel(savedEntity);
    }

}
