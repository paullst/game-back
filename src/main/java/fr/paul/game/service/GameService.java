package fr.paul.game.service;

import fr.paul.game.model.Game;

/**
 * Game Service Interface
 */
public interface GameService {

    /**
     * Create new game
     * @return new game
     */
    Game createNewGame(String player1, String player2);

}
