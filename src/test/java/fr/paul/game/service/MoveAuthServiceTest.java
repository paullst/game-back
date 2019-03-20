package fr.paul.game.service;

import fr.paul.game.mapper.GameMapper;
import fr.paul.game.model.Game;
import fr.paul.game.service.impl.GameServiceImpl;
import fr.paul.game.service.impl.MoveAuthServiceImpl;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Move Authorization Service Test
 */
public class MoveAuthServiceTest {

    @InjectMocks
    private MoveAuthServiceImpl moveAuthService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    //TODO

}