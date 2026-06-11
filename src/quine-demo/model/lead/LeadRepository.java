// MR-1: Lead repository interface

package quine.demo.model.lead;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for the Lead aggregate.
 * Repositories are responsible for persisting and retrieving aggregates.
 * The implementation of this interface is not part of the domain model.
 */
public interface LeadRepository {
    /**
     * Generates and returns the next unique ID for a Lead.
     * MR-1: The unique ID of an Aggregate Root is obtained from its repository via a nextId method.
     *
     * @return a new unique LeadId
     */
    LeadId nextId();

    /**
     * Saves a Lead aggregate to the repository.
     * MR-1: The save method must return nothing.
     *
     * @param lead the lead to save
     * @throws IllegalArgumentException if lead is null
     */
    void save(Lead lead);

    /**
     * Retrieves a Lead by its ID.
     *
     * @param leadId the ID of the lead to retrieve
     * @return an Optional containing the lead if found, empty otherwise
     * @throws IllegalArgumentException if leadId is null
     */
    Optional<Lead> getById(LeadId leadId);

    /**
     * Retrieves all Leads from the repository.
     *
     * @return a list of all leads
     */
    List<Lead> getAll();
}
