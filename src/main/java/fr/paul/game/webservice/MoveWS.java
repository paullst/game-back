package fr.paul.game.webservice;

import fr.paul.game.model.Game;
import fr.paul.game.model.Move;
import fr.paul.game.model.State;
import fr.paul.game.service.GameService;
import fr.paul.game.service.MoveAuthService;
import fr.paul.game.service.ProcessMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Move Webservice
 */
@RestController
public class MoveWS {

    @Autowired
    private MoveAuthService moveAuth;

    @Autowired
    private GameService gameService;

    @Autowired
    private ProcessMoveService processMoveService;


    /**
     * Make move webservice
     * @param id
     * @param move
     * @return updated state
     */
    @PostMapping("/game/{id}/move")
    public ResponseEntity<State> makeMove(@PathVariable("id") String id, @RequestBody Move move) {

        Game game = gameService.getGameById(Integer.parseInt(id));

        System.out.println(move);

        if (Objects.isNull(game) || !moveAuth.moveIsLegal(move, game)) {

            // TODO handle bad request
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {

            return new ResponseEntity<State>(processMoveService.processMove(game, move), HttpStatus.OK);
        }


    }

}