package fr.paul.game.entity;

import javax.persistence.*;

/**
 * State entity
 */
@Entity
@Table(name = "state")
public class StateEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    // Move/turn index
    private Integer moveNo;
    private String nextPlayer;

    @ManyToOne
    @JoinColumn(name = "game")
    private GameEntity game;

    // Map of countries
    private String map;

    /*
    Getters & setters
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get move/turn index
     * @return moveNo
     */
    public Integer getMoveNo() {
        return moveNo;
    }

    /**
     * Set move/turn index
     * @param moveNo
     */
    public void setMoveNo(Integer moveNo) {
        this.moveNo = moveNo;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(String nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    /**
     * Get map of countries
     * @return map
     */
    public String getMap() {
        return map;
    }

    /**
     * Set map of countries
     * @param map
     */
    public void setMap(String map) {
        this.map = map;
    }

}
