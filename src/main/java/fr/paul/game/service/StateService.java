package fr.paul.game.service;

import fr.paul.game.model.State;

/**
 * State service
 */
public interface StateService {

    /**
     * Make initial state for game init
     * @param player1
     * @param player2
     * @return first state
     */
    State makeInitialState(String player1, String player2);

    /**
     * Save state
     * @param state
     * @return
     */
    State saveState(State state);
}
