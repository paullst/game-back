package fr.paul.game.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Abstract Mapper
 *
 * @param <E> the Entity
 * @param <M> the Model
 */
public abstract class AbstractMapper<E, M> {

    /**
     * Map to model m.
     *
     * @param entity the entity
     * @return the m
     */
    public abstract M mapToModel(E entity);

    /**
     * Map from model e.
     *
     * @param model the model
     * @return the e
     */
    public abstract E mapFromModel(M model);


    /**
     * Map to models list.
     *
     * @param entities the entities
     * @return the list
     */
    public List<M> mapToModels(List<E> entities) {

        return entities.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    /**
     * Map from models list.
     *
     * @param models the models
     * @return the list
     */
    public List<E> mapFromModels(List<M> models) {

        return models.stream()
                .map(this::mapFromModel)
                .collect(Collectors.toList());
    }


}
