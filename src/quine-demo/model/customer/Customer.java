// MR-3: Customer aggregate root

package quine.demo.model.customer;

import quine.demo.model.lead.LeadId;
import quine.demo.model.shared.AggregateRoot;
import java.util.Objects;

/**
 * Customer aggregate root representing a customer in the system.
 * A Customer has metadata like name, address, and revenue.
 * A Customer can be created from a Lead.
 */
public class Customer extends AggregateRoot {
    private final CustomerId customerId;
    private final CustomerName name;
    private final CustomerAddress address;
    private final CustomerRevenue revenue;
    private final LeadId leadId;

    /**
     * Creates a new Customer with the given ID, name, address, revenue, and source Lead ID.
     * MR-3: A Customer can be created from a Lead.
     *
     * @param customerId the unique identifier for the customer
     * @param name the name of the customer
     * @param address the address of the customer
     * @param revenue the revenue of the customer
     * @param leadId the ID of the Lead from which this Customer was created
     * @throws IllegalArgumentException if any parameter is null
     */
    public Customer(CustomerId customerId, CustomerName name, CustomerAddress address,
                    CustomerRevenue revenue, LeadId leadId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Customer name cannot be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("Customer address cannot be null");
        }
        if (revenue == null) {
            throw new IllegalArgumentException("Customer revenue cannot be null");
        }
        if (leadId == null) {
            throw new IllegalArgumentException("Lead ID cannot be null");
        }
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.revenue = revenue;
        this.leadId = leadId;
    }

    /**
     * Returns the unique identifier of this Customer.
     *
     * @return the customer ID
     */
    public CustomerId getCustomerId() {
        return customerId;
    }

    /**
     * Returns the name of this Customer.
     *
     * @return the customer name
     */
    public CustomerName getName() {
        return name;
    }

    /**
     * Returns the address of this Customer.
     *
     * @return the customer address
     */
    public CustomerAddress getAddress() {
        return address;
    }

    /**
     * Returns the revenue of this Customer.
     *
     * @return the customer revenue
     */
    public CustomerRevenue getRevenue() {
        return revenue;
    }

    /**
     * Returns the ID of the Lead from which this Customer was created.
     * MR-3: A Customer can be created from a Lead.
     *
     * @return the lead ID
     */
    public LeadId getLeadId() {
        return leadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
