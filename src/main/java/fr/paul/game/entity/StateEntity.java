package fr.paul.game.entity;

import javax.persistence.*;

/**
 * State Entity
 */
@Entity
@Table(name = "state")
public class StateEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer moveNo;
    private String nextPlayer;
    private String map;

    @ManyToOne
    @JoinColumn(name = "game")
    private GameEntity game;

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
     * Gets map.
     *
     * @return the map
     */
    public String getMap() {
        return map;
    }

    /**
     * Sets map.
     *
     * @param map the map
     */
    public void setMap(String map) {
        this.map = map;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public GameEntity getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(GameEntity game) {
        this.game = game;
    }
}
