package fr.paul.game.service;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.mapper.GameMapper;
import fr.paul.game.model.Game;
import fr.paul.game.model.State;
import fr.paul.game.repository.GameRepository;
import fr.paul.game.service.impl.GameServiceImpl;
import fr.paul.game.service.impl.StateServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * The Game service test.
 */
public class GameServiceTest {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private GameMapper gameMapper;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createNewGame() {

        String player1 = "Player A";
        String player2 = "Player B";

        Game mockGame = makeMockGame(player1, player2);

        Mockito.when(gameMapper.mapToModel(null)).thenReturn(mockGame);

        Game game = gameService.createNewGame(player1, player2);

        // Players are set
        Assert.assertEquals(game.getPlayer1(), player1);
        Assert.assertEquals(game.getPlayer2(), player2);

        // ID is ok
        Assert.assertEquals(game.getId(), mockGame.getId());

        // Winner is null
        Assert.assertEquals(game.getWinner(), null);

        // TODO : states

    }

    @Test
    public void getGameById() {
        // TODO
    }

    private Game makeMockGame(String player1, String player2) {

        Game game = new Game();
        game.setId(1);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setWinner(null);

        return game;

    }


}