// MR-3: Customer ID value object

package quine.demo.model.customer;

import java.util.Objects;

/**
 * Value object representing the unique identifier of a Customer aggregate.
 * Two CustomerId instances are equal if they contain the same customerId value.
 */
public class CustomerId {
    private final String customerId;

    /**
     * Creates a new CustomerId with the given identifier.
     *
     * @param customerId the unique identifier for the customer
     * @throws IllegalArgumentException if customerId is null or empty
     */
    public CustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        this.customerId = customerId;
    }

    /**
     * Returns the customer identifier value.
     *
     * @return the customer ID
     */
    public String getValue() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerId that = (CustomerId) o;
        return Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return customerId;
    }
}
