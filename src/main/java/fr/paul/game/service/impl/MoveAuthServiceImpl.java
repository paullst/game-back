package fr.paul.game.service.impl;

import fr.paul.game.constant.CountryRef;
import fr.paul.game.model.Country;
import fr.paul.game.model.Game;
import fr.paul.game.model.Move;
import fr.paul.game.model.State;
import fr.paul.game.service.MoveAuthService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class MoveAuthServiceImpl implements MoveAuthService {

    @Override
    public Boolean moveIsLegal(Move move, Game game) {

        State lastState = game.getStates().get(game.getStates().size() - 1);

        return countriesExists(move)
                && StringUtils.isEmpty(game.getWinner())
                && playerIsAuthorized(lastState, move)
                && moveMakesSense(move, lastState)
                && canMovePop(isAggressive(move, lastState), move, lastState);
    }

    /**
     * Check if both origin and destination countries exist
     * @param move
     * @return boolean
     */
    private Boolean countriesExists(Move move) {

        CountryRef fromRef = CountryRef.valueOf(move.getFrom().toUpperCase());
        CountryRef toRef = CountryRef.valueOf(move.getTo().toUpperCase());

        if (Stream.of(fromRef, toRef).anyMatch(Objects::isNull)) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Check if player can perform move
     * @param lastState
     * @param move
     * @return boolean
     */
    private Boolean playerIsAuthorized(State lastState, Move move) {

        // Check if it's player's turn
        Boolean isPlayersTurn = lastState.getNextPlayer().equals(move.getPlayer());

        // Check if player own origin country
        String lastOwner = lastState.getMap().get(move.getFrom()).getOwner();
        Boolean ownOriginCountry = Objects.nonNull(lastOwner) && lastOwner.equals(move.getPlayer());

        return isPlayersTurn && ownOriginCountry;

    }

    /**
     * Check if countries are different, adjacent, origin country has enough pop
     * @param move
     * @param lastState
     * @return boolean
     */
    private Boolean moveMakesSense(Move move, State lastState) {

        // Check if countries are different
        Boolean countriesAreDifferent = !move.getFrom().equals(move.getTo());

        // Check if origin and destination countries are adjacent
        CountryRef refFrom = CountryRef.valueOf(move.getFrom().toUpperCase());
        Boolean countriesAreAdjacent = Arrays.asList(refFrom.getNeighbors()).contains(move.getTo());

        // Check if last country has enough pop
        Boolean originCountryHasEnoughPop = lastState.getMap().get(move.getFrom()).getPop() >= move.getPop();

        return countriesAreDifferent && countriesAreAdjacent && originCountryHasEnoughPop;

    }

    /**
     * Check if move is aggressive
     * @param move
     * @param lastState
     * @return boolean
     */
    private Boolean isAggressive(Move move, State lastState) {

        Country from = lastState.getMap().get(move.getFrom());
        Country to = lastState.getMap().get(move.getTo());

        // Check if destination country has no or different owner
        return Objects.isNull(to.getOwner()) || !from.getOwner().equals(to.getOwner()) ? true : false;

    }

    /**
     * Check if player can move pop to another country
     * @param isAggressive
     * @param move
     * @param lastState
     * @return boolean
     */
    private Boolean canMovePop(Boolean isAggressive, Move move, State lastState) {

        Country to = lastState.getMap().get(move.getTo());

        return isAggressive ? move.getPop() >= to.getPop() : true;

    }

}
