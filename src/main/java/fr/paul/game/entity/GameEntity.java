package fr.paul.game.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Game Entity
 */
@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String player1;
    private String player2;
    private String winner;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "game")
    private List<StateEntity> states;

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
     * Gets player 1.
     *
     * @return the player 1
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * Sets player 1.
     *
     * @param player1 the player 1
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * Gets player 2.
     *
     * @return the player 2
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * Sets player 2.
     *
     * @param player2 the player 2
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * Gets winner.
     *
     * @return the winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Sets winner.
     *
     * @param winner the winner
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * Gets states.
     *
     * @return the states
     */
    public List<StateEntity> getStates() {
        return states;
    }

    /**
     * Sets states.
     *
     * @param states the states
     */
    public void setStates(List<StateEntity> states) {
        this.states = states;
    }
}
