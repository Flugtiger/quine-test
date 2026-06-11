// MR-3: Customer name value object

package quine.demo.model.customer;

import java.util.Objects;

/**
 * Value object representing the name of a Customer.
 * Two CustomerName instances are equal if they contain the same name value.
 */
public class CustomerName {
    private final String name;

    /**
     * Creates a new CustomerName with the given name.
     *
     * @param name the name of the customer
     * @throws IllegalArgumentException if name is null or empty
     */
    public CustomerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        this.name = name.trim();
    }

    /**
     * Returns the customer name value.
     *
     * @return the customer name
     */
    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerName that = (CustomerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
