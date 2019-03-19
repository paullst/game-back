package fr.paul.game.model;

import java.util.Map;

/**
 * State Model
 */
public class State {

    private Integer id;
    private Integer moveNo;
    private Map<String, Country> map;
    private String nextPlayer;
    private Game game;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets move no.
     *
     * @return the move no
     */
    public Integer getMoveNo() {
        return moveNo;
    }

    /**
     * Sets move no.
     *
     * @param moveNo the move no
     */
    public void setMoveNo(Integer moveNo) {
        this.moveNo = moveNo;
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public Map<String, Country> getMap() {
        return map;
    }

    /**
     * Sets map.
     *
     * @param map the map
     */
    public void setMap(Map<String, Country> map) {
        this.map = map;
    }

    /**
     * Gets next player.
     *
     * @return the next player
     */
    public String getNextPlayer() {
        return nextPlayer;
    }

    /**
     * Sets next player.
     *
     * @param nextPlayer the next player
     */
    public void setNextPlayer(String nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
