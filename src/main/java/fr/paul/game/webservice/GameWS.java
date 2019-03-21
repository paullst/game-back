package fr.paul.game.webservice;

import fr.paul.game.model.State;
import fr.paul.game.repository.GameRepository;
import fr.paul.game.service.GameService;
import fr.paul.game.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

/**
 * Game Webservice
 */
@RestController
public class GameWS {

    @Autowired
    private GameRepository repo;

    @Autowired
    private StateService stateService;

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public ResponseEntity<String> index() {

        return new ResponseEntity<String>("Game API", HttpStatus.OK);
    }

    /**
     * Create new game
     * @param p1
     * @param p2
     * @return new game id
     */
    @GetMapping("/new")
    public ResponseEntity<?> createGame(@RequestParam("player1") String p1, @RequestParam("player2") String p2) {

        if (Stream.of(p1, p2).anyMatch(StringUtils::isEmpty) || p1.equals(p2)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Integer>(gameService.createNewGame(p1, p2).getId(), HttpStatus.OK);

    }


    /**
     * Get last state of game
     * @param id the game id
     * @return state
     */
    @GetMapping("/game/{id}")
    public ResponseEntity<State> getLastState(@PathVariable("id") String id) {

        List<State> states = gameService
                .getGameById(Integer.parseInt(id))
                .getStates();

        return new ResponseEntity<State>(states.get(states.size()-1), HttpStatus.OK);

    }

}