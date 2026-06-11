// MR-3: Customer repository interface

package quine.demo.model.customer;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for the Customer aggregate.
 * Repositories are responsible for persisting and retrieving aggregates.
 * The implementation of this interface is not part of the domain model.
 */
public interface CustomerRepository {
    /**
     * Generates and returns the next unique ID for a Customer.
     * MR-3: The unique ID of an Aggregate Root is obtained from its repository via a nextId method.
     *
     * @return a new unique CustomerId
     */
    CustomerId nextId();

    /**
     * Saves a Customer aggregate to the repository.
     * MR-3: The save method must return nothing.
     *
     * @param customer the customer to save
     * @throws IllegalArgumentException if customer is null
     */
    void save(Customer customer);

    /**
     * Retrieves a Customer by its ID.
     *
     * @param customerId the ID of the customer to retrieve
     * @return an Optional containing the customer if found, empty otherwise
     * @throws IllegalArgumentException if customerId is null
     */
    Optional<Customer> getById(CustomerId customerId);

    /**
     * Retrieves all Customers from the repository.
     *
     * @return a list of all customers
     */
    List<Customer> getAll();
}
