package fr.paul.game.model;

/**
 * Move Model
 */
public class Move {

    private String player;
    private String from;
    private String to;
    private Integer pop;

    /**
     * Gets player.
     *
     * @return the player
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(String player) {
        this.player = player;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets pop.
     *
     * @return the pop
     */
    public Integer getPop() {
        return pop;
    }

    /**
     * Sets pop.
     *
     * @param pop the pop
     */
    public void setPop(Integer pop) {
        this.pop = pop;
    }
}
