package fr.paul.game.service.impl;

import fr.paul.game.model.Country;
import fr.paul.game.model.Game;
import fr.paul.game.model.Move;
import fr.paul.game.model.State;
import fr.paul.game.service.GameService;
import fr.paul.game.service.ProcessMoveService;
import fr.paul.game.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProcessMoveServiceImpl implements ProcessMoveService {

    @Autowired
    private GameService gameService;

    @Autowired
    private StateService stateService;

    @Override
    public State processMove(Game game, Move move){

        // Get last state
        State lastState = game.getStates().get(game.getStates().size() - 1);

        // Make next state
        State nextState = makeNextState(move, lastState);

        // Set next turn player
        String nextPlayer = game.getPlayer1().equals(lastState.getNextPlayer()) ? game.getPlayer2() : game.getPlayer1();
        nextState.setNextPlayer(nextPlayer);

        // Set move no
        nextState.setMoveNo(lastState.getMoveNo() + 1);

        // Set game
        nextState.setGame(game);

        // End game if apply
        gameIsOver(nextState);

        // Save updated game
        return stateService.saveState(nextState);

    }


    /**
     * Make next state
     * @param move
     * @param lastState
     * @return next state
     */
    private State makeNextState(Move move, State lastState) {

        Country from = lastState.getMap().get(move.getFrom());
        Country to = lastState.getMap().get(move.getTo());

        // Set player as owner of destination country;
        to.setOwner(move.getPlayer());

        // Set new population
        from.setPop(from.getPop() - move.getPop());
        to.setPop(to.getPop() + move.getPop());

        // Make updated map
        Map<String, Country> newMap = lastState.getMap();
        newMap.put(move.getTo(), to);
        newMap.put(move.getFrom(), from);

        // Make new state
        State nextState = new State();
        nextState.setMap(newMap);

        return nextState;

    }

    /**
     * Set winner to player username if we wins
     * @param state
     */
    private void gameIsOver(State state) {

        List<Country> countries = state.getMap().values().stream().collect(Collectors.toList());

        // Check if next player has lost (0 pop left)
        Integer nextPlayerTotalPop = countries.stream()
                .filter(c -> !StringUtils.isEmpty(c.getOwner()) && c.getOwner().equals(state.getNextPlayer()))
                .map(c -> c.getPop())
                .reduce(0, (a, v) -> a + v);

        // Set winner game is over
        if (Objects.isNull(nextPlayerTotalPop) || nextPlayerTotalPop == 0) {
            Game game = state.getGame();
            String winner = game.getPlayer1().equals(state.getNextPlayer()) ? game.getPlayer2() : game.getPlayer1();
            game.setWinner(winner);
            state.setGame(game);
        }

        // TODO : nextPlayer is blocked (adjacent countries cannot be invaded)

    }
}
