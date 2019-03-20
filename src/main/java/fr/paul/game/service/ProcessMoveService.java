package fr.paul.game.service;

import fr.paul.game.model.Game;
import fr.paul.game.model.Move;
import fr.paul.game.model.State;

/**
 * Process Move Service Interface
 */
public interface ProcessMoveService {

    /**
     * Process move
     * @param game
     * @param move
     * @return updated state
     */
    State processMove(Game game, Move move);
}
