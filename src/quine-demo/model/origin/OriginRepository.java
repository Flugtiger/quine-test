// MR-2: Origin repository interface

package quine.demo.model.origin;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for the Origin aggregate.
 * Repositories are responsible for persisting and retrieving aggregates.
 * The implementation of this interface is not part of the domain model.
 */
public interface OriginRepository {
    /**
     * Generates and returns the next unique ID for an Origin.
     * MR-2: The unique ID of an Aggregate Root is obtained from its repository via a nextId method.
     *
     * @return a new unique OriginId
     */
    OriginId nextId();

    /**
     * Saves an Origin aggregate to the repository.
     * MR-2: The save method must return nothing.
     *
     * @param origin the origin to save
     * @throws IllegalArgumentException if origin is null
     */
    void save(Origin origin);

    /**
     * Retrieves an Origin by its ID.
     *
     * @param originId the ID of the origin to retrieve
     * @return an Optional containing the origin if found, empty otherwise
     * @throws IllegalArgumentException if originId is null
     */
    Optional<Origin> getById(OriginId originId);

    /**
     * Retrieves all Origins from the repository.
     *
     * @return a list of all origins
     */
    List<Origin> getAll();
}
