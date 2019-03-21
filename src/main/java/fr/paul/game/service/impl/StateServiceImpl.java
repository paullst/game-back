package fr.paul.game.service.impl;

import fr.paul.game.constant.CountryRef;
import fr.paul.game.mapper.StateMapper;
import fr.paul.game.model.Country;
import fr.paul.game.model.State;
import fr.paul.game.repository.StateRepository;
import fr.paul.game.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * State Service Implementation
 */
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateMapper stateMapper;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State makeInitialState(String player1, String player2) {

        State state = new State();
        state.setMoveNo(0);
        state.setMap(makeInitialCountryMap(player1, player2));

        // Set starting player
        state.setNextPlayer(Math.random() > 0.5 ? player1 : player2);

        return state;
    }

    @Override
    public State saveState(State state) {
        return stateMapper.mapToModel(stateRepository.save(stateMapper.mapFromModel(state)));
    }


    /**
     * Build initial map
     * @param player1
     * @param player2
     * @return map
     */
    private Map<String, Country> makeInitialCountryMap(String player1, String player2) {

        // Init country map
        Map<String, Country> map = Arrays.asList(CountryRef.values())
                .stream()
                .collect(Collectors.toMap(CountryRef::getId, this::makeInitialCountry));

                /* .forEach(ref -> {
                    map.put(ref.getId(), makeInitialCountry(ref));
                }); */

        // Set origin countries for player
        String isoPlayer1 = getRandomCountry(map);
        String isoPlayer2 = null;

        while (Objects.isNull(isoPlayer2)
                        || isoPlayer1.equals(isoPlayer2)) {
            isoPlayer2 = getRandomCountry(map);
        }

        // TODO: check player1 et player2 are NOT adjacent

        map.get(isoPlayer1).setOwner(player1);
        map.get(isoPlayer2).setOwner(player2);

        return map;

    }

    /**
     * Make Country object from CountryRef
     * @param ref
     * @return country
     */
    private Country makeInitialCountry(CountryRef ref) {

        Country country = new Country();
        country.setId(ref.getId());
        country.setLabel(ref.getLabel());
        country.setPop((ref.getNeighbors().length >= 4 ? ref.getNeighbors().length : 4) * 10);

        return country;

    }

    /**
     * Get rand country ISO code
     * @param map
     * @return country ISO
     */
    private String getRandomCountry(Map<String, Country> map) {

        Random random = new Random();
        List<String> keys = new ArrayList<String>(map.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));

        return randomKey;
    }
}
