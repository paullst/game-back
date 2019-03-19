package fr.paul.game.mapper;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.entity.StateEntity;
import fr.paul.game.model.Game;
import fr.paul.game.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game mapper Test
 */
public class GameMapperTest {

    @Mock
    private StateMapper stateMapper;

    @InjectMocks
    private GameMapper gameMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Map to model Test
     */
    @Test
    public void mapToModel() {

        GameEntity entity = mockEntity();

        Mockito.when(stateMapper.mapToModel(Mockito.any(StateEntity.class))).thenReturn(new State());

        Game model = gameMapper.mapToModel(entity);


        // Check model and entity conformity
        Assert.assertEquals(model.getId(), entity.getId());
        Assert.assertEquals(model.getPlayer1(), entity.getPlayer1());
        Assert.assertEquals(model.getPlayer2(), entity.getPlayer2());
        Assert.assertEquals(model.getWinner(), entity.getWinner());

        //TODO states

    }

    /**
     * Map from model Test
     */
    @Test
    public void mapFromModel() {

        Game model = mockModel();

        Mockito.when(stateMapper.mapFromModel(Mockito.any(State.class))).thenReturn(new StateEntity());

        GameEntity entity = gameMapper.mapFromModel(model);

        // Check model and entity conformity
        Assert.assertEquals(model.getId(), entity.getId());
        Assert.assertEquals(model.getPlayer1(), entity.getPlayer1());
        Assert.assertEquals(model.getPlayer2(), entity.getPlayer2());
        Assert.assertEquals(model.getWinner(), entity.getWinner());

        //TODO states

    }

    private Game mockModel() {
        Game model = new Game();
        model.setId(1);
        model.setPlayer1("Player A");
        model.setPlayer2("Player B");
        model.setWinner("Player A");

        return model;
    }

    private GameEntity mockEntity() {
        GameEntity entity = new GameEntity();
        entity.setId(1);
        entity.setPlayer1("Player A");
        entity.setPlayer2("Player B");
        entity.setWinner("Player A");

        return entity;
    }
}