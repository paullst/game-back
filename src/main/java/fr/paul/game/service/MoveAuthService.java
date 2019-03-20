package fr.paul.game.service;

import fr.paul.game.model.Game;
import fr.paul.game.model.Move;

/**
 * Move Authorization Service Interface
 */
public interface MoveAuthService {

    /**
     * Authorize or deny move request
     * @param move
     * @param game
     * @return boolean
     */
    Boolean moveIsLegal(Move move, Game game);
}
