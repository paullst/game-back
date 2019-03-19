package fr.paul.game.model;

import java.util.Objects;

/**
 * Country Model
 */
public class Country {

    private String label;
    private String id;
    private Integer pop;
    private String owner;

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets label.
     *
     * @param label the label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
