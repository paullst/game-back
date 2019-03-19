package fr.paul.game.mapper;

import fr.paul.game.entity.GameEntity;
import fr.paul.game.entity.StateEntity;
import fr.paul.game.model.Game;
import fr.paul.game.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * The type State mapper Test
 */
public class StateMapperTest {

    @Mock
    private GameMapper gameMapper;

    @InjectMocks
    private StateMapper stateMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Map to model Test
     */
    @Test
    public void mapToModel() {

        StateEntity entity = mockEntity();

        Mockito.when(gameMapper.mapToModel(Mockito.any(GameEntity.class))).thenReturn(new Game());

        State model = stateMapper.mapToModel(entity);

        Assert.assertEquals(entity.getId(), model.getId());
        Assert.assertEquals(entity.getMoveNo(), model.getMoveNo());
        Assert.assertEquals(entity.getNextPlayer(), model.getNextPlayer());

        //TODO : game, map

    }

    /**
     * Map from model Test
     */
    @Test
    public void mapFromModel() {

        State model = mockModel();

        Mockito.when(gameMapper.mapFromModel(Mockito.any(Game.class))).thenReturn(new GameEntity());

        StateEntity entity = stateMapper.mapFromModel(model);

        Assert.assertEquals(entity.getId(), model.getId());
        Assert.assertEquals(entity.getMoveNo(), model.getMoveNo());
        Assert.assertEquals(entity.getNextPlayer(), model.getNextPlayer());

        //TODO : game, map
    }

    private State mockModel() {

        State model = new State();
        model.setId(1);
        model.setMoveNo(0);
        model.setNextPlayer("Player C");

        return model;

    }

    private StateEntity mockEntity() {

        StateEntity entity = new StateEntity();
        entity.setId(1);
        entity.setMoveNo(0);
        entity.setNextPlayer("Player C");

        return entity;
    }

}