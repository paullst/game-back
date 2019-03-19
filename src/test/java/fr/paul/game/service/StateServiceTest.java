package fr.paul.game.service;

import fr.paul.game.model.Country;
import fr.paul.game.model.State;
import fr.paul.game.service.impl.StateServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type State service test.
 */
public class StateServiceTest {

    @InjectMocks
    private StateServiceImpl stateService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void makeInitialStateTest() {

        String player1 = "Player A";
        String player2 = "Player B";

        State state = stateService.makeInitialState(player1, player2);

        Map<String, Country> map = state.getMap();
        List<Country> countries = map.values().stream().collect(Collectors.toList());

        // Next player is set
        Assert.assertTrue(state.getNextPlayer() == player1 || state.getNextPlayer() == player2);

        // Move no is 0
        Assert.assertTrue(state.getMoveNo() == 0);

        // Check each player has only 1 initial country
        Assert.assertTrue(playerHasOneInitialCountry(countries, player1));
        Assert.assertTrue(playerHasOneInitialCountry(countries, player2));

    }

    /**
     * Test if player has 1 initial country
     * @param countries
     * @param player
     * @return boolean
     */
    private Boolean playerHasOneInitialCountry(List<Country> countries, String player) {
        return countries.stream()
                .filter(c -> Objects.nonNull(c.getOwner()) && c.getOwner().equals(player))
                .collect(Collectors.toList())
                .size() == 1;
    }
}