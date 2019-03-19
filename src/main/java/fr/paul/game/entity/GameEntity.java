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

    // Game moves collections
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "game")
    private List<StateEntity> states;

    /*
    Getter & setters
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * Get game moves collection
     * @return states
     */
    public List<StateEntity> getStates() {
        return states;
    }

    /**
     * Set game moves collection
     * @param states
     */
    public void setStates(List<StateEntity> states) {
        this.states = states;
    }
}
